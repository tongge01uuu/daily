package com.we.contract.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BorrowContractExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public BorrowContractExample() {
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

        public Criteria andContractidIsNull() {
            addCriterion("contractId is null");
            return (Criteria) this;
        }

        public Criteria andContractidIsNotNull() {
            addCriterion("contractId is not null");
            return (Criteria) this;
        }

        public Criteria andContractidEqualTo(Integer value) {
            addCriterion("contractId =", value, "contractid");
            return (Criteria) this;
        }

        public Criteria andContractidNotEqualTo(Integer value) {
            addCriterion("contractId <>", value, "contractid");
            return (Criteria) this;
        }

        public Criteria andContractidGreaterThan(Integer value) {
            addCriterion("contractId >", value, "contractid");
            return (Criteria) this;
        }

        public Criteria andContractidGreaterThanOrEqualTo(Integer value) {
            addCriterion("contractId >=", value, "contractid");
            return (Criteria) this;
        }

        public Criteria andContractidLessThan(Integer value) {
            addCriterion("contractId <", value, "contractid");
            return (Criteria) this;
        }

        public Criteria andContractidLessThanOrEqualTo(Integer value) {
            addCriterion("contractId <=", value, "contractid");
            return (Criteria) this;
        }

        public Criteria andContractidIn(List<Integer> values) {
            addCriterion("contractId in", values, "contractid");
            return (Criteria) this;
        }

        public Criteria andContractidNotIn(List<Integer> values) {
            addCriterion("contractId not in", values, "contractid");
            return (Criteria) this;
        }

        public Criteria andContractidBetween(Integer value1, Integer value2) {
            addCriterion("contractId between", value1, value2, "contractid");
            return (Criteria) this;
        }

        public Criteria andContractidNotBetween(Integer value1, Integer value2) {
            addCriterion("contractId not between", value1, value2, "contractid");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andLoanIsNull() {
            addCriterion("loan is null");
            return (Criteria) this;
        }

        public Criteria andLoanIsNotNull() {
            addCriterion("loan is not null");
            return (Criteria) this;
        }

        public Criteria andLoanEqualTo(Integer value) {
            addCriterion("loan =", value, "loan");
            return (Criteria) this;
        }

        public Criteria andLoanNotEqualTo(Integer value) {
            addCriterion("loan <>", value, "loan");
            return (Criteria) this;
        }

        public Criteria andLoanGreaterThan(Integer value) {
            addCriterion("loan >", value, "loan");
            return (Criteria) this;
        }

        public Criteria andLoanGreaterThanOrEqualTo(Integer value) {
            addCriterion("loan >=", value, "loan");
            return (Criteria) this;
        }

        public Criteria andLoanLessThan(Integer value) {
            addCriterion("loan <", value, "loan");
            return (Criteria) this;
        }

        public Criteria andLoanLessThanOrEqualTo(Integer value) {
            addCriterion("loan <=", value, "loan");
            return (Criteria) this;
        }

        public Criteria andLoanIn(List<Integer> values) {
            addCriterion("loan in", values, "loan");
            return (Criteria) this;
        }

        public Criteria andLoanNotIn(List<Integer> values) {
            addCriterion("loan not in", values, "loan");
            return (Criteria) this;
        }

        public Criteria andLoanBetween(Integer value1, Integer value2) {
            addCriterion("loan between", value1, value2, "loan");
            return (Criteria) this;
        }

        public Criteria andLoanNotBetween(Integer value1, Integer value2) {
            addCriterion("loan not between", value1, value2, "loan");
            return (Criteria) this;
        }

        public Criteria andUserIsNull() {
            addCriterion("user_ is null");
            return (Criteria) this;
        }

        public Criteria andUserIsNotNull() {
            addCriterion("user_ is not null");
            return (Criteria) this;
        }

        public Criteria andUserEqualTo(Integer value) {
            addCriterion("user_ =", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotEqualTo(Integer value) {
            addCriterion("user_ <>", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserGreaterThan(Integer value) {
            addCriterion("user_ >", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_ >=", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLessThan(Integer value) {
            addCriterion("user_ <", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLessThanOrEqualTo(Integer value) {
            addCriterion("user_ <=", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserIn(List<Integer> values) {
            addCriterion("user_ in", values, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotIn(List<Integer> values) {
            addCriterion("user_ not in", values, "user");
            return (Criteria) this;
        }

        public Criteria andUserBetween(Integer value1, Integer value2) {
            addCriterion("user_ between", value1, value2, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotBetween(Integer value1, Integer value2) {
            addCriterion("user_ not between", value1, value2, "user");
            return (Criteria) this;
        }

        public Criteria andAdvanceRepayPenalRateIsNull() {
            addCriterion("advance_repay_penal_rate is null");
            return (Criteria) this;
        }

        public Criteria andAdvanceRepayPenalRateIsNotNull() {
            addCriterion("advance_repay_penal_rate is not null");
            return (Criteria) this;
        }

        public Criteria andAdvanceRepayPenalRateEqualTo(String value) {
            addCriterion("advance_repay_penal_rate =", value, "advanceRepayPenalRate");
            return (Criteria) this;
        }

        public Criteria andAdvanceRepayPenalRateNotEqualTo(String value) {
            addCriterion("advance_repay_penal_rate <>", value, "advanceRepayPenalRate");
            return (Criteria) this;
        }

        public Criteria andAdvanceRepayPenalRateGreaterThan(String value) {
            addCriterion("advance_repay_penal_rate >", value, "advanceRepayPenalRate");
            return (Criteria) this;
        }

        public Criteria andAdvanceRepayPenalRateGreaterThanOrEqualTo(String value) {
            addCriterion("advance_repay_penal_rate >=", value, "advanceRepayPenalRate");
            return (Criteria) this;
        }

        public Criteria andAdvanceRepayPenalRateLessThan(String value) {
            addCriterion("advance_repay_penal_rate <", value, "advanceRepayPenalRate");
            return (Criteria) this;
        }

        public Criteria andAdvanceRepayPenalRateLessThanOrEqualTo(String value) {
            addCriterion("advance_repay_penal_rate <=", value, "advanceRepayPenalRate");
            return (Criteria) this;
        }

        public Criteria andAdvanceRepayPenalRateLike(String value) {
            addCriterion("advance_repay_penal_rate like", value, "advanceRepayPenalRate");
            return (Criteria) this;
        }

        public Criteria andAdvanceRepayPenalRateNotLike(String value) {
            addCriterion("advance_repay_penal_rate not like", value, "advanceRepayPenalRate");
            return (Criteria) this;
        }

        public Criteria andAdvanceRepayPenalRateIn(List<String> values) {
            addCriterion("advance_repay_penal_rate in", values, "advanceRepayPenalRate");
            return (Criteria) this;
        }

        public Criteria andAdvanceRepayPenalRateNotIn(List<String> values) {
            addCriterion("advance_repay_penal_rate not in", values, "advanceRepayPenalRate");
            return (Criteria) this;
        }

        public Criteria andAdvanceRepayPenalRateBetween(String value1, String value2) {
            addCriterion("advance_repay_penal_rate between", value1, value2, "advanceRepayPenalRate");
            return (Criteria) this;
        }

        public Criteria andAdvanceRepayPenalRateNotBetween(String value1, String value2) {
            addCriterion("advance_repay_penal_rate not between", value1, value2, "advanceRepayPenalRate");
            return (Criteria) this;
        }

        public Criteria andBadDebtDaysIsNull() {
            addCriterion("bad_debt_days is null");
            return (Criteria) this;
        }

        public Criteria andBadDebtDaysIsNotNull() {
            addCriterion("bad_debt_days is not null");
            return (Criteria) this;
        }

        public Criteria andBadDebtDaysEqualTo(Integer value) {
            addCriterion("bad_debt_days =", value, "badDebtDays");
            return (Criteria) this;
        }

        public Criteria andBadDebtDaysNotEqualTo(Integer value) {
            addCriterion("bad_debt_days <>", value, "badDebtDays");
            return (Criteria) this;
        }

        public Criteria andBadDebtDaysGreaterThan(Integer value) {
            addCriterion("bad_debt_days >", value, "badDebtDays");
            return (Criteria) this;
        }

        public Criteria andBadDebtDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("bad_debt_days >=", value, "badDebtDays");
            return (Criteria) this;
        }

        public Criteria andBadDebtDaysLessThan(Integer value) {
            addCriterion("bad_debt_days <", value, "badDebtDays");
            return (Criteria) this;
        }

        public Criteria andBadDebtDaysLessThanOrEqualTo(Integer value) {
            addCriterion("bad_debt_days <=", value, "badDebtDays");
            return (Criteria) this;
        }

        public Criteria andBadDebtDaysIn(List<Integer> values) {
            addCriterion("bad_debt_days in", values, "badDebtDays");
            return (Criteria) this;
        }

        public Criteria andBadDebtDaysNotIn(List<Integer> values) {
            addCriterion("bad_debt_days not in", values, "badDebtDays");
            return (Criteria) this;
        }

        public Criteria andBadDebtDaysBetween(Integer value1, Integer value2) {
            addCriterion("bad_debt_days between", value1, value2, "badDebtDays");
            return (Criteria) this;
        }

        public Criteria andBadDebtDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("bad_debt_days not between", value1, value2, "badDebtDays");
            return (Criteria) this;
        }

        public Criteria andBorrowMgmtRateIsNull() {
            addCriterion("borrow_mgmt_rate is null");
            return (Criteria) this;
        }

        public Criteria andBorrowMgmtRateIsNotNull() {
            addCriterion("borrow_mgmt_rate is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowMgmtRateEqualTo(String value) {
            addCriterion("borrow_mgmt_rate =", value, "borrowMgmtRate");
            return (Criteria) this;
        }

        public Criteria andBorrowMgmtRateNotEqualTo(String value) {
            addCriterion("borrow_mgmt_rate <>", value, "borrowMgmtRate");
            return (Criteria) this;
        }

        public Criteria andBorrowMgmtRateGreaterThan(String value) {
            addCriterion("borrow_mgmt_rate >", value, "borrowMgmtRate");
            return (Criteria) this;
        }

        public Criteria andBorrowMgmtRateGreaterThanOrEqualTo(String value) {
            addCriterion("borrow_mgmt_rate >=", value, "borrowMgmtRate");
            return (Criteria) this;
        }

        public Criteria andBorrowMgmtRateLessThan(String value) {
            addCriterion("borrow_mgmt_rate <", value, "borrowMgmtRate");
            return (Criteria) this;
        }

        public Criteria andBorrowMgmtRateLessThanOrEqualTo(String value) {
            addCriterion("borrow_mgmt_rate <=", value, "borrowMgmtRate");
            return (Criteria) this;
        }

        public Criteria andBorrowMgmtRateLike(String value) {
            addCriterion("borrow_mgmt_rate like", value, "borrowMgmtRate");
            return (Criteria) this;
        }

        public Criteria andBorrowMgmtRateNotLike(String value) {
            addCriterion("borrow_mgmt_rate not like", value, "borrowMgmtRate");
            return (Criteria) this;
        }

        public Criteria andBorrowMgmtRateIn(List<String> values) {
            addCriterion("borrow_mgmt_rate in", values, "borrowMgmtRate");
            return (Criteria) this;
        }

        public Criteria andBorrowMgmtRateNotIn(List<String> values) {
            addCriterion("borrow_mgmt_rate not in", values, "borrowMgmtRate");
            return (Criteria) this;
        }

        public Criteria andBorrowMgmtRateBetween(String value1, String value2) {
            addCriterion("borrow_mgmt_rate between", value1, value2, "borrowMgmtRate");
            return (Criteria) this;
        }

        public Criteria andBorrowMgmtRateNotBetween(String value1, String value2) {
            addCriterion("borrow_mgmt_rate not between", value1, value2, "borrowMgmtRate");
            return (Criteria) this;
        }

        public Criteria andGuaranteeRateIsNull() {
            addCriterion("guarantee_rate is null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeRateIsNotNull() {
            addCriterion("guarantee_rate is not null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeRateEqualTo(String value) {
            addCriterion("guarantee_rate =", value, "guaranteeRate");
            return (Criteria) this;
        }

        public Criteria andGuaranteeRateNotEqualTo(String value) {
            addCriterion("guarantee_rate <>", value, "guaranteeRate");
            return (Criteria) this;
        }

        public Criteria andGuaranteeRateGreaterThan(String value) {
            addCriterion("guarantee_rate >", value, "guaranteeRate");
            return (Criteria) this;
        }

        public Criteria andGuaranteeRateGreaterThanOrEqualTo(String value) {
            addCriterion("guarantee_rate >=", value, "guaranteeRate");
            return (Criteria) this;
        }

        public Criteria andGuaranteeRateLessThan(String value) {
            addCriterion("guarantee_rate <", value, "guaranteeRate");
            return (Criteria) this;
        }

        public Criteria andGuaranteeRateLessThanOrEqualTo(String value) {
            addCriterion("guarantee_rate <=", value, "guaranteeRate");
            return (Criteria) this;
        }

        public Criteria andGuaranteeRateLike(String value) {
            addCriterion("guarantee_rate like", value, "guaranteeRate");
            return (Criteria) this;
        }

        public Criteria andGuaranteeRateNotLike(String value) {
            addCriterion("guarantee_rate not like", value, "guaranteeRate");
            return (Criteria) this;
        }

        public Criteria andGuaranteeRateIn(List<String> values) {
            addCriterion("guarantee_rate in", values, "guaranteeRate");
            return (Criteria) this;
        }

        public Criteria andGuaranteeRateNotIn(List<String> values) {
            addCriterion("guarantee_rate not in", values, "guaranteeRate");
            return (Criteria) this;
        }

        public Criteria andGuaranteeRateBetween(String value1, String value2) {
            addCriterion("guarantee_rate between", value1, value2, "guaranteeRate");
            return (Criteria) this;
        }

        public Criteria andGuaranteeRateNotBetween(String value1, String value2) {
            addCriterion("guarantee_rate not between", value1, value2, "guaranteeRate");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestRate1IsNull() {
            addCriterion("overdue_interest_rate1 is null");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestRate1IsNotNull() {
            addCriterion("overdue_interest_rate1 is not null");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestRate1EqualTo(String value) {
            addCriterion("overdue_interest_rate1 =", value, "overdueInterestRate1");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestRate1NotEqualTo(String value) {
            addCriterion("overdue_interest_rate1 <>", value, "overdueInterestRate1");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestRate1GreaterThan(String value) {
            addCriterion("overdue_interest_rate1 >", value, "overdueInterestRate1");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestRate1GreaterThanOrEqualTo(String value) {
            addCriterion("overdue_interest_rate1 >=", value, "overdueInterestRate1");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestRate1LessThan(String value) {
            addCriterion("overdue_interest_rate1 <", value, "overdueInterestRate1");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestRate1LessThanOrEqualTo(String value) {
            addCriterion("overdue_interest_rate1 <=", value, "overdueInterestRate1");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestRate1Like(String value) {
            addCriterion("overdue_interest_rate1 like", value, "overdueInterestRate1");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestRate1NotLike(String value) {
            addCriterion("overdue_interest_rate1 not like", value, "overdueInterestRate1");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestRate1In(List<String> values) {
            addCriterion("overdue_interest_rate1 in", values, "overdueInterestRate1");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestRate1NotIn(List<String> values) {
            addCriterion("overdue_interest_rate1 not in", values, "overdueInterestRate1");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestRate1Between(String value1, String value2) {
            addCriterion("overdue_interest_rate1 between", value1, value2, "overdueInterestRate1");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestRate1NotBetween(String value1, String value2) {
            addCriterion("overdue_interest_rate1 not between", value1, value2, "overdueInterestRate1");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestRate2IsNull() {
            addCriterion("overdue_interest_rate2 is null");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestRate2IsNotNull() {
            addCriterion("overdue_interest_rate2 is not null");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestRate2EqualTo(String value) {
            addCriterion("overdue_interest_rate2 =", value, "overdueInterestRate2");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestRate2NotEqualTo(String value) {
            addCriterion("overdue_interest_rate2 <>", value, "overdueInterestRate2");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestRate2GreaterThan(String value) {
            addCriterion("overdue_interest_rate2 >", value, "overdueInterestRate2");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestRate2GreaterThanOrEqualTo(String value) {
            addCriterion("overdue_interest_rate2 >=", value, "overdueInterestRate2");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestRate2LessThan(String value) {
            addCriterion("overdue_interest_rate2 <", value, "overdueInterestRate2");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestRate2LessThanOrEqualTo(String value) {
            addCriterion("overdue_interest_rate2 <=", value, "overdueInterestRate2");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestRate2Like(String value) {
            addCriterion("overdue_interest_rate2 like", value, "overdueInterestRate2");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestRate2NotLike(String value) {
            addCriterion("overdue_interest_rate2 not like", value, "overdueInterestRate2");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestRate2In(List<String> values) {
            addCriterion("overdue_interest_rate2 in", values, "overdueInterestRate2");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestRate2NotIn(List<String> values) {
            addCriterion("overdue_interest_rate2 not in", values, "overdueInterestRate2");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestRate2Between(String value1, String value2) {
            addCriterion("overdue_interest_rate2 between", value1, value2, "overdueInterestRate2");
            return (Criteria) this;
        }

        public Criteria andOverdueInterestRate2NotBetween(String value1, String value2) {
            addCriterion("overdue_interest_rate2 not between", value1, value2, "overdueInterestRate2");
            return (Criteria) this;
        }

        public Criteria andOverdueMgmtRate1IsNull() {
            addCriterion("overdue_mgmt_rate1 is null");
            return (Criteria) this;
        }

        public Criteria andOverdueMgmtRate1IsNotNull() {
            addCriterion("overdue_mgmt_rate1 is not null");
            return (Criteria) this;
        }

        public Criteria andOverdueMgmtRate1EqualTo(String value) {
            addCriterion("overdue_mgmt_rate1 =", value, "overdueMgmtRate1");
            return (Criteria) this;
        }

        public Criteria andOverdueMgmtRate1NotEqualTo(String value) {
            addCriterion("overdue_mgmt_rate1 <>", value, "overdueMgmtRate1");
            return (Criteria) this;
        }

        public Criteria andOverdueMgmtRate1GreaterThan(String value) {
            addCriterion("overdue_mgmt_rate1 >", value, "overdueMgmtRate1");
            return (Criteria) this;
        }

        public Criteria andOverdueMgmtRate1GreaterThanOrEqualTo(String value) {
            addCriterion("overdue_mgmt_rate1 >=", value, "overdueMgmtRate1");
            return (Criteria) this;
        }

        public Criteria andOverdueMgmtRate1LessThan(String value) {
            addCriterion("overdue_mgmt_rate1 <", value, "overdueMgmtRate1");
            return (Criteria) this;
        }

        public Criteria andOverdueMgmtRate1LessThanOrEqualTo(String value) {
            addCriterion("overdue_mgmt_rate1 <=", value, "overdueMgmtRate1");
            return (Criteria) this;
        }

        public Criteria andOverdueMgmtRate1Like(String value) {
            addCriterion("overdue_mgmt_rate1 like", value, "overdueMgmtRate1");
            return (Criteria) this;
        }

        public Criteria andOverdueMgmtRate1NotLike(String value) {
            addCriterion("overdue_mgmt_rate1 not like", value, "overdueMgmtRate1");
            return (Criteria) this;
        }

        public Criteria andOverdueMgmtRate1In(List<String> values) {
            addCriterion("overdue_mgmt_rate1 in", values, "overdueMgmtRate1");
            return (Criteria) this;
        }

        public Criteria andOverdueMgmtRate1NotIn(List<String> values) {
            addCriterion("overdue_mgmt_rate1 not in", values, "overdueMgmtRate1");
            return (Criteria) this;
        }

        public Criteria andOverdueMgmtRate1Between(String value1, String value2) {
            addCriterion("overdue_mgmt_rate1 between", value1, value2, "overdueMgmtRate1");
            return (Criteria) this;
        }

        public Criteria andOverdueMgmtRate1NotBetween(String value1, String value2) {
            addCriterion("overdue_mgmt_rate1 not between", value1, value2, "overdueMgmtRate1");
            return (Criteria) this;
        }

        public Criteria andOverdueMgmtRate2IsNull() {
            addCriterion("overdue_mgmt_rate2 is null");
            return (Criteria) this;
        }

        public Criteria andOverdueMgmtRate2IsNotNull() {
            addCriterion("overdue_mgmt_rate2 is not null");
            return (Criteria) this;
        }

        public Criteria andOverdueMgmtRate2EqualTo(String value) {
            addCriterion("overdue_mgmt_rate2 =", value, "overdueMgmtRate2");
            return (Criteria) this;
        }

        public Criteria andOverdueMgmtRate2NotEqualTo(String value) {
            addCriterion("overdue_mgmt_rate2 <>", value, "overdueMgmtRate2");
            return (Criteria) this;
        }

        public Criteria andOverdueMgmtRate2GreaterThan(String value) {
            addCriterion("overdue_mgmt_rate2 >", value, "overdueMgmtRate2");
            return (Criteria) this;
        }

        public Criteria andOverdueMgmtRate2GreaterThanOrEqualTo(String value) {
            addCriterion("overdue_mgmt_rate2 >=", value, "overdueMgmtRate2");
            return (Criteria) this;
        }

        public Criteria andOverdueMgmtRate2LessThan(String value) {
            addCriterion("overdue_mgmt_rate2 <", value, "overdueMgmtRate2");
            return (Criteria) this;
        }

        public Criteria andOverdueMgmtRate2LessThanOrEqualTo(String value) {
            addCriterion("overdue_mgmt_rate2 <=", value, "overdueMgmtRate2");
            return (Criteria) this;
        }

        public Criteria andOverdueMgmtRate2Like(String value) {
            addCriterion("overdue_mgmt_rate2 like", value, "overdueMgmtRate2");
            return (Criteria) this;
        }

        public Criteria andOverdueMgmtRate2NotLike(String value) {
            addCriterion("overdue_mgmt_rate2 not like", value, "overdueMgmtRate2");
            return (Criteria) this;
        }

        public Criteria andOverdueMgmtRate2In(List<String> values) {
            addCriterion("overdue_mgmt_rate2 in", values, "overdueMgmtRate2");
            return (Criteria) this;
        }

        public Criteria andOverdueMgmtRate2NotIn(List<String> values) {
            addCriterion("overdue_mgmt_rate2 not in", values, "overdueMgmtRate2");
            return (Criteria) this;
        }

        public Criteria andOverdueMgmtRate2Between(String value1, String value2) {
            addCriterion("overdue_mgmt_rate2 between", value1, value2, "overdueMgmtRate2");
            return (Criteria) this;
        }

        public Criteria andOverdueMgmtRate2NotBetween(String value1, String value2) {
            addCriterion("overdue_mgmt_rate2 not between", value1, value2, "overdueMgmtRate2");
            return (Criteria) this;
        }

        public Criteria andSvcRateIsNull() {
            addCriterion("svc_rate is null");
            return (Criteria) this;
        }

        public Criteria andSvcRateIsNotNull() {
            addCriterion("svc_rate is not null");
            return (Criteria) this;
        }

        public Criteria andSvcRateEqualTo(String value) {
            addCriterion("svc_rate =", value, "svcRate");
            return (Criteria) this;
        }

        public Criteria andSvcRateNotEqualTo(String value) {
            addCriterion("svc_rate <>", value, "svcRate");
            return (Criteria) this;
        }

        public Criteria andSvcRateGreaterThan(String value) {
            addCriterion("svc_rate >", value, "svcRate");
            return (Criteria) this;
        }

        public Criteria andSvcRateGreaterThanOrEqualTo(String value) {
            addCriterion("svc_rate >=", value, "svcRate");
            return (Criteria) this;
        }

        public Criteria andSvcRateLessThan(String value) {
            addCriterion("svc_rate <", value, "svcRate");
            return (Criteria) this;
        }

        public Criteria andSvcRateLessThanOrEqualTo(String value) {
            addCriterion("svc_rate <=", value, "svcRate");
            return (Criteria) this;
        }

        public Criteria andSvcRateLike(String value) {
            addCriterion("svc_rate like", value, "svcRate");
            return (Criteria) this;
        }

        public Criteria andSvcRateNotLike(String value) {
            addCriterion("svc_rate not like", value, "svcRate");
            return (Criteria) this;
        }

        public Criteria andSvcRateIn(List<String> values) {
            addCriterion("svc_rate in", values, "svcRate");
            return (Criteria) this;
        }

        public Criteria andSvcRateNotIn(List<String> values) {
            addCriterion("svc_rate not in", values, "svcRate");
            return (Criteria) this;
        }

        public Criteria andSvcRateBetween(String value1, String value2) {
            addCriterion("svc_rate between", value1, value2, "svcRate");
            return (Criteria) this;
        }

        public Criteria andSvcRateNotBetween(String value1, String value2) {
            addCriterion("svc_rate not between", value1, value2, "svcRate");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andLegalReprIsNull() {
            addCriterion("legal_repr is null");
            return (Criteria) this;
        }

        public Criteria andLegalReprIsNotNull() {
            addCriterion("legal_repr is not null");
            return (Criteria) this;
        }

        public Criteria andLegalReprEqualTo(String value) {
            addCriterion("legal_repr =", value, "legalRepr");
            return (Criteria) this;
        }

        public Criteria andLegalReprNotEqualTo(String value) {
            addCriterion("legal_repr <>", value, "legalRepr");
            return (Criteria) this;
        }

        public Criteria andLegalReprGreaterThan(String value) {
            addCriterion("legal_repr >", value, "legalRepr");
            return (Criteria) this;
        }

        public Criteria andLegalReprGreaterThanOrEqualTo(String value) {
            addCriterion("legal_repr >=", value, "legalRepr");
            return (Criteria) this;
        }

        public Criteria andLegalReprLessThan(String value) {
            addCriterion("legal_repr <", value, "legalRepr");
            return (Criteria) this;
        }

        public Criteria andLegalReprLessThanOrEqualTo(String value) {
            addCriterion("legal_repr <=", value, "legalRepr");
            return (Criteria) this;
        }

        public Criteria andLegalReprLike(String value) {
            addCriterion("legal_repr like", value, "legalRepr");
            return (Criteria) this;
        }

        public Criteria andLegalReprNotLike(String value) {
            addCriterion("legal_repr not like", value, "legalRepr");
            return (Criteria) this;
        }

        public Criteria andLegalReprIn(List<String> values) {
            addCriterion("legal_repr in", values, "legalRepr");
            return (Criteria) this;
        }

        public Criteria andLegalReprNotIn(List<String> values) {
            addCriterion("legal_repr not in", values, "legalRepr");
            return (Criteria) this;
        }

        public Criteria andLegalReprBetween(String value1, String value2) {
            addCriterion("legal_repr between", value1, value2, "legalRepr");
            return (Criteria) this;
        }

        public Criteria andLegalReprNotBetween(String value1, String value2) {
            addCriterion("legal_repr not between", value1, value2, "legalRepr");
            return (Criteria) this;
        }

        public Criteria andMortgageratesIsNull() {
            addCriterion("mortgageRates is null");
            return (Criteria) this;
        }

        public Criteria andMortgageratesIsNotNull() {
            addCriterion("mortgageRates is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageratesEqualTo(Double value) {
            addCriterion("mortgageRates =", value, "mortgagerates");
            return (Criteria) this;
        }

        public Criteria andMortgageratesNotEqualTo(Double value) {
            addCriterion("mortgageRates <>", value, "mortgagerates");
            return (Criteria) this;
        }

        public Criteria andMortgageratesGreaterThan(Double value) {
            addCriterion("mortgageRates >", value, "mortgagerates");
            return (Criteria) this;
        }

        public Criteria andMortgageratesGreaterThanOrEqualTo(Double value) {
            addCriterion("mortgageRates >=", value, "mortgagerates");
            return (Criteria) this;
        }

        public Criteria andMortgageratesLessThan(Double value) {
            addCriterion("mortgageRates <", value, "mortgagerates");
            return (Criteria) this;
        }

        public Criteria andMortgageratesLessThanOrEqualTo(Double value) {
            addCriterion("mortgageRates <=", value, "mortgagerates");
            return (Criteria) this;
        }

        public Criteria andMortgageratesIn(List<Double> values) {
            addCriterion("mortgageRates in", values, "mortgagerates");
            return (Criteria) this;
        }

        public Criteria andMortgageratesNotIn(List<Double> values) {
            addCriterion("mortgageRates not in", values, "mortgagerates");
            return (Criteria) this;
        }

        public Criteria andMortgageratesBetween(Double value1, Double value2) {
            addCriterion("mortgageRates between", value1, value2, "mortgagerates");
            return (Criteria) this;
        }

        public Criteria andMortgageratesNotBetween(Double value1, Double value2) {
            addCriterion("mortgageRates not between", value1, value2, "mortgagerates");
            return (Criteria) this;
        }

        public Criteria andMortgagevalueIsNull() {
            addCriterion("mortgageValue is null");
            return (Criteria) this;
        }

        public Criteria andMortgagevalueIsNotNull() {
            addCriterion("mortgageValue is not null");
            return (Criteria) this;
        }

        public Criteria andMortgagevalueEqualTo(Double value) {
            addCriterion("mortgageValue =", value, "mortgagevalue");
            return (Criteria) this;
        }

        public Criteria andMortgagevalueNotEqualTo(Double value) {
            addCriterion("mortgageValue <>", value, "mortgagevalue");
            return (Criteria) this;
        }

        public Criteria andMortgagevalueGreaterThan(Double value) {
            addCriterion("mortgageValue >", value, "mortgagevalue");
            return (Criteria) this;
        }

        public Criteria andMortgagevalueGreaterThanOrEqualTo(Double value) {
            addCriterion("mortgageValue >=", value, "mortgagevalue");
            return (Criteria) this;
        }

        public Criteria andMortgagevalueLessThan(Double value) {
            addCriterion("mortgageValue <", value, "mortgagevalue");
            return (Criteria) this;
        }

        public Criteria andMortgagevalueLessThanOrEqualTo(Double value) {
            addCriterion("mortgageValue <=", value, "mortgagevalue");
            return (Criteria) this;
        }

        public Criteria andMortgagevalueIn(List<Double> values) {
            addCriterion("mortgageValue in", values, "mortgagevalue");
            return (Criteria) this;
        }

        public Criteria andMortgagevalueNotIn(List<Double> values) {
            addCriterion("mortgageValue not in", values, "mortgagevalue");
            return (Criteria) this;
        }

        public Criteria andMortgagevalueBetween(Double value1, Double value2) {
            addCriterion("mortgageValue between", value1, value2, "mortgagevalue");
            return (Criteria) this;
        }

        public Criteria andMortgagevalueNotBetween(Double value1, Double value2) {
            addCriterion("mortgageValue not between", value1, value2, "mortgagevalue");
            return (Criteria) this;
        }

        public Criteria andPledgorIsNull() {
            addCriterion("pledgor is null");
            return (Criteria) this;
        }

        public Criteria andPledgorIsNotNull() {
            addCriterion("pledgor is not null");
            return (Criteria) this;
        }

        public Criteria andPledgorEqualTo(String value) {
            addCriterion("pledgor =", value, "pledgor");
            return (Criteria) this;
        }

        public Criteria andPledgorNotEqualTo(String value) {
            addCriterion("pledgor <>", value, "pledgor");
            return (Criteria) this;
        }

        public Criteria andPledgorGreaterThan(String value) {
            addCriterion("pledgor >", value, "pledgor");
            return (Criteria) this;
        }

        public Criteria andPledgorGreaterThanOrEqualTo(String value) {
            addCriterion("pledgor >=", value, "pledgor");
            return (Criteria) this;
        }

        public Criteria andPledgorLessThan(String value) {
            addCriterion("pledgor <", value, "pledgor");
            return (Criteria) this;
        }

        public Criteria andPledgorLessThanOrEqualTo(String value) {
            addCriterion("pledgor <=", value, "pledgor");
            return (Criteria) this;
        }

        public Criteria andPledgorLike(String value) {
            addCriterion("pledgor like", value, "pledgor");
            return (Criteria) this;
        }

        public Criteria andPledgorNotLike(String value) {
            addCriterion("pledgor not like", value, "pledgor");
            return (Criteria) this;
        }

        public Criteria andPledgorIn(List<String> values) {
            addCriterion("pledgor in", values, "pledgor");
            return (Criteria) this;
        }

        public Criteria andPledgorNotIn(List<String> values) {
            addCriterion("pledgor not in", values, "pledgor");
            return (Criteria) this;
        }

        public Criteria andPledgorBetween(String value1, String value2) {
            addCriterion("pledgor between", value1, value2, "pledgor");
            return (Criteria) this;
        }

        public Criteria andPledgorNotBetween(String value1, String value2) {
            addCriterion("pledgor not between", value1, value2, "pledgor");
            return (Criteria) this;
        }

        public Criteria andResidenceIsNull() {
            addCriterion("residence is null");
            return (Criteria) this;
        }

        public Criteria andResidenceIsNotNull() {
            addCriterion("residence is not null");
            return (Criteria) this;
        }

        public Criteria andResidenceEqualTo(String value) {
            addCriterion("residence =", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceNotEqualTo(String value) {
            addCriterion("residence <>", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceGreaterThan(String value) {
            addCriterion("residence >", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceGreaterThanOrEqualTo(String value) {
            addCriterion("residence >=", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceLessThan(String value) {
            addCriterion("residence <", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceLessThanOrEqualTo(String value) {
            addCriterion("residence <=", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceLike(String value) {
            addCriterion("residence like", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceNotLike(String value) {
            addCriterion("residence not like", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceIn(List<String> values) {
            addCriterion("residence in", values, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceNotIn(List<String> values) {
            addCriterion("residence not in", values, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceBetween(String value1, String value2) {
            addCriterion("residence between", value1, value2, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceNotBetween(String value1, String value2) {
            addCriterion("residence not between", value1, value2, "residence");
            return (Criteria) this;
        }

        public Criteria andInternalInterestRateIsNull() {
            addCriterion("internal_interest_rate is null");
            return (Criteria) this;
        }

        public Criteria andInternalInterestRateIsNotNull() {
            addCriterion("internal_interest_rate is not null");
            return (Criteria) this;
        }

        public Criteria andInternalInterestRateEqualTo(BigDecimal value) {
            addCriterion("internal_interest_rate =", value, "internalInterestRate");
            return (Criteria) this;
        }

        public Criteria andInternalInterestRateNotEqualTo(BigDecimal value) {
            addCriterion("internal_interest_rate <>", value, "internalInterestRate");
            return (Criteria) this;
        }

        public Criteria andInternalInterestRateGreaterThan(BigDecimal value) {
            addCriterion("internal_interest_rate >", value, "internalInterestRate");
            return (Criteria) this;
        }

        public Criteria andInternalInterestRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("internal_interest_rate >=", value, "internalInterestRate");
            return (Criteria) this;
        }

        public Criteria andInternalInterestRateLessThan(BigDecimal value) {
            addCriterion("internal_interest_rate <", value, "internalInterestRate");
            return (Criteria) this;
        }

        public Criteria andInternalInterestRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("internal_interest_rate <=", value, "internalInterestRate");
            return (Criteria) this;
        }

        public Criteria andInternalInterestRateIn(List<BigDecimal> values) {
            addCriterion("internal_interest_rate in", values, "internalInterestRate");
            return (Criteria) this;
        }

        public Criteria andInternalInterestRateNotIn(List<BigDecimal> values) {
            addCriterion("internal_interest_rate not in", values, "internalInterestRate");
            return (Criteria) this;
        }

        public Criteria andInternalInterestRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("internal_interest_rate between", value1, value2, "internalInterestRate");
            return (Criteria) this;
        }

        public Criteria andInternalInterestRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("internal_interest_rate not between", value1, value2, "internalInterestRate");
            return (Criteria) this;
        }

        public Criteria andInternalRepayAmountIsNull() {
            addCriterion("internal_repay_amount is null");
            return (Criteria) this;
        }

        public Criteria andInternalRepayAmountIsNotNull() {
            addCriterion("internal_repay_amount is not null");
            return (Criteria) this;
        }

        public Criteria andInternalRepayAmountEqualTo(BigDecimal value) {
            addCriterion("internal_repay_amount =", value, "internalRepayAmount");
            return (Criteria) this;
        }

        public Criteria andInternalRepayAmountNotEqualTo(BigDecimal value) {
            addCriterion("internal_repay_amount <>", value, "internalRepayAmount");
            return (Criteria) this;
        }

        public Criteria andInternalRepayAmountGreaterThan(BigDecimal value) {
            addCriterion("internal_repay_amount >", value, "internalRepayAmount");
            return (Criteria) this;
        }

        public Criteria andInternalRepayAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("internal_repay_amount >=", value, "internalRepayAmount");
            return (Criteria) this;
        }

        public Criteria andInternalRepayAmountLessThan(BigDecimal value) {
            addCriterion("internal_repay_amount <", value, "internalRepayAmount");
            return (Criteria) this;
        }

        public Criteria andInternalRepayAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("internal_repay_amount <=", value, "internalRepayAmount");
            return (Criteria) this;
        }

        public Criteria andInternalRepayAmountIn(List<BigDecimal> values) {
            addCriterion("internal_repay_amount in", values, "internalRepayAmount");
            return (Criteria) this;
        }

        public Criteria andInternalRepayAmountNotIn(List<BigDecimal> values) {
            addCriterion("internal_repay_amount not in", values, "internalRepayAmount");
            return (Criteria) this;
        }

        public Criteria andInternalRepayAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("internal_repay_amount between", value1, value2, "internalRepayAmount");
            return (Criteria) this;
        }

        public Criteria andInternalRepayAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("internal_repay_amount not between", value1, value2, "internalRepayAmount");
            return (Criteria) this;
        }

        public Criteria andContractinfoIsNull() {
            addCriterion("contractInfo is null");
            return (Criteria) this;
        }

        public Criteria andContractinfoIsNotNull() {
            addCriterion("contractInfo is not null");
            return (Criteria) this;
        }

        public Criteria andContractinfoEqualTo(String value) {
            addCriterion("contractInfo =", value, "contractinfo");
            return (Criteria) this;
        }

        public Criteria andContractinfoNotEqualTo(String value) {
            addCriterion("contractInfo <>", value, "contractinfo");
            return (Criteria) this;
        }

        public Criteria andContractinfoGreaterThan(String value) {
            addCriterion("contractInfo >", value, "contractinfo");
            return (Criteria) this;
        }

        public Criteria andContractinfoGreaterThanOrEqualTo(String value) {
            addCriterion("contractInfo >=", value, "contractinfo");
            return (Criteria) this;
        }

        public Criteria andContractinfoLessThan(String value) {
            addCriterion("contractInfo <", value, "contractinfo");
            return (Criteria) this;
        }

        public Criteria andContractinfoLessThanOrEqualTo(String value) {
            addCriterion("contractInfo <=", value, "contractinfo");
            return (Criteria) this;
        }

        public Criteria andContractinfoLike(String value) {
            addCriterion("contractInfo like", value, "contractinfo");
            return (Criteria) this;
        }

        public Criteria andContractinfoNotLike(String value) {
            addCriterion("contractInfo not like", value, "contractinfo");
            return (Criteria) this;
        }

        public Criteria andContractinfoIn(List<String> values) {
            addCriterion("contractInfo in", values, "contractinfo");
            return (Criteria) this;
        }

        public Criteria andContractinfoNotIn(List<String> values) {
            addCriterion("contractInfo not in", values, "contractinfo");
            return (Criteria) this;
        }

        public Criteria andContractinfoBetween(String value1, String value2) {
            addCriterion("contractInfo between", value1, value2, "contractinfo");
            return (Criteria) this;
        }

        public Criteria andContractinfoNotBetween(String value1, String value2) {
            addCriterion("contractInfo not between", value1, value2, "contractinfo");
            return (Criteria) this;
        }

        public Criteria andLoanguaranteetypeIsNull() {
            addCriterion("loanGuaranteeType is null");
            return (Criteria) this;
        }

        public Criteria andLoanguaranteetypeIsNotNull() {
            addCriterion("loanGuaranteeType is not null");
            return (Criteria) this;
        }

        public Criteria andLoanguaranteetypeEqualTo(String value) {
            addCriterion("loanGuaranteeType =", value, "loanguaranteetype");
            return (Criteria) this;
        }

        public Criteria andLoanguaranteetypeNotEqualTo(String value) {
            addCriterion("loanGuaranteeType <>", value, "loanguaranteetype");
            return (Criteria) this;
        }

        public Criteria andLoanguaranteetypeGreaterThan(String value) {
            addCriterion("loanGuaranteeType >", value, "loanguaranteetype");
            return (Criteria) this;
        }

        public Criteria andLoanguaranteetypeGreaterThanOrEqualTo(String value) {
            addCriterion("loanGuaranteeType >=", value, "loanguaranteetype");
            return (Criteria) this;
        }

        public Criteria andLoanguaranteetypeLessThan(String value) {
            addCriterion("loanGuaranteeType <", value, "loanguaranteetype");
            return (Criteria) this;
        }

        public Criteria andLoanguaranteetypeLessThanOrEqualTo(String value) {
            addCriterion("loanGuaranteeType <=", value, "loanguaranteetype");
            return (Criteria) this;
        }

        public Criteria andLoanguaranteetypeLike(String value) {
            addCriterion("loanGuaranteeType like", value, "loanguaranteetype");
            return (Criteria) this;
        }

        public Criteria andLoanguaranteetypeNotLike(String value) {
            addCriterion("loanGuaranteeType not like", value, "loanguaranteetype");
            return (Criteria) this;
        }

        public Criteria andLoanguaranteetypeIn(List<String> values) {
            addCriterion("loanGuaranteeType in", values, "loanguaranteetype");
            return (Criteria) this;
        }

        public Criteria andLoanguaranteetypeNotIn(List<String> values) {
            addCriterion("loanGuaranteeType not in", values, "loanguaranteetype");
            return (Criteria) this;
        }

        public Criteria andLoanguaranteetypeBetween(String value1, String value2) {
            addCriterion("loanGuaranteeType between", value1, value2, "loanguaranteetype");
            return (Criteria) this;
        }

        public Criteria andLoanguaranteetypeNotBetween(String value1, String value2) {
            addCriterion("loanGuaranteeType not between", value1, value2, "loanguaranteetype");
            return (Criteria) this;
        }

        public Criteria andContracttemplateidIsNull() {
            addCriterion("contractTemplateId is null");
            return (Criteria) this;
        }

        public Criteria andContracttemplateidIsNotNull() {
            addCriterion("contractTemplateId is not null");
            return (Criteria) this;
        }

        public Criteria andContracttemplateidEqualTo(Integer value) {
            addCriterion("contractTemplateId =", value, "contracttemplateid");
            return (Criteria) this;
        }

        public Criteria andContracttemplateidNotEqualTo(Integer value) {
            addCriterion("contractTemplateId <>", value, "contracttemplateid");
            return (Criteria) this;
        }

        public Criteria andContracttemplateidGreaterThan(Integer value) {
            addCriterion("contractTemplateId >", value, "contracttemplateid");
            return (Criteria) this;
        }

        public Criteria andContracttemplateidGreaterThanOrEqualTo(Integer value) {
            addCriterion("contractTemplateId >=", value, "contracttemplateid");
            return (Criteria) this;
        }

        public Criteria andContracttemplateidLessThan(Integer value) {
            addCriterion("contractTemplateId <", value, "contracttemplateid");
            return (Criteria) this;
        }

        public Criteria andContracttemplateidLessThanOrEqualTo(Integer value) {
            addCriterion("contractTemplateId <=", value, "contracttemplateid");
            return (Criteria) this;
        }

        public Criteria andContracttemplateidIn(List<Integer> values) {
            addCriterion("contractTemplateId in", values, "contracttemplateid");
            return (Criteria) this;
        }

        public Criteria andContracttemplateidNotIn(List<Integer> values) {
            addCriterion("contractTemplateId not in", values, "contracttemplateid");
            return (Criteria) this;
        }

        public Criteria andContracttemplateidBetween(Integer value1, Integer value2) {
            addCriterion("contractTemplateId between", value1, value2, "contracttemplateid");
            return (Criteria) this;
        }

        public Criteria andContracttemplateidNotBetween(Integer value1, Integer value2) {
            addCriterion("contractTemplateId not between", value1, value2, "contracttemplateid");
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