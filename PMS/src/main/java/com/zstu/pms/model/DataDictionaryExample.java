package com.zstu.pms.model;

import java.util.ArrayList;
import java.util.List;

public class DataDictionaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DataDictionaryExample() {
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

        public Criteria andDataIdIsNull() {
            addCriterion("data_id is null");
            return (Criteria) this;
        }

        public Criteria andDataIdIsNotNull() {
            addCriterion("data_id is not null");
            return (Criteria) this;
        }

        public Criteria andDataIdEqualTo(String value) {
            addCriterion("data_id =", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotEqualTo(String value) {
            addCriterion("data_id <>", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdGreaterThan(String value) {
            addCriterion("data_id >", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdGreaterThanOrEqualTo(String value) {
            addCriterion("data_id >=", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdLessThan(String value) {
            addCriterion("data_id <", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdLessThanOrEqualTo(String value) {
            addCriterion("data_id <=", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdLike(String value) {
            addCriterion("data_id like", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotLike(String value) {
            addCriterion("data_id not like", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdIn(List<String> values) {
            addCriterion("data_id in", values, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotIn(List<String> values) {
            addCriterion("data_id not in", values, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdBetween(String value1, String value2) {
            addCriterion("data_id between", value1, value2, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotBetween(String value1, String value2) {
            addCriterion("data_id not between", value1, value2, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataContentIsNull() {
            addCriterion("data_content is null");
            return (Criteria) this;
        }

        public Criteria andDataContentIsNotNull() {
            addCriterion("data_content is not null");
            return (Criteria) this;
        }

        public Criteria andDataContentEqualTo(String value) {
            addCriterion("data_content =", value, "dataContent");
            return (Criteria) this;
        }

        public Criteria andDataContentNotEqualTo(String value) {
            addCriterion("data_content <>", value, "dataContent");
            return (Criteria) this;
        }

        public Criteria andDataContentGreaterThan(String value) {
            addCriterion("data_content >", value, "dataContent");
            return (Criteria) this;
        }

        public Criteria andDataContentGreaterThanOrEqualTo(String value) {
            addCriterion("data_content >=", value, "dataContent");
            return (Criteria) this;
        }

        public Criteria andDataContentLessThan(String value) {
            addCriterion("data_content <", value, "dataContent");
            return (Criteria) this;
        }

        public Criteria andDataContentLessThanOrEqualTo(String value) {
            addCriterion("data_content <=", value, "dataContent");
            return (Criteria) this;
        }

        public Criteria andDataContentLike(String value) {
            addCriterion("data_content like", value, "dataContent");
            return (Criteria) this;
        }

        public Criteria andDataContentNotLike(String value) {
            addCriterion("data_content not like", value, "dataContent");
            return (Criteria) this;
        }

        public Criteria andDataContentIn(List<String> values) {
            addCriterion("data_content in", values, "dataContent");
            return (Criteria) this;
        }

        public Criteria andDataContentNotIn(List<String> values) {
            addCriterion("data_content not in", values, "dataContent");
            return (Criteria) this;
        }

        public Criteria andDataContentBetween(String value1, String value2) {
            addCriterion("data_content between", value1, value2, "dataContent");
            return (Criteria) this;
        }

        public Criteria andDataContentNotBetween(String value1, String value2) {
            addCriterion("data_content not between", value1, value2, "dataContent");
            return (Criteria) this;
        }

        public Criteria andDataTypeIsNull() {
            addCriterion("data_type is null");
            return (Criteria) this;
        }

        public Criteria andDataTypeIsNotNull() {
            addCriterion("data_type is not null");
            return (Criteria) this;
        }

        public Criteria andDataTypeEqualTo(String value) {
            addCriterion("data_type =", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotEqualTo(String value) {
            addCriterion("data_type <>", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThan(String value) {
            addCriterion("data_type >", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThanOrEqualTo(String value) {
            addCriterion("data_type >=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThan(String value) {
            addCriterion("data_type <", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThanOrEqualTo(String value) {
            addCriterion("data_type <=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLike(String value) {
            addCriterion("data_type like", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotLike(String value) {
            addCriterion("data_type not like", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeIn(List<String> values) {
            addCriterion("data_type in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotIn(List<String> values) {
            addCriterion("data_type not in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeBetween(String value1, String value2) {
            addCriterion("data_type between", value1, value2, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotBetween(String value1, String value2) {
            addCriterion("data_type not between", value1, value2, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataDescrIsNull() {
            addCriterion("data_descr is null");
            return (Criteria) this;
        }

        public Criteria andDataDescrIsNotNull() {
            addCriterion("data_descr is not null");
            return (Criteria) this;
        }

        public Criteria andDataDescrEqualTo(String value) {
            addCriterion("data_descr =", value, "dataDescr");
            return (Criteria) this;
        }

        public Criteria andDataDescrNotEqualTo(String value) {
            addCriterion("data_descr <>", value, "dataDescr");
            return (Criteria) this;
        }

        public Criteria andDataDescrGreaterThan(String value) {
            addCriterion("data_descr >", value, "dataDescr");
            return (Criteria) this;
        }

        public Criteria andDataDescrGreaterThanOrEqualTo(String value) {
            addCriterion("data_descr >=", value, "dataDescr");
            return (Criteria) this;
        }

        public Criteria andDataDescrLessThan(String value) {
            addCriterion("data_descr <", value, "dataDescr");
            return (Criteria) this;
        }

        public Criteria andDataDescrLessThanOrEqualTo(String value) {
            addCriterion("data_descr <=", value, "dataDescr");
            return (Criteria) this;
        }

        public Criteria andDataDescrLike(String value) {
            addCriterion("data_descr like", value, "dataDescr");
            return (Criteria) this;
        }

        public Criteria andDataDescrNotLike(String value) {
            addCriterion("data_descr not like", value, "dataDescr");
            return (Criteria) this;
        }

        public Criteria andDataDescrIn(List<String> values) {
            addCriterion("data_descr in", values, "dataDescr");
            return (Criteria) this;
        }

        public Criteria andDataDescrNotIn(List<String> values) {
            addCriterion("data_descr not in", values, "dataDescr");
            return (Criteria) this;
        }

        public Criteria andDataDescrBetween(String value1, String value2) {
            addCriterion("data_descr between", value1, value2, "dataDescr");
            return (Criteria) this;
        }

        public Criteria andDataDescrNotBetween(String value1, String value2) {
            addCriterion("data_descr not between", value1, value2, "dataDescr");
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