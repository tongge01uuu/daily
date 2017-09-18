package com.we.demo.service;

import com.alibaba.fastjson.JSON;
import com.site.bean.resultBean.Result;
import com.we.contract.enums.ContractType;
import com.we.contract.service.ContractService;
import com.we.demo.BaseTest;
import com.we.contract.service.DemoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by qibaichao on 2016/9/14.
 */
public class ContractServiceTest extends BaseTest {
    @Autowired
    private ContractService contractServiceRpc;
    @Test
    public void demo(){
//        Result result=contractServiceRpc.getTemplate(6);
        Result result=contractServiceRpc.getContract(720, ContractType.FINANCE_PLAN);
        System.out.println(JSON.toJSONString(result));
    }

}
