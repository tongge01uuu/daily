package com.we.contract.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class LoanTransferContract implements Serializable {
    private Integer id;

    /**
    * 购买人ID
    */
    private Integer buyerId;

    /**
    *  模板
    */
    private Integer contractTemplateId;

    private Date createTime;

    /**
    * 最后一起还款时间
    */
    private Date endTime;

    /**
    * 债权总价值
    */
    private BigDecimal fairPrice;

    /**
    * 转让管理费
    */
    private BigDecimal fee;

    /**
    * 对应的初始借款金额（总额）
    */
    private BigDecimal initialAmount;

    /**
    * 剩余期数
    */
    private Integer leftMonth;

    /**
    * 对应的标ID
    */
    private Integer loanId;

    /**
    * 对应的债权ID
    */
    private Integer loanTransferId;

    /**
    * 月还本息(总额)
    */
    private BigDecimal monthlyAmount;

    /**
    * 债权转让价格
    */
    private BigDecimal price;

    /**
    * 转出人ID
    */
    private Integer salerId;

    /**
    * 开始接受还款时间
    */
    private Date startTime;

    /**
    * 购买子账户ID
    */
    private Integer buyerSubpointId;

    /**
    * 转出子账户ID
    */
    private Integer salerSubpointId;

    /**
    * 平台业务流水号 防止重复提交
    */
    private String orderNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public Integer getContractTemplateId() {
        return contractTemplateId;
    }

    public void setContractTemplateId(Integer contractTemplateId) {
        this.contractTemplateId = contractTemplateId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getFairPrice() {
        return fairPrice;
    }

    public void setFairPrice(BigDecimal fairPrice) {
        this.fairPrice = fairPrice;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getInitialAmount() {
        return initialAmount;
    }

    public void setInitialAmount(BigDecimal initialAmount) {
        this.initialAmount = initialAmount;
    }

    public Integer getLeftMonth() {
        return leftMonth;
    }

    public void setLeftMonth(Integer leftMonth) {
        this.leftMonth = leftMonth;
    }

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public Integer getLoanTransferId() {
        return loanTransferId;
    }

    public void setLoanTransferId(Integer loanTransferId) {
        this.loanTransferId = loanTransferId;
    }

    public BigDecimal getMonthlyAmount() {
        return monthlyAmount;
    }

    public void setMonthlyAmount(BigDecimal monthlyAmount) {
        this.monthlyAmount = monthlyAmount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getSalerId() {
        return salerId;
    }

    public void setSalerId(Integer salerId) {
        this.salerId = salerId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Integer getBuyerSubpointId() {
        return buyerSubpointId;
    }

    public void setBuyerSubpointId(Integer buyerSubpointId) {
        this.buyerSubpointId = buyerSubpointId;
    }

    public Integer getSalerSubpointId() {
        return salerSubpointId;
    }

    public void setSalerSubpointId(Integer salerSubpointId) {
        this.salerSubpointId = salerSubpointId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}