package com.we.p2p.util.orderNoGenerator;

import org.springframework.stereotype.Service;

/**
 * Created by shuaizhiguo on 2016/9/14.
 * 付款单流水号
 */
@Service
public class PaymentBillNo extends AbstractSequence  {

    private static final String DATA_FORMAT = "yyyyMMddHHmmss";

    @Override
    public String getDateFormat() {
        return DATA_FORMAT;
    }

    @Override
    public int getThirdPartLength() {
        return 3;
    }
}
