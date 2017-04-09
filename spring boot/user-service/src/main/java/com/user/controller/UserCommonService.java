package com.user.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yukai on 2016/9/2.
 */
@RestController
public class UserCommonService
{
    static final Log LOG = LogFactory.getLog(UserCommonService.class);
    static final Logger log= Logger.getLogger(UserCommonService.class);
    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String login(@RequestParam String username,@RequestParam String password)
    {
        log.info(username+"   "+ password);
        return "ok";
    }
}
