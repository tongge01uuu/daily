package com.we.contract.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FinancePlanContract  implements Serializable {
    private Integer id;

    /**
    * 理财计划编号（页面显示用）
    */
    @NotBlank
    private String code;

    private Date createTime;
    @NotNull
    private Integer financePlanId;

    private Date updateTime;

    /**
    * 购买人
    */
    @NotNull
    private Integer userId;

    /**
    * 购买或是预定理财计划
    */
    @NotBlank
    private String type;

    /**
    * 预定理财计划时记一下当时的预定金额
    */
    private BigDecimal reserveAmount;

    /**
    * 子账户类型:FINANCE_PLAN(理财计划), AUTO_INVEST_PLAN(定投计划)
    */
    @NotBlank
    private String subPointType;

    @NotBlank
    private String md5Value;

    @NotBlank
    private String saltValue;

    @NotBlank
    private String filePath;

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

    public String getMd5Value() {
        return md5Value;
    }

    public void setMd5Value(String md5Value) {
        this.md5Value = md5Value;
    }

    public String getSaltValue() {
        return saltValue;
    }

    public void setSaltValue(String saltValue) {
        this.saltValue = saltValue;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}