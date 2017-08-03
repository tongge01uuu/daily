package com.springboot.web.configurationProperties;

import com.springboot.starter.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yukai on 2017/6/29.
 */
@RestController
public class AutoConfigController {

    @Autowired
    private DBSetting dbSetting;

    @Autowired
    private HelloService helloService;

    @RequestMapping("/db")
    public DBSetting getDBSetting()
    {
        return dbSetting;

    }

    @RequestMapping("/sayHello")
    public String sayHello()
    {
        return helloService.sayHello();
    }
}
