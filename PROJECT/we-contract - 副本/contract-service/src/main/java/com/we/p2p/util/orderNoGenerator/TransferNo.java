package com.we.p2p.util.orderNoGenerator;

import org.springframework.stereotype.Service;

/**
 * Created by qibaichao on 2016/9/1.
 * 转账流水号
 */
@Service
public class TransferNo extends AbstractSequence {

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