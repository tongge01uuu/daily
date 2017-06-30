package com.springmvc.demo.quickstart;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yukai on 2017/6/23.
 */
@Controller
@RequestMapping("index")
public class MvcController {
    @RequestMapping
    public String index()
    {
        return "index";
    }

    @RequestMapping("/json")
    @ResponseBody
    public String indexJson()
    {
        return "{'name':'andy','sexy':0}";
    }

    @RequestMapping(value = "/text",produces = "text/plain;charset=UTF-8")
    public @ResponseBody String indexJson2()
    {
        return "{'name':'andy','sexy':0}";
    }

    @RequestMapping(value = "/text/{pathParam}",produces = "text/plain;charset=UTF-8")
    public @ResponseBody String indexPathParam(@PathVariable String pathParam,
                                               @RequestParam String requestParam,
                                               MvcEntityVo mvcEntityVo,
                                               HttpServletRequest request)
    {
        String content=String.format(" pathParam :%s \n requestParam:%s \n mvcEntityVo:%s \n  request \n URI:%S \n URL:%S \n sessionId:%S",
                pathParam,
                requestParam,
                JSON.toJSON(mvcEntityVo),
                request.getRequestURI(),request.getRequestURL(),request.getRequestedSessionId());
        return content;
    }
    @RequestMapping(value = "text/requestBody",produces = "application/json;charset=UTF-8")
    public @ResponseBody MvcEntityVo indexRequestBody(@RequestBody MvcEntityVo mvcEntityVo,
                                                      @RequestParam String requestParam,
                                                        HttpServletRequest request)
    {
        String content=String.format("  mvcEntityVo:%s \n requestParam:%s \n request \n URI:%S \n URL:%S \n sessionId:%S",
                JSON.toJSON(mvcEntityVo),
                requestParam,
                request.getRequestURI(),request.getRequestURL(),request.getRequestedSessionId());
        System.out.println(content);
        String[] array={"te","tt"};
        List hobbys= Arrays.asList(array);
        return mvcEntityVo;
    }
    @RequestMapping(value = "/text/ObjParam",produces = "application/json;charset=UTF-8")
    public @ResponseBody MvcEntityVo indexObjParam(MvcEntityVo mvcEntityVo,
                                               HttpServletRequest request)
    {
        String content=String.format("  mvcEntityVo:%s \n  request \n URI:%S \n URL:%S \n sessionId:%S",
                JSON.toJSON(mvcEntityVo),
                request.getRequestURI(),request.getRequestURL(),request.getRequestedSessionId());
        System.out.println(content);
        String[] array={"te","tt"};
        List hobbys= Arrays.asList(array);
        return mvcEntityVo;
    }
    //  index/controllerAdviceTest?id=12&name=hahha  id的值会被忽略 参照  MvcControllerAdvice的全局配置
    //  index/controllerAdviceTest?id=12&name=hahha.com  . 后面的字符串不会被忽略
    @RequestMapping("/controllerAdviceTest")
    public String controllerAdviceTest(@ModelAttribute("author") String author ,@ModelAttribute("timestamp") String timestamp,MvcEntityVo mvcEntityVo)
    {
        System.out.println(JSON.toJSON(mvcEntityVo));
        throw new RuntimeException(String.format("全局异常控制器&&额外绑定字段测试：author：%s timestamp %s",author,timestamp));
    }

    @RequestMapping("/uploadController")
    public @ResponseBody String doUpload(MultipartFile uploadFile)
    {

        try {
            File target=new File("d:/upload/"+uploadFile.getOriginalFilename());
//            target.mkdirs();
            FileUtils.writeByteArrayToFile(target,uploadFile.getBytes(),true);
            return "SUCCESS";
        } catch (IOException e) {
            e.printStackTrace();
            return "UPLOAD FAIL";
        }
    }


    public static void main(String[] args) {
        File target=new File("/upload/");
        target.mkdirs();
    }
}
