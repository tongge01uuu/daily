package com.we.contract.util;


public class RedisKeyConstant {

    /**
     * 订单号
     */
    public static final String REDIS_KEY_ORDERNO = "orderNo_%s";

    /**
     * 有效时间24h
     */
    public static final int EXPIRE_DAY = 3600 * 24;

    /**
     * 有效时间1分钟
     */
    public static final int EXPIRE_MINUTE = 60;
    /**
     * 文件批次号
     */
    public static final String FILE_BATCH_NO = "FILE_BATCH_NO";

    /**
     * userId set
     */
    public static final String REDISKEY_USER_ORDER_SHARES_USERID = "user_order_shares_userId";

}
