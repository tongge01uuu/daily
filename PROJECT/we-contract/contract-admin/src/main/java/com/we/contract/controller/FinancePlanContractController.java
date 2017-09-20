package com.we.contract.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.site.bean.resultBean.Result;
import com.we.contract.architect.constant.BussinessCode;
import com.we.contract.constant.SubPointType;
import com.we.contract.controller.basic.BasicController;
import com.we.contract.entity.FinancePlanContract;
import com.we.contract.param.FinancePlanContractParam;
import com.we.contract.service.FinancePlanContractService;
import com.we.contract.util.ResultEntity;
import com.we.contract.util.ResultUtil;
import com.we.contract.vo.FinancePlanContractVo;
import com.we.p2p.service.UPlanService;
import com.we.p2p.vo.UplanVo;
import com.we.user.service.UserService;
import com.we.user.vo.UserSecurityInfoVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.file.NoSuchFileException;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Created by yukai on 2017-9-11.
 */
@Controller
@RequestMapping("contract/financePlan")
public class FinancePlanContractController extends BasicController {
    @Autowired
    private FinancePlanContractService financePlanContractService;
    @Autowired
    private UPlanService uPlanService;
    @Autowired
    private UserService userRpcService;
    @Value("${file.root.path}")
    private String fileRootPath;
    @Value("${file.root.project.path}")
    private String fileRootProjectPath;

    @RequestMapping("toList.do")
    public String toList(Model model)
    {
        Map subPointTypes= SubPointType.getAllTypes();
        model.addAttribute("subPointTypes",subPointTypes);
        return "contract/contract_finance_plan_list";
    }

    @RequestMapping("list.do")
    @ResponseBody
    public ResultEntity list(FinancePlanContractParam param)
    {
        ResultEntity resultEntity=ResultEntity.build();
        try {
            PageHelper.startPage(param.getPageNum(),param.getPageSize(),true);
            List<FinancePlanContract> financePlanContracts = financePlanContractService.list(param);
            PageInfo pageInfo=new PageInfo(financePlanContracts);
            FinancePlanContractVo financePlanContractVo=null;
            String financePlanName="";
            String userName="";
            String subPointName="undifined";
            List<FinancePlanContractVo> financePlanContractVos=new ArrayList<>();
            for (FinancePlanContract financePlanContract:financePlanContracts)
            {
                financePlanContractVo=new FinancePlanContractVo();
                BeanUtils.copyProperties(financePlanContract,financePlanContractVo);

                Result<UplanVo> uplanVoResult= null;
                Result<UserSecurityInfoVo> userResult= null;
                try {
                    uplanVoResult = uPlanService.getPlanInfo(financePlanContract.getFinancePlanId());
                    userResult = userRpcService.getUserSecurityInfo(financePlanContract.getUserId());
                } catch (Exception e) {
                    log.warn(ExceptionUtils.getStackTrace(e));
                }
                financePlanName= ResultUtil.isNull(uplanVoResult)?financePlanContract.getFinancePlanId()+"":uplanVoResult.getValue().getName();
                userName=ResultUtil.isNull(userResult)?financePlanContract.getUserId()+"":userResult.getValue().getRealName();

                financePlanContractVo.setFinancePlanName(financePlanName);
                financePlanContractVo.setUserName(userName);
                try {
                    subPointName=SubPointType.valueOf(financePlanContract.getSubPointType()).toString();
                } catch (IllegalArgumentException e) {
                    log.warn(ExceptionUtils.getStackTrace(e));
                }
                financePlanContractVo.setSubPointTypeName(subPointName);
                financePlanContractVos.add(financePlanContractVo);
            }
            pageInfo.setList(financePlanContractVos);
            resultEntity.setData(pageInfo);
        }
        catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return resultEntity.withError(BussinessCode.GLOBAL_ERROR);
        }

        return resultEntity;
    }
    @RequestMapping(value = "/to/show.do")
    public String show(Integer id, Model model, HttpServletRequest request)
    {
        ResultEntity resultEntity=ResultEntity.build();
        String msg= null;
        try {
            FinancePlanContract financePlanContract=financePlanContractService.get(id);
            msg = "";
            if (financePlanContract==null)
            {
                msg="合同不存在";
                request.setAttribute("msg",msg);
                resultEntity.withError(msg);
            }
            String filePath=financePlanContract.getFilePath();
            resultEntity.setData(fileRootProjectPath+filePath);

            //COPY FILE
            String sourceFilePath=fileRootPath+filePath;
            String targetFilePath=request.getSession().getServletContext().getRealPath("/")+"/"+fileRootProjectPath+filePath;
            copy(sourceFilePath,targetFilePath);

            if (StringUtils.isBlank(filePath))
            {
                msg="该合同没有文件";
                request.setAttribute("msg",msg);
                resultEntity.withError(msg);
            }
        } catch (NoSuchFileException e)
        {
            log.error(ExceptionUtils.getStackTrace(e));
            msg="合同文件不存在";
            resultEntity.withError(msg);
        }
        catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            msg="系统异常";
            resultEntity.withError(msg);
        }
        model.addAttribute("result",resultEntity);

        return "contract/contract_preview";
    }

    @RequestMapping(value = "download.do")
    @ResponseBody
    public ResultEntity download(String filePath, HttpServletResponse response, HttpServletRequest request)
    {
        ResultEntity resultEntity=ResultEntity.build();

//        String fileName=filePath.substring(filePath.lastIndexOf("\\")+1);
        String msg="";
        if (filePath==null)
        {
            request.setAttribute("msg","该合同没有文件");
            msg="该合同没有文件";
            resultEntity.withError(msg);
            return resultEntity;
        }
        FileInputStream fileInputStream=null;
        BufferedInputStream bufferedInputStream=null;
        try {
            filePath=fileRootPath+filePath;
            File file=new File(filePath);
            fileInputStream=new FileInputStream(file);
            bufferedInputStream=new BufferedInputStream(fileInputStream);
            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition", "attachment;fileName="
                    +  URLEncoder.encode(file.getName(), "UTF-8"));

            OutputStream outputStream=response.getOutputStream();
            byte[] data=new byte[1024];
            while(bufferedInputStream.read(data)>-1)
            {
                outputStream.write(data,0,data.length);
            }
            outputStream.flush();
            fileInputStream.close();
            bufferedInputStream.close();
        } catch (FileNotFoundException e) {
//            response.setStatus(404);
           log.warn(ExceptionUtils.getStackTrace(e));
            msg="合同文件不存在";
        }catch (IOException e)
        {
//            response.setStatus(500);
            log.error(ExceptionUtils.getStackTrace(e));
            msg="请求异常";
        }
        resultEntity.withError(msg);
        return resultEntity;
    }

    @RequestMapping(value = "/downloadZip.do")
    public String downloadFiles(@RequestParam("filePaths")String filePaths, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int successNum=0;
        int failNum=0;
        String[] filePathArray=filePaths.split(",");
        File file=null;
        List<File> files=new ArrayList<>();
        for (String cell:filePathArray)
        {
            file=new File(fileRootPath+cell);
            if (file.exists())
            {
                files.add(file);
            }else {
                failNum++;
            }
        }
        String fileName = UUID.randomUUID().toString() + ".zip";
        // 在服务器端创建打包下载的临时文件
        String outFilePath = request.getSession().getServletContext().getRealPath("/");

        File fileZip = new File(outFilePath + fileName);
        // 文件输出流
        FileOutputStream outStream = new FileOutputStream(fileZip);
        // 压缩流
        ZipOutputStream zipOutStream = new ZipOutputStream(outStream);

        zipFile(files, zipOutStream);
        log.info("生成文件：{}",fileZip.getCanonicalPath());
        zipOutStream.close();
        outStream.close();
        this.downloadFile(fileZip, response, true);
        return null;
    }

    public void downloadFile(File file,HttpServletResponse response,boolean isDelete) {
        try {
            // 以流的形式下载文件。
            BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file.getPath()));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(file.getName().getBytes("UTF-8"),"ISO-8859-1"));
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
            if(isDelete)
            {
                file.delete();        //是否将生成的服务器端文件删除
                log.info("删除文件：{}",file.getCanonicalPath());
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static void zipFile(List<File> files, ZipOutputStream outputStream) throws IOException, ServletException {
        try {
            int size = files.size();
            Set<String> tmp=new HashSet<>();
            // 压缩列表中的文件
            File file=null;
            for (int i = 0; i < size; i++) {
                file = (File) files.get(i);
                if (tmp.contains(file.getName()))
                {
//                    boolean optResult=file.renameTo(new File(file.getAbsolutePath().replace(".","-"+i+".")));
                    continue;
                }
                tmp.add(file.getName());
                zipFile(file, outputStream);
            }
        } catch (IOException e) {
            throw e;
        }
    }

    public static void zipFile(File inputFile, ZipOutputStream outputstream) throws IOException, ServletException {
        try {
            if (inputFile.exists()) {
                if (inputFile.isFile()) {
                    FileInputStream inStream = new FileInputStream(inputFile);
                    BufferedInputStream bInStream = new BufferedInputStream(inStream);
                    ZipEntry entry = new ZipEntry(inputFile.getName());
                    outputstream.putNextEntry(entry);
                    final int MAX_BYTE = 10 * 1024 * 1024; // 最大的流为10M
                    long streamTotal = 0; // 接受流的容量
                    int streamNum = 0; // 流需要分开的数量
                    int leaveByte = 0; // 文件剩下的字符数
                    byte[] inOutbyte; // byte数组接受文件的数据

                    streamTotal = bInStream.available(); // 通过available方法取得流的最大字符数
                    streamNum = (int) Math.floor(streamTotal / MAX_BYTE); // 取得流文件需要分开的数量
                    leaveByte = (int) streamTotal % MAX_BYTE; // 分开文件之后,剩余的数量

                    if (streamNum > 0) {
                        for (int j = 0; j < streamNum; ++j) {
                            inOutbyte = new byte[MAX_BYTE];
                            // 读入流,保存在byte数组
                            bInStream.read(inOutbyte, 0, MAX_BYTE);
                            outputstream.write(inOutbyte, 0, MAX_BYTE); // 写出流
                        }
                    }
                    // 写出剩下的流数据
                    inOutbyte = new byte[leaveByte];
                    bInStream.read(inOutbyte, 0, leaveByte);
                    outputstream.write(inOutbyte);
                    outputstream.closeEntry(); // Closes the current ZIP entry

                    bInStream.close(); // 关闭
                    inStream.close();
                }
            } else {
                throw new ServletException("文件不存在！");
            }
        } catch (IOException e) {
            throw e;
        }
    }


    private void copy(String sourcePath,String targetPath)throws Exception
    {
        File targetFile=new File(targetPath);
        File sourceFile=new File(sourcePath);
        if (!sourceFile.exists())
        {
            log.error("源文件路径错误：{}",sourcePath);
            throw new NoSuchFileException(sourcePath);
        }
        if (!targetFile.exists())
        {
            FileCopyUtils.copy(sourceFile,targetFile);
            log.info("文件复制成功：{}--->{}",sourcePath,targetPath);
        }
    }

}
