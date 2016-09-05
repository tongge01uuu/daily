package com.we.scheduleCenter.rpc;

import java.util.concurrent.Future;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.fastjson.JSON;
import com.site.bean.resultBean.Result;
import com.we.exchange.service.ExchangeOrderService;
import com.we.scheduleCenter.base.BaseTest;

public class ExchangeOrderServiceTest extends BaseTest {

    @Autowired
    private ExchangeOrderService exchangeOrderService;

    @Test
    public void test() {
        try {
            this.exchangeOrderService.fixOrderState();
            Future<Result<Boolean>> future = RpcContext.getContext().getFuture();

            Result<Boolean> result = future.get();
            System.err.println(JSON.toJSONString(result, true));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
