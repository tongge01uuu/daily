package com.we.contract.controller;

import com.we.contract.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yukai on 2017-8-28.
 */
@Controller
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private DemoService demoService;

    @RequestMapping("")
    @ResponseBody
    public String demo()
    {
        demoService.doService();
        return "Hello World";
    }
}
