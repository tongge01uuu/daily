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
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

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

    @RequestMapping(value = "download.do")
    @ResponseBody
    public ResultEntity download(String filePath, HttpServletResponse response, HttpServletRequest request)
    {
        ResultEntity resultEntity=ResultEntity.build();
        String fileName=filePath.substring(filePath.lastIndexOf("\\")+1);

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
            fileInputStream=new FileInputStream(filePath);
            bufferedInputStream=new BufferedInputStream(fileInputStream);

            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition", "attachment;fileName="
                    +  URLEncoder.encode(fileName, "UTF-8"));

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

}
