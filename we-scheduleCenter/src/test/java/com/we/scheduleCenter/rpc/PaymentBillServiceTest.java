package com.we.scheduleCenter.rpc;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.fastjson.JSON;
import com.site.bean.resultBean.Result;
import com.we.exchange.service.PaymentBillService;
import com.we.scheduleCenter.base.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.Future;

/**
 * Created by qibaichao on 2016/5/31.
 */
public class PaymentBillServiceTest extends BaseTest {

    @Autowired
    private PaymentBillService paymentBillService;

    @Test
    public void doRequest() {
        try {
            paymentBillService.payRequest();
            Future<Result<Boolean>> future = RpcContext.getContext().getFuture();
            Result<Boolean> result = future.get();
            System.out.println(("--------还款请求支付中心结束: " + JSON.toJSONString(result)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
