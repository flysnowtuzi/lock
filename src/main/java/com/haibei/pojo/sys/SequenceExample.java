package com.haibei.pojo.sys;

import java.util.ArrayList;
import java.util.List;

public class SequenceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int rowsPerPage = -1;

    public SequenceExample() {
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

    public void setLimitStart(int limitStart) {
        this.limitStart=limitStart;
    }

    public int getLimitStart() {
        return limitStart;
    }

    public void setRowsPerPage(int rowsPerPage) {
        this.rowsPerPage=rowsPerPage;
    }

    public int getRowsPerPage() {
        return rowsPerPage;
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

        public Criteria andSequenceCodeIsNull() {
            addCriterion("SEQUENCE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andSequenceCodeIsNotNull() {
            addCriterion("SEQUENCE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andSequenceCodeEqualTo(String value) {
            addCriterion("SEQUENCE_CODE =", value, "sequenceCode");
            return (Criteria) this;
        }

        public Criteria andSequenceCodeNotEqualTo(String value) {
            addCriterion("SEQUENCE_CODE <>", value, "sequenceCode");
            return (Criteria) this;
        }

        public Criteria andSequenceCodeGreaterThan(String value) {
            addCriterion("SEQUENCE_CODE >", value, "sequenceCode");
            return (Criteria) this;
        }

        public Criteria andSequenceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SEQUENCE_CODE >=", value, "sequenceCode");
            return (Criteria) this;
        }

        public Criteria andSequenceCodeLessThan(String value) {
            addCriterion("SEQUENCE_CODE <", value, "sequenceCode");
            return (Criteria) this;
        }

        public Criteria andSequenceCodeLessThanOrEqualTo(String value) {
            addCriterion("SEQUENCE_CODE <=", value, "sequenceCode");
            return (Criteria) this;
        }

        public Criteria andSequenceCodeLike(String value) {
            addCriterion("SEQUENCE_CODE like", value, "sequenceCode");
            return (Criteria) this;
        }

        public Criteria andSequenceCodeNotLike(String value) {
            addCriterion("SEQUENCE_CODE not like", value, "sequenceCode");
            return (Criteria) this;
        }

        public Criteria andSequenceCodeIn(List<String> values) {
            addCriterion("SEQUENCE_CODE in", values, "sequenceCode");
            return (Criteria) this;
        }

        public Criteria andSequenceCodeNotIn(List<String> values) {
            addCriterion("SEQUENCE_CODE not in", values, "sequenceCode");
            return (Criteria) this;
        }

        public Criteria andSequenceCodeBetween(String value1, String value2) {
            addCriterion("SEQUENCE_CODE between", value1, value2, "sequenceCode");
            return (Criteria) this;
        }

        public Criteria andSequenceCodeNotBetween(String value1, String value2) {
            addCriterion("SEQUENCE_CODE not between", value1, value2, "sequenceCode");
            return (Criteria) this;
        }

        public Criteria andSequenceLastIdIsNull() {
            addCriterion("SEQUENCE_LAST_ID is null");
            return (Criteria) this;
        }

        public Criteria andSequenceLastIdIsNotNull() {
            addCriterion("SEQUENCE_LAST_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSequenceLastIdEqualTo(Long value) {
            addCriterion("SEQUENCE_LAST_ID =", value, "sequenceLastId");
            return (Criteria) this;
        }

        public Criteria andSequenceLastIdNotEqualTo(Long value) {
            addCriterion("SEQUENCE_LAST_ID <>", value, "sequenceLastId");
            return (Criteria) this;
        }

        public Criteria andSequenceLastIdGreaterThan(Long value) {
            addCriterion("SEQUENCE_LAST_ID >", value, "sequenceLastId");
            return (Criteria) this;
        }

        public Criteria andSequenceLastIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SEQUENCE_LAST_ID >=", value, "sequenceLastId");
            return (Criteria) this;
        }

        public Criteria andSequenceLastIdLessThan(Long value) {
            addCriterion("SEQUENCE_LAST_ID <", value, "sequenceLastId");
            return (Criteria) this;
        }

        public Criteria andSequenceLastIdLessThanOrEqualTo(Long value) {
            addCriterion("SEQUENCE_LAST_ID <=", value, "sequenceLastId");
            return (Criteria) this;
        }

        public Criteria andSequenceLastIdIn(List<Long> values) {
            addCriterion("SEQUENCE_LAST_ID in", values, "sequenceLastId");
            return (Criteria) this;
        }

        public Criteria andSequenceLastIdNotIn(List<Long> values) {
            addCriterion("SEQUENCE_LAST_ID not in", values, "sequenceLastId");
            return (Criteria) this;
        }

        public Criteria andSequenceLastIdBetween(Long value1, Long value2) {
            addCriterion("SEQUENCE_LAST_ID between", value1, value2, "sequenceLastId");
            return (Criteria) this;
        }

        public Criteria andSequenceLastIdNotBetween(Long value1, Long value2) {
            addCriterion("SEQUENCE_LAST_ID not between", value1, value2, "sequenceLastId");
            return (Criteria) this;
        }

        public Criteria andSequenceIncreaseIsNull() {
            addCriterion("SEQUENCE_INCREASE is null");
            return (Criteria) this;
        }

        public Criteria andSequenceIncreaseIsNotNull() {
            addCriterion("SEQUENCE_INCREASE is not null");
            return (Criteria) this;
        }

        public Criteria andSequenceIncreaseEqualTo(Long value) {
            addCriterion("SEQUENCE_INCREASE =", value, "sequenceIncrease");
            return (Criteria) this;
        }

        public Criteria andSequenceIncreaseNotEqualTo(Long value) {
            addCriterion("SEQUENCE_INCREASE <>", value, "sequenceIncrease");
            return (Criteria) this;
        }

        public Criteria andSequenceIncreaseGreaterThan(Long value) {
            addCriterion("SEQUENCE_INCREASE >", value, "sequenceIncrease");
            return (Criteria) this;
        }

        public Criteria andSequenceIncreaseGreaterThanOrEqualTo(Long value) {
            addCriterion("SEQUENCE_INCREASE >=", value, "sequenceIncrease");
            return (Criteria) this;
        }

        public Criteria andSequenceIncreaseLessThan(Long value) {
            addCriterion("SEQUENCE_INCREASE <", value, "sequenceIncrease");
            return (Criteria) this;
        }

        public Criteria andSequenceIncreaseLessThanOrEqualTo(Long value) {
            addCriterion("SEQUENCE_INCREASE <=", value, "sequenceIncrease");
            return (Criteria) this;
        }

        public Criteria andSequenceIncreaseIn(List<Long> values) {
            addCriterion("SEQUENCE_INCREASE in", values, "sequenceIncrease");
            return (Criteria) this;
        }

        public Criteria andSequenceIncreaseNotIn(List<Long> values) {
            addCriterion("SEQUENCE_INCREASE not in", values, "sequenceIncrease");
            return (Criteria) this;
        }

        public Criteria andSequenceIncreaseBetween(Long value1, Long value2) {
            addCriterion("SEQUENCE_INCREASE between", value1, value2, "sequenceIncrease");
            return (Criteria) this;
        }

        public Criteria andSequenceIncreaseNotBetween(Long value1, Long value2) {
            addCriterion("SEQUENCE_INCREASE not between", value1, value2, "sequenceIncrease");
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