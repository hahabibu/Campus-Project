package com.zstu.pms.model;

import java.util.ArrayList;
import java.util.List;

public class RoleAuthortyInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoleAuthortyInfoExample() {
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

        public Criteria andRoleAuthortyIdIsNull() {
            addCriterion("role_authorty_id is null");
            return (Criteria) this;
        }

        public Criteria andRoleAuthortyIdIsNotNull() {
            addCriterion("role_authorty_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoleAuthortyIdEqualTo(String value) {
            addCriterion("role_authorty_id =", value, "roleAuthortyId");
            return (Criteria) this;
        }

        public Criteria andRoleAuthortyIdNotEqualTo(String value) {
            addCriterion("role_authorty_id <>", value, "roleAuthortyId");
            return (Criteria) this;
        }

        public Criteria andRoleAuthortyIdGreaterThan(String value) {
            addCriterion("role_authorty_id >", value, "roleAuthortyId");
            return (Criteria) this;
        }

        public Criteria andRoleAuthortyIdGreaterThanOrEqualTo(String value) {
            addCriterion("role_authorty_id >=", value, "roleAuthortyId");
            return (Criteria) this;
        }

        public Criteria andRoleAuthortyIdLessThan(String value) {
            addCriterion("role_authorty_id <", value, "roleAuthortyId");
            return (Criteria) this;
        }

        public Criteria andRoleAuthortyIdLessThanOrEqualTo(String value) {
            addCriterion("role_authorty_id <=", value, "roleAuthortyId");
            return (Criteria) this;
        }

        public Criteria andRoleAuthortyIdLike(String value) {
            addCriterion("role_authorty_id like", value, "roleAuthortyId");
            return (Criteria) this;
        }

        public Criteria andRoleAuthortyIdNotLike(String value) {
            addCriterion("role_authorty_id not like", value, "roleAuthortyId");
            return (Criteria) this;
        }

        public Criteria andRoleAuthortyIdIn(List<String> values) {
            addCriterion("role_authorty_id in", values, "roleAuthortyId");
            return (Criteria) this;
        }

        public Criteria andRoleAuthortyIdNotIn(List<String> values) {
            addCriterion("role_authorty_id not in", values, "roleAuthortyId");
            return (Criteria) this;
        }

        public Criteria andRoleAuthortyIdBetween(String value1, String value2) {
            addCriterion("role_authorty_id between", value1, value2, "roleAuthortyId");
            return (Criteria) this;
        }

        public Criteria andRoleAuthortyIdNotBetween(String value1, String value2) {
            addCriterion("role_authorty_id not between", value1, value2, "roleAuthortyId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNull() {
            addCriterion("role_id is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("role_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(String value) {
            addCriterion("role_id =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(String value) {
            addCriterion("role_id <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(String value) {
            addCriterion("role_id >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(String value) {
            addCriterion("role_id >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(String value) {
            addCriterion("role_id <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(String value) {
            addCriterion("role_id <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLike(String value) {
            addCriterion("role_id like", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotLike(String value) {
            addCriterion("role_id not like", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<String> values) {
            addCriterion("role_id in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<String> values) {
            addCriterion("role_id not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(String value1, String value2) {
            addCriterion("role_id between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(String value1, String value2) {
            addCriterion("role_id not between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andAuthortyIdIsNull() {
            addCriterion("authorty_id is null");
            return (Criteria) this;
        }

        public Criteria andAuthortyIdIsNotNull() {
            addCriterion("authorty_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuthortyIdEqualTo(String value) {
            addCriterion("authorty_id =", value, "authortyId");
            return (Criteria) this;
        }

        public Criteria andAuthortyIdNotEqualTo(String value) {
            addCriterion("authorty_id <>", value, "authortyId");
            return (Criteria) this;
        }

        public Criteria andAuthortyIdGreaterThan(String value) {
            addCriterion("authorty_id >", value, "authortyId");
            return (Criteria) this;
        }

        public Criteria andAuthortyIdGreaterThanOrEqualTo(String value) {
            addCriterion("authorty_id >=", value, "authortyId");
            return (Criteria) this;
        }

        public Criteria andAuthortyIdLessThan(String value) {
            addCriterion("authorty_id <", value, "authortyId");
            return (Criteria) this;
        }

        public Criteria andAuthortyIdLessThanOrEqualTo(String value) {
            addCriterion("authorty_id <=", value, "authortyId");
            return (Criteria) this;
        }

        public Criteria andAuthortyIdLike(String value) {
            addCriterion("authorty_id like", value, "authortyId");
            return (Criteria) this;
        }

        public Criteria andAuthortyIdNotLike(String value) {
            addCriterion("authorty_id not like", value, "authortyId");
            return (Criteria) this;
        }

        public Criteria andAuthortyIdIn(List<String> values) {
            addCriterion("authorty_id in", values, "authortyId");
            return (Criteria) this;
        }

        public Criteria andAuthortyIdNotIn(List<String> values) {
            addCriterion("authorty_id not in", values, "authortyId");
            return (Criteria) this;
        }

        public Criteria andAuthortyIdBetween(String value1, String value2) {
            addCriterion("authorty_id between", value1, value2, "authortyId");
            return (Criteria) this;
        }

        public Criteria andAuthortyIdNotBetween(String value1, String value2) {
            addCriterion("authorty_id not between", value1, value2, "authortyId");
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