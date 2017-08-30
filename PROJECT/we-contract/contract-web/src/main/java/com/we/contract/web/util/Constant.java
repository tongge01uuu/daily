package com.we.contract.web.util;

import java.util.HashMap;

/**
 * User:hgq
 * Datetime:2016/5/8 20:54
 */
public class Constant {

    public static final int STAUTS_RAISE = 1;
    public static final int STAUTS_APPLY = 2;
    public static final int STAUTS_FULFIL = 3;
    public static final int STAUTS_DONE = 4;
    public static final int STAUTS_INTEREST = 5;
    public static final int STAUTS_QUIT = 6;
    public static final int STAUTS_DRAFT = 7;
    public static final int STAUTS_FAIL = 8;
    public static final int STAUTS_DELETE = 9;

    //已成年
    public static final String IS_ADULT_1 = "1";
    //未成年
    public static final String IS_ADULT_2 = "2";

    //未绑卡
    public static final String BAND_CARD_0 = "0";
    //绑卡没有省市信息
    public static final String BAND_CARD_1 = "1";
    //绑卡有省市信息
    public static final String BAND_CARD_2 = "2";

    //绑定银行卡类型
    //未绑卡
    public static final String BIND_TYPE_0 = "0";
    //未定快钱
    public static final String BIND_TYPE_1 = "1";
    //绑定民生
    public static final String BIND_TYPE_2 = "2";
    /**
     * 产品状态
     */
    public static final HashMap<Integer, String> PRODUCT_STATUS_MAP = new HashMap<Integer, String>() {
        private static final long serialVersionUID = 1L;
        {
            put(1, "募集期");
            put(2, "申请期");
            put(3, "已满额");
            put(4, "募集结束");
            put(5, "收益中");
            put(6, "已退出");
            put(7, "草稿");
            put(8, "募集失败");
            put(9, "已删除");
        }
    };

    /**
     * 平台
     */
    public static final HashMap<String, String> PLATFORM_MAP = new HashMap<String, String>() {
        private static final long serialVersionUID = 1L;
        {
            put("pc", "1");
            put("android", "2");
            put("ios", "3");
        }
    };


    /**
     * 需要排序的字段
     */
    public static final HashMap<String, Integer> SORT_NAME_MAP = new HashMap<String, Integer>() {
        private static final long serialVersionUID = 1L;
        {
            put("productPeriod",1);
            put("startAmount", 2);
            put("annualRate", 3);
            put("investTime", 4);
        }
    };

    /**
     * 排序规则
     */
    public static final HashMap<String, Integer> SORT_TYPE_MAP = new HashMap<String, Integer>() {
        private static final long serialVersionUID = 1L;
        {
            put("asc",1);
            put("desc", 2);
        }
    };

    /**
     * 账户内查询状态
     */
    public static final HashMap<String, Integer> USER_PRODUCT_STAUTS_MAP = new HashMap<String, Integer>() {
        private static final long serialVersionUID = 1L;
        {
            put("all",1);
            put("hold", 2);
            put("quit", 3);
        }
    };

    public static final String SMS_CONTENT_REDEEM = "您于%s发起赎回%s产品%s元，赎回申请已受理。如有问题请致电：400-090-6600";

}
