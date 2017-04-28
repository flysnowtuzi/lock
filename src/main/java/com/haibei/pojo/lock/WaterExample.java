package com.haibei.pojo.lock;

import java.util.ArrayList;
import java.util.List;

public class WaterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int rowsPerPage = -1;

    public WaterExample() {
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

        public Criteria andSeqNoIsNull() {
            addCriterion("SEQ_NO is null");
            return (Criteria) this;
        }

        public Criteria andSeqNoIsNotNull() {
            addCriterion("SEQ_NO is not null");
            return (Criteria) this;
        }

        public Criteria andSeqNoEqualTo(Long value) {
            addCriterion("SEQ_NO =", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoNotEqualTo(Long value) {
            addCriterion("SEQ_NO <>", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoGreaterThan(Long value) {
            addCriterion("SEQ_NO >", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoGreaterThanOrEqualTo(Long value) {
            addCriterion("SEQ_NO >=", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoLessThan(Long value) {
            addCriterion("SEQ_NO <", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoLessThanOrEqualTo(Long value) {
            addCriterion("SEQ_NO <=", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoIn(List<Long> values) {
            addCriterion("SEQ_NO in", values, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoNotIn(List<Long> values) {
            addCriterion("SEQ_NO not in", values, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoBetween(Long value1, Long value2) {
            addCriterion("SEQ_NO between", value1, value2, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoNotBetween(Long value1, Long value2) {
            addCriterion("SEQ_NO not between", value1, value2, "seqNo");
            return (Criteria) this;
        }

        public Criteria andDevIdIsNull() {
            addCriterion("DEV_ID is null");
            return (Criteria) this;
        }

        public Criteria andDevIdIsNotNull() {
            addCriterion("DEV_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDevIdEqualTo(String value) {
            addCriterion("DEV_ID =", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdNotEqualTo(String value) {
            addCriterion("DEV_ID <>", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdGreaterThan(String value) {
            addCriterion("DEV_ID >", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdGreaterThanOrEqualTo(String value) {
            addCriterion("DEV_ID >=", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdLessThan(String value) {
            addCriterion("DEV_ID <", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdLessThanOrEqualTo(String value) {
            addCriterion("DEV_ID <=", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdLike(String value) {
            addCriterion("DEV_ID like", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdNotLike(String value) {
            addCriterion("DEV_ID not like", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdIn(List<String> values) {
            addCriterion("DEV_ID in", values, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdNotIn(List<String> values) {
            addCriterion("DEV_ID not in", values, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdBetween(String value1, String value2) {
            addCriterion("DEV_ID between", value1, value2, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdNotBetween(String value1, String value2) {
            addCriterion("DEV_ID not between", value1, value2, "devId");
            return (Criteria) this;
        }

        public Criteria andDevNameIsNull() {
            addCriterion("DEV_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDevNameIsNotNull() {
            addCriterion("DEV_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDevNameEqualTo(String value) {
            addCriterion("DEV_NAME =", value, "devName");
            return (Criteria) this;
        }

        public Criteria andDevNameNotEqualTo(String value) {
            addCriterion("DEV_NAME <>", value, "devName");
            return (Criteria) this;
        }

        public Criteria andDevNameGreaterThan(String value) {
            addCriterion("DEV_NAME >", value, "devName");
            return (Criteria) this;
        }

        public Criteria andDevNameGreaterThanOrEqualTo(String value) {
            addCriterion("DEV_NAME >=", value, "devName");
            return (Criteria) this;
        }

        public Criteria andDevNameLessThan(String value) {
            addCriterion("DEV_NAME <", value, "devName");
            return (Criteria) this;
        }

        public Criteria andDevNameLessThanOrEqualTo(String value) {
            addCriterion("DEV_NAME <=", value, "devName");
            return (Criteria) this;
        }

        public Criteria andDevNameLike(String value) {
            addCriterion("DEV_NAME like", value, "devName");
            return (Criteria) this;
        }

        public Criteria andDevNameNotLike(String value) {
            addCriterion("DEV_NAME not like", value, "devName");
            return (Criteria) this;
        }

        public Criteria andDevNameIn(List<String> values) {
            addCriterion("DEV_NAME in", values, "devName");
            return (Criteria) this;
        }

        public Criteria andDevNameNotIn(List<String> values) {
            addCriterion("DEV_NAME not in", values, "devName");
            return (Criteria) this;
        }

        public Criteria andDevNameBetween(String value1, String value2) {
            addCriterion("DEV_NAME between", value1, value2, "devName");
            return (Criteria) this;
        }

        public Criteria andDevNameNotBetween(String value1, String value2) {
            addCriterion("DEV_NAME not between", value1, value2, "devName");
            return (Criteria) this;
        }

        public Criteria andLockIdIsNull() {
            addCriterion("LOCK_ID is null");
            return (Criteria) this;
        }

        public Criteria andLockIdIsNotNull() {
            addCriterion("LOCK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLockIdEqualTo(String value) {
            addCriterion("LOCK_ID =", value, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdNotEqualTo(String value) {
            addCriterion("LOCK_ID <>", value, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdGreaterThan(String value) {
            addCriterion("LOCK_ID >", value, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdGreaterThanOrEqualTo(String value) {
            addCriterion("LOCK_ID >=", value, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdLessThan(String value) {
            addCriterion("LOCK_ID <", value, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdLessThanOrEqualTo(String value) {
            addCriterion("LOCK_ID <=", value, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdLike(String value) {
            addCriterion("LOCK_ID like", value, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdNotLike(String value) {
            addCriterion("LOCK_ID not like", value, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdIn(List<String> values) {
            addCriterion("LOCK_ID in", values, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdNotIn(List<String> values) {
            addCriterion("LOCK_ID not in", values, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdBetween(String value1, String value2) {
            addCriterion("LOCK_ID between", value1, value2, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdNotBetween(String value1, String value2) {
            addCriterion("LOCK_ID not between", value1, value2, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockNameIsNull() {
            addCriterion("LOCK_NAME is null");
            return (Criteria) this;
        }

        public Criteria andLockNameIsNotNull() {
            addCriterion("LOCK_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andLockNameEqualTo(String value) {
            addCriterion("LOCK_NAME =", value, "lockName");
            return (Criteria) this;
        }

        public Criteria andLockNameNotEqualTo(String value) {
            addCriterion("LOCK_NAME <>", value, "lockName");
            return (Criteria) this;
        }

        public Criteria andLockNameGreaterThan(String value) {
            addCriterion("LOCK_NAME >", value, "lockName");
            return (Criteria) this;
        }

        public Criteria andLockNameGreaterThanOrEqualTo(String value) {
            addCriterion("LOCK_NAME >=", value, "lockName");
            return (Criteria) this;
        }

        public Criteria andLockNameLessThan(String value) {
            addCriterion("LOCK_NAME <", value, "lockName");
            return (Criteria) this;
        }

        public Criteria andLockNameLessThanOrEqualTo(String value) {
            addCriterion("LOCK_NAME <=", value, "lockName");
            return (Criteria) this;
        }

        public Criteria andLockNameLike(String value) {
            addCriterion("LOCK_NAME like", value, "lockName");
            return (Criteria) this;
        }

        public Criteria andLockNameNotLike(String value) {
            addCriterion("LOCK_NAME not like", value, "lockName");
            return (Criteria) this;
        }

        public Criteria andLockNameIn(List<String> values) {
            addCriterion("LOCK_NAME in", values, "lockName");
            return (Criteria) this;
        }

        public Criteria andLockNameNotIn(List<String> values) {
            addCriterion("LOCK_NAME not in", values, "lockName");
            return (Criteria) this;
        }

        public Criteria andLockNameBetween(String value1, String value2) {
            addCriterion("LOCK_NAME between", value1, value2, "lockName");
            return (Criteria) this;
        }

        public Criteria andLockNameNotBetween(String value1, String value2) {
            addCriterion("LOCK_NAME not between", value1, value2, "lockName");
            return (Criteria) this;
        }

        public Criteria andEventIdIsNull() {
            addCriterion("EVENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andEventIdIsNotNull() {
            addCriterion("EVENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andEventIdEqualTo(Short value) {
            addCriterion("EVENT_ID =", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdNotEqualTo(Short value) {
            addCriterion("EVENT_ID <>", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdGreaterThan(Short value) {
            addCriterion("EVENT_ID >", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdGreaterThanOrEqualTo(Short value) {
            addCriterion("EVENT_ID >=", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdLessThan(Short value) {
            addCriterion("EVENT_ID <", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdLessThanOrEqualTo(Short value) {
            addCriterion("EVENT_ID <=", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdIn(List<Short> values) {
            addCriterion("EVENT_ID in", values, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdNotIn(List<Short> values) {
            addCriterion("EVENT_ID not in", values, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdBetween(Short value1, Short value2) {
            addCriterion("EVENT_ID between", value1, value2, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdNotBetween(Short value1, Short value2) {
            addCriterion("EVENT_ID not between", value1, value2, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventNameIsNull() {
            addCriterion("EVENT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andEventNameIsNotNull() {
            addCriterion("EVENT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andEventNameEqualTo(String value) {
            addCriterion("EVENT_NAME =", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameNotEqualTo(String value) {
            addCriterion("EVENT_NAME <>", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameGreaterThan(String value) {
            addCriterion("EVENT_NAME >", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameGreaterThanOrEqualTo(String value) {
            addCriterion("EVENT_NAME >=", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameLessThan(String value) {
            addCriterion("EVENT_NAME <", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameLessThanOrEqualTo(String value) {
            addCriterion("EVENT_NAME <=", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameLike(String value) {
            addCriterion("EVENT_NAME like", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameNotLike(String value) {
            addCriterion("EVENT_NAME not like", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameIn(List<String> values) {
            addCriterion("EVENT_NAME in", values, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameNotIn(List<String> values) {
            addCriterion("EVENT_NAME not in", values, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameBetween(String value1, String value2) {
            addCriterion("EVENT_NAME between", value1, value2, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameNotBetween(String value1, String value2) {
            addCriterion("EVENT_NAME not between", value1, value2, "eventName");
            return (Criteria) this;
        }

        public Criteria andCardPhyidIsNull() {
            addCriterion("CARD_PHYID is null");
            return (Criteria) this;
        }

        public Criteria andCardPhyidIsNotNull() {
            addCriterion("CARD_PHYID is not null");
            return (Criteria) this;
        }

        public Criteria andCardPhyidEqualTo(String value) {
            addCriterion("CARD_PHYID =", value, "cardPhyid");
            return (Criteria) this;
        }

        public Criteria andCardPhyidNotEqualTo(String value) {
            addCriterion("CARD_PHYID <>", value, "cardPhyid");
            return (Criteria) this;
        }

        public Criteria andCardPhyidGreaterThan(String value) {
            addCriterion("CARD_PHYID >", value, "cardPhyid");
            return (Criteria) this;
        }

        public Criteria andCardPhyidGreaterThanOrEqualTo(String value) {
            addCriterion("CARD_PHYID >=", value, "cardPhyid");
            return (Criteria) this;
        }

        public Criteria andCardPhyidLessThan(String value) {
            addCriterion("CARD_PHYID <", value, "cardPhyid");
            return (Criteria) this;
        }

        public Criteria andCardPhyidLessThanOrEqualTo(String value) {
            addCriterion("CARD_PHYID <=", value, "cardPhyid");
            return (Criteria) this;
        }

        public Criteria andCardPhyidLike(String value) {
            addCriterion("CARD_PHYID like", value, "cardPhyid");
            return (Criteria) this;
        }

        public Criteria andCardPhyidNotLike(String value) {
            addCriterion("CARD_PHYID not like", value, "cardPhyid");
            return (Criteria) this;
        }

        public Criteria andCardPhyidIn(List<String> values) {
            addCriterion("CARD_PHYID in", values, "cardPhyid");
            return (Criteria) this;
        }

        public Criteria andCardPhyidNotIn(List<String> values) {
            addCriterion("CARD_PHYID not in", values, "cardPhyid");
            return (Criteria) this;
        }

        public Criteria andCardPhyidBetween(String value1, String value2) {
            addCriterion("CARD_PHYID between", value1, value2, "cardPhyid");
            return (Criteria) this;
        }

        public Criteria andCardPhyidNotBetween(String value1, String value2) {
            addCriterion("CARD_PHYID not between", value1, value2, "cardPhyid");
            return (Criteria) this;
        }

        public Criteria andTimeCreateIsNull() {
            addCriterion("TIME_CREATE is null");
            return (Criteria) this;
        }

        public Criteria andTimeCreateIsNotNull() {
            addCriterion("TIME_CREATE is not null");
            return (Criteria) this;
        }

        public Criteria andTimeCreateEqualTo(String value) {
            addCriterion("TIME_CREATE =", value, "timeCreate");
            return (Criteria) this;
        }

        public Criteria andTimeCreateNotEqualTo(String value) {
            addCriterion("TIME_CREATE <>", value, "timeCreate");
            return (Criteria) this;
        }

        public Criteria andTimeCreateGreaterThan(String value) {
            addCriterion("TIME_CREATE >", value, "timeCreate");
            return (Criteria) this;
        }

        public Criteria andTimeCreateGreaterThanOrEqualTo(String value) {
            addCriterion("TIME_CREATE >=", value, "timeCreate");
            return (Criteria) this;
        }

        public Criteria andTimeCreateLessThan(String value) {
            addCriterion("TIME_CREATE <", value, "timeCreate");
            return (Criteria) this;
        }

        public Criteria andTimeCreateLessThanOrEqualTo(String value) {
            addCriterion("TIME_CREATE <=", value, "timeCreate");
            return (Criteria) this;
        }

        public Criteria andTimeCreateLike(String value) {
            addCriterion("TIME_CREATE like", value, "timeCreate");
            return (Criteria) this;
        }

        public Criteria andTimeCreateNotLike(String value) {
            addCriterion("TIME_CREATE not like", value, "timeCreate");
            return (Criteria) this;
        }

        public Criteria andTimeCreateIn(List<String> values) {
            addCriterion("TIME_CREATE in", values, "timeCreate");
            return (Criteria) this;
        }

        public Criteria andTimeCreateNotIn(List<String> values) {
            addCriterion("TIME_CREATE not in", values, "timeCreate");
            return (Criteria) this;
        }

        public Criteria andTimeCreateBetween(String value1, String value2) {
            addCriterion("TIME_CREATE between", value1, value2, "timeCreate");
            return (Criteria) this;
        }

        public Criteria andTimeCreateNotBetween(String value1, String value2) {
            addCriterion("TIME_CREATE not between", value1, value2, "timeCreate");
            return (Criteria) this;
        }

        public Criteria andTimeReturnIsNull() {
            addCriterion("TIME_RETURN is null");
            return (Criteria) this;
        }

        public Criteria andTimeReturnIsNotNull() {
            addCriterion("TIME_RETURN is not null");
            return (Criteria) this;
        }

        public Criteria andTimeReturnEqualTo(String value) {
            addCriterion("TIME_RETURN =", value, "timeReturn");
            return (Criteria) this;
        }

        public Criteria andTimeReturnNotEqualTo(String value) {
            addCriterion("TIME_RETURN <>", value, "timeReturn");
            return (Criteria) this;
        }

        public Criteria andTimeReturnGreaterThan(String value) {
            addCriterion("TIME_RETURN >", value, "timeReturn");
            return (Criteria) this;
        }

        public Criteria andTimeReturnGreaterThanOrEqualTo(String value) {
            addCriterion("TIME_RETURN >=", value, "timeReturn");
            return (Criteria) this;
        }

        public Criteria andTimeReturnLessThan(String value) {
            addCriterion("TIME_RETURN <", value, "timeReturn");
            return (Criteria) this;
        }

        public Criteria andTimeReturnLessThanOrEqualTo(String value) {
            addCriterion("TIME_RETURN <=", value, "timeReturn");
            return (Criteria) this;
        }

        public Criteria andTimeReturnLike(String value) {
            addCriterion("TIME_RETURN like", value, "timeReturn");
            return (Criteria) this;
        }

        public Criteria andTimeReturnNotLike(String value) {
            addCriterion("TIME_RETURN not like", value, "timeReturn");
            return (Criteria) this;
        }

        public Criteria andTimeReturnIn(List<String> values) {
            addCriterion("TIME_RETURN in", values, "timeReturn");
            return (Criteria) this;
        }

        public Criteria andTimeReturnNotIn(List<String> values) {
            addCriterion("TIME_RETURN not in", values, "timeReturn");
            return (Criteria) this;
        }

        public Criteria andTimeReturnBetween(String value1, String value2) {
            addCriterion("TIME_RETURN between", value1, value2, "timeReturn");
            return (Criteria) this;
        }

        public Criteria andTimeReturnNotBetween(String value1, String value2) {
            addCriterion("TIME_RETURN not between", value1, value2, "timeReturn");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("USER_ID like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("USER_ID not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("USER_NAME =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("USER_NAME <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("USER_NAME >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NAME >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("USER_NAME <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("USER_NAME <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("USER_NAME like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("USER_NAME not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("USER_NAME in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("USER_NAME not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("USER_NAME between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("USER_NAME not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNull() {
            addCriterion("DEPT_ID is null");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNotNull() {
            addCriterion("DEPT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDeptIdEqualTo(String value) {
            addCriterion("DEPT_ID =", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotEqualTo(String value) {
            addCriterion("DEPT_ID <>", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThan(String value) {
            addCriterion("DEPT_ID >", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThanOrEqualTo(String value) {
            addCriterion("DEPT_ID >=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThan(String value) {
            addCriterion("DEPT_ID <", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThanOrEqualTo(String value) {
            addCriterion("DEPT_ID <=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLike(String value) {
            addCriterion("DEPT_ID like", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotLike(String value) {
            addCriterion("DEPT_ID not like", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdIn(List<String> values) {
            addCriterion("DEPT_ID in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotIn(List<String> values) {
            addCriterion("DEPT_ID not in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdBetween(String value1, String value2) {
            addCriterion("DEPT_ID between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotBetween(String value1, String value2) {
            addCriterion("DEPT_ID not between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptNameIsNull() {
            addCriterion("DEPT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDeptNameIsNotNull() {
            addCriterion("DEPT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDeptNameEqualTo(String value) {
            addCriterion("DEPT_NAME =", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotEqualTo(String value) {
            addCriterion("DEPT_NAME <>", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameGreaterThan(String value) {
            addCriterion("DEPT_NAME >", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameGreaterThanOrEqualTo(String value) {
            addCriterion("DEPT_NAME >=", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLessThan(String value) {
            addCriterion("DEPT_NAME <", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLessThanOrEqualTo(String value) {
            addCriterion("DEPT_NAME <=", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLike(String value) {
            addCriterion("DEPT_NAME like", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotLike(String value) {
            addCriterion("DEPT_NAME not like", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameIn(List<String> values) {
            addCriterion("DEPT_NAME in", values, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotIn(List<String> values) {
            addCriterion("DEPT_NAME not in", values, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameBetween(String value1, String value2) {
            addCriterion("DEPT_NAME between", value1, value2, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotBetween(String value1, String value2) {
            addCriterion("DEPT_NAME not between", value1, value2, "deptName");
            return (Criteria) this;
        }

        public Criteria andRtnFlagIsNull() {
            addCriterion("RTN_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andRtnFlagIsNotNull() {
            addCriterion("RTN_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andRtnFlagEqualTo(Short value) {
            addCriterion("RTN_FLAG =", value, "rtnFlag");
            return (Criteria) this;
        }

        public Criteria andRtnFlagNotEqualTo(Short value) {
            addCriterion("RTN_FLAG <>", value, "rtnFlag");
            return (Criteria) this;
        }

        public Criteria andRtnFlagGreaterThan(Short value) {
            addCriterion("RTN_FLAG >", value, "rtnFlag");
            return (Criteria) this;
        }

        public Criteria andRtnFlagGreaterThanOrEqualTo(Short value) {
            addCriterion("RTN_FLAG >=", value, "rtnFlag");
            return (Criteria) this;
        }

        public Criteria andRtnFlagLessThan(Short value) {
            addCriterion("RTN_FLAG <", value, "rtnFlag");
            return (Criteria) this;
        }

        public Criteria andRtnFlagLessThanOrEqualTo(Short value) {
            addCriterion("RTN_FLAG <=", value, "rtnFlag");
            return (Criteria) this;
        }

        public Criteria andRtnFlagIn(List<Short> values) {
            addCriterion("RTN_FLAG in", values, "rtnFlag");
            return (Criteria) this;
        }

        public Criteria andRtnFlagNotIn(List<Short> values) {
            addCriterion("RTN_FLAG not in", values, "rtnFlag");
            return (Criteria) this;
        }

        public Criteria andRtnFlagBetween(Short value1, Short value2) {
            addCriterion("RTN_FLAG between", value1, value2, "rtnFlag");
            return (Criteria) this;
        }

        public Criteria andRtnFlagNotBetween(Short value1, Short value2) {
            addCriterion("RTN_FLAG not between", value1, value2, "rtnFlag");
            return (Criteria) this;
        }

        public Criteria andRtnDataIsNull() {
            addCriterion("RTN_DATA is null");
            return (Criteria) this;
        }

        public Criteria andRtnDataIsNotNull() {
            addCriterion("RTN_DATA is not null");
            return (Criteria) this;
        }

        public Criteria andRtnDataEqualTo(String value) {
            addCriterion("RTN_DATA =", value, "rtnData");
            return (Criteria) this;
        }

        public Criteria andRtnDataNotEqualTo(String value) {
            addCriterion("RTN_DATA <>", value, "rtnData");
            return (Criteria) this;
        }

        public Criteria andRtnDataGreaterThan(String value) {
            addCriterion("RTN_DATA >", value, "rtnData");
            return (Criteria) this;
        }

        public Criteria andRtnDataGreaterThanOrEqualTo(String value) {
            addCriterion("RTN_DATA >=", value, "rtnData");
            return (Criteria) this;
        }

        public Criteria andRtnDataLessThan(String value) {
            addCriterion("RTN_DATA <", value, "rtnData");
            return (Criteria) this;
        }

        public Criteria andRtnDataLessThanOrEqualTo(String value) {
            addCriterion("RTN_DATA <=", value, "rtnData");
            return (Criteria) this;
        }

        public Criteria andRtnDataLike(String value) {
            addCriterion("RTN_DATA like", value, "rtnData");
            return (Criteria) this;
        }

        public Criteria andRtnDataNotLike(String value) {
            addCriterion("RTN_DATA not like", value, "rtnData");
            return (Criteria) this;
        }

        public Criteria andRtnDataIn(List<String> values) {
            addCriterion("RTN_DATA in", values, "rtnData");
            return (Criteria) this;
        }

        public Criteria andRtnDataNotIn(List<String> values) {
            addCriterion("RTN_DATA not in", values, "rtnData");
            return (Criteria) this;
        }

        public Criteria andRtnDataBetween(String value1, String value2) {
            addCriterion("RTN_DATA between", value1, value2, "rtnData");
            return (Criteria) this;
        }

        public Criteria andRtnDataNotBetween(String value1, String value2) {
            addCriterion("RTN_DATA not between", value1, value2, "rtnData");
            return (Criteria) this;
        }

        public Criteria andRtnJsonIsNull() {
            addCriterion("RTN_JSON is null");
            return (Criteria) this;
        }

        public Criteria andRtnJsonIsNotNull() {
            addCriterion("RTN_JSON is not null");
            return (Criteria) this;
        }

        public Criteria andRtnJsonEqualTo(String value) {
            addCriterion("RTN_JSON =", value, "rtnJson");
            return (Criteria) this;
        }

        public Criteria andRtnJsonNotEqualTo(String value) {
            addCriterion("RTN_JSON <>", value, "rtnJson");
            return (Criteria) this;
        }

        public Criteria andRtnJsonGreaterThan(String value) {
            addCriterion("RTN_JSON >", value, "rtnJson");
            return (Criteria) this;
        }

        public Criteria andRtnJsonGreaterThanOrEqualTo(String value) {
            addCriterion("RTN_JSON >=", value, "rtnJson");
            return (Criteria) this;
        }

        public Criteria andRtnJsonLessThan(String value) {
            addCriterion("RTN_JSON <", value, "rtnJson");
            return (Criteria) this;
        }

        public Criteria andRtnJsonLessThanOrEqualTo(String value) {
            addCriterion("RTN_JSON <=", value, "rtnJson");
            return (Criteria) this;
        }

        public Criteria andRtnJsonLike(String value) {
            addCriterion("RTN_JSON like", value, "rtnJson");
            return (Criteria) this;
        }

        public Criteria andRtnJsonNotLike(String value) {
            addCriterion("RTN_JSON not like", value, "rtnJson");
            return (Criteria) this;
        }

        public Criteria andRtnJsonIn(List<String> values) {
            addCriterion("RTN_JSON in", values, "rtnJson");
            return (Criteria) this;
        }

        public Criteria andRtnJsonNotIn(List<String> values) {
            addCriterion("RTN_JSON not in", values, "rtnJson");
            return (Criteria) this;
        }

        public Criteria andRtnJsonBetween(String value1, String value2) {
            addCriterion("RTN_JSON between", value1, value2, "rtnJson");
            return (Criteria) this;
        }

        public Criteria andRtnJsonNotBetween(String value1, String value2) {
            addCriterion("RTN_JSON not between", value1, value2, "rtnJson");
            return (Criteria) this;
        }

        public Criteria andCmdNoIsNull() {
            addCriterion("CMD_NO is null");
            return (Criteria) this;
        }

        public Criteria andCmdNoIsNotNull() {
            addCriterion("CMD_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCmdNoEqualTo(String value) {
            addCriterion("CMD_NO =", value, "cmdNo");
            return (Criteria) this;
        }

        public Criteria andCmdNoNotEqualTo(String value) {
            addCriterion("CMD_NO <>", value, "cmdNo");
            return (Criteria) this;
        }

        public Criteria andCmdNoGreaterThan(String value) {
            addCriterion("CMD_NO >", value, "cmdNo");
            return (Criteria) this;
        }

        public Criteria andCmdNoGreaterThanOrEqualTo(String value) {
            addCriterion("CMD_NO >=", value, "cmdNo");
            return (Criteria) this;
        }

        public Criteria andCmdNoLessThan(String value) {
            addCriterion("CMD_NO <", value, "cmdNo");
            return (Criteria) this;
        }

        public Criteria andCmdNoLessThanOrEqualTo(String value) {
            addCriterion("CMD_NO <=", value, "cmdNo");
            return (Criteria) this;
        }

        public Criteria andCmdNoLike(String value) {
            addCriterion("CMD_NO like", value, "cmdNo");
            return (Criteria) this;
        }

        public Criteria andCmdNoNotLike(String value) {
            addCriterion("CMD_NO not like", value, "cmdNo");
            return (Criteria) this;
        }

        public Criteria andCmdNoIn(List<String> values) {
            addCriterion("CMD_NO in", values, "cmdNo");
            return (Criteria) this;
        }

        public Criteria andCmdNoNotIn(List<String> values) {
            addCriterion("CMD_NO not in", values, "cmdNo");
            return (Criteria) this;
        }

        public Criteria andCmdNoBetween(String value1, String value2) {
            addCriterion("CMD_NO between", value1, value2, "cmdNo");
            return (Criteria) this;
        }

        public Criteria andCmdNoNotBetween(String value1, String value2) {
            addCriterion("CMD_NO not between", value1, value2, "cmdNo");
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