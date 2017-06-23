package com.springmvc.demo.quickstart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yukai on 2017/6/23.
 */
@Controller
public class MvcController {
    @RequestMapping("/index")
    public String index()
    {
        return "index";
    }
}
