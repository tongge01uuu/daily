package com.we.demo.service;

import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.fastjson.JSON;
import com.site.bean.resultBean.Result;
import com.we.contract.constant.SubPointType;
import com.we.contract.entity.FinancePlanContract;
import com.we.contract.enums.ContractType;
import com.we.contract.service.ContractService;
import com.we.demo.BaseTest;
import com.we.contract.service.DemoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

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
    @Test
    public void insret()
    {
        try {
            FinancePlanContract financePlanContract=new FinancePlanContract();
            financePlanContract.setCode("test");
            financePlanContract.setFilePath("sql-old/contract-old-withdata.sql");
            financePlanContract.setFinancePlanId(2222);
            financePlanContract.setMd5Value("test");
            financePlanContract.setSaltValue("test");
            financePlanContract.setSubPointType(SubPointType.FINANCE_PLAN.name());
//            financePlanContract.setUserId(2222);
            financePlanContract.setType("BUY");
            Result result=contractServiceRpc.saveContractRecord(financePlanContract,ContractType.FINANCE_PLAN);
            System.out.println(JSON.toJSONString(result));
        } catch (Exception e) {
//            ConstraintViolationException ve = (ConstraintViolationException) e.getCause(); // 里面嵌了一个ConstraintViolationException
//            Set<ConstraintViolation<?>> violations = ve.getConstraintViolations(); // 可以拿到一个验证错误详细信息的集合
//            System.out.println(violations);
            e.printStackTrace();
        }
    }

}
