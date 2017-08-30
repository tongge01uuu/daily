package com.we.demo.service;

import com.alibaba.fastjson.JSON;
import com.site.bean.resultBean.Result;
import com.we.demo.BaseTest;
import com.we.contract.service.DemoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by qibaichao on 2016/9/14.
 */
public class DemoServiceTest extends BaseTest {
    @Autowired
    private DemoService demoService;
    @Test
    public void demo(){
        Result result=demoService.demo();
        System.out.println(JSON.toJSONString(result));
    }

}
