package com.we.p2p.web.controller;

import com.site.bean.resultBean.Result;
import com.we.p2p.service.DemoService;
import com.we.p2p.web.util.MsgConstants;
import com.we.p2p.web.util.ReturnData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by qibaichao on 2016/9/7.
 */
@RestController
@RequestMapping("/demo")
public class DemoController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private DemoService demoService;

    @RequestMapping("query")
    public ReturnData query(HttpServletRequest request) {
        ReturnData returnData = ReturnData.build();
        try {
            Result voResult = demoService.demo();
        } catch (Exception e) {
            logger.error("error:" + e.getMessage(), e);
            returnData.withError(MsgConstants.SYSTEM_ERROR);
        }
        //给前端赋值
        return returnData;
    }

}
