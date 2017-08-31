package com.we.contract.web.util;

/**
 * User:hgq
 * Datetime:2016/5/8 9:13
 */
public enum MsgConstants {

    SYSTEM_ERROR(40000,"系统错误"),

    PARAM_ERROR(40001,"参数错误"),

    PARAM_NULL_ERROR(40002,"参数不能为空"),

    //支付中心错误
    PAY_CENTER_ERROR(41001,"支付异常"),

    USER_BIND_CARD_ERROR(41002,"获取用户绑卡信息异常"),

    AUTH_CODE_ERROR(41003,"验证码错误，请重新获取"),

    BALANCE_NOT_ENOUGH_ERROR(41004,"投资失败，请确保绑定的银行卡内余额充足。"),

    //用户中心错误
    GET_USER_INFO_ERROR(42001,"获取用户信息异常"),

    GET_USER_LEVEL_ERROR(42002,"获得用户等级异常"),


    GET_PRODUCT_LIST_ERROR(40010,"获得产品列表异常"),

    GET_USER_TOTAL_ACCOUNT_ERROR(40011,"获取用户账户总览异常"),

    GET_BANK_LIST_ERROR(40012,"获取银行列表异常"),

    GET_BRANCH_BANK_ERROR(40013,"获取支行信息异常"),

    BIND_CARD_VALID_CODE_ERROR(40014,"获取支行信息异常"),

    BIND_CARD_ERROR(40015,"绑卡异常"),

    BUY_PRODUCXT_ERROR(40017,"投资失败，请稍后再试。"),

    USER_IS_NOT_ADULT_ERROR(40018,"用户未满18周岁，不能投资"),

    BEGIN_SELL_AMOUNT_ERROR(40019,"投资金额低于起售金额"),

    ONE_INVEST_LIMIT_ERROR(40020,"投资金额超出单笔投资限额"),

    APPEND_MULTIPLE_AMOUNT(40021,"单位加价金额参数错误"),

    INVEST_AMOUNT_APPEND_AMOUNT_EEROR(40022,"投资金额不符合单位加价金额规则"),

    SUM_INVEST_AMOUNT_ERROR(40023,"投资金额超出个人累计投资限额"),

    TOTAL_AMOUNT_ERROR(40024,"累计投资金额超出募集总金额"),

    //块钱错误码
    KQ_ERROR_24000(41002,"银行预留手机号不匹配"),
    KQ_ERROR_21011(41003,"银行预留手机号不匹配"),
    KQ_ERROR_B_BIN_0005(41004,"银行卡号错误，请检查后重新输入"),
    KQ_ERROR_L9(41005,"银行卡号错误，请检查后重新输入"),
    KQ_ERROR_L5(41006,"银行卡号错误，请检查后重新输入"),
    KQ_ERROR_OG(41007,"交易金额超过最大限制"),
    KQ_ERROR_G0(41008,"充值金额超过限制"),
    KQ_ERROR_51(41009,"银行卡余额不足"),
    KQ_ERROR_01(41010,"请联系发卡行，或核对卡信息后重新输入"),
    KQ_ERROR_12(41011,"无效交易，或核对卡信息后重新输入"),
    KQ_ERROR_13(41012,"无效金额，交易金额不在许可的范围内，疑问请联系我们。"),
    KQ_ERROR_14(41013,"无效卡号（无此号），或核对卡信息后重新输入"),
    KQ_ERROR_I5(41014,"超出持卡人设置的交易限额，请持卡人联系发卡银行调高限额"),
    KQ_ERROR_40011(41015,"银行账号格式不正确"),
    KQ_ERROR_40017(41016,"手机号码格式不正确"),
    KQ_ERROR_41002(41017,"该银行账户号码交易超过限制次数"),
    KQ_ERROR_24001(41018,"身份证件号码及银行账户名称与银行账户号码都不匹配"),
    KQ_ERROR_24002(41019,"身份证号码与银行账户号码不匹配"),
    KQ_ERROR_24005(41020,"该银行账户号码已被挂失"),
    KQ_ERROR_24006(41021,"该银行账户号码已被冻结"),
    KQ_ERROR_24007(41022,"该银行账户号码已被销户"),
    KQ_ERROR_24008(41023,"该银行账户号码不存在"),
    KQ_ERROR_B0(41024,"金额超限"),
    KQ_ERROR_BA(41025,"卡信息错误次数超限，请联系发卡行"),
    KQ_ERROR_E6(41026,"银行卡号不合法"),
    KQ_ERROR_F7(41027,"身份证号不合法"),
    KQ_ERROR_I9(41028,"银行结帐中，请重试交易"),
    KQ_ERROR_D6(41029,"手机号被列入黑名单"),
    KQ_ERROR_D7(41030,"银行卡号被列入黑名单"),
    KQ_ERROR_F1(41031,"手机号不合法"),
    KQ_ERROR_G3(41032,"超出系统当日金额限制"),
    KQ_ERROR_G4(41033,"超出系统当日该银行卡成功交易次数限制"),
    KQ_ERROR_OK(41034,"EDC.交易已经完成"),
    KQ_ERROR_OL(41035,"EDC.交易超时"),
    KQ_ERROR_J2(41036,"无效订单"),
    KQ_ERROR_J4(41037,"订单已支付"),
    KQ_ERROR_HW(41038,"手机号码不符"),
    KQ_ERROR_HX(41039,"姓名不符"),
    KQ_ERROR_HY(41040,"证件类型不符"),
    KQ_ERROR_HZ(41041,"证件号不符"),
    KQ_ERROR_J9(41042,"手机号后六位错误"),
    KQ_ERROR_JA(41043,"原手机号的绑定关系不存在"),
    KQ_ERROR_W0(41044,"手机号与开户时登记的不一致"),
    KQ_ERROR_W1(41045,"手机号与开户时登记的不一致，且超过支付限额"),
    KQ_ERROR_W2(41046,"身份证号码与开户时登记的不一致"),
    KQ_ERROR_W3(41047,"身份证号码与开户时登记的不一致，且超过支付限额"),
    KQ_ERROR_W4(41048,"姓名与开户时登记的不一致"),
    KQ_ERROR_W5(41049,"姓名与开户时登记的不一致，且超过支付限额"),
    KQ_ERROR_W6(41050,"手机号、身份证号码、姓名与开户时登记的不一致"),
    KQ_ERROR_W7(41051,"手机号、身份证号码、姓名与开户时登记的不一致，且超过支付限额"),
    KQ_ERROR_W8(41052,"手机号、身份证号码与开户时登记的不一致"),
    KQ_ERROR_W9(41053,"手机号、身份证号码与开户时登记的不一致，且超过支付限额"),
    KQ_ERROR_WA(41054,"身份证号码、姓名与开户时登记的不一致"),
    KQ_ERROR_WB(41055,"身份证号码、姓名与开户时登记的不一致，且超过支付限额"),
    KQ_ERROR_WC(41056,"手机号、姓名与开户时登记的不一致"),
    KQ_ERROR_WD(41057,"手机号、姓名与开户时登记的不一致，且超过支付限额"),
    KQ_ERROR_WI(41058,"超出系统身份证当日金额限制"),
    KQ_ERROR_Y1(41059,"身份认证失败"),
    KQ_ERROR_B_MGW_0120(41060,"银行与卡号不匹配");
    private int code;
    private String message;

    private MsgConstants(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static MsgConstants getInstance(String message) {
        if (message.equals("验证码错误"))
            return MsgConstants.AUTH_CODE_ERROR;
        if (message.equals("银行卡余额不足"))
            return MsgConstants.BALANCE_NOT_ENOUGH_ERROR;
        for (MsgConstants msgConstants : MsgConstants.values()) {
            if (message.equals(msgConstants.getMessage())) {
                return msgConstants;
            }
        }
        return MsgConstants.SYSTEM_ERROR;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
