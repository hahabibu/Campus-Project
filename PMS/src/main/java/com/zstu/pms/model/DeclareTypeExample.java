package com.zstu.pms.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeclareTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeclareTypeExample() {
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

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(String value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(String value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(String value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(String value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(String value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLike(String value) {
            addCriterion("type_id like", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotLike(String value) {
            addCriterion("type_id not like", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<String> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<String> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(String value1, String value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(String value1, String value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNull() {
            addCriterion("type_name is null");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNotNull() {
            addCriterion("type_name is not null");
            return (Criteria) this;
        }

        public Criteria andTypeNameEqualTo(String value) {
            addCriterion("type_name =", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotEqualTo(String value) {
            addCriterion("type_name <>", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThan(String value) {
            addCriterion("type_name >", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("type_name >=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThan(String value) {
            addCriterion("type_name <", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThanOrEqualTo(String value) {
            addCriterion("type_name <=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLike(String value) {
            addCriterion("type_name like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotLike(String value) {
            addCriterion("type_name not like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameIn(List<String> values) {
            addCriterion("type_name in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotIn(List<String> values) {
            addCriterion("type_name not in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameBetween(String value1, String value2) {
            addCriterion("type_name between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotBetween(String value1, String value2) {
            addCriterion("type_name not between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeDescrIsNull() {
            addCriterion("type_descr is null");
            return (Criteria) this;
        }

        public Criteria andTypeDescrIsNotNull() {
            addCriterion("type_descr is not null");
            return (Criteria) this;
        }

        public Criteria andTypeDescrEqualTo(String value) {
            addCriterion("type_descr =", value, "typeDescr");
            return (Criteria) this;
        }

        public Criteria andTypeDescrNotEqualTo(String value) {
            addCriterion("type_descr <>", value, "typeDescr");
            return (Criteria) this;
        }

        public Criteria andTypeDescrGreaterThan(String value) {
            addCriterion("type_descr >", value, "typeDescr");
            return (Criteria) this;
        }

        public Criteria andTypeDescrGreaterThanOrEqualTo(String value) {
            addCriterion("type_descr >=", value, "typeDescr");
            return (Criteria) this;
        }

        public Criteria andTypeDescrLessThan(String value) {
            addCriterion("type_descr <", value, "typeDescr");
            return (Criteria) this;
        }

        public Criteria andTypeDescrLessThanOrEqualTo(String value) {
            addCriterion("type_descr <=", value, "typeDescr");
            return (Criteria) this;
        }

        public Criteria andTypeDescrLike(String value) {
            addCriterion("type_descr like", value, "typeDescr");
            return (Criteria) this;
        }

        public Criteria andTypeDescrNotLike(String value) {
            addCriterion("type_descr not like", value, "typeDescr");
            return (Criteria) this;
        }

        public Criteria andTypeDescrIn(List<String> values) {
            addCriterion("type_descr in", values, "typeDescr");
            return (Criteria) this;
        }

        public Criteria andTypeDescrNotIn(List<String> values) {
            addCriterion("type_descr not in", values, "typeDescr");
            return (Criteria) this;
        }

        public Criteria andTypeDescrBetween(String value1, String value2) {
            addCriterion("type_descr between", value1, value2, "typeDescr");
            return (Criteria) this;
        }

        public Criteria andTypeDescrNotBetween(String value1, String value2) {
            addCriterion("type_descr not between", value1, value2, "typeDescr");
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

        public Criteria andModifiedTimeIsNull() {
            addCriterion("modified_time is null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNotNull() {
            addCriterion("modified_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeEqualTo(Date value) {
            addCriterion("modified_time =", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotEqualTo(Date value) {
            addCriterion("modified_time <>", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThan(Date value) {
            addCriterion("modified_time >", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modified_time >=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThan(Date value) {
            addCriterion("modified_time <", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThanOrEqualTo(Date value) {
            addCriterion("modified_time <=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIn(List<Date> values) {
            addCriterion("modified_time in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotIn(List<Date> values) {
            addCriterion("modified_time not in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeBetween(Date value1, Date value2) {
            addCriterion("modified_time between", value1, value2, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotBetween(Date value1, Date value2) {
            addCriterion("modified_time not between", value1, value2, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andMiddleTimeIsNull() {
            addCriterion("middle_time is null");
            return (Criteria) this;
        }

        public Criteria andMiddleTimeIsNotNull() {
            addCriterion("middle_time is not null");
            return (Criteria) this;
        }

        public Criteria andMiddleTimeEqualTo(Date value) {
            addCriterion("middle_time =", value, "middleTime");
            return (Criteria) this;
        }

        public Criteria andMiddleTimeNotEqualTo(Date value) {
            addCriterion("middle_time <>", value, "middleTime");
            return (Criteria) this;
        }

        public Criteria andMiddleTimeGreaterThan(Date value) {
            addCriterion("middle_time >", value, "middleTime");
            return (Criteria) this;
        }

        public Criteria andMiddleTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("middle_time >=", value, "middleTime");
            return (Criteria) this;
        }

        public Criteria andMiddleTimeLessThan(Date value) {
            addCriterion("middle_time <", value, "middleTime");
            return (Criteria) this;
        }

        public Criteria andMiddleTimeLessThanOrEqualTo(Date value) {
            addCriterion("middle_time <=", value, "middleTime");
            return (Criteria) this;
        }

        public Criteria andMiddleTimeIn(List<Date> values) {
            addCriterion("middle_time in", values, "middleTime");
            return (Criteria) this;
        }

        public Criteria andMiddleTimeNotIn(List<Date> values) {
            addCriterion("middle_time not in", values, "middleTime");
            return (Criteria) this;
        }

        public Criteria andMiddleTimeBetween(Date value1, Date value2) {
            addCriterion("middle_time between", value1, value2, "middleTime");
            return (Criteria) this;
        }

        public Criteria andMiddleTimeNotBetween(Date value1, Date value2) {
            addCriterion("middle_time not between", value1, value2, "middleTime");
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

        public Criteria andStartStatusIsNull() {
            addCriterion("start_status is null");
            return (Criteria) this;
        }

        public Criteria andStartStatusIsNotNull() {
            addCriterion("start_status is not null");
            return (Criteria) this;
        }

        public Criteria andStartStatusEqualTo(Integer value) {
            addCriterion("start_status =", value, "startStatus");
            return (Criteria) this;
        }

        public Criteria andStartStatusNotEqualTo(Integer value) {
            addCriterion("start_status <>", value, "startStatus");
            return (Criteria) this;
        }

        public Criteria andStartStatusGreaterThan(Integer value) {
            addCriterion("start_status >", value, "startStatus");
            return (Criteria) this;
        }

        public Criteria andStartStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("start_status >=", value, "startStatus");
            return (Criteria) this;
        }

        public Criteria andStartStatusLessThan(Integer value) {
            addCriterion("start_status <", value, "startStatus");
            return (Criteria) this;
        }

        public Criteria andStartStatusLessThanOrEqualTo(Integer value) {
            addCriterion("start_status <=", value, "startStatus");
            return (Criteria) this;
        }

        public Criteria andStartStatusIn(List<Integer> values) {
            addCriterion("start_status in", values, "startStatus");
            return (Criteria) this;
        }

        public Criteria andStartStatusNotIn(List<Integer> values) {
            addCriterion("start_status not in", values, "startStatus");
            return (Criteria) this;
        }

        public Criteria andStartStatusBetween(Integer value1, Integer value2) {
            addCriterion("start_status between", value1, value2, "startStatus");
            return (Criteria) this;
        }

        public Criteria andStartStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("start_status not between", value1, value2, "startStatus");
            return (Criteria) this;
        }

        public Criteria andDelTagIsNull() {
            addCriterion("del_tag is null");
            return (Criteria) this;
        }

        public Criteria andDelTagIsNotNull() {
            addCriterion("del_tag is not null");
            return (Criteria) this;
        }

        public Criteria andDelTagEqualTo(Integer value) {
            addCriterion("del_tag =", value, "delTag");
            return (Criteria) this;
        }

        public Criteria andDelTagNotEqualTo(Integer value) {
            addCriterion("del_tag <>", value, "delTag");
            return (Criteria) this;
        }

        public Criteria andDelTagGreaterThan(Integer value) {
            addCriterion("del_tag >", value, "delTag");
            return (Criteria) this;
        }

        public Criteria andDelTagGreaterThanOrEqualTo(Integer value) {
            addCriterion("del_tag >=", value, "delTag");
            return (Criteria) this;
        }

        public Criteria andDelTagLessThan(Integer value) {
            addCriterion("del_tag <", value, "delTag");
            return (Criteria) this;
        }

        public Criteria andDelTagLessThanOrEqualTo(Integer value) {
            addCriterion("del_tag <=", value, "delTag");
            return (Criteria) this;
        }

        public Criteria andDelTagIn(List<Integer> values) {
            addCriterion("del_tag in", values, "delTag");
            return (Criteria) this;
        }

        public Criteria andDelTagNotIn(List<Integer> values) {
            addCriterion("del_tag not in", values, "delTag");
            return (Criteria) this;
        }

        public Criteria andDelTagBetween(Integer value1, Integer value2) {
            addCriterion("del_tag between", value1, value2, "delTag");
            return (Criteria) this;
        }

        public Criteria andDelTagNotBetween(Integer value1, Integer value2) {
            addCriterion("del_tag not between", value1, value2, "delTag");
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