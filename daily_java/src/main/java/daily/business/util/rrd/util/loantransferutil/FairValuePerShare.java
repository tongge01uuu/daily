package daily.business.util.rrd.util.loantransferutil;

public class FairValuePerShare {
    /**
     * 每份债权的公允价值
     */
    private double amount;

    /**
     * 每份债权公允价值中的本金部分
     */
    private double principal;

    /**
     * 每份债权公允价值中本金的当前价值
     */
    private double principalNow;

    /**
     * 每份债权公允价值中的利息部分
     */
    private double interest;

    /**
     * 每份债权中剩余利息部分
     */
    private double leftInterest;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPrincipal() {
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public double getPrincipalNow() {
        return principalNow;
    }

    public void setPrincipalNow(double principalNow) {
        this.principalNow = principalNow;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getLeftInterest() {
        return leftInterest;
    }

    public void setLeftInterest(double leftInterest) {
        this.leftInterest = leftInterest;
    }
}
