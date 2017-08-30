package com.we.p2p.web.vo;

import org.hibernate.validator.constraints.NotBlank;

/**
 * User:hgq
 * Datetime:2016/9/1 17:58
 */
public class DemoParamVo {
    //用户ID
    @NotBlank(message = "用户ID不能为空！")
    private String userId;

    //购买平台
    @NotBlank(message = "购买平台不能为空！")
    private String platform;

    //验证码
    @NotBlank(message = "验证码不能为空！")
    private String validCode;

    //token值
    @NotBlank(message = "token不能为空！")
    private String token;

    //银行编码
    private String bankCode;

    //银行卡号
    private String cardNo;

    //交易金额
    @NotBlank(message = "交易金额不能为空！")
    private String amount;

    //订单号
    @NotBlank(message = "订单号不能为空！")
    private String orderNo;

    //手机号
    @NotBlank(message = "手机号不能为空！")
    private String telephone;

    //用户绑卡信息 0:用户未绑卡
    //            1:用户已绑卡但没有银行信息
    //            2:用户已绑卡且有银行信息
    @NotBlank(message = "用户绑卡信息不能为空！")
    private String bankCardCheck;

    //产品编码
    @NotBlank(message = "产品编码不能为空！")
    private String productNo;

    //省
    private String province;

    //市
    private String city;

    //支行信息
    private String branchBank;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getValidCode() {
        return validCode;
    }

    public void setValidCode(String validCode) {
        this.validCode = validCode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getBankCardCheck() {
        return bankCardCheck;
    }

    public void setBankCardCheck(String bankCardCheck) {
        this.bankCardCheck = bankCardCheck;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBranchBank() {
        return branchBank;
    }

    public void setBranchBank(String branchBank) {
        this.branchBank = branchBank;
    }
}
