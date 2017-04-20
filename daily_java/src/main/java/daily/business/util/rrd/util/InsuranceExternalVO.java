package daily.business.util.rrd.util;

import java.math.BigDecimal;
import java.util.Date;

/**
 * excel工具类
 *
 * @author luzongwei
 */
public class InsuranceExternalVO {

    private Integer id;

    private String userName;

    private String orderNo;

    private String applicantName;

    private String applicantMobile;

    private String applicantIdcardno;

    private String insuredName;

    private String insuredIdcardno;

    private String productName;

    private BigDecimal premium;

    private BigDecimal premiumYears;

    private BigDecimal ape;

    private BigDecimal sumInsured;

    private String contractNo;

    private Date policyDate;

    private Integer version;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName == null ? null : applicantName.trim();
    }

    public String getApplicantMobile() {
        return applicantMobile;
    }

    public void setApplicantMobile(String applicantMobile) {
        this.applicantMobile = applicantMobile == null ? null : applicantMobile.trim();
    }

    public String getApplicantIdcardno() {
        return applicantIdcardno;
    }

    public void setApplicantIdcardno(String applicantIdcardno) {
        this.applicantIdcardno = applicantIdcardno == null ? null : applicantIdcardno.trim();
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName == null ? null : insuredName.trim();
    }

    public String getInsuredIdcardno() {
        return insuredIdcardno;
    }

    public void setInsuredIdcardno(String insuredIdcardno) {
        this.insuredIdcardno = insuredIdcardno == null ? null : insuredIdcardno.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) {
        this.premium = premium;
    }

    public BigDecimal getPremiumYears() {
        return premiumYears;
    }

    public void setPremiumYears(BigDecimal premiumYears) {
        this.premiumYears = premiumYears;
    }

    public BigDecimal getApe() {
        return ape;
    }

    public void setApe(BigDecimal ape) {
        this.ape = ape;
    }

    public BigDecimal getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(BigDecimal sumInsured) {
        this.sumInsured = sumInsured;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    public Date getPolicyDate() {
        return policyDate;
    }

    public void setPolicyDate(Date policyDate) {
        this.policyDate = policyDate;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
