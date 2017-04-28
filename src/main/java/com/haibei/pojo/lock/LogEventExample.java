package com.haibei.pojo.lock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LogEventExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int rowsPerPage = -1;

    public LogEventExample() {
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

        public Criteria andEventIdIsNull() {
            addCriterion("EVENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andEventIdIsNotNull() {
            addCriterion("EVENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andEventIdEqualTo(Long value) {
            addCriterion("EVENT_ID =", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdNotEqualTo(Long value) {
            addCriterion("EVENT_ID <>", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdGreaterThan(Long value) {
            addCriterion("EVENT_ID >", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdGreaterThanOrEqualTo(Long value) {
            addCriterion("EVENT_ID >=", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdLessThan(Long value) {
            addCriterion("EVENT_ID <", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdLessThanOrEqualTo(Long value) {
            addCriterion("EVENT_ID <=", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdIn(List<Long> values) {
            addCriterion("EVENT_ID in", values, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdNotIn(List<Long> values) {
            addCriterion("EVENT_ID not in", values, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdBetween(Long value1, Long value2) {
            addCriterion("EVENT_ID between", value1, value2, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdNotBetween(Long value1, Long value2) {
            addCriterion("EVENT_ID not between", value1, value2, "eventId");
            return (Criteria) this;
        }

        public Criteria andTimestmpIsNull() {
            addCriterion("TIMESTMP is null");
            return (Criteria) this;
        }

        public Criteria andTimestmpIsNotNull() {
            addCriterion("TIMESTMP is not null");
            return (Criteria) this;
        }

        public Criteria andTimestmpEqualTo(BigDecimal value) {
            addCriterion("TIMESTMP =", value, "timestmp");
            return (Criteria) this;
        }

        public Criteria andTimestmpNotEqualTo(BigDecimal value) {
            addCriterion("TIMESTMP <>", value, "timestmp");
            return (Criteria) this;
        }

        public Criteria andTimestmpGreaterThan(BigDecimal value) {
            addCriterion("TIMESTMP >", value, "timestmp");
            return (Criteria) this;
        }

        public Criteria andTimestmpGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TIMESTMP >=", value, "timestmp");
            return (Criteria) this;
        }

        public Criteria andTimestmpLessThan(BigDecimal value) {
            addCriterion("TIMESTMP <", value, "timestmp");
            return (Criteria) this;
        }

        public Criteria andTimestmpLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TIMESTMP <=", value, "timestmp");
            return (Criteria) this;
        }

        public Criteria andTimestmpIn(List<BigDecimal> values) {
            addCriterion("TIMESTMP in", values, "timestmp");
            return (Criteria) this;
        }

        public Criteria andTimestmpNotIn(List<BigDecimal> values) {
            addCriterion("TIMESTMP not in", values, "timestmp");
            return (Criteria) this;
        }

        public Criteria andTimestmpBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TIMESTMP between", value1, value2, "timestmp");
            return (Criteria) this;
        }

        public Criteria andTimestmpNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TIMESTMP not between", value1, value2, "timestmp");
            return (Criteria) this;
        }

        public Criteria andFormattedMessageIsNull() {
            addCriterion("FORMATTED_MESSAGE is null");
            return (Criteria) this;
        }

        public Criteria andFormattedMessageIsNotNull() {
            addCriterion("FORMATTED_MESSAGE is not null");
            return (Criteria) this;
        }

        public Criteria andFormattedMessageEqualTo(String value) {
            addCriterion("FORMATTED_MESSAGE =", value, "formattedMessage");
            return (Criteria) this;
        }

        public Criteria andFormattedMessageNotEqualTo(String value) {
            addCriterion("FORMATTED_MESSAGE <>", value, "formattedMessage");
            return (Criteria) this;
        }

        public Criteria andFormattedMessageGreaterThan(String value) {
            addCriterion("FORMATTED_MESSAGE >", value, "formattedMessage");
            return (Criteria) this;
        }

        public Criteria andFormattedMessageGreaterThanOrEqualTo(String value) {
            addCriterion("FORMATTED_MESSAGE >=", value, "formattedMessage");
            return (Criteria) this;
        }

        public Criteria andFormattedMessageLessThan(String value) {
            addCriterion("FORMATTED_MESSAGE <", value, "formattedMessage");
            return (Criteria) this;
        }

        public Criteria andFormattedMessageLessThanOrEqualTo(String value) {
            addCriterion("FORMATTED_MESSAGE <=", value, "formattedMessage");
            return (Criteria) this;
        }

        public Criteria andFormattedMessageLike(String value) {
            addCriterion("FORMATTED_MESSAGE like", value, "formattedMessage");
            return (Criteria) this;
        }

        public Criteria andFormattedMessageNotLike(String value) {
            addCriterion("FORMATTED_MESSAGE not like", value, "formattedMessage");
            return (Criteria) this;
        }

        public Criteria andFormattedMessageIn(List<String> values) {
            addCriterion("FORMATTED_MESSAGE in", values, "formattedMessage");
            return (Criteria) this;
        }

        public Criteria andFormattedMessageNotIn(List<String> values) {
            addCriterion("FORMATTED_MESSAGE not in", values, "formattedMessage");
            return (Criteria) this;
        }

        public Criteria andFormattedMessageBetween(String value1, String value2) {
            addCriterion("FORMATTED_MESSAGE between", value1, value2, "formattedMessage");
            return (Criteria) this;
        }

        public Criteria andFormattedMessageNotBetween(String value1, String value2) {
            addCriterion("FORMATTED_MESSAGE not between", value1, value2, "formattedMessage");
            return (Criteria) this;
        }

        public Criteria andLoggerNameIsNull() {
            addCriterion("LOGGER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andLoggerNameIsNotNull() {
            addCriterion("LOGGER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andLoggerNameEqualTo(String value) {
            addCriterion("LOGGER_NAME =", value, "loggerName");
            return (Criteria) this;
        }

        public Criteria andLoggerNameNotEqualTo(String value) {
            addCriterion("LOGGER_NAME <>", value, "loggerName");
            return (Criteria) this;
        }

        public Criteria andLoggerNameGreaterThan(String value) {
            addCriterion("LOGGER_NAME >", value, "loggerName");
            return (Criteria) this;
        }

        public Criteria andLoggerNameGreaterThanOrEqualTo(String value) {
            addCriterion("LOGGER_NAME >=", value, "loggerName");
            return (Criteria) this;
        }

        public Criteria andLoggerNameLessThan(String value) {
            addCriterion("LOGGER_NAME <", value, "loggerName");
            return (Criteria) this;
        }

        public Criteria andLoggerNameLessThanOrEqualTo(String value) {
            addCriterion("LOGGER_NAME <=", value, "loggerName");
            return (Criteria) this;
        }

        public Criteria andLoggerNameLike(String value) {
            addCriterion("LOGGER_NAME like", value, "loggerName");
            return (Criteria) this;
        }

        public Criteria andLoggerNameNotLike(String value) {
            addCriterion("LOGGER_NAME not like", value, "loggerName");
            return (Criteria) this;
        }

        public Criteria andLoggerNameIn(List<String> values) {
            addCriterion("LOGGER_NAME in", values, "loggerName");
            return (Criteria) this;
        }

        public Criteria andLoggerNameNotIn(List<String> values) {
            addCriterion("LOGGER_NAME not in", values, "loggerName");
            return (Criteria) this;
        }

        public Criteria andLoggerNameBetween(String value1, String value2) {
            addCriterion("LOGGER_NAME between", value1, value2, "loggerName");
            return (Criteria) this;
        }

        public Criteria andLoggerNameNotBetween(String value1, String value2) {
            addCriterion("LOGGER_NAME not between", value1, value2, "loggerName");
            return (Criteria) this;
        }

        public Criteria andLevelStringIsNull() {
            addCriterion("LEVEL_STRING is null");
            return (Criteria) this;
        }

        public Criteria andLevelStringIsNotNull() {
            addCriterion("LEVEL_STRING is not null");
            return (Criteria) this;
        }

        public Criteria andLevelStringEqualTo(String value) {
            addCriterion("LEVEL_STRING =", value, "levelString");
            return (Criteria) this;
        }

        public Criteria andLevelStringNotEqualTo(String value) {
            addCriterion("LEVEL_STRING <>", value, "levelString");
            return (Criteria) this;
        }

        public Criteria andLevelStringGreaterThan(String value) {
            addCriterion("LEVEL_STRING >", value, "levelString");
            return (Criteria) this;
        }

        public Criteria andLevelStringGreaterThanOrEqualTo(String value) {
            addCriterion("LEVEL_STRING >=", value, "levelString");
            return (Criteria) this;
        }

        public Criteria andLevelStringLessThan(String value) {
            addCriterion("LEVEL_STRING <", value, "levelString");
            return (Criteria) this;
        }

        public Criteria andLevelStringLessThanOrEqualTo(String value) {
            addCriterion("LEVEL_STRING <=", value, "levelString");
            return (Criteria) this;
        }

        public Criteria andLevelStringLike(String value) {
            addCriterion("LEVEL_STRING like", value, "levelString");
            return (Criteria) this;
        }

        public Criteria andLevelStringNotLike(String value) {
            addCriterion("LEVEL_STRING not like", value, "levelString");
            return (Criteria) this;
        }

        public Criteria andLevelStringIn(List<String> values) {
            addCriterion("LEVEL_STRING in", values, "levelString");
            return (Criteria) this;
        }

        public Criteria andLevelStringNotIn(List<String> values) {
            addCriterion("LEVEL_STRING not in", values, "levelString");
            return (Criteria) this;
        }

        public Criteria andLevelStringBetween(String value1, String value2) {
            addCriterion("LEVEL_STRING between", value1, value2, "levelString");
            return (Criteria) this;
        }

        public Criteria andLevelStringNotBetween(String value1, String value2) {
            addCriterion("LEVEL_STRING not between", value1, value2, "levelString");
            return (Criteria) this;
        }

        public Criteria andThreadNameIsNull() {
            addCriterion("THREAD_NAME is null");
            return (Criteria) this;
        }

        public Criteria andThreadNameIsNotNull() {
            addCriterion("THREAD_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andThreadNameEqualTo(String value) {
            addCriterion("THREAD_NAME =", value, "threadName");
            return (Criteria) this;
        }

        public Criteria andThreadNameNotEqualTo(String value) {
            addCriterion("THREAD_NAME <>", value, "threadName");
            return (Criteria) this;
        }

        public Criteria andThreadNameGreaterThan(String value) {
            addCriterion("THREAD_NAME >", value, "threadName");
            return (Criteria) this;
        }

        public Criteria andThreadNameGreaterThanOrEqualTo(String value) {
            addCriterion("THREAD_NAME >=", value, "threadName");
            return (Criteria) this;
        }

        public Criteria andThreadNameLessThan(String value) {
            addCriterion("THREAD_NAME <", value, "threadName");
            return (Criteria) this;
        }

        public Criteria andThreadNameLessThanOrEqualTo(String value) {
            addCriterion("THREAD_NAME <=", value, "threadName");
            return (Criteria) this;
        }

        public Criteria andThreadNameLike(String value) {
            addCriterion("THREAD_NAME like", value, "threadName");
            return (Criteria) this;
        }

        public Criteria andThreadNameNotLike(String value) {
            addCriterion("THREAD_NAME not like", value, "threadName");
            return (Criteria) this;
        }

        public Criteria andThreadNameIn(List<String> values) {
            addCriterion("THREAD_NAME in", values, "threadName");
            return (Criteria) this;
        }

        public Criteria andThreadNameNotIn(List<String> values) {
            addCriterion("THREAD_NAME not in", values, "threadName");
            return (Criteria) this;
        }

        public Criteria andThreadNameBetween(String value1, String value2) {
            addCriterion("THREAD_NAME between", value1, value2, "threadName");
            return (Criteria) this;
        }

        public Criteria andThreadNameNotBetween(String value1, String value2) {
            addCriterion("THREAD_NAME not between", value1, value2, "threadName");
            return (Criteria) this;
        }

        public Criteria andReferenceFlagIsNull() {
            addCriterion("REFERENCE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andReferenceFlagIsNotNull() {
            addCriterion("REFERENCE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andReferenceFlagEqualTo(BigDecimal value) {
            addCriterion("REFERENCE_FLAG =", value, "referenceFlag");
            return (Criteria) this;
        }

        public Criteria andReferenceFlagNotEqualTo(BigDecimal value) {
            addCriterion("REFERENCE_FLAG <>", value, "referenceFlag");
            return (Criteria) this;
        }

        public Criteria andReferenceFlagGreaterThan(BigDecimal value) {
            addCriterion("REFERENCE_FLAG >", value, "referenceFlag");
            return (Criteria) this;
        }

        public Criteria andReferenceFlagGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REFERENCE_FLAG >=", value, "referenceFlag");
            return (Criteria) this;
        }

        public Criteria andReferenceFlagLessThan(BigDecimal value) {
            addCriterion("REFERENCE_FLAG <", value, "referenceFlag");
            return (Criteria) this;
        }

        public Criteria andReferenceFlagLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REFERENCE_FLAG <=", value, "referenceFlag");
            return (Criteria) this;
        }

        public Criteria andReferenceFlagIn(List<BigDecimal> values) {
            addCriterion("REFERENCE_FLAG in", values, "referenceFlag");
            return (Criteria) this;
        }

        public Criteria andReferenceFlagNotIn(List<BigDecimal> values) {
            addCriterion("REFERENCE_FLAG not in", values, "referenceFlag");
            return (Criteria) this;
        }

        public Criteria andReferenceFlagBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REFERENCE_FLAG between", value1, value2, "referenceFlag");
            return (Criteria) this;
        }

        public Criteria andReferenceFlagNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REFERENCE_FLAG not between", value1, value2, "referenceFlag");
            return (Criteria) this;
        }

        public Criteria andArg0IsNull() {
            addCriterion("ARG0 is null");
            return (Criteria) this;
        }

        public Criteria andArg0IsNotNull() {
            addCriterion("ARG0 is not null");
            return (Criteria) this;
        }

        public Criteria andArg0EqualTo(String value) {
            addCriterion("ARG0 =", value, "arg0");
            return (Criteria) this;
        }

        public Criteria andArg0NotEqualTo(String value) {
            addCriterion("ARG0 <>", value, "arg0");
            return (Criteria) this;
        }

        public Criteria andArg0GreaterThan(String value) {
            addCriterion("ARG0 >", value, "arg0");
            return (Criteria) this;
        }

        public Criteria andArg0GreaterThanOrEqualTo(String value) {
            addCriterion("ARG0 >=", value, "arg0");
            return (Criteria) this;
        }

        public Criteria andArg0LessThan(String value) {
            addCriterion("ARG0 <", value, "arg0");
            return (Criteria) this;
        }

        public Criteria andArg0LessThanOrEqualTo(String value) {
            addCriterion("ARG0 <=", value, "arg0");
            return (Criteria) this;
        }

        public Criteria andArg0Like(String value) {
            addCriterion("ARG0 like", value, "arg0");
            return (Criteria) this;
        }

        public Criteria andArg0NotLike(String value) {
            addCriterion("ARG0 not like", value, "arg0");
            return (Criteria) this;
        }

        public Criteria andArg0In(List<String> values) {
            addCriterion("ARG0 in", values, "arg0");
            return (Criteria) this;
        }

        public Criteria andArg0NotIn(List<String> values) {
            addCriterion("ARG0 not in", values, "arg0");
            return (Criteria) this;
        }

        public Criteria andArg0Between(String value1, String value2) {
            addCriterion("ARG0 between", value1, value2, "arg0");
            return (Criteria) this;
        }

        public Criteria andArg0NotBetween(String value1, String value2) {
            addCriterion("ARG0 not between", value1, value2, "arg0");
            return (Criteria) this;
        }

        public Criteria andArg1IsNull() {
            addCriterion("ARG1 is null");
            return (Criteria) this;
        }

        public Criteria andArg1IsNotNull() {
            addCriterion("ARG1 is not null");
            return (Criteria) this;
        }

        public Criteria andArg1EqualTo(String value) {
            addCriterion("ARG1 =", value, "arg1");
            return (Criteria) this;
        }

        public Criteria andArg1NotEqualTo(String value) {
            addCriterion("ARG1 <>", value, "arg1");
            return (Criteria) this;
        }

        public Criteria andArg1GreaterThan(String value) {
            addCriterion("ARG1 >", value, "arg1");
            return (Criteria) this;
        }

        public Criteria andArg1GreaterThanOrEqualTo(String value) {
            addCriterion("ARG1 >=", value, "arg1");
            return (Criteria) this;
        }

        public Criteria andArg1LessThan(String value) {
            addCriterion("ARG1 <", value, "arg1");
            return (Criteria) this;
        }

        public Criteria andArg1LessThanOrEqualTo(String value) {
            addCriterion("ARG1 <=", value, "arg1");
            return (Criteria) this;
        }

        public Criteria andArg1Like(String value) {
            addCriterion("ARG1 like", value, "arg1");
            return (Criteria) this;
        }

        public Criteria andArg1NotLike(String value) {
            addCriterion("ARG1 not like", value, "arg1");
            return (Criteria) this;
        }

        public Criteria andArg1In(List<String> values) {
            addCriterion("ARG1 in", values, "arg1");
            return (Criteria) this;
        }

        public Criteria andArg1NotIn(List<String> values) {
            addCriterion("ARG1 not in", values, "arg1");
            return (Criteria) this;
        }

        public Criteria andArg1Between(String value1, String value2) {
            addCriterion("ARG1 between", value1, value2, "arg1");
            return (Criteria) this;
        }

        public Criteria andArg1NotBetween(String value1, String value2) {
            addCriterion("ARG1 not between", value1, value2, "arg1");
            return (Criteria) this;
        }

        public Criteria andArg2IsNull() {
            addCriterion("ARG2 is null");
            return (Criteria) this;
        }

        public Criteria andArg2IsNotNull() {
            addCriterion("ARG2 is not null");
            return (Criteria) this;
        }

        public Criteria andArg2EqualTo(String value) {
            addCriterion("ARG2 =", value, "arg2");
            return (Criteria) this;
        }

        public Criteria andArg2NotEqualTo(String value) {
            addCriterion("ARG2 <>", value, "arg2");
            return (Criteria) this;
        }

        public Criteria andArg2GreaterThan(String value) {
            addCriterion("ARG2 >", value, "arg2");
            return (Criteria) this;
        }

        public Criteria andArg2GreaterThanOrEqualTo(String value) {
            addCriterion("ARG2 >=", value, "arg2");
            return (Criteria) this;
        }

        public Criteria andArg2LessThan(String value) {
            addCriterion("ARG2 <", value, "arg2");
            return (Criteria) this;
        }

        public Criteria andArg2LessThanOrEqualTo(String value) {
            addCriterion("ARG2 <=", value, "arg2");
            return (Criteria) this;
        }

        public Criteria andArg2Like(String value) {
            addCriterion("ARG2 like", value, "arg2");
            return (Criteria) this;
        }

        public Criteria andArg2NotLike(String value) {
            addCriterion("ARG2 not like", value, "arg2");
            return (Criteria) this;
        }

        public Criteria andArg2In(List<String> values) {
            addCriterion("ARG2 in", values, "arg2");
            return (Criteria) this;
        }

        public Criteria andArg2NotIn(List<String> values) {
            addCriterion("ARG2 not in", values, "arg2");
            return (Criteria) this;
        }

        public Criteria andArg2Between(String value1, String value2) {
            addCriterion("ARG2 between", value1, value2, "arg2");
            return (Criteria) this;
        }

        public Criteria andArg2NotBetween(String value1, String value2) {
            addCriterion("ARG2 not between", value1, value2, "arg2");
            return (Criteria) this;
        }

        public Criteria andArg3IsNull() {
            addCriterion("ARG3 is null");
            return (Criteria) this;
        }

        public Criteria andArg3IsNotNull() {
            addCriterion("ARG3 is not null");
            return (Criteria) this;
        }

        public Criteria andArg3EqualTo(String value) {
            addCriterion("ARG3 =", value, "arg3");
            return (Criteria) this;
        }

        public Criteria andArg3NotEqualTo(String value) {
            addCriterion("ARG3 <>", value, "arg3");
            return (Criteria) this;
        }

        public Criteria andArg3GreaterThan(String value) {
            addCriterion("ARG3 >", value, "arg3");
            return (Criteria) this;
        }

        public Criteria andArg3GreaterThanOrEqualTo(String value) {
            addCriterion("ARG3 >=", value, "arg3");
            return (Criteria) this;
        }

        public Criteria andArg3LessThan(String value) {
            addCriterion("ARG3 <", value, "arg3");
            return (Criteria) this;
        }

        public Criteria andArg3LessThanOrEqualTo(String value) {
            addCriterion("ARG3 <=", value, "arg3");
            return (Criteria) this;
        }

        public Criteria andArg3Like(String value) {
            addCriterion("ARG3 like", value, "arg3");
            return (Criteria) this;
        }

        public Criteria andArg3NotLike(String value) {
            addCriterion("ARG3 not like", value, "arg3");
            return (Criteria) this;
        }

        public Criteria andArg3In(List<String> values) {
            addCriterion("ARG3 in", values, "arg3");
            return (Criteria) this;
        }

        public Criteria andArg3NotIn(List<String> values) {
            addCriterion("ARG3 not in", values, "arg3");
            return (Criteria) this;
        }

        public Criteria andArg3Between(String value1, String value2) {
            addCriterion("ARG3 between", value1, value2, "arg3");
            return (Criteria) this;
        }

        public Criteria andArg3NotBetween(String value1, String value2) {
            addCriterion("ARG3 not between", value1, value2, "arg3");
            return (Criteria) this;
        }

        public Criteria andCallerFilenameIsNull() {
            addCriterion("CALLER_FILENAME is null");
            return (Criteria) this;
        }

        public Criteria andCallerFilenameIsNotNull() {
            addCriterion("CALLER_FILENAME is not null");
            return (Criteria) this;
        }

        public Criteria andCallerFilenameEqualTo(String value) {
            addCriterion("CALLER_FILENAME =", value, "callerFilename");
            return (Criteria) this;
        }

        public Criteria andCallerFilenameNotEqualTo(String value) {
            addCriterion("CALLER_FILENAME <>", value, "callerFilename");
            return (Criteria) this;
        }

        public Criteria andCallerFilenameGreaterThan(String value) {
            addCriterion("CALLER_FILENAME >", value, "callerFilename");
            return (Criteria) this;
        }

        public Criteria andCallerFilenameGreaterThanOrEqualTo(String value) {
            addCriterion("CALLER_FILENAME >=", value, "callerFilename");
            return (Criteria) this;
        }

        public Criteria andCallerFilenameLessThan(String value) {
            addCriterion("CALLER_FILENAME <", value, "callerFilename");
            return (Criteria) this;
        }

        public Criteria andCallerFilenameLessThanOrEqualTo(String value) {
            addCriterion("CALLER_FILENAME <=", value, "callerFilename");
            return (Criteria) this;
        }

        public Criteria andCallerFilenameLike(String value) {
            addCriterion("CALLER_FILENAME like", value, "callerFilename");
            return (Criteria) this;
        }

        public Criteria andCallerFilenameNotLike(String value) {
            addCriterion("CALLER_FILENAME not like", value, "callerFilename");
            return (Criteria) this;
        }

        public Criteria andCallerFilenameIn(List<String> values) {
            addCriterion("CALLER_FILENAME in", values, "callerFilename");
            return (Criteria) this;
        }

        public Criteria andCallerFilenameNotIn(List<String> values) {
            addCriterion("CALLER_FILENAME not in", values, "callerFilename");
            return (Criteria) this;
        }

        public Criteria andCallerFilenameBetween(String value1, String value2) {
            addCriterion("CALLER_FILENAME between", value1, value2, "callerFilename");
            return (Criteria) this;
        }

        public Criteria andCallerFilenameNotBetween(String value1, String value2) {
            addCriterion("CALLER_FILENAME not between", value1, value2, "callerFilename");
            return (Criteria) this;
        }

        public Criteria andCallerClassIsNull() {
            addCriterion("CALLER_CLASS is null");
            return (Criteria) this;
        }

        public Criteria andCallerClassIsNotNull() {
            addCriterion("CALLER_CLASS is not null");
            return (Criteria) this;
        }

        public Criteria andCallerClassEqualTo(String value) {
            addCriterion("CALLER_CLASS =", value, "callerClass");
            return (Criteria) this;
        }

        public Criteria andCallerClassNotEqualTo(String value) {
            addCriterion("CALLER_CLASS <>", value, "callerClass");
            return (Criteria) this;
        }

        public Criteria andCallerClassGreaterThan(String value) {
            addCriterion("CALLER_CLASS >", value, "callerClass");
            return (Criteria) this;
        }

        public Criteria andCallerClassGreaterThanOrEqualTo(String value) {
            addCriterion("CALLER_CLASS >=", value, "callerClass");
            return (Criteria) this;
        }

        public Criteria andCallerClassLessThan(String value) {
            addCriterion("CALLER_CLASS <", value, "callerClass");
            return (Criteria) this;
        }

        public Criteria andCallerClassLessThanOrEqualTo(String value) {
            addCriterion("CALLER_CLASS <=", value, "callerClass");
            return (Criteria) this;
        }

        public Criteria andCallerClassLike(String value) {
            addCriterion("CALLER_CLASS like", value, "callerClass");
            return (Criteria) this;
        }

        public Criteria andCallerClassNotLike(String value) {
            addCriterion("CALLER_CLASS not like", value, "callerClass");
            return (Criteria) this;
        }

        public Criteria andCallerClassIn(List<String> values) {
            addCriterion("CALLER_CLASS in", values, "callerClass");
            return (Criteria) this;
        }

        public Criteria andCallerClassNotIn(List<String> values) {
            addCriterion("CALLER_CLASS not in", values, "callerClass");
            return (Criteria) this;
        }

        public Criteria andCallerClassBetween(String value1, String value2) {
            addCriterion("CALLER_CLASS between", value1, value2, "callerClass");
            return (Criteria) this;
        }

        public Criteria andCallerClassNotBetween(String value1, String value2) {
            addCriterion("CALLER_CLASS not between", value1, value2, "callerClass");
            return (Criteria) this;
        }

        public Criteria andCallerMethodIsNull() {
            addCriterion("CALLER_METHOD is null");
            return (Criteria) this;
        }

        public Criteria andCallerMethodIsNotNull() {
            addCriterion("CALLER_METHOD is not null");
            return (Criteria) this;
        }

        public Criteria andCallerMethodEqualTo(String value) {
            addCriterion("CALLER_METHOD =", value, "callerMethod");
            return (Criteria) this;
        }

        public Criteria andCallerMethodNotEqualTo(String value) {
            addCriterion("CALLER_METHOD <>", value, "callerMethod");
            return (Criteria) this;
        }

        public Criteria andCallerMethodGreaterThan(String value) {
            addCriterion("CALLER_METHOD >", value, "callerMethod");
            return (Criteria) this;
        }

        public Criteria andCallerMethodGreaterThanOrEqualTo(String value) {
            addCriterion("CALLER_METHOD >=", value, "callerMethod");
            return (Criteria) this;
        }

        public Criteria andCallerMethodLessThan(String value) {
            addCriterion("CALLER_METHOD <", value, "callerMethod");
            return (Criteria) this;
        }

        public Criteria andCallerMethodLessThanOrEqualTo(String value) {
            addCriterion("CALLER_METHOD <=", value, "callerMethod");
            return (Criteria) this;
        }

        public Criteria andCallerMethodLike(String value) {
            addCriterion("CALLER_METHOD like", value, "callerMethod");
            return (Criteria) this;
        }

        public Criteria andCallerMethodNotLike(String value) {
            addCriterion("CALLER_METHOD not like", value, "callerMethod");
            return (Criteria) this;
        }

        public Criteria andCallerMethodIn(List<String> values) {
            addCriterion("CALLER_METHOD in", values, "callerMethod");
            return (Criteria) this;
        }

        public Criteria andCallerMethodNotIn(List<String> values) {
            addCriterion("CALLER_METHOD not in", values, "callerMethod");
            return (Criteria) this;
        }

        public Criteria andCallerMethodBetween(String value1, String value2) {
            addCriterion("CALLER_METHOD between", value1, value2, "callerMethod");
            return (Criteria) this;
        }

        public Criteria andCallerMethodNotBetween(String value1, String value2) {
            addCriterion("CALLER_METHOD not between", value1, value2, "callerMethod");
            return (Criteria) this;
        }

        public Criteria andCallerLineIsNull() {
            addCriterion("CALLER_LINE is null");
            return (Criteria) this;
        }

        public Criteria andCallerLineIsNotNull() {
            addCriterion("CALLER_LINE is not null");
            return (Criteria) this;
        }

        public Criteria andCallerLineEqualTo(String value) {
            addCriterion("CALLER_LINE =", value, "callerLine");
            return (Criteria) this;
        }

        public Criteria andCallerLineNotEqualTo(String value) {
            addCriterion("CALLER_LINE <>", value, "callerLine");
            return (Criteria) this;
        }

        public Criteria andCallerLineGreaterThan(String value) {
            addCriterion("CALLER_LINE >", value, "callerLine");
            return (Criteria) this;
        }

        public Criteria andCallerLineGreaterThanOrEqualTo(String value) {
            addCriterion("CALLER_LINE >=", value, "callerLine");
            return (Criteria) this;
        }

        public Criteria andCallerLineLessThan(String value) {
            addCriterion("CALLER_LINE <", value, "callerLine");
            return (Criteria) this;
        }

        public Criteria andCallerLineLessThanOrEqualTo(String value) {
            addCriterion("CALLER_LINE <=", value, "callerLine");
            return (Criteria) this;
        }

        public Criteria andCallerLineLike(String value) {
            addCriterion("CALLER_LINE like", value, "callerLine");
            return (Criteria) this;
        }

        public Criteria andCallerLineNotLike(String value) {
            addCriterion("CALLER_LINE not like", value, "callerLine");
            return (Criteria) this;
        }

        public Criteria andCallerLineIn(List<String> values) {
            addCriterion("CALLER_LINE in", values, "callerLine");
            return (Criteria) this;
        }

        public Criteria andCallerLineNotIn(List<String> values) {
            addCriterion("CALLER_LINE not in", values, "callerLine");
            return (Criteria) this;
        }

        public Criteria andCallerLineBetween(String value1, String value2) {
            addCriterion("CALLER_LINE between", value1, value2, "callerLine");
            return (Criteria) this;
        }

        public Criteria andCallerLineNotBetween(String value1, String value2) {
            addCriterion("CALLER_LINE not between", value1, value2, "callerLine");
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