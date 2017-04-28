package com.haibei.pojo.lock;

import java.util.ArrayList;
import java.util.List;

public class LockUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int rowsPerPage = -1;

    public LockUserExample() {
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

        public Criteria andOpenTypeIsNull() {
            addCriterion("OPEN_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andOpenTypeIsNotNull() {
            addCriterion("OPEN_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOpenTypeEqualTo(Short value) {
            addCriterion("OPEN_TYPE =", value, "openType");
            return (Criteria) this;
        }

        public Criteria andOpenTypeNotEqualTo(Short value) {
            addCriterion("OPEN_TYPE <>", value, "openType");
            return (Criteria) this;
        }

        public Criteria andOpenTypeGreaterThan(Short value) {
            addCriterion("OPEN_TYPE >", value, "openType");
            return (Criteria) this;
        }

        public Criteria andOpenTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("OPEN_TYPE >=", value, "openType");
            return (Criteria) this;
        }

        public Criteria andOpenTypeLessThan(Short value) {
            addCriterion("OPEN_TYPE <", value, "openType");
            return (Criteria) this;
        }

        public Criteria andOpenTypeLessThanOrEqualTo(Short value) {
            addCriterion("OPEN_TYPE <=", value, "openType");
            return (Criteria) this;
        }

        public Criteria andOpenTypeIn(List<Short> values) {
            addCriterion("OPEN_TYPE in", values, "openType");
            return (Criteria) this;
        }

        public Criteria andOpenTypeNotIn(List<Short> values) {
            addCriterion("OPEN_TYPE not in", values, "openType");
            return (Criteria) this;
        }

        public Criteria andOpenTypeBetween(Short value1, Short value2) {
            addCriterion("OPEN_TYPE between", value1, value2, "openType");
            return (Criteria) this;
        }

        public Criteria andOpenTypeNotBetween(Short value1, Short value2) {
            addCriterion("OPEN_TYPE not between", value1, value2, "openType");
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

        public Criteria andLockUserAddrIsNull() {
            addCriterion("LOCK_USER_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andLockUserAddrIsNotNull() {
            addCriterion("LOCK_USER_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andLockUserAddrEqualTo(Short value) {
            addCriterion("LOCK_USER_ADDR =", value, "lockUserAddr");
            return (Criteria) this;
        }

        public Criteria andLockUserAddrNotEqualTo(Short value) {
            addCriterion("LOCK_USER_ADDR <>", value, "lockUserAddr");
            return (Criteria) this;
        }

        public Criteria andLockUserAddrGreaterThan(Short value) {
            addCriterion("LOCK_USER_ADDR >", value, "lockUserAddr");
            return (Criteria) this;
        }

        public Criteria andLockUserAddrGreaterThanOrEqualTo(Short value) {
            addCriterion("LOCK_USER_ADDR >=", value, "lockUserAddr");
            return (Criteria) this;
        }

        public Criteria andLockUserAddrLessThan(Short value) {
            addCriterion("LOCK_USER_ADDR <", value, "lockUserAddr");
            return (Criteria) this;
        }

        public Criteria andLockUserAddrLessThanOrEqualTo(Short value) {
            addCriterion("LOCK_USER_ADDR <=", value, "lockUserAddr");
            return (Criteria) this;
        }

        public Criteria andLockUserAddrIn(List<Short> values) {
            addCriterion("LOCK_USER_ADDR in", values, "lockUserAddr");
            return (Criteria) this;
        }

        public Criteria andLockUserAddrNotIn(List<Short> values) {
            addCriterion("LOCK_USER_ADDR not in", values, "lockUserAddr");
            return (Criteria) this;
        }

        public Criteria andLockUserAddrBetween(Short value1, Short value2) {
            addCriterion("LOCK_USER_ADDR between", value1, value2, "lockUserAddr");
            return (Criteria) this;
        }

        public Criteria andLockUserAddrNotBetween(Short value1, Short value2) {
            addCriterion("LOCK_USER_ADDR not between", value1, value2, "lockUserAddr");
            return (Criteria) this;
        }

        public Criteria andLockUserStatusIsNull() {
            addCriterion("LOCK_USER_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andLockUserStatusIsNotNull() {
            addCriterion("LOCK_USER_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andLockUserStatusEqualTo(Short value) {
            addCriterion("LOCK_USER_STATUS =", value, "lockUserStatus");
            return (Criteria) this;
        }

        public Criteria andLockUserStatusNotEqualTo(Short value) {
            addCriterion("LOCK_USER_STATUS <>", value, "lockUserStatus");
            return (Criteria) this;
        }

        public Criteria andLockUserStatusGreaterThan(Short value) {
            addCriterion("LOCK_USER_STATUS >", value, "lockUserStatus");
            return (Criteria) this;
        }

        public Criteria andLockUserStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("LOCK_USER_STATUS >=", value, "lockUserStatus");
            return (Criteria) this;
        }

        public Criteria andLockUserStatusLessThan(Short value) {
            addCriterion("LOCK_USER_STATUS <", value, "lockUserStatus");
            return (Criteria) this;
        }

        public Criteria andLockUserStatusLessThanOrEqualTo(Short value) {
            addCriterion("LOCK_USER_STATUS <=", value, "lockUserStatus");
            return (Criteria) this;
        }

        public Criteria andLockUserStatusIn(List<Short> values) {
            addCriterion("LOCK_USER_STATUS in", values, "lockUserStatus");
            return (Criteria) this;
        }

        public Criteria andLockUserStatusNotIn(List<Short> values) {
            addCriterion("LOCK_USER_STATUS not in", values, "lockUserStatus");
            return (Criteria) this;
        }

        public Criteria andLockUserStatusBetween(Short value1, Short value2) {
            addCriterion("LOCK_USER_STATUS between", value1, value2, "lockUserStatus");
            return (Criteria) this;
        }

        public Criteria andLockUserStatusNotBetween(Short value1, Short value2) {
            addCriterion("LOCK_USER_STATUS not between", value1, value2, "lockUserStatus");
            return (Criteria) this;
        }

        public Criteria andLockUserMemoIsNull() {
            addCriterion("LOCK_USER_MEMO is null");
            return (Criteria) this;
        }

        public Criteria andLockUserMemoIsNotNull() {
            addCriterion("LOCK_USER_MEMO is not null");
            return (Criteria) this;
        }

        public Criteria andLockUserMemoEqualTo(String value) {
            addCriterion("LOCK_USER_MEMO =", value, "lockUserMemo");
            return (Criteria) this;
        }

        public Criteria andLockUserMemoNotEqualTo(String value) {
            addCriterion("LOCK_USER_MEMO <>", value, "lockUserMemo");
            return (Criteria) this;
        }

        public Criteria andLockUserMemoGreaterThan(String value) {
            addCriterion("LOCK_USER_MEMO >", value, "lockUserMemo");
            return (Criteria) this;
        }

        public Criteria andLockUserMemoGreaterThanOrEqualTo(String value) {
            addCriterion("LOCK_USER_MEMO >=", value, "lockUserMemo");
            return (Criteria) this;
        }

        public Criteria andLockUserMemoLessThan(String value) {
            addCriterion("LOCK_USER_MEMO <", value, "lockUserMemo");
            return (Criteria) this;
        }

        public Criteria andLockUserMemoLessThanOrEqualTo(String value) {
            addCriterion("LOCK_USER_MEMO <=", value, "lockUserMemo");
            return (Criteria) this;
        }

        public Criteria andLockUserMemoLike(String value) {
            addCriterion("LOCK_USER_MEMO like", value, "lockUserMemo");
            return (Criteria) this;
        }

        public Criteria andLockUserMemoNotLike(String value) {
            addCriterion("LOCK_USER_MEMO not like", value, "lockUserMemo");
            return (Criteria) this;
        }

        public Criteria andLockUserMemoIn(List<String> values) {
            addCriterion("LOCK_USER_MEMO in", values, "lockUserMemo");
            return (Criteria) this;
        }

        public Criteria andLockUserMemoNotIn(List<String> values) {
            addCriterion("LOCK_USER_MEMO not in", values, "lockUserMemo");
            return (Criteria) this;
        }

        public Criteria andLockUserMemoBetween(String value1, String value2) {
            addCriterion("LOCK_USER_MEMO between", value1, value2, "lockUserMemo");
            return (Criteria) this;
        }

        public Criteria andLockUserMemoNotBetween(String value1, String value2) {
            addCriterion("LOCK_USER_MEMO not between", value1, value2, "lockUserMemo");
            return (Criteria) this;
        }

        public Criteria andLastUpdateIsNull() {
            addCriterion("LAST_UPDATE is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateIsNotNull() {
            addCriterion("LAST_UPDATE is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateEqualTo(String value) {
            addCriterion("LAST_UPDATE =", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateNotEqualTo(String value) {
            addCriterion("LAST_UPDATE <>", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateGreaterThan(String value) {
            addCriterion("LAST_UPDATE >", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_UPDATE >=", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateLessThan(String value) {
            addCriterion("LAST_UPDATE <", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateLessThanOrEqualTo(String value) {
            addCriterion("LAST_UPDATE <=", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateLike(String value) {
            addCriterion("LAST_UPDATE like", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateNotLike(String value) {
            addCriterion("LAST_UPDATE not like", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateIn(List<String> values) {
            addCriterion("LAST_UPDATE in", values, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateNotIn(List<String> values) {
            addCriterion("LAST_UPDATE not in", values, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateBetween(String value1, String value2) {
            addCriterion("LAST_UPDATE between", value1, value2, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateNotBetween(String value1, String value2) {
            addCriterion("LAST_UPDATE not between", value1, value2, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andValidFromIsNull() {
            addCriterion("VALID_FROM is null");
            return (Criteria) this;
        }

        public Criteria andValidFromIsNotNull() {
            addCriterion("VALID_FROM is not null");
            return (Criteria) this;
        }

        public Criteria andValidFromEqualTo(String value) {
            addCriterion("VALID_FROM =", value, "validFrom");
            return (Criteria) this;
        }

        public Criteria andValidFromNotEqualTo(String value) {
            addCriterion("VALID_FROM <>", value, "validFrom");
            return (Criteria) this;
        }

        public Criteria andValidFromGreaterThan(String value) {
            addCriterion("VALID_FROM >", value, "validFrom");
            return (Criteria) this;
        }

        public Criteria andValidFromGreaterThanOrEqualTo(String value) {
            addCriterion("VALID_FROM >=", value, "validFrom");
            return (Criteria) this;
        }

        public Criteria andValidFromLessThan(String value) {
            addCriterion("VALID_FROM <", value, "validFrom");
            return (Criteria) this;
        }

        public Criteria andValidFromLessThanOrEqualTo(String value) {
            addCriterion("VALID_FROM <=", value, "validFrom");
            return (Criteria) this;
        }

        public Criteria andValidFromLike(String value) {
            addCriterion("VALID_FROM like", value, "validFrom");
            return (Criteria) this;
        }

        public Criteria andValidFromNotLike(String value) {
            addCriterion("VALID_FROM not like", value, "validFrom");
            return (Criteria) this;
        }

        public Criteria andValidFromIn(List<String> values) {
            addCriterion("VALID_FROM in", values, "validFrom");
            return (Criteria) this;
        }

        public Criteria andValidFromNotIn(List<String> values) {
            addCriterion("VALID_FROM not in", values, "validFrom");
            return (Criteria) this;
        }

        public Criteria andValidFromBetween(String value1, String value2) {
            addCriterion("VALID_FROM between", value1, value2, "validFrom");
            return (Criteria) this;
        }

        public Criteria andValidFromNotBetween(String value1, String value2) {
            addCriterion("VALID_FROM not between", value1, value2, "validFrom");
            return (Criteria) this;
        }

        public Criteria andValidToIsNull() {
            addCriterion("VALID_TO is null");
            return (Criteria) this;
        }

        public Criteria andValidToIsNotNull() {
            addCriterion("VALID_TO is not null");
            return (Criteria) this;
        }

        public Criteria andValidToEqualTo(String value) {
            addCriterion("VALID_TO =", value, "validTo");
            return (Criteria) this;
        }

        public Criteria andValidToNotEqualTo(String value) {
            addCriterion("VALID_TO <>", value, "validTo");
            return (Criteria) this;
        }

        public Criteria andValidToGreaterThan(String value) {
            addCriterion("VALID_TO >", value, "validTo");
            return (Criteria) this;
        }

        public Criteria andValidToGreaterThanOrEqualTo(String value) {
            addCriterion("VALID_TO >=", value, "validTo");
            return (Criteria) this;
        }

        public Criteria andValidToLessThan(String value) {
            addCriterion("VALID_TO <", value, "validTo");
            return (Criteria) this;
        }

        public Criteria andValidToLessThanOrEqualTo(String value) {
            addCriterion("VALID_TO <=", value, "validTo");
            return (Criteria) this;
        }

        public Criteria andValidToLike(String value) {
            addCriterion("VALID_TO like", value, "validTo");
            return (Criteria) this;
        }

        public Criteria andValidToNotLike(String value) {
            addCriterion("VALID_TO not like", value, "validTo");
            return (Criteria) this;
        }

        public Criteria andValidToIn(List<String> values) {
            addCriterion("VALID_TO in", values, "validTo");
            return (Criteria) this;
        }

        public Criteria andValidToNotIn(List<String> values) {
            addCriterion("VALID_TO not in", values, "validTo");
            return (Criteria) this;
        }

        public Criteria andValidToBetween(String value1, String value2) {
            addCriterion("VALID_TO between", value1, value2, "validTo");
            return (Criteria) this;
        }

        public Criteria andValidToNotBetween(String value1, String value2) {
            addCriterion("VALID_TO not between", value1, value2, "validTo");
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