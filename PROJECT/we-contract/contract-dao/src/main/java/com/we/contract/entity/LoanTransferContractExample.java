package com.we.contract.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoanTransferContractExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public LoanTransferContractExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBuyerIdIsNull() {
            addCriterion("buyer_id is null");
            return (Criteria) this;
        }

        public Criteria andBuyerIdIsNotNull() {
            addCriterion("buyer_id is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerIdEqualTo(Integer value) {
            addCriterion("buyer_id =", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdNotEqualTo(Integer value) {
            addCriterion("buyer_id <>", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdGreaterThan(Integer value) {
            addCriterion("buyer_id >", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("buyer_id >=", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdLessThan(Integer value) {
            addCriterion("buyer_id <", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdLessThanOrEqualTo(Integer value) {
            addCriterion("buyer_id <=", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdIn(List<Integer> values) {
            addCriterion("buyer_id in", values, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdNotIn(List<Integer> values) {
            addCriterion("buyer_id not in", values, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdBetween(Integer value1, Integer value2) {
            addCriterion("buyer_id between", value1, value2, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("buyer_id not between", value1, value2, "buyerId");
            return (Criteria) this;
        }

        public Criteria andContractTemplateIdIsNull() {
            addCriterion("contract_template_id is null");
            return (Criteria) this;
        }

        public Criteria andContractTemplateIdIsNotNull() {
            addCriterion("contract_template_id is not null");
            return (Criteria) this;
        }

        public Criteria andContractTemplateIdEqualTo(Integer value) {
            addCriterion("contract_template_id =", value, "contractTemplateId");
            return (Criteria) this;
        }

        public Criteria andContractTemplateIdNotEqualTo(Integer value) {
            addCriterion("contract_template_id <>", value, "contractTemplateId");
            return (Criteria) this;
        }

        public Criteria andContractTemplateIdGreaterThan(Integer value) {
            addCriterion("contract_template_id >", value, "contractTemplateId");
            return (Criteria) this;
        }

        public Criteria andContractTemplateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("contract_template_id >=", value, "contractTemplateId");
            return (Criteria) this;
        }

        public Criteria andContractTemplateIdLessThan(Integer value) {
            addCriterion("contract_template_id <", value, "contractTemplateId");
            return (Criteria) this;
        }

        public Criteria andContractTemplateIdLessThanOrEqualTo(Integer value) {
            addCriterion("contract_template_id <=", value, "contractTemplateId");
            return (Criteria) this;
        }

        public Criteria andContractTemplateIdIn(List<Integer> values) {
            addCriterion("contract_template_id in", values, "contractTemplateId");
            return (Criteria) this;
        }

        public Criteria andContractTemplateIdNotIn(List<Integer> values) {
            addCriterion("contract_template_id not in", values, "contractTemplateId");
            return (Criteria) this;
        }

        public Criteria andContractTemplateIdBetween(Integer value1, Integer value2) {
            addCriterion("contract_template_id between", value1, value2, "contractTemplateId");
            return (Criteria) this;
        }

        public Criteria andContractTemplateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("contract_template_id not between", value1, value2, "contractTemplateId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andFairPriceIsNull() {
            addCriterion("fair_price is null");
            return (Criteria) this;
        }

        public Criteria andFairPriceIsNotNull() {
            addCriterion("fair_price is not null");
            return (Criteria) this;
        }

        public Criteria andFairPriceEqualTo(BigDecimal value) {
            addCriterion("fair_price =", value, "fairPrice");
            return (Criteria) this;
        }

        public Criteria andFairPriceNotEqualTo(BigDecimal value) {
            addCriterion("fair_price <>", value, "fairPrice");
            return (Criteria) this;
        }

        public Criteria andFairPriceGreaterThan(BigDecimal value) {
            addCriterion("fair_price >", value, "fairPrice");
            return (Criteria) this;
        }

        public Criteria andFairPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fair_price >=", value, "fairPrice");
            return (Criteria) this;
        }

        public Criteria andFairPriceLessThan(BigDecimal value) {
            addCriterion("fair_price <", value, "fairPrice");
            return (Criteria) this;
        }

        public Criteria andFairPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fair_price <=", value, "fairPrice");
            return (Criteria) this;
        }

        public Criteria andFairPriceIn(List<BigDecimal> values) {
            addCriterion("fair_price in", values, "fairPrice");
            return (Criteria) this;
        }

        public Criteria andFairPriceNotIn(List<BigDecimal> values) {
            addCriterion("fair_price not in", values, "fairPrice");
            return (Criteria) this;
        }

        public Criteria andFairPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fair_price between", value1, value2, "fairPrice");
            return (Criteria) this;
        }

        public Criteria andFairPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fair_price not between", value1, value2, "fairPrice");
            return (Criteria) this;
        }

        public Criteria andFeeIsNull() {
            addCriterion("fee is null");
            return (Criteria) this;
        }

        public Criteria andFeeIsNotNull() {
            addCriterion("fee is not null");
            return (Criteria) this;
        }

        public Criteria andFeeEqualTo(BigDecimal value) {
            addCriterion("fee =", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotEqualTo(BigDecimal value) {
            addCriterion("fee <>", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThan(BigDecimal value) {
            addCriterion("fee >", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fee >=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThan(BigDecimal value) {
            addCriterion("fee <", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fee <=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeIn(List<BigDecimal> values) {
            addCriterion("fee in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotIn(List<BigDecimal> values) {
            addCriterion("fee not in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fee between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fee not between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andInitialAmountIsNull() {
            addCriterion("initial_amount is null");
            return (Criteria) this;
        }

        public Criteria andInitialAmountIsNotNull() {
            addCriterion("initial_amount is not null");
            return (Criteria) this;
        }

        public Criteria andInitialAmountEqualTo(BigDecimal value) {
            addCriterion("initial_amount =", value, "initialAmount");
            return (Criteria) this;
        }

        public Criteria andInitialAmountNotEqualTo(BigDecimal value) {
            addCriterion("initial_amount <>", value, "initialAmount");
            return (Criteria) this;
        }

        public Criteria andInitialAmountGreaterThan(BigDecimal value) {
            addCriterion("initial_amount >", value, "initialAmount");
            return (Criteria) this;
        }

        public Criteria andInitialAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("initial_amount >=", value, "initialAmount");
            return (Criteria) this;
        }

        public Criteria andInitialAmountLessThan(BigDecimal value) {
            addCriterion("initial_amount <", value, "initialAmount");
            return (Criteria) this;
        }

        public Criteria andInitialAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("initial_amount <=", value, "initialAmount");
            return (Criteria) this;
        }

        public Criteria andInitialAmountIn(List<BigDecimal> values) {
            addCriterion("initial_amount in", values, "initialAmount");
            return (Criteria) this;
        }

        public Criteria andInitialAmountNotIn(List<BigDecimal> values) {
            addCriterion("initial_amount not in", values, "initialAmount");
            return (Criteria) this;
        }

        public Criteria andInitialAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("initial_amount between", value1, value2, "initialAmount");
            return (Criteria) this;
        }

        public Criteria andInitialAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("initial_amount not between", value1, value2, "initialAmount");
            return (Criteria) this;
        }

        public Criteria andLeftMonthIsNull() {
            addCriterion("left_month is null");
            return (Criteria) this;
        }

        public Criteria andLeftMonthIsNotNull() {
            addCriterion("left_month is not null");
            return (Criteria) this;
        }

        public Criteria andLeftMonthEqualTo(Integer value) {
            addCriterion("left_month =", value, "leftMonth");
            return (Criteria) this;
        }

        public Criteria andLeftMonthNotEqualTo(Integer value) {
            addCriterion("left_month <>", value, "leftMonth");
            return (Criteria) this;
        }

        public Criteria andLeftMonthGreaterThan(Integer value) {
            addCriterion("left_month >", value, "leftMonth");
            return (Criteria) this;
        }

        public Criteria andLeftMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("left_month >=", value, "leftMonth");
            return (Criteria) this;
        }

        public Criteria andLeftMonthLessThan(Integer value) {
            addCriterion("left_month <", value, "leftMonth");
            return (Criteria) this;
        }

        public Criteria andLeftMonthLessThanOrEqualTo(Integer value) {
            addCriterion("left_month <=", value, "leftMonth");
            return (Criteria) this;
        }

        public Criteria andLeftMonthIn(List<Integer> values) {
            addCriterion("left_month in", values, "leftMonth");
            return (Criteria) this;
        }

        public Criteria andLeftMonthNotIn(List<Integer> values) {
            addCriterion("left_month not in", values, "leftMonth");
            return (Criteria) this;
        }

        public Criteria andLeftMonthBetween(Integer value1, Integer value2) {
            addCriterion("left_month between", value1, value2, "leftMonth");
            return (Criteria) this;
        }

        public Criteria andLeftMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("left_month not between", value1, value2, "leftMonth");
            return (Criteria) this;
        }

        public Criteria andLoanIdIsNull() {
            addCriterion("loan_id is null");
            return (Criteria) this;
        }

        public Criteria andLoanIdIsNotNull() {
            addCriterion("loan_id is not null");
            return (Criteria) this;
        }

        public Criteria andLoanIdEqualTo(Integer value) {
            addCriterion("loan_id =", value, "loanId");
            return (Criteria) this;
        }

        public Criteria andLoanIdNotEqualTo(Integer value) {
            addCriterion("loan_id <>", value, "loanId");
            return (Criteria) this;
        }

        public Criteria andLoanIdGreaterThan(Integer value) {
            addCriterion("loan_id >", value, "loanId");
            return (Criteria) this;
        }

        public Criteria andLoanIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("loan_id >=", value, "loanId");
            return (Criteria) this;
        }

        public Criteria andLoanIdLessThan(Integer value) {
            addCriterion("loan_id <", value, "loanId");
            return (Criteria) this;
        }

        public Criteria andLoanIdLessThanOrEqualTo(Integer value) {
            addCriterion("loan_id <=", value, "loanId");
            return (Criteria) this;
        }

        public Criteria andLoanIdIn(List<Integer> values) {
            addCriterion("loan_id in", values, "loanId");
            return (Criteria) this;
        }

        public Criteria andLoanIdNotIn(List<Integer> values) {
            addCriterion("loan_id not in", values, "loanId");
            return (Criteria) this;
        }

        public Criteria andLoanIdBetween(Integer value1, Integer value2) {
            addCriterion("loan_id between", value1, value2, "loanId");
            return (Criteria) this;
        }

        public Criteria andLoanIdNotBetween(Integer value1, Integer value2) {
            addCriterion("loan_id not between", value1, value2, "loanId");
            return (Criteria) this;
        }

        public Criteria andLoanTransferIdIsNull() {
            addCriterion("loan_transfer_id is null");
            return (Criteria) this;
        }

        public Criteria andLoanTransferIdIsNotNull() {
            addCriterion("loan_transfer_id is not null");
            return (Criteria) this;
        }

        public Criteria andLoanTransferIdEqualTo(Integer value) {
            addCriterion("loan_transfer_id =", value, "loanTransferId");
            return (Criteria) this;
        }

        public Criteria andLoanTransferIdNotEqualTo(Integer value) {
            addCriterion("loan_transfer_id <>", value, "loanTransferId");
            return (Criteria) this;
        }

        public Criteria andLoanTransferIdGreaterThan(Integer value) {
            addCriterion("loan_transfer_id >", value, "loanTransferId");
            return (Criteria) this;
        }

        public Criteria andLoanTransferIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("loan_transfer_id >=", value, "loanTransferId");
            return (Criteria) this;
        }

        public Criteria andLoanTransferIdLessThan(Integer value) {
            addCriterion("loan_transfer_id <", value, "loanTransferId");
            return (Criteria) this;
        }

        public Criteria andLoanTransferIdLessThanOrEqualTo(Integer value) {
            addCriterion("loan_transfer_id <=", value, "loanTransferId");
            return (Criteria) this;
        }

        public Criteria andLoanTransferIdIn(List<Integer> values) {
            addCriterion("loan_transfer_id in", values, "loanTransferId");
            return (Criteria) this;
        }

        public Criteria andLoanTransferIdNotIn(List<Integer> values) {
            addCriterion("loan_transfer_id not in", values, "loanTransferId");
            return (Criteria) this;
        }

        public Criteria andLoanTransferIdBetween(Integer value1, Integer value2) {
            addCriterion("loan_transfer_id between", value1, value2, "loanTransferId");
            return (Criteria) this;
        }

        public Criteria andLoanTransferIdNotBetween(Integer value1, Integer value2) {
            addCriterion("loan_transfer_id not between", value1, value2, "loanTransferId");
            return (Criteria) this;
        }

        public Criteria andMonthlyAmountIsNull() {
            addCriterion("monthly_amount is null");
            return (Criteria) this;
        }

        public Criteria andMonthlyAmountIsNotNull() {
            addCriterion("monthly_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMonthlyAmountEqualTo(BigDecimal value) {
            addCriterion("monthly_amount =", value, "monthlyAmount");
            return (Criteria) this;
        }

        public Criteria andMonthlyAmountNotEqualTo(BigDecimal value) {
            addCriterion("monthly_amount <>", value, "monthlyAmount");
            return (Criteria) this;
        }

        public Criteria andMonthlyAmountGreaterThan(BigDecimal value) {
            addCriterion("monthly_amount >", value, "monthlyAmount");
            return (Criteria) this;
        }

        public Criteria andMonthlyAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("monthly_amount >=", value, "monthlyAmount");
            return (Criteria) this;
        }

        public Criteria andMonthlyAmountLessThan(BigDecimal value) {
            addCriterion("monthly_amount <", value, "monthlyAmount");
            return (Criteria) this;
        }

        public Criteria andMonthlyAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("monthly_amount <=", value, "monthlyAmount");
            return (Criteria) this;
        }

        public Criteria andMonthlyAmountIn(List<BigDecimal> values) {
            addCriterion("monthly_amount in", values, "monthlyAmount");
            return (Criteria) this;
        }

        public Criteria andMonthlyAmountNotIn(List<BigDecimal> values) {
            addCriterion("monthly_amount not in", values, "monthlyAmount");
            return (Criteria) this;
        }

        public Criteria andMonthlyAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("monthly_amount between", value1, value2, "monthlyAmount");
            return (Criteria) this;
        }

        public Criteria andMonthlyAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("monthly_amount not between", value1, value2, "monthlyAmount");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andSalerIdIsNull() {
            addCriterion("saler_id is null");
            return (Criteria) this;
        }

        public Criteria andSalerIdIsNotNull() {
            addCriterion("saler_id is not null");
            return (Criteria) this;
        }

        public Criteria andSalerIdEqualTo(Integer value) {
            addCriterion("saler_id =", value, "salerId");
            return (Criteria) this;
        }

        public Criteria andSalerIdNotEqualTo(Integer value) {
            addCriterion("saler_id <>", value, "salerId");
            return (Criteria) this;
        }

        public Criteria andSalerIdGreaterThan(Integer value) {
            addCriterion("saler_id >", value, "salerId");
            return (Criteria) this;
        }

        public Criteria andSalerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("saler_id >=", value, "salerId");
            return (Criteria) this;
        }

        public Criteria andSalerIdLessThan(Integer value) {
            addCriterion("saler_id <", value, "salerId");
            return (Criteria) this;
        }

        public Criteria andSalerIdLessThanOrEqualTo(Integer value) {
            addCriterion("saler_id <=", value, "salerId");
            return (Criteria) this;
        }

        public Criteria andSalerIdIn(List<Integer> values) {
            addCriterion("saler_id in", values, "salerId");
            return (Criteria) this;
        }

        public Criteria andSalerIdNotIn(List<Integer> values) {
            addCriterion("saler_id not in", values, "salerId");
            return (Criteria) this;
        }

        public Criteria andSalerIdBetween(Integer value1, Integer value2) {
            addCriterion("saler_id between", value1, value2, "salerId");
            return (Criteria) this;
        }

        public Criteria andSalerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("saler_id not between", value1, value2, "salerId");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andBuyerSubpointIdIsNull() {
            addCriterion("buyer_subpoint_id is null");
            return (Criteria) this;
        }

        public Criteria andBuyerSubpointIdIsNotNull() {
            addCriterion("buyer_subpoint_id is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerSubpointIdEqualTo(Integer value) {
            addCriterion("buyer_subpoint_id =", value, "buyerSubpointId");
            return (Criteria) this;
        }

        public Criteria andBuyerSubpointIdNotEqualTo(Integer value) {
            addCriterion("buyer_subpoint_id <>", value, "buyerSubpointId");
            return (Criteria) this;
        }

        public Criteria andBuyerSubpointIdGreaterThan(Integer value) {
            addCriterion("buyer_subpoint_id >", value, "buyerSubpointId");
            return (Criteria) this;
        }

        public Criteria andBuyerSubpointIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("buyer_subpoint_id >=", value, "buyerSubpointId");
            return (Criteria) this;
        }

        public Criteria andBuyerSubpointIdLessThan(Integer value) {
            addCriterion("buyer_subpoint_id <", value, "buyerSubpointId");
            return (Criteria) this;
        }

        public Criteria andBuyerSubpointIdLessThanOrEqualTo(Integer value) {
            addCriterion("buyer_subpoint_id <=", value, "buyerSubpointId");
            return (Criteria) this;
        }

        public Criteria andBuyerSubpointIdIn(List<Integer> values) {
            addCriterion("buyer_subpoint_id in", values, "buyerSubpointId");
            return (Criteria) this;
        }

        public Criteria andBuyerSubpointIdNotIn(List<Integer> values) {
            addCriterion("buyer_subpoint_id not in", values, "buyerSubpointId");
            return (Criteria) this;
        }

        public Criteria andBuyerSubpointIdBetween(Integer value1, Integer value2) {
            addCriterion("buyer_subpoint_id between", value1, value2, "buyerSubpointId");
            return (Criteria) this;
        }

        public Criteria andBuyerSubpointIdNotBetween(Integer value1, Integer value2) {
            addCriterion("buyer_subpoint_id not between", value1, value2, "buyerSubpointId");
            return (Criteria) this;
        }

        public Criteria andSalerSubpointIdIsNull() {
            addCriterion("saler_subpoint_id is null");
            return (Criteria) this;
        }

        public Criteria andSalerSubpointIdIsNotNull() {
            addCriterion("saler_subpoint_id is not null");
            return (Criteria) this;
        }

        public Criteria andSalerSubpointIdEqualTo(Integer value) {
            addCriterion("saler_subpoint_id =", value, "salerSubpointId");
            return (Criteria) this;
        }

        public Criteria andSalerSubpointIdNotEqualTo(Integer value) {
            addCriterion("saler_subpoint_id <>", value, "salerSubpointId");
            return (Criteria) this;
        }

        public Criteria andSalerSubpointIdGreaterThan(Integer value) {
            addCriterion("saler_subpoint_id >", value, "salerSubpointId");
            return (Criteria) this;
        }

        public Criteria andSalerSubpointIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("saler_subpoint_id >=", value, "salerSubpointId");
            return (Criteria) this;
        }

        public Criteria andSalerSubpointIdLessThan(Integer value) {
            addCriterion("saler_subpoint_id <", value, "salerSubpointId");
            return (Criteria) this;
        }

        public Criteria andSalerSubpointIdLessThanOrEqualTo(Integer value) {
            addCriterion("saler_subpoint_id <=", value, "salerSubpointId");
            return (Criteria) this;
        }

        public Criteria andSalerSubpointIdIn(List<Integer> values) {
            addCriterion("saler_subpoint_id in", values, "salerSubpointId");
            return (Criteria) this;
        }

        public Criteria andSalerSubpointIdNotIn(List<Integer> values) {
            addCriterion("saler_subpoint_id not in", values, "salerSubpointId");
            return (Criteria) this;
        }

        public Criteria andSalerSubpointIdBetween(Integer value1, Integer value2) {
            addCriterion("saler_subpoint_id between", value1, value2, "salerSubpointId");
            return (Criteria) this;
        }

        public Criteria andSalerSubpointIdNotBetween(Integer value1, Integer value2) {
            addCriterion("saler_subpoint_id not between", value1, value2, "salerSubpointId");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}