package com.haibei.pojo.lock;

import java.util.ArrayList;
import java.util.List;

public class CmdExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int rowsPerPage = -1;

    public CmdExample() {
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

        public Criteria andSeqNoEqualTo(String value) {
            addCriterion("SEQ_NO =", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoNotEqualTo(String value) {
            addCriterion("SEQ_NO <>", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoGreaterThan(String value) {
            addCriterion("SEQ_NO >", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoGreaterThanOrEqualTo(String value) {
            addCriterion("SEQ_NO >=", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoLessThan(String value) {
            addCriterion("SEQ_NO <", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoLessThanOrEqualTo(String value) {
            addCriterion("SEQ_NO <=", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoLike(String value) {
            addCriterion("SEQ_NO like", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoNotLike(String value) {
            addCriterion("SEQ_NO not like", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoIn(List<String> values) {
            addCriterion("SEQ_NO in", values, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoNotIn(List<String> values) {
            addCriterion("SEQ_NO not in", values, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoBetween(String value1, String value2) {
            addCriterion("SEQ_NO between", value1, value2, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoNotBetween(String value1, String value2) {
            addCriterion("SEQ_NO not between", value1, value2, "seqNo");
            return (Criteria) this;
        }

        public Criteria andDevIpIsNull() {
            addCriterion("DEV_IP is null");
            return (Criteria) this;
        }

        public Criteria andDevIpIsNotNull() {
            addCriterion("DEV_IP is not null");
            return (Criteria) this;
        }

        public Criteria andDevIpEqualTo(String value) {
            addCriterion("DEV_IP =", value, "devIp");
            return (Criteria) this;
        }

        public Criteria andDevIpNotEqualTo(String value) {
            addCriterion("DEV_IP <>", value, "devIp");
            return (Criteria) this;
        }

        public Criteria andDevIpGreaterThan(String value) {
            addCriterion("DEV_IP >", value, "devIp");
            return (Criteria) this;
        }

        public Criteria andDevIpGreaterThanOrEqualTo(String value) {
            addCriterion("DEV_IP >=", value, "devIp");
            return (Criteria) this;
        }

        public Criteria andDevIpLessThan(String value) {
            addCriterion("DEV_IP <", value, "devIp");
            return (Criteria) this;
        }

        public Criteria andDevIpLessThanOrEqualTo(String value) {
            addCriterion("DEV_IP <=", value, "devIp");
            return (Criteria) this;
        }

        public Criteria andDevIpLike(String value) {
            addCriterion("DEV_IP like", value, "devIp");
            return (Criteria) this;
        }

        public Criteria andDevIpNotLike(String value) {
            addCriterion("DEV_IP not like", value, "devIp");
            return (Criteria) this;
        }

        public Criteria andDevIpIn(List<String> values) {
            addCriterion("DEV_IP in", values, "devIp");
            return (Criteria) this;
        }

        public Criteria andDevIpNotIn(List<String> values) {
            addCriterion("DEV_IP not in", values, "devIp");
            return (Criteria) this;
        }

        public Criteria andDevIpBetween(String value1, String value2) {
            addCriterion("DEV_IP between", value1, value2, "devIp");
            return (Criteria) this;
        }

        public Criteria andDevIpNotBetween(String value1, String value2) {
            addCriterion("DEV_IP not between", value1, value2, "devIp");
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

        public Criteria andCmdPlainIsNull() {
            addCriterion("CMD_PLAIN is null");
            return (Criteria) this;
        }

        public Criteria andCmdPlainIsNotNull() {
            addCriterion("CMD_PLAIN is not null");
            return (Criteria) this;
        }

        public Criteria andCmdPlainEqualTo(String value) {
            addCriterion("CMD_PLAIN =", value, "cmdPlain");
            return (Criteria) this;
        }

        public Criteria andCmdPlainNotEqualTo(String value) {
            addCriterion("CMD_PLAIN <>", value, "cmdPlain");
            return (Criteria) this;
        }

        public Criteria andCmdPlainGreaterThan(String value) {
            addCriterion("CMD_PLAIN >", value, "cmdPlain");
            return (Criteria) this;
        }

        public Criteria andCmdPlainGreaterThanOrEqualTo(String value) {
            addCriterion("CMD_PLAIN >=", value, "cmdPlain");
            return (Criteria) this;
        }

        public Criteria andCmdPlainLessThan(String value) {
            addCriterion("CMD_PLAIN <", value, "cmdPlain");
            return (Criteria) this;
        }

        public Criteria andCmdPlainLessThanOrEqualTo(String value) {
            addCriterion("CMD_PLAIN <=", value, "cmdPlain");
            return (Criteria) this;
        }

        public Criteria andCmdPlainLike(String value) {
            addCriterion("CMD_PLAIN like", value, "cmdPlain");
            return (Criteria) this;
        }

        public Criteria andCmdPlainNotLike(String value) {
            addCriterion("CMD_PLAIN not like", value, "cmdPlain");
            return (Criteria) this;
        }

        public Criteria andCmdPlainIn(List<String> values) {
            addCriterion("CMD_PLAIN in", values, "cmdPlain");
            return (Criteria) this;
        }

        public Criteria andCmdPlainNotIn(List<String> values) {
            addCriterion("CMD_PLAIN not in", values, "cmdPlain");
            return (Criteria) this;
        }

        public Criteria andCmdPlainBetween(String value1, String value2) {
            addCriterion("CMD_PLAIN between", value1, value2, "cmdPlain");
            return (Criteria) this;
        }

        public Criteria andCmdPlainNotBetween(String value1, String value2) {
            addCriterion("CMD_PLAIN not between", value1, value2, "cmdPlain");
            return (Criteria) this;
        }

        public Criteria andCmdCipherIsNull() {
            addCriterion("CMD_CIPHER is null");
            return (Criteria) this;
        }

        public Criteria andCmdCipherIsNotNull() {
            addCriterion("CMD_CIPHER is not null");
            return (Criteria) this;
        }

        public Criteria andCmdCipherEqualTo(String value) {
            addCriterion("CMD_CIPHER =", value, "cmdCipher");
            return (Criteria) this;
        }

        public Criteria andCmdCipherNotEqualTo(String value) {
            addCriterion("CMD_CIPHER <>", value, "cmdCipher");
            return (Criteria) this;
        }

        public Criteria andCmdCipherGreaterThan(String value) {
            addCriterion("CMD_CIPHER >", value, "cmdCipher");
            return (Criteria) this;
        }

        public Criteria andCmdCipherGreaterThanOrEqualTo(String value) {
            addCriterion("CMD_CIPHER >=", value, "cmdCipher");
            return (Criteria) this;
        }

        public Criteria andCmdCipherLessThan(String value) {
            addCriterion("CMD_CIPHER <", value, "cmdCipher");
            return (Criteria) this;
        }

        public Criteria andCmdCipherLessThanOrEqualTo(String value) {
            addCriterion("CMD_CIPHER <=", value, "cmdCipher");
            return (Criteria) this;
        }

        public Criteria andCmdCipherLike(String value) {
            addCriterion("CMD_CIPHER like", value, "cmdCipher");
            return (Criteria) this;
        }

        public Criteria andCmdCipherNotLike(String value) {
            addCriterion("CMD_CIPHER not like", value, "cmdCipher");
            return (Criteria) this;
        }

        public Criteria andCmdCipherIn(List<String> values) {
            addCriterion("CMD_CIPHER in", values, "cmdCipher");
            return (Criteria) this;
        }

        public Criteria andCmdCipherNotIn(List<String> values) {
            addCriterion("CMD_CIPHER not in", values, "cmdCipher");
            return (Criteria) this;
        }

        public Criteria andCmdCipherBetween(String value1, String value2) {
            addCriterion("CMD_CIPHER between", value1, value2, "cmdCipher");
            return (Criteria) this;
        }

        public Criteria andCmdCipherNotBetween(String value1, String value2) {
            addCriterion("CMD_CIPHER not between", value1, value2, "cmdCipher");
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

        public Criteria andRtnPlainIsNull() {
            addCriterion("RTN_PLAIN is null");
            return (Criteria) this;
        }

        public Criteria andRtnPlainIsNotNull() {
            addCriterion("RTN_PLAIN is not null");
            return (Criteria) this;
        }

        public Criteria andRtnPlainEqualTo(String value) {
            addCriterion("RTN_PLAIN =", value, "rtnPlain");
            return (Criteria) this;
        }

        public Criteria andRtnPlainNotEqualTo(String value) {
            addCriterion("RTN_PLAIN <>", value, "rtnPlain");
            return (Criteria) this;
        }

        public Criteria andRtnPlainGreaterThan(String value) {
            addCriterion("RTN_PLAIN >", value, "rtnPlain");
            return (Criteria) this;
        }

        public Criteria andRtnPlainGreaterThanOrEqualTo(String value) {
            addCriterion("RTN_PLAIN >=", value, "rtnPlain");
            return (Criteria) this;
        }

        public Criteria andRtnPlainLessThan(String value) {
            addCriterion("RTN_PLAIN <", value, "rtnPlain");
            return (Criteria) this;
        }

        public Criteria andRtnPlainLessThanOrEqualTo(String value) {
            addCriterion("RTN_PLAIN <=", value, "rtnPlain");
            return (Criteria) this;
        }

        public Criteria andRtnPlainLike(String value) {
            addCriterion("RTN_PLAIN like", value, "rtnPlain");
            return (Criteria) this;
        }

        public Criteria andRtnPlainNotLike(String value) {
            addCriterion("RTN_PLAIN not like", value, "rtnPlain");
            return (Criteria) this;
        }

        public Criteria andRtnPlainIn(List<String> values) {
            addCriterion("RTN_PLAIN in", values, "rtnPlain");
            return (Criteria) this;
        }

        public Criteria andRtnPlainNotIn(List<String> values) {
            addCriterion("RTN_PLAIN not in", values, "rtnPlain");
            return (Criteria) this;
        }

        public Criteria andRtnPlainBetween(String value1, String value2) {
            addCriterion("RTN_PLAIN between", value1, value2, "rtnPlain");
            return (Criteria) this;
        }

        public Criteria andRtnPlainNotBetween(String value1, String value2) {
            addCriterion("RTN_PLAIN not between", value1, value2, "rtnPlain");
            return (Criteria) this;
        }

        public Criteria andRtnCipherIsNull() {
            addCriterion("RTN_CIPHER is null");
            return (Criteria) this;
        }

        public Criteria andRtnCipherIsNotNull() {
            addCriterion("RTN_CIPHER is not null");
            return (Criteria) this;
        }

        public Criteria andRtnCipherEqualTo(String value) {
            addCriterion("RTN_CIPHER =", value, "rtnCipher");
            return (Criteria) this;
        }

        public Criteria andRtnCipherNotEqualTo(String value) {
            addCriterion("RTN_CIPHER <>", value, "rtnCipher");
            return (Criteria) this;
        }

        public Criteria andRtnCipherGreaterThan(String value) {
            addCriterion("RTN_CIPHER >", value, "rtnCipher");
            return (Criteria) this;
        }

        public Criteria andRtnCipherGreaterThanOrEqualTo(String value) {
            addCriterion("RTN_CIPHER >=", value, "rtnCipher");
            return (Criteria) this;
        }

        public Criteria andRtnCipherLessThan(String value) {
            addCriterion("RTN_CIPHER <", value, "rtnCipher");
            return (Criteria) this;
        }

        public Criteria andRtnCipherLessThanOrEqualTo(String value) {
            addCriterion("RTN_CIPHER <=", value, "rtnCipher");
            return (Criteria) this;
        }

        public Criteria andRtnCipherLike(String value) {
            addCriterion("RTN_CIPHER like", value, "rtnCipher");
            return (Criteria) this;
        }

        public Criteria andRtnCipherNotLike(String value) {
            addCriterion("RTN_CIPHER not like", value, "rtnCipher");
            return (Criteria) this;
        }

        public Criteria andRtnCipherIn(List<String> values) {
            addCriterion("RTN_CIPHER in", values, "rtnCipher");
            return (Criteria) this;
        }

        public Criteria andRtnCipherNotIn(List<String> values) {
            addCriterion("RTN_CIPHER not in", values, "rtnCipher");
            return (Criteria) this;
        }

        public Criteria andRtnCipherBetween(String value1, String value2) {
            addCriterion("RTN_CIPHER between", value1, value2, "rtnCipher");
            return (Criteria) this;
        }

        public Criteria andRtnCipherNotBetween(String value1, String value2) {
            addCriterion("RTN_CIPHER not between", value1, value2, "rtnCipher");
            return (Criteria) this;
        }

        public Criteria andTimeCostIsNull() {
            addCriterion("TIME_COST is null");
            return (Criteria) this;
        }

        public Criteria andTimeCostIsNotNull() {
            addCriterion("TIME_COST is not null");
            return (Criteria) this;
        }

        public Criteria andTimeCostEqualTo(Short value) {
            addCriterion("TIME_COST =", value, "timeCost");
            return (Criteria) this;
        }

        public Criteria andTimeCostNotEqualTo(Short value) {
            addCriterion("TIME_COST <>", value, "timeCost");
            return (Criteria) this;
        }

        public Criteria andTimeCostGreaterThan(Short value) {
            addCriterion("TIME_COST >", value, "timeCost");
            return (Criteria) this;
        }

        public Criteria andTimeCostGreaterThanOrEqualTo(Short value) {
            addCriterion("TIME_COST >=", value, "timeCost");
            return (Criteria) this;
        }

        public Criteria andTimeCostLessThan(Short value) {
            addCriterion("TIME_COST <", value, "timeCost");
            return (Criteria) this;
        }

        public Criteria andTimeCostLessThanOrEqualTo(Short value) {
            addCriterion("TIME_COST <=", value, "timeCost");
            return (Criteria) this;
        }

        public Criteria andTimeCostIn(List<Short> values) {
            addCriterion("TIME_COST in", values, "timeCost");
            return (Criteria) this;
        }

        public Criteria andTimeCostNotIn(List<Short> values) {
            addCriterion("TIME_COST not in", values, "timeCost");
            return (Criteria) this;
        }

        public Criteria andTimeCostBetween(Short value1, Short value2) {
            addCriterion("TIME_COST between", value1, value2, "timeCost");
            return (Criteria) this;
        }

        public Criteria andTimeCostNotBetween(Short value1, Short value2) {
            addCriterion("TIME_COST not between", value1, value2, "timeCost");
            return (Criteria) this;
        }

        public Criteria andCmdFlagIsNull() {
            addCriterion("CMD_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andCmdFlagIsNotNull() {
            addCriterion("CMD_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andCmdFlagEqualTo(Short value) {
            addCriterion("CMD_FLAG =", value, "cmdFlag");
            return (Criteria) this;
        }

        public Criteria andCmdFlagNotEqualTo(Short value) {
            addCriterion("CMD_FLAG <>", value, "cmdFlag");
            return (Criteria) this;
        }

        public Criteria andCmdFlagGreaterThan(Short value) {
            addCriterion("CMD_FLAG >", value, "cmdFlag");
            return (Criteria) this;
        }

        public Criteria andCmdFlagGreaterThanOrEqualTo(Short value) {
            addCriterion("CMD_FLAG >=", value, "cmdFlag");
            return (Criteria) this;
        }

        public Criteria andCmdFlagLessThan(Short value) {
            addCriterion("CMD_FLAG <", value, "cmdFlag");
            return (Criteria) this;
        }

        public Criteria andCmdFlagLessThanOrEqualTo(Short value) {
            addCriterion("CMD_FLAG <=", value, "cmdFlag");
            return (Criteria) this;
        }

        public Criteria andCmdFlagIn(List<Short> values) {
            addCriterion("CMD_FLAG in", values, "cmdFlag");
            return (Criteria) this;
        }

        public Criteria andCmdFlagNotIn(List<Short> values) {
            addCriterion("CMD_FLAG not in", values, "cmdFlag");
            return (Criteria) this;
        }

        public Criteria andCmdFlagBetween(Short value1, Short value2) {
            addCriterion("CMD_FLAG between", value1, value2, "cmdFlag");
            return (Criteria) this;
        }

        public Criteria andCmdFlagNotBetween(Short value1, Short value2) {
            addCriterion("CMD_FLAG not between", value1, value2, "cmdFlag");
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

        public Criteria andCmdStatusIsNull() {
            addCriterion("CMD_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andCmdStatusIsNotNull() {
            addCriterion("CMD_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andCmdStatusEqualTo(Short value) {
            addCriterion("CMD_STATUS =", value, "cmdStatus");
            return (Criteria) this;
        }

        public Criteria andCmdStatusNotEqualTo(Short value) {
            addCriterion("CMD_STATUS <>", value, "cmdStatus");
            return (Criteria) this;
        }

        public Criteria andCmdStatusGreaterThan(Short value) {
            addCriterion("CMD_STATUS >", value, "cmdStatus");
            return (Criteria) this;
        }

        public Criteria andCmdStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("CMD_STATUS >=", value, "cmdStatus");
            return (Criteria) this;
        }

        public Criteria andCmdStatusLessThan(Short value) {
            addCriterion("CMD_STATUS <", value, "cmdStatus");
            return (Criteria) this;
        }

        public Criteria andCmdStatusLessThanOrEqualTo(Short value) {
            addCriterion("CMD_STATUS <=", value, "cmdStatus");
            return (Criteria) this;
        }

        public Criteria andCmdStatusIn(List<Short> values) {
            addCriterion("CMD_STATUS in", values, "cmdStatus");
            return (Criteria) this;
        }

        public Criteria andCmdStatusNotIn(List<Short> values) {
            addCriterion("CMD_STATUS not in", values, "cmdStatus");
            return (Criteria) this;
        }

        public Criteria andCmdStatusBetween(Short value1, Short value2) {
            addCriterion("CMD_STATUS between", value1, value2, "cmdStatus");
            return (Criteria) this;
        }

        public Criteria andCmdStatusNotBetween(Short value1, Short value2) {
            addCriterion("CMD_STATUS not between", value1, value2, "cmdStatus");
            return (Criteria) this;
        }

        public Criteria andLockAddrIsNull() {
            addCriterion("LOCK_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andLockAddrIsNotNull() {
            addCriterion("LOCK_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andLockAddrEqualTo(String value) {
            addCriterion("LOCK_ADDR =", value, "lockAddr");
            return (Criteria) this;
        }

        public Criteria andLockAddrNotEqualTo(String value) {
            addCriterion("LOCK_ADDR <>", value, "lockAddr");
            return (Criteria) this;
        }

        public Criteria andLockAddrGreaterThan(String value) {
            addCriterion("LOCK_ADDR >", value, "lockAddr");
            return (Criteria) this;
        }

        public Criteria andLockAddrGreaterThanOrEqualTo(String value) {
            addCriterion("LOCK_ADDR >=", value, "lockAddr");
            return (Criteria) this;
        }

        public Criteria andLockAddrLessThan(String value) {
            addCriterion("LOCK_ADDR <", value, "lockAddr");
            return (Criteria) this;
        }

        public Criteria andLockAddrLessThanOrEqualTo(String value) {
            addCriterion("LOCK_ADDR <=", value, "lockAddr");
            return (Criteria) this;
        }

        public Criteria andLockAddrLike(String value) {
            addCriterion("LOCK_ADDR like", value, "lockAddr");
            return (Criteria) this;
        }

        public Criteria andLockAddrNotLike(String value) {
            addCriterion("LOCK_ADDR not like", value, "lockAddr");
            return (Criteria) this;
        }

        public Criteria andLockAddrIn(List<String> values) {
            addCriterion("LOCK_ADDR in", values, "lockAddr");
            return (Criteria) this;
        }

        public Criteria andLockAddrNotIn(List<String> values) {
            addCriterion("LOCK_ADDR not in", values, "lockAddr");
            return (Criteria) this;
        }

        public Criteria andLockAddrBetween(String value1, String value2) {
            addCriterion("LOCK_ADDR between", value1, value2, "lockAddr");
            return (Criteria) this;
        }

        public Criteria andLockAddrNotBetween(String value1, String value2) {
            addCriterion("LOCK_ADDR not between", value1, value2, "lockAddr");
            return (Criteria) this;
        }

        public Criteria andTimeDownloadIsNull() {
            addCriterion("TIME_DOWNLOAD is null");
            return (Criteria) this;
        }

        public Criteria andTimeDownloadIsNotNull() {
            addCriterion("TIME_DOWNLOAD is not null");
            return (Criteria) this;
        }

        public Criteria andTimeDownloadEqualTo(String value) {
            addCriterion("TIME_DOWNLOAD =", value, "timeDownload");
            return (Criteria) this;
        }

        public Criteria andTimeDownloadNotEqualTo(String value) {
            addCriterion("TIME_DOWNLOAD <>", value, "timeDownload");
            return (Criteria) this;
        }

        public Criteria andTimeDownloadGreaterThan(String value) {
            addCriterion("TIME_DOWNLOAD >", value, "timeDownload");
            return (Criteria) this;
        }

        public Criteria andTimeDownloadGreaterThanOrEqualTo(String value) {
            addCriterion("TIME_DOWNLOAD >=", value, "timeDownload");
            return (Criteria) this;
        }

        public Criteria andTimeDownloadLessThan(String value) {
            addCriterion("TIME_DOWNLOAD <", value, "timeDownload");
            return (Criteria) this;
        }

        public Criteria andTimeDownloadLessThanOrEqualTo(String value) {
            addCriterion("TIME_DOWNLOAD <=", value, "timeDownload");
            return (Criteria) this;
        }

        public Criteria andTimeDownloadLike(String value) {
            addCriterion("TIME_DOWNLOAD like", value, "timeDownload");
            return (Criteria) this;
        }

        public Criteria andTimeDownloadNotLike(String value) {
            addCriterion("TIME_DOWNLOAD not like", value, "timeDownload");
            return (Criteria) this;
        }

        public Criteria andTimeDownloadIn(List<String> values) {
            addCriterion("TIME_DOWNLOAD in", values, "timeDownload");
            return (Criteria) this;
        }

        public Criteria andTimeDownloadNotIn(List<String> values) {
            addCriterion("TIME_DOWNLOAD not in", values, "timeDownload");
            return (Criteria) this;
        }

        public Criteria andTimeDownloadBetween(String value1, String value2) {
            addCriterion("TIME_DOWNLOAD between", value1, value2, "timeDownload");
            return (Criteria) this;
        }

        public Criteria andTimeDownloadNotBetween(String value1, String value2) {
            addCriterion("TIME_DOWNLOAD not between", value1, value2, "timeDownload");
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

        public Criteria andRtnIsNull() {
            addCriterion("RTN is null");
            return (Criteria) this;
        }

        public Criteria andRtnIsNotNull() {
            addCriterion("RTN is not null");
            return (Criteria) this;
        }

        public Criteria andRtnEqualTo(String value) {
            addCriterion("RTN =", value, "rtn");
            return (Criteria) this;
        }

        public Criteria andRtnNotEqualTo(String value) {
            addCriterion("RTN <>", value, "rtn");
            return (Criteria) this;
        }

        public Criteria andRtnGreaterThan(String value) {
            addCriterion("RTN >", value, "rtn");
            return (Criteria) this;
        }

        public Criteria andRtnGreaterThanOrEqualTo(String value) {
            addCriterion("RTN >=", value, "rtn");
            return (Criteria) this;
        }

        public Criteria andRtnLessThan(String value) {
            addCriterion("RTN <", value, "rtn");
            return (Criteria) this;
        }

        public Criteria andRtnLessThanOrEqualTo(String value) {
            addCriterion("RTN <=", value, "rtn");
            return (Criteria) this;
        }

        public Criteria andRtnLike(String value) {
            addCriterion("RTN like", value, "rtn");
            return (Criteria) this;
        }

        public Criteria andRtnNotLike(String value) {
            addCriterion("RTN not like", value, "rtn");
            return (Criteria) this;
        }

        public Criteria andRtnIn(List<String> values) {
            addCriterion("RTN in", values, "rtn");
            return (Criteria) this;
        }

        public Criteria andRtnNotIn(List<String> values) {
            addCriterion("RTN not in", values, "rtn");
            return (Criteria) this;
        }

        public Criteria andRtnBetween(String value1, String value2) {
            addCriterion("RTN between", value1, value2, "rtn");
            return (Criteria) this;
        }

        public Criteria andRtnNotBetween(String value1, String value2) {
            addCriterion("RTN not between", value1, value2, "rtn");
            return (Criteria) this;
        }

        public Criteria andLockUserSeqIsNull() {
            addCriterion("LOCK_USER_SEQ is null");
            return (Criteria) this;
        }

        public Criteria andLockUserSeqIsNotNull() {
            addCriterion("LOCK_USER_SEQ is not null");
            return (Criteria) this;
        }

        public Criteria andLockUserSeqEqualTo(String value) {
            addCriterion("LOCK_USER_SEQ =", value, "lockUserSeq");
            return (Criteria) this;
        }

        public Criteria andLockUserSeqNotEqualTo(String value) {
            addCriterion("LOCK_USER_SEQ <>", value, "lockUserSeq");
            return (Criteria) this;
        }

        public Criteria andLockUserSeqGreaterThan(String value) {
            addCriterion("LOCK_USER_SEQ >", value, "lockUserSeq");
            return (Criteria) this;
        }

        public Criteria andLockUserSeqGreaterThanOrEqualTo(String value) {
            addCriterion("LOCK_USER_SEQ >=", value, "lockUserSeq");
            return (Criteria) this;
        }

        public Criteria andLockUserSeqLessThan(String value) {
            addCriterion("LOCK_USER_SEQ <", value, "lockUserSeq");
            return (Criteria) this;
        }

        public Criteria andLockUserSeqLessThanOrEqualTo(String value) {
            addCriterion("LOCK_USER_SEQ <=", value, "lockUserSeq");
            return (Criteria) this;
        }

        public Criteria andLockUserSeqLike(String value) {
            addCriterion("LOCK_USER_SEQ like", value, "lockUserSeq");
            return (Criteria) this;
        }

        public Criteria andLockUserSeqNotLike(String value) {
            addCriterion("LOCK_USER_SEQ not like", value, "lockUserSeq");
            return (Criteria) this;
        }

        public Criteria andLockUserSeqIn(List<String> values) {
            addCriterion("LOCK_USER_SEQ in", values, "lockUserSeq");
            return (Criteria) this;
        }

        public Criteria andLockUserSeqNotIn(List<String> values) {
            addCriterion("LOCK_USER_SEQ not in", values, "lockUserSeq");
            return (Criteria) this;
        }

        public Criteria andLockUserSeqBetween(String value1, String value2) {
            addCriterion("LOCK_USER_SEQ between", value1, value2, "lockUserSeq");
            return (Criteria) this;
        }

        public Criteria andLockUserSeqNotBetween(String value1, String value2) {
            addCriterion("LOCK_USER_SEQ not between", value1, value2, "lockUserSeq");
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