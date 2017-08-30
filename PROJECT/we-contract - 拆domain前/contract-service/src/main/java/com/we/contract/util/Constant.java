package com.we.contract.util;

import java.util.HashMap;

/**
 * User:hgq
 * Datetime:2016/5/8 20:54
 */
public class Constant {
    /**
     * 产品可用状态 1：可用  2：不可用
     */
    public static final int PRODUCT_STATUS_Y=1;
    public static final int PRODUCT_STATUS_N=2;

    /**
     * 用户退出标志 0:未退出  1:已退出
     */
    public static final int QUIT_NOT = 0;
    public static final int QUIT_YES = 1;

    /**
     * 风险等级对应关系
     */
    public static final HashMap<String, String> RISK_MAP = new HashMap<String, String>() {
        private static final long serialVersionUID = 1L;

        {
            put("1", "2");
            put("2", "3");
            put("3", "5");
        }
    };
    /**
     * 银行对应关系
     */
    public static final HashMap<String, String> BANK_MAP = new HashMap<String, String>() {
        private static final long serialVersionUID = 1L;

        {
            put("ICBC", "002");
            put("ABC", "003");
            put("BOC", "004");
            put("CCB", "005");
            put("CMB", "007");
            put("CITIC", "015");
            put("GDB", "016");
            put("PAB", "920");
            put("HXB", "012");
            put("CEB", "009");
            put("CMBC", "014");
            put("BCOM", "006");
            put("SPDB", "010");
            put("CIB", "011");
        }
    };

    /**
     * 文件上传类型
     */
    public static final String PURCHASE_UPLOAD = "022";
    public static final String ACCOUNT_UPLOAD = "100";
    public static final String REDEEM_UPLOAD = "024";

    /**
     * 确认文件类型
     */
    public static final String PURCHASE_CONFIRM = "122";
    public static final String ACCOUNT_CONFIRM = "101";
    public static final String REDEEM_CONFIRM = "124";
    public static final String PRODUCT_PROFIT = "800";
    public static final String INVESTOR_CONFIRM = "801";
    public static final String PRODUCT_REDEEM_DATE = "C6";
    public static final String PRODUCT_SHARES = "26";
    public static final String ORDER_PROFIT = "27";

    public static final String SMS_CONTENT_QUIT = "您于%s购买%s产品%s元到期退出成功，到期本息合计%s元，预计1-2个工作日提现至绑定银行卡。如有问题请致电：400-090-6600";
}
