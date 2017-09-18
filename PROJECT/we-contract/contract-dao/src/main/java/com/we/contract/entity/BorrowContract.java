package com.we.contract.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BorrowContract  implements Serializable {
    private Integer contractid;

    private Date createtime;

    private Integer loan;

    private Integer user;

    /**
    * 提前还款违约费率（%）
    */
    private String advanceRepayPenalRate;

    /**
    * 逾期天数
    */
    private Integer badDebtDays;

    /**
    * 借款管理费率(%)
    */
    private String borrowMgmtRate;

    /**
    * 担保金费率(%)
    */
    private String guaranteeRate;

    /**
    * 逾期1-30天罚息利率 (%)
    */
    private String overdueInterestRate1;

    /**
    * 逾期31天及以上罚息利率 (%)
    */
    private String overdueInterestRate2;

    /**
    * 逾期1-30天管理利率 (%)
    */
    private String overdueMgmtRate1;

    /**
    * 逾期31天及以上管理利率 (%)
    */
    private String overdueMgmtRate2;

    /**
    * 服务费，即成交手续费率（%）
    */
    private String svcRate;

    /**
    * 合同编号
    */
    private String code;

    /**
    * 法定代表人
    */
    private String legalRepr;

    /**
    * 抵/质押率，如80%，mortgageRates=80
    */
    private Double mortgagerates;

    /**
    * 抵/质押物初始价值
    */
    private Double mortgagevalue;

    /**
    * 丁方（出质人和保证人）
    */
    private String pledgor;

    /**
    * 住所
    */
    private String residence;

    /**
    * 跟第三方协定的内部实际年化借款利率
    */
    private BigDecimal internalInterestRate;

    /**
    * 跟第三方协定的内部实际月还款金额
    */
    private BigDecimal internalRepayAmount;

    /**
    *  标中合同信息（Json）
    */
    private String contractinfo;

    private String loanguaranteetype;

    /**
    * 合同模板ID
    */
    private Integer contracttemplateid;

    public Integer getContractid() {
        return contractid;
    }

    public void setContractid(Integer contractid) {
        this.contractid = contractid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getLoan() {
        return loan;
    }

    public void setLoan(Integer loan) {
        this.loan = loan;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public String getAdvanceRepayPenalRate() {
        return advanceRepayPenalRate;
    }

    public void setAdvanceRepayPenalRate(String advanceRepayPenalRate) {
        this.advanceRepayPenalRate = advanceRepayPenalRate;
    }

    public Integer getBadDebtDays() {
        return badDebtDays;
    }

    public void setBadDebtDays(Integer badDebtDays) {
        this.badDebtDays = badDebtDays;
    }

    public String getBorrowMgmtRate() {
        return borrowMgmtRate;
    }

    public void setBorrowMgmtRate(String borrowMgmtRate) {
        this.borrowMgmtRate = borrowMgmtRate;
    }

    public String getGuaranteeRate() {
        return guaranteeRate;
    }

    public void setGuaranteeRate(String guaranteeRate) {
        this.guaranteeRate = guaranteeRate;
    }

    public String getOverdueInterestRate1() {
        return overdueInterestRate1;
    }

    public void setOverdueInterestRate1(String overdueInterestRate1) {
        this.overdueInterestRate1 = overdueInterestRate1;
    }

    public String getOverdueInterestRate2() {
        return overdueInterestRate2;
    }

    public void setOverdueInterestRate2(String overdueInterestRate2) {
        this.overdueInterestRate2 = overdueInterestRate2;
    }

    public String getOverdueMgmtRate1() {
        return overdueMgmtRate1;
    }

    public void setOverdueMgmtRate1(String overdueMgmtRate1) {
        this.overdueMgmtRate1 = overdueMgmtRate1;
    }

    public String getOverdueMgmtRate2() {
        return overdueMgmtRate2;
    }

    public void setOverdueMgmtRate2(String overdueMgmtRate2) {
        this.overdueMgmtRate2 = overdueMgmtRate2;
    }

    public String getSvcRate() {
        return svcRate;
    }

    public void setSvcRate(String svcRate) {
        this.svcRate = svcRate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLegalRepr() {
        return legalRepr;
    }

    public void setLegalRepr(String legalRepr) {
        this.legalRepr = legalRepr;
    }

    public Double getMortgagerates() {
        return mortgagerates;
    }

    public void setMortgagerates(Double mortgagerates) {
        this.mortgagerates = mortgagerates;
    }

    public Double getMortgagevalue() {
        return mortgagevalue;
    }

    public void setMortgagevalue(Double mortgagevalue) {
        this.mortgagevalue = mortgagevalue;
    }

    public String getPledgor() {
        return pledgor;
    }

    public void setPledgor(String pledgor) {
        this.pledgor = pledgor;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public BigDecimal getInternalInterestRate() {
        return internalInterestRate;
    }

    public void setInternalInterestRate(BigDecimal internalInterestRate) {
        this.internalInterestRate = internalInterestRate;
    }

    public BigDecimal getInternalRepayAmount() {
        return internalRepayAmount;
    }

    public void setInternalRepayAmount(BigDecimal internalRepayAmount) {
        this.internalRepayAmount = internalRepayAmount;
    }

    public String getContractinfo() {
        return contractinfo;
    }

    public void setContractinfo(String contractinfo) {
        this.contractinfo = contractinfo;
    }

    public String getLoanguaranteetype() {
        return loanguaranteetype;
    }

    public void setLoanguaranteetype(String loanguaranteetype) {
        this.loanguaranteetype = loanguaranteetype;
    }

    public Integer getContracttemplateid() {
        return contracttemplateid;
    }

    public void setContracttemplateid(Integer contracttemplateid) {
        this.contracttemplateid = contracttemplateid;
    }
}