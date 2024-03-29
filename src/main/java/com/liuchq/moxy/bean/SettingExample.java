package com.liuchq.moxy.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SettingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SettingExample() {
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

        public Criteria andSettingIdIsNull() {
            addCriterion("setting_id is null");
            return (Criteria) this;
        }

        public Criteria andSettingIdIsNotNull() {
            addCriterion("setting_id is not null");
            return (Criteria) this;
        }

        public Criteria andSettingIdEqualTo(String value) {
            addCriterion("setting_id =", value, "settingId");
            return (Criteria) this;
        }

        public Criteria andSettingIdNotEqualTo(String value) {
            addCriterion("setting_id <>", value, "settingId");
            return (Criteria) this;
        }

        public Criteria andSettingIdGreaterThan(String value) {
            addCriterion("setting_id >", value, "settingId");
            return (Criteria) this;
        }

        public Criteria andSettingIdGreaterThanOrEqualTo(String value) {
            addCriterion("setting_id >=", value, "settingId");
            return (Criteria) this;
        }

        public Criteria andSettingIdLessThan(String value) {
            addCriterion("setting_id <", value, "settingId");
            return (Criteria) this;
        }

        public Criteria andSettingIdLessThanOrEqualTo(String value) {
            addCriterion("setting_id <=", value, "settingId");
            return (Criteria) this;
        }

        public Criteria andSettingIdLike(String value) {
            addCriterion("setting_id like", value, "settingId");
            return (Criteria) this;
        }

        public Criteria andSettingIdNotLike(String value) {
            addCriterion("setting_id not like", value, "settingId");
            return (Criteria) this;
        }

        public Criteria andSettingIdIn(List<String> values) {
            addCriterion("setting_id in", values, "settingId");
            return (Criteria) this;
        }

        public Criteria andSettingIdNotIn(List<String> values) {
            addCriterion("setting_id not in", values, "settingId");
            return (Criteria) this;
        }

        public Criteria andSettingIdBetween(String value1, String value2) {
            addCriterion("setting_id between", value1, value2, "settingId");
            return (Criteria) this;
        }

        public Criteria andSettingIdNotBetween(String value1, String value2) {
            addCriterion("setting_id not between", value1, value2, "settingId");
            return (Criteria) this;
        }

        public Criteria andSettingKeyIsNull() {
            addCriterion("setting_key is null");
            return (Criteria) this;
        }

        public Criteria andSettingKeyIsNotNull() {
            addCriterion("setting_key is not null");
            return (Criteria) this;
        }

        public Criteria andSettingKeyEqualTo(String value) {
            addCriterion("setting_key =", value, "settingKey");
            return (Criteria) this;
        }

        public Criteria andSettingKeyNotEqualTo(String value) {
            addCriterion("setting_key <>", value, "settingKey");
            return (Criteria) this;
        }

        public Criteria andSettingKeyGreaterThan(String value) {
            addCriterion("setting_key >", value, "settingKey");
            return (Criteria) this;
        }

        public Criteria andSettingKeyGreaterThanOrEqualTo(String value) {
            addCriterion("setting_key >=", value, "settingKey");
            return (Criteria) this;
        }

        public Criteria andSettingKeyLessThan(String value) {
            addCriterion("setting_key <", value, "settingKey");
            return (Criteria) this;
        }

        public Criteria andSettingKeyLessThanOrEqualTo(String value) {
            addCriterion("setting_key <=", value, "settingKey");
            return (Criteria) this;
        }

        public Criteria andSettingKeyLike(String value) {
            addCriterion("setting_key like", value, "settingKey");
            return (Criteria) this;
        }

        public Criteria andSettingKeyNotLike(String value) {
            addCriterion("setting_key not like", value, "settingKey");
            return (Criteria) this;
        }

        public Criteria andSettingKeyIn(List<String> values) {
            addCriterion("setting_key in", values, "settingKey");
            return (Criteria) this;
        }

        public Criteria andSettingKeyNotIn(List<String> values) {
            addCriterion("setting_key not in", values, "settingKey");
            return (Criteria) this;
        }

        public Criteria andSettingKeyBetween(String value1, String value2) {
            addCriterion("setting_key between", value1, value2, "settingKey");
            return (Criteria) this;
        }

        public Criteria andSettingKeyNotBetween(String value1, String value2) {
            addCriterion("setting_key not between", value1, value2, "settingKey");
            return (Criteria) this;
        }

        public Criteria andSettingValueIsNull() {
            addCriterion("setting_value is null");
            return (Criteria) this;
        }

        public Criteria andSettingValueIsNotNull() {
            addCriterion("setting_value is not null");
            return (Criteria) this;
        }

        public Criteria andSettingValueEqualTo(String value) {
            addCriterion("setting_value =", value, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueNotEqualTo(String value) {
            addCriterion("setting_value <>", value, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueGreaterThan(String value) {
            addCriterion("setting_value >", value, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueGreaterThanOrEqualTo(String value) {
            addCriterion("setting_value >=", value, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueLessThan(String value) {
            addCriterion("setting_value <", value, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueLessThanOrEqualTo(String value) {
            addCriterion("setting_value <=", value, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueLike(String value) {
            addCriterion("setting_value like", value, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueNotLike(String value) {
            addCriterion("setting_value not like", value, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueIn(List<String> values) {
            addCriterion("setting_value in", values, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueNotIn(List<String> values) {
            addCriterion("setting_value not in", values, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueBetween(String value1, String value2) {
            addCriterion("setting_value between", value1, value2, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueNotBetween(String value1, String value2) {
            addCriterion("setting_value not between", value1, value2, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingCreatetimeIsNull() {
            addCriterion("setting_createtime is null");
            return (Criteria) this;
        }

        public Criteria andSettingCreatetimeIsNotNull() {
            addCriterion("setting_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andSettingCreatetimeEqualTo(Date value) {
            addCriterion("setting_createtime =", value, "settingCreatetime");
            return (Criteria) this;
        }

        public Criteria andSettingCreatetimeNotEqualTo(Date value) {
            addCriterion("setting_createtime <>", value, "settingCreatetime");
            return (Criteria) this;
        }

        public Criteria andSettingCreatetimeGreaterThan(Date value) {
            addCriterion("setting_createtime >", value, "settingCreatetime");
            return (Criteria) this;
        }

        public Criteria andSettingCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("setting_createtime >=", value, "settingCreatetime");
            return (Criteria) this;
        }

        public Criteria andSettingCreatetimeLessThan(Date value) {
            addCriterion("setting_createtime <", value, "settingCreatetime");
            return (Criteria) this;
        }

        public Criteria andSettingCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("setting_createtime <=", value, "settingCreatetime");
            return (Criteria) this;
        }

        public Criteria andSettingCreatetimeIn(List<Date> values) {
            addCriterion("setting_createtime in", values, "settingCreatetime");
            return (Criteria) this;
        }

        public Criteria andSettingCreatetimeNotIn(List<Date> values) {
            addCriterion("setting_createtime not in", values, "settingCreatetime");
            return (Criteria) this;
        }

        public Criteria andSettingCreatetimeBetween(Date value1, Date value2) {
            addCriterion("setting_createtime between", value1, value2, "settingCreatetime");
            return (Criteria) this;
        }

        public Criteria andSettingCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("setting_createtime not between", value1, value2, "settingCreatetime");
            return (Criteria) this;
        }

        public Criteria andSettingDescriptionIsNull() {
            addCriterion("setting_description is null");
            return (Criteria) this;
        }

        public Criteria andSettingDescriptionIsNotNull() {
            addCriterion("setting_description is not null");
            return (Criteria) this;
        }

        public Criteria andSettingDescriptionEqualTo(String value) {
            addCriterion("setting_description =", value, "settingDescription");
            return (Criteria) this;
        }

        public Criteria andSettingDescriptionNotEqualTo(String value) {
            addCriterion("setting_description <>", value, "settingDescription");
            return (Criteria) this;
        }

        public Criteria andSettingDescriptionGreaterThan(String value) {
            addCriterion("setting_description >", value, "settingDescription");
            return (Criteria) this;
        }

        public Criteria andSettingDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("setting_description >=", value, "settingDescription");
            return (Criteria) this;
        }

        public Criteria andSettingDescriptionLessThan(String value) {
            addCriterion("setting_description <", value, "settingDescription");
            return (Criteria) this;
        }

        public Criteria andSettingDescriptionLessThanOrEqualTo(String value) {
            addCriterion("setting_description <=", value, "settingDescription");
            return (Criteria) this;
        }

        public Criteria andSettingDescriptionLike(String value) {
            addCriterion("setting_description like", value, "settingDescription");
            return (Criteria) this;
        }

        public Criteria andSettingDescriptionNotLike(String value) {
            addCriterion("setting_description not like", value, "settingDescription");
            return (Criteria) this;
        }

        public Criteria andSettingDescriptionIn(List<String> values) {
            addCriterion("setting_description in", values, "settingDescription");
            return (Criteria) this;
        }

        public Criteria andSettingDescriptionNotIn(List<String> values) {
            addCriterion("setting_description not in", values, "settingDescription");
            return (Criteria) this;
        }

        public Criteria andSettingDescriptionBetween(String value1, String value2) {
            addCriterion("setting_description between", value1, value2, "settingDescription");
            return (Criteria) this;
        }

        public Criteria andSettingDescriptionNotBetween(String value1, String value2) {
            addCriterion("setting_description not between", value1, value2, "settingDescription");
            return (Criteria) this;
        }
    }

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