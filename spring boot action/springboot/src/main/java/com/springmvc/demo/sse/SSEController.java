package com.springmvc.demo.sse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yukai on 2017/6/28.
 */
@Controller
@RequestMapping("/push")
public class SSEController {
    @RequestMapping(value = "/sse",produces = "text/event-stream")
    @ResponseBody
    public String push(){
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result=format.format(date);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //靠！1-页面取值用的e.data的形式，这样返回肯定不行了。
        //   2-尾部一定要带 "\n\n"
//        return "服务器端推送测试，时间更新："+result+"\n\n";
        return "data:服务器端推送测试，时间更新："+result+"\n\n";
    }

}
