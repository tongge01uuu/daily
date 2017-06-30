package com.springmvc.demo.sse;

import org.springframework.scheduling.annotation.Scheduled;
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
public class ServletAysncController {
    public String result;
    @RequestMapping("servlet/aysnc")
    @ResponseBody
    public String push()
    {
        try {
            Thread.sleep(5555);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Scheduled(fixedDelay = 5000)
    public void refresh()
    {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        result=format.format(new Date());
    }


}
