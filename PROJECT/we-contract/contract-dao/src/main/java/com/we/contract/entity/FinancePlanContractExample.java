package com.we.contract.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FinancePlanContractExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public FinancePlanContractExample() {
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

        public Criteria andFinancePlanIdIsNull() {
            addCriterion("finance_plan_id is null");
            return (Criteria) this;
        }

        public Criteria andFinancePlanIdIsNotNull() {
            addCriterion("finance_plan_id is not null");
            return (Criteria) this;
        }

        public Criteria andFinancePlanIdEqualTo(Integer value) {
            addCriterion("finance_plan_id =", value, "financePlanId");
            return (Criteria) this;
        }

        public Criteria andFinancePlanIdNotEqualTo(Integer value) {
            addCriterion("finance_plan_id <>", value, "financePlanId");
            return (Criteria) this;
        }

        public Criteria andFinancePlanIdGreaterThan(Integer value) {
            addCriterion("finance_plan_id >", value, "financePlanId");
            return (Criteria) this;
        }

        public Criteria andFinancePlanIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("finance_plan_id >=", value, "financePlanId");
            return (Criteria) this;
        }

        public Criteria andFinancePlanIdLessThan(Integer value) {
            addCriterion("finance_plan_id <", value, "financePlanId");
            return (Criteria) this;
        }

        public Criteria andFinancePlanIdLessThanOrEqualTo(Integer value) {
            addCriterion("finance_plan_id <=", value, "financePlanId");
            return (Criteria) this;
        }

        public Criteria andFinancePlanIdIn(List<Integer> values) {
            addCriterion("finance_plan_id in", values, "financePlanId");
            return (Criteria) this;
        }

        public Criteria andFinancePlanIdNotIn(List<Integer> values) {
            addCriterion("finance_plan_id not in", values, "financePlanId");
            return (Criteria) this;
        }

        public Criteria andFinancePlanIdBetween(Integer value1, Integer value2) {
            addCriterion("finance_plan_id between", value1, value2, "financePlanId");
            return (Criteria) this;
        }

        public Criteria andFinancePlanIdNotBetween(Integer value1, Integer value2) {
            addCriterion("finance_plan_id not between", value1, value2, "financePlanId");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andReserveAmountIsNull() {
            addCriterion("reserve_amount is null");
            return (Criteria) this;
        }

        public Criteria andReserveAmountIsNotNull() {
            addCriterion("reserve_amount is not null");
            return (Criteria) this;
        }

        public Criteria andReserveAmountEqualTo(BigDecimal value) {
            addCriterion("reserve_amount =", value, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andReserveAmountNotEqualTo(BigDecimal value) {
            addCriterion("reserve_amount <>", value, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andReserveAmountGreaterThan(BigDecimal value) {
            addCriterion("reserve_amount >", value, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andReserveAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("reserve_amount >=", value, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andReserveAmountLessThan(BigDecimal value) {
            addCriterion("reserve_amount <", value, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andReserveAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("reserve_amount <=", value, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andReserveAmountIn(List<BigDecimal> values) {
            addCriterion("reserve_amount in", values, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andReserveAmountNotIn(List<BigDecimal> values) {
            addCriterion("reserve_amount not in", values, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andReserveAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("reserve_amount between", value1, value2, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andReserveAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("reserve_amount not between", value1, value2, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andSubPointTypeIsNull() {
            addCriterion("sub_point_type is null");
            return (Criteria) this;
        }

        public Criteria andSubPointTypeIsNotNull() {
            addCriterion("sub_point_type is not null");
            return (Criteria) this;
        }

        public Criteria andSubPointTypeEqualTo(String value) {
            addCriterion("sub_point_type =", value, "subPointType");
            return (Criteria) this;
        }

        public Criteria andSubPointTypeNotEqualTo(String value) {
            addCriterion("sub_point_type <>", value, "subPointType");
            return (Criteria) this;
        }

        public Criteria andSubPointTypeGreaterThan(String value) {
            addCriterion("sub_point_type >", value, "subPointType");
            return (Criteria) this;
        }

        public Criteria andSubPointTypeGreaterThanOrEqualTo(String value) {
            addCriterion("sub_point_type >=", value, "subPointType");
            return (Criteria) this;
        }

        public Criteria andSubPointTypeLessThan(String value) {
            addCriterion("sub_point_type <", value, "subPointType");
            return (Criteria) this;
        }

        public Criteria andSubPointTypeLessThanOrEqualTo(String value) {
            addCriterion("sub_point_type <=", value, "subPointType");
            return (Criteria) this;
        }

        public Criteria andSubPointTypeLike(String value) {
            addCriterion("sub_point_type like", value, "subPointType");
            return (Criteria) this;
        }

        public Criteria andSubPointTypeNotLike(String value) {
            addCriterion("sub_point_type not like", value, "subPointType");
            return (Criteria) this;
        }

        public Criteria andSubPointTypeIn(List<String> values) {
            addCriterion("sub_point_type in", values, "subPointType");
            return (Criteria) this;
        }

        public Criteria andSubPointTypeNotIn(List<String> values) {
            addCriterion("sub_point_type not in", values, "subPointType");
            return (Criteria) this;
        }

        public Criteria andSubPointTypeBetween(String value1, String value2) {
            addCriterion("sub_point_type between", value1, value2, "subPointType");
            return (Criteria) this;
        }

        public Criteria andSubPointTypeNotBetween(String value1, String value2) {
            addCriterion("sub_point_type not between", value1, value2, "subPointType");
            return (Criteria) this;
        }

        public Criteria andMd5ValueIsNull() {
            addCriterion("md5_value is null");
            return (Criteria) this;
        }

        public Criteria andMd5ValueIsNotNull() {
            addCriterion("md5_value is not null");
            return (Criteria) this;
        }

        public Criteria andMd5ValueEqualTo(String value) {
            addCriterion("md5_value =", value, "md5Value");
            return (Criteria) this;
        }

        public Criteria andMd5ValueNotEqualTo(String value) {
            addCriterion("md5_value <>", value, "md5Value");
            return (Criteria) this;
        }

        public Criteria andMd5ValueGreaterThan(String value) {
            addCriterion("md5_value >", value, "md5Value");
            return (Criteria) this;
        }

        public Criteria andMd5ValueGreaterThanOrEqualTo(String value) {
            addCriterion("md5_value >=", value, "md5Value");
            return (Criteria) this;
        }

        public Criteria andMd5ValueLessThan(String value) {
            addCriterion("md5_value <", value, "md5Value");
            return (Criteria) this;
        }

        public Criteria andMd5ValueLessThanOrEqualTo(String value) {
            addCriterion("md5_value <=", value, "md5Value");
            return (Criteria) this;
        }

        public Criteria andMd5ValueLike(String value) {
            addCriterion("md5_value like", value, "md5Value");
            return (Criteria) this;
        }

        public Criteria andMd5ValueNotLike(String value) {
            addCriterion("md5_value not like", value, "md5Value");
            return (Criteria) this;
        }

        public Criteria andMd5ValueIn(List<String> values) {
            addCriterion("md5_value in", values, "md5Value");
            return (Criteria) this;
        }

        public Criteria andMd5ValueNotIn(List<String> values) {
            addCriterion("md5_value not in", values, "md5Value");
            return (Criteria) this;
        }

        public Criteria andMd5ValueBetween(String value1, String value2) {
            addCriterion("md5_value between", value1, value2, "md5Value");
            return (Criteria) this;
        }

        public Criteria andMd5ValueNotBetween(String value1, String value2) {
            addCriterion("md5_value not between", value1, value2, "md5Value");
            return (Criteria) this;
        }

        public Criteria andSaltValueIsNull() {
            addCriterion("salt_value is null");
            return (Criteria) this;
        }

        public Criteria andSaltValueIsNotNull() {
            addCriterion("salt_value is not null");
            return (Criteria) this;
        }

        public Criteria andSaltValueEqualTo(String value) {
            addCriterion("salt_value =", value, "saltValue");
            return (Criteria) this;
        }

        public Criteria andSaltValueNotEqualTo(String value) {
            addCriterion("salt_value <>", value, "saltValue");
            return (Criteria) this;
        }

        public Criteria andSaltValueGreaterThan(String value) {
            addCriterion("salt_value >", value, "saltValue");
            return (Criteria) this;
        }

        public Criteria andSaltValueGreaterThanOrEqualTo(String value) {
            addCriterion("salt_value >=", value, "saltValue");
            return (Criteria) this;
        }

        public Criteria andSaltValueLessThan(String value) {
            addCriterion("salt_value <", value, "saltValue");
            return (Criteria) this;
        }

        public Criteria andSaltValueLessThanOrEqualTo(String value) {
            addCriterion("salt_value <=", value, "saltValue");
            return (Criteria) this;
        }

        public Criteria andSaltValueLike(String value) {
            addCriterion("salt_value like", value, "saltValue");
            return (Criteria) this;
        }

        public Criteria andSaltValueNotLike(String value) {
            addCriterion("salt_value not like", value, "saltValue");
            return (Criteria) this;
        }

        public Criteria andSaltValueIn(List<String> values) {
            addCriterion("salt_value in", values, "saltValue");
            return (Criteria) this;
        }

        public Criteria andSaltValueNotIn(List<String> values) {
            addCriterion("salt_value not in", values, "saltValue");
            return (Criteria) this;
        }

        public Criteria andSaltValueBetween(String value1, String value2) {
            addCriterion("salt_value between", value1, value2, "saltValue");
            return (Criteria) this;
        }

        public Criteria andSaltValueNotBetween(String value1, String value2) {
            addCriterion("salt_value not between", value1, value2, "saltValue");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNull() {
            addCriterion("file_path is null");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNotNull() {
            addCriterion("file_path is not null");
            return (Criteria) this;
        }

        public Criteria andFilePathEqualTo(String value) {
            addCriterion("file_path =", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotEqualTo(String value) {
            addCriterion("file_path <>", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThan(String value) {
            addCriterion("file_path >", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("file_path >=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThan(String value) {
            addCriterion("file_path <", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThanOrEqualTo(String value) {
            addCriterion("file_path <=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLike(String value) {
            addCriterion("file_path like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotLike(String value) {
            addCriterion("file_path not like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathIn(List<String> values) {
            addCriterion("file_path in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotIn(List<String> values) {
            addCriterion("file_path not in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathBetween(String value1, String value2) {
            addCriterion("file_path between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotBetween(String value1, String value2) {
            addCriterion("file_path not between", value1, value2, "filePath");
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