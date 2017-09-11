package com.we.contract.entity;

import java.math.BigDecimal;
import java.util.Date;

public class FinancePlanContract {
    private Integer id;

    private String code;

    private Date createTime;

    private Integer financePlanId;

    private Date updateTime;

    private Integer userId;

    /**
    * 购买或是预定理财计划
    */
    private String type;

    /**
    * 预定理财计划时记一下当时的预定金额
    */
    private BigDecimal reserveAmount;

    /**
    * 子账户类型:FINANCE_PLAN(理财计划), AUTO_INVEST_PLAN(定投计划)
    */
    private String subPointType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getFinancePlanId() {
        return financePlanId;
    }

    public void setFinancePlanId(Integer financePlanId) {
        this.financePlanId = financePlanId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getReserveAmount() {
        return reserveAmount;
    }

    public void setReserveAmount(BigDecimal reserveAmount) {
        this.reserveAmount = reserveAmount;
    }

    public String getSubPointType() {
        return subPointType;
    }

    public void setSubPointType(String subPointType) {
        this.subPointType = subPointType;
    }
}