package com.liuchq.moxy.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CourseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseExample() {
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

        public Criteria andCourseIdIsNull() {
            addCriterion("course_id is null");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNotNull() {
            addCriterion("course_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourseIdEqualTo(String value) {
            addCriterion("course_id =", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotEqualTo(String value) {
            addCriterion("course_id <>", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThan(String value) {
            addCriterion("course_id >", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThanOrEqualTo(String value) {
            addCriterion("course_id >=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThan(String value) {
            addCriterion("course_id <", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThanOrEqualTo(String value) {
            addCriterion("course_id <=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLike(String value) {
            addCriterion("course_id like", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotLike(String value) {
            addCriterion("course_id not like", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIn(List<String> values) {
            addCriterion("course_id in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotIn(List<String> values) {
            addCriterion("course_id not in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdBetween(String value1, String value2) {
            addCriterion("course_id between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotBetween(String value1, String value2) {
            addCriterion("course_id not between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseNumberIsNull() {
            addCriterion("course_number is null");
            return (Criteria) this;
        }

        public Criteria andCourseNumberIsNotNull() {
            addCriterion("course_number is not null");
            return (Criteria) this;
        }

        public Criteria andCourseNumberEqualTo(String value) {
            addCriterion("course_number =", value, "courseNumber");
            return (Criteria) this;
        }

        public Criteria andCourseNumberNotEqualTo(String value) {
            addCriterion("course_number <>", value, "courseNumber");
            return (Criteria) this;
        }

        public Criteria andCourseNumberGreaterThan(String value) {
            addCriterion("course_number >", value, "courseNumber");
            return (Criteria) this;
        }

        public Criteria andCourseNumberGreaterThanOrEqualTo(String value) {
            addCriterion("course_number >=", value, "courseNumber");
            return (Criteria) this;
        }

        public Criteria andCourseNumberLessThan(String value) {
            addCriterion("course_number <", value, "courseNumber");
            return (Criteria) this;
        }

        public Criteria andCourseNumberLessThanOrEqualTo(String value) {
            addCriterion("course_number <=", value, "courseNumber");
            return (Criteria) this;
        }

        public Criteria andCourseNumberLike(String value) {
            addCriterion("course_number like", value, "courseNumber");
            return (Criteria) this;
        }

        public Criteria andCourseNumberNotLike(String value) {
            addCriterion("course_number not like", value, "courseNumber");
            return (Criteria) this;
        }

        public Criteria andCourseNumberIn(List<String> values) {
            addCriterion("course_number in", values, "courseNumber");
            return (Criteria) this;
        }

        public Criteria andCourseNumberNotIn(List<String> values) {
            addCriterion("course_number not in", values, "courseNumber");
            return (Criteria) this;
        }

        public Criteria andCourseNumberBetween(String value1, String value2) {
            addCriterion("course_number between", value1, value2, "courseNumber");
            return (Criteria) this;
        }

        public Criteria andCourseNumberNotBetween(String value1, String value2) {
            addCriterion("course_number not between", value1, value2, "courseNumber");
            return (Criteria) this;
        }

        public Criteria andCourseSectionNumberIsNull() {
            addCriterion("course_section_number is null");
            return (Criteria) this;
        }

        public Criteria andCourseSectionNumberIsNotNull() {
            addCriterion("course_section_number is not null");
            return (Criteria) this;
        }

        public Criteria andCourseSectionNumberEqualTo(String value) {
            addCriterion("course_section_number =", value, "courseSectionNumber");
            return (Criteria) this;
        }

        public Criteria andCourseSectionNumberNotEqualTo(String value) {
            addCriterion("course_section_number <>", value, "courseSectionNumber");
            return (Criteria) this;
        }

        public Criteria andCourseSectionNumberGreaterThan(String value) {
            addCriterion("course_section_number >", value, "courseSectionNumber");
            return (Criteria) this;
        }

        public Criteria andCourseSectionNumberGreaterThanOrEqualTo(String value) {
            addCriterion("course_section_number >=", value, "courseSectionNumber");
            return (Criteria) this;
        }

        public Criteria andCourseSectionNumberLessThan(String value) {
            addCriterion("course_section_number <", value, "courseSectionNumber");
            return (Criteria) this;
        }

        public Criteria andCourseSectionNumberLessThanOrEqualTo(String value) {
            addCriterion("course_section_number <=", value, "courseSectionNumber");
            return (Criteria) this;
        }

        public Criteria andCourseSectionNumberLike(String value) {
            addCriterion("course_section_number like", value, "courseSectionNumber");
            return (Criteria) this;
        }

        public Criteria andCourseSectionNumberNotLike(String value) {
            addCriterion("course_section_number not like", value, "courseSectionNumber");
            return (Criteria) this;
        }

        public Criteria andCourseSectionNumberIn(List<String> values) {
            addCriterion("course_section_number in", values, "courseSectionNumber");
            return (Criteria) this;
        }

        public Criteria andCourseSectionNumberNotIn(List<String> values) {
            addCriterion("course_section_number not in", values, "courseSectionNumber");
            return (Criteria) this;
        }

        public Criteria andCourseSectionNumberBetween(String value1, String value2) {
            addCriterion("course_section_number between", value1, value2, "courseSectionNumber");
            return (Criteria) this;
        }

        public Criteria andCourseSectionNumberNotBetween(String value1, String value2) {
            addCriterion("course_section_number not between", value1, value2, "courseSectionNumber");
            return (Criteria) this;
        }

        public Criteria andCourseCreatetimeIsNull() {
            addCriterion("course_createtime is null");
            return (Criteria) this;
        }

        public Criteria andCourseCreatetimeIsNotNull() {
            addCriterion("course_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCourseCreatetimeEqualTo(Date value) {
            addCriterion("course_createtime =", value, "courseCreatetime");
            return (Criteria) this;
        }

        public Criteria andCourseCreatetimeNotEqualTo(Date value) {
            addCriterion("course_createtime <>", value, "courseCreatetime");
            return (Criteria) this;
        }

        public Criteria andCourseCreatetimeGreaterThan(Date value) {
            addCriterion("course_createtime >", value, "courseCreatetime");
            return (Criteria) this;
        }

        public Criteria andCourseCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("course_createtime >=", value, "courseCreatetime");
            return (Criteria) this;
        }

        public Criteria andCourseCreatetimeLessThan(Date value) {
            addCriterion("course_createtime <", value, "courseCreatetime");
            return (Criteria) this;
        }

        public Criteria andCourseCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("course_createtime <=", value, "courseCreatetime");
            return (Criteria) this;
        }

        public Criteria andCourseCreatetimeIn(List<Date> values) {
            addCriterion("course_createtime in", values, "courseCreatetime");
            return (Criteria) this;
        }

        public Criteria andCourseCreatetimeNotIn(List<Date> values) {
            addCriterion("course_createtime not in", values, "courseCreatetime");
            return (Criteria) this;
        }

        public Criteria andCourseCreatetimeBetween(Date value1, Date value2) {
            addCriterion("course_createtime between", value1, value2, "courseCreatetime");
            return (Criteria) this;
        }

        public Criteria andCourseCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("course_createtime not between", value1, value2, "courseCreatetime");
            return (Criteria) this;
        }

        public Criteria andCourseOwnerIsNull() {
            addCriterion("course_owner is null");
            return (Criteria) this;
        }

        public Criteria andCourseOwnerIsNotNull() {
            addCriterion("course_owner is not null");
            return (Criteria) this;
        }

        public Criteria andCourseOwnerEqualTo(String value) {
            addCriterion("course_owner =", value, "courseOwner");
            return (Criteria) this;
        }

        public Criteria andCourseOwnerNotEqualTo(String value) {
            addCriterion("course_owner <>", value, "courseOwner");
            return (Criteria) this;
        }

        public Criteria andCourseOwnerGreaterThan(String value) {
            addCriterion("course_owner >", value, "courseOwner");
            return (Criteria) this;
        }

        public Criteria andCourseOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("course_owner >=", value, "courseOwner");
            return (Criteria) this;
        }

        public Criteria andCourseOwnerLessThan(String value) {
            addCriterion("course_owner <", value, "courseOwner");
            return (Criteria) this;
        }

        public Criteria andCourseOwnerLessThanOrEqualTo(String value) {
            addCriterion("course_owner <=", value, "courseOwner");
            return (Criteria) this;
        }

        public Criteria andCourseOwnerLike(String value) {
            addCriterion("course_owner like", value, "courseOwner");
            return (Criteria) this;
        }

        public Criteria andCourseOwnerNotLike(String value) {
            addCriterion("course_owner not like", value, "courseOwner");
            return (Criteria) this;
        }

        public Criteria andCourseOwnerIn(List<String> values) {
            addCriterion("course_owner in", values, "courseOwner");
            return (Criteria) this;
        }

        public Criteria andCourseOwnerNotIn(List<String> values) {
            addCriterion("course_owner not in", values, "courseOwner");
            return (Criteria) this;
        }

        public Criteria andCourseOwnerBetween(String value1, String value2) {
            addCriterion("course_owner between", value1, value2, "courseOwner");
            return (Criteria) this;
        }

        public Criteria andCourseOwnerNotBetween(String value1, String value2) {
            addCriterion("course_owner not between", value1, value2, "courseOwner");
            return (Criteria) this;
        }

        public Criteria andCourseNeedSecondsIsNull() {
            addCriterion("course_need_seconds is null");
            return (Criteria) this;
        }

        public Criteria andCourseNeedSecondsIsNotNull() {
            addCriterion("course_need_seconds is not null");
            return (Criteria) this;
        }

        public Criteria andCourseNeedSecondsEqualTo(String value) {
            addCriterion("course_need_seconds =", value, "courseNeedSeconds");
            return (Criteria) this;
        }

        public Criteria andCourseNeedSecondsNotEqualTo(String value) {
            addCriterion("course_need_seconds <>", value, "courseNeedSeconds");
            return (Criteria) this;
        }

        public Criteria andCourseNeedSecondsGreaterThan(String value) {
            addCriterion("course_need_seconds >", value, "courseNeedSeconds");
            return (Criteria) this;
        }

        public Criteria andCourseNeedSecondsGreaterThanOrEqualTo(String value) {
            addCriterion("course_need_seconds >=", value, "courseNeedSeconds");
            return (Criteria) this;
        }

        public Criteria andCourseNeedSecondsLessThan(String value) {
            addCriterion("course_need_seconds <", value, "courseNeedSeconds");
            return (Criteria) this;
        }

        public Criteria andCourseNeedSecondsLessThanOrEqualTo(String value) {
            addCriterion("course_need_seconds <=", value, "courseNeedSeconds");
            return (Criteria) this;
        }

        public Criteria andCourseNeedSecondsLike(String value) {
            addCriterion("course_need_seconds like", value, "courseNeedSeconds");
            return (Criteria) this;
        }

        public Criteria andCourseNeedSecondsNotLike(String value) {
            addCriterion("course_need_seconds not like", value, "courseNeedSeconds");
            return (Criteria) this;
        }

        public Criteria andCourseNeedSecondsIn(List<String> values) {
            addCriterion("course_need_seconds in", values, "courseNeedSeconds");
            return (Criteria) this;
        }

        public Criteria andCourseNeedSecondsNotIn(List<String> values) {
            addCriterion("course_need_seconds not in", values, "courseNeedSeconds");
            return (Criteria) this;
        }

        public Criteria andCourseNeedSecondsBetween(String value1, String value2) {
            addCriterion("course_need_seconds between", value1, value2, "courseNeedSeconds");
            return (Criteria) this;
        }

        public Criteria andCourseNeedSecondsNotBetween(String value1, String value2) {
            addCriterion("course_need_seconds not between", value1, value2, "courseNeedSeconds");
            return (Criteria) this;
        }

        public Criteria andCourseVersionIsNull() {
            addCriterion("course_version is null");
            return (Criteria) this;
        }

        public Criteria andCourseVersionIsNotNull() {
            addCriterion("course_version is not null");
            return (Criteria) this;
        }

        public Criteria andCourseVersionEqualTo(String value) {
            addCriterion("course_version =", value, "courseVersion");
            return (Criteria) this;
        }

        public Criteria andCourseVersionNotEqualTo(String value) {
            addCriterion("course_version <>", value, "courseVersion");
            return (Criteria) this;
        }

        public Criteria andCourseVersionGreaterThan(String value) {
            addCriterion("course_version >", value, "courseVersion");
            return (Criteria) this;
        }

        public Criteria andCourseVersionGreaterThanOrEqualTo(String value) {
            addCriterion("course_version >=", value, "courseVersion");
            return (Criteria) this;
        }

        public Criteria andCourseVersionLessThan(String value) {
            addCriterion("course_version <", value, "courseVersion");
            return (Criteria) this;
        }

        public Criteria andCourseVersionLessThanOrEqualTo(String value) {
            addCriterion("course_version <=", value, "courseVersion");
            return (Criteria) this;
        }

        public Criteria andCourseVersionLike(String value) {
            addCriterion("course_version like", value, "courseVersion");
            return (Criteria) this;
        }

        public Criteria andCourseVersionNotLike(String value) {
            addCriterion("course_version not like", value, "courseVersion");
            return (Criteria) this;
        }

        public Criteria andCourseVersionIn(List<String> values) {
            addCriterion("course_version in", values, "courseVersion");
            return (Criteria) this;
        }

        public Criteria andCourseVersionNotIn(List<String> values) {
            addCriterion("course_version not in", values, "courseVersion");
            return (Criteria) this;
        }

        public Criteria andCourseVersionBetween(String value1, String value2) {
            addCriterion("course_version between", value1, value2, "courseVersion");
            return (Criteria) this;
        }

        public Criteria andCourseVersionNotBetween(String value1, String value2) {
            addCriterion("course_version not between", value1, value2, "courseVersion");
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