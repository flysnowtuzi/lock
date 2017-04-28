package com.haibei.pojo.lock;

import java.util.ArrayList;
import java.util.List;

public class LockExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int rowsPerPage = -1;

    public LockExample() {
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

        public Criteria andDoorIdIsNull() {
            addCriterion("DOOR_ID is null");
            return (Criteria) this;
        }

        public Criteria andDoorIdIsNotNull() {
            addCriterion("DOOR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDoorIdEqualTo(String value) {
            addCriterion("DOOR_ID =", value, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdNotEqualTo(String value) {
            addCriterion("DOOR_ID <>", value, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdGreaterThan(String value) {
            addCriterion("DOOR_ID >", value, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdGreaterThanOrEqualTo(String value) {
            addCriterion("DOOR_ID >=", value, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdLessThan(String value) {
            addCriterion("DOOR_ID <", value, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdLessThanOrEqualTo(String value) {
            addCriterion("DOOR_ID <=", value, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdLike(String value) {
            addCriterion("DOOR_ID like", value, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdNotLike(String value) {
            addCriterion("DOOR_ID not like", value, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdIn(List<String> values) {
            addCriterion("DOOR_ID in", values, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdNotIn(List<String> values) {
            addCriterion("DOOR_ID not in", values, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdBetween(String value1, String value2) {
            addCriterion("DOOR_ID between", value1, value2, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdNotBetween(String value1, String value2) {
            addCriterion("DOOR_ID not between", value1, value2, "doorId");
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

        public Criteria andFloorIdIsNull() {
            addCriterion("FLOOR_ID is null");
            return (Criteria) this;
        }

        public Criteria andFloorIdIsNotNull() {
            addCriterion("FLOOR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFloorIdEqualTo(String value) {
            addCriterion("FLOOR_ID =", value, "floorId");
            return (Criteria) this;
        }

        public Criteria andFloorIdNotEqualTo(String value) {
            addCriterion("FLOOR_ID <>", value, "floorId");
            return (Criteria) this;
        }

        public Criteria andFloorIdGreaterThan(String value) {
            addCriterion("FLOOR_ID >", value, "floorId");
            return (Criteria) this;
        }

        public Criteria andFloorIdGreaterThanOrEqualTo(String value) {
            addCriterion("FLOOR_ID >=", value, "floorId");
            return (Criteria) this;
        }

        public Criteria andFloorIdLessThan(String value) {
            addCriterion("FLOOR_ID <", value, "floorId");
            return (Criteria) this;
        }

        public Criteria andFloorIdLessThanOrEqualTo(String value) {
            addCriterion("FLOOR_ID <=", value, "floorId");
            return (Criteria) this;
        }

        public Criteria andFloorIdLike(String value) {
            addCriterion("FLOOR_ID like", value, "floorId");
            return (Criteria) this;
        }

        public Criteria andFloorIdNotLike(String value) {
            addCriterion("FLOOR_ID not like", value, "floorId");
            return (Criteria) this;
        }

        public Criteria andFloorIdIn(List<String> values) {
            addCriterion("FLOOR_ID in", values, "floorId");
            return (Criteria) this;
        }

        public Criteria andFloorIdNotIn(List<String> values) {
            addCriterion("FLOOR_ID not in", values, "floorId");
            return (Criteria) this;
        }

        public Criteria andFloorIdBetween(String value1, String value2) {
            addCriterion("FLOOR_ID between", value1, value2, "floorId");
            return (Criteria) this;
        }

        public Criteria andFloorIdNotBetween(String value1, String value2) {
            addCriterion("FLOOR_ID not between", value1, value2, "floorId");
            return (Criteria) this;
        }

        public Criteria andLockFlagIsNull() {
            addCriterion("LOCK_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andLockFlagIsNotNull() {
            addCriterion("LOCK_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andLockFlagEqualTo(Short value) {
            addCriterion("LOCK_FLAG =", value, "lockFlag");
            return (Criteria) this;
        }

        public Criteria andLockFlagNotEqualTo(Short value) {
            addCriterion("LOCK_FLAG <>", value, "lockFlag");
            return (Criteria) this;
        }

        public Criteria andLockFlagGreaterThan(Short value) {
            addCriterion("LOCK_FLAG >", value, "lockFlag");
            return (Criteria) this;
        }

        public Criteria andLockFlagGreaterThanOrEqualTo(Short value) {
            addCriterion("LOCK_FLAG >=", value, "lockFlag");
            return (Criteria) this;
        }

        public Criteria andLockFlagLessThan(Short value) {
            addCriterion("LOCK_FLAG <", value, "lockFlag");
            return (Criteria) this;
        }

        public Criteria andLockFlagLessThanOrEqualTo(Short value) {
            addCriterion("LOCK_FLAG <=", value, "lockFlag");
            return (Criteria) this;
        }

        public Criteria andLockFlagIn(List<Short> values) {
            addCriterion("LOCK_FLAG in", values, "lockFlag");
            return (Criteria) this;
        }

        public Criteria andLockFlagNotIn(List<Short> values) {
            addCriterion("LOCK_FLAG not in", values, "lockFlag");
            return (Criteria) this;
        }

        public Criteria andLockFlagBetween(Short value1, Short value2) {
            addCriterion("LOCK_FLAG between", value1, value2, "lockFlag");
            return (Criteria) this;
        }

        public Criteria andLockFlagNotBetween(Short value1, Short value2) {
            addCriterion("LOCK_FLAG not between", value1, value2, "lockFlag");
            return (Criteria) this;
        }

        public Criteria andLockMemoIsNull() {
            addCriterion("LOCK_MEMO is null");
            return (Criteria) this;
        }

        public Criteria andLockMemoIsNotNull() {
            addCriterion("LOCK_MEMO is not null");
            return (Criteria) this;
        }

        public Criteria andLockMemoEqualTo(String value) {
            addCriterion("LOCK_MEMO =", value, "lockMemo");
            return (Criteria) this;
        }

        public Criteria andLockMemoNotEqualTo(String value) {
            addCriterion("LOCK_MEMO <>", value, "lockMemo");
            return (Criteria) this;
        }

        public Criteria andLockMemoGreaterThan(String value) {
            addCriterion("LOCK_MEMO >", value, "lockMemo");
            return (Criteria) this;
        }

        public Criteria andLockMemoGreaterThanOrEqualTo(String value) {
            addCriterion("LOCK_MEMO >=", value, "lockMemo");
            return (Criteria) this;
        }

        public Criteria andLockMemoLessThan(String value) {
            addCriterion("LOCK_MEMO <", value, "lockMemo");
            return (Criteria) this;
        }

        public Criteria andLockMemoLessThanOrEqualTo(String value) {
            addCriterion("LOCK_MEMO <=", value, "lockMemo");
            return (Criteria) this;
        }

        public Criteria andLockMemoLike(String value) {
            addCriterion("LOCK_MEMO like", value, "lockMemo");
            return (Criteria) this;
        }

        public Criteria andLockMemoNotLike(String value) {
            addCriterion("LOCK_MEMO not like", value, "lockMemo");
            return (Criteria) this;
        }

        public Criteria andLockMemoIn(List<String> values) {
            addCriterion("LOCK_MEMO in", values, "lockMemo");
            return (Criteria) this;
        }

        public Criteria andLockMemoNotIn(List<String> values) {
            addCriterion("LOCK_MEMO not in", values, "lockMemo");
            return (Criteria) this;
        }

        public Criteria andLockMemoBetween(String value1, String value2) {
            addCriterion("LOCK_MEMO between", value1, value2, "lockMemo");
            return (Criteria) this;
        }

        public Criteria andLockMemoNotBetween(String value1, String value2) {
            addCriterion("LOCK_MEMO not between", value1, value2, "lockMemo");
            return (Criteria) this;
        }

        public Criteria andLockStatusIsNull() {
            addCriterion("LOCK_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andLockStatusIsNotNull() {
            addCriterion("LOCK_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andLockStatusEqualTo(Short value) {
            addCriterion("LOCK_STATUS =", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusNotEqualTo(Short value) {
            addCriterion("LOCK_STATUS <>", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusGreaterThan(Short value) {
            addCriterion("LOCK_STATUS >", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("LOCK_STATUS >=", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusLessThan(Short value) {
            addCriterion("LOCK_STATUS <", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusLessThanOrEqualTo(Short value) {
            addCriterion("LOCK_STATUS <=", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusIn(List<Short> values) {
            addCriterion("LOCK_STATUS in", values, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusNotIn(List<Short> values) {
            addCriterion("LOCK_STATUS not in", values, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusBetween(Short value1, Short value2) {
            addCriterion("LOCK_STATUS between", value1, value2, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusNotBetween(Short value1, Short value2) {
            addCriterion("LOCK_STATUS not between", value1, value2, "lockStatus");
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

        public Criteria andWaterNoIsNull() {
            addCriterion("WATER_NO is null");
            return (Criteria) this;
        }

        public Criteria andWaterNoIsNotNull() {
            addCriterion("WATER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andWaterNoEqualTo(String value) {
            addCriterion("WATER_NO =", value, "waterNo");
            return (Criteria) this;
        }

        public Criteria andWaterNoNotEqualTo(String value) {
            addCriterion("WATER_NO <>", value, "waterNo");
            return (Criteria) this;
        }

        public Criteria andWaterNoGreaterThan(String value) {
            addCriterion("WATER_NO >", value, "waterNo");
            return (Criteria) this;
        }

        public Criteria andWaterNoGreaterThanOrEqualTo(String value) {
            addCriterion("WATER_NO >=", value, "waterNo");
            return (Criteria) this;
        }

        public Criteria andWaterNoLessThan(String value) {
            addCriterion("WATER_NO <", value, "waterNo");
            return (Criteria) this;
        }

        public Criteria andWaterNoLessThanOrEqualTo(String value) {
            addCriterion("WATER_NO <=", value, "waterNo");
            return (Criteria) this;
        }

        public Criteria andWaterNoLike(String value) {
            addCriterion("WATER_NO like", value, "waterNo");
            return (Criteria) this;
        }

        public Criteria andWaterNoNotLike(String value) {
            addCriterion("WATER_NO not like", value, "waterNo");
            return (Criteria) this;
        }

        public Criteria andWaterNoIn(List<String> values) {
            addCriterion("WATER_NO in", values, "waterNo");
            return (Criteria) this;
        }

        public Criteria andWaterNoNotIn(List<String> values) {
            addCriterion("WATER_NO not in", values, "waterNo");
            return (Criteria) this;
        }

        public Criteria andWaterNoBetween(String value1, String value2) {
            addCriterion("WATER_NO between", value1, value2, "waterNo");
            return (Criteria) this;
        }

        public Criteria andWaterNoNotBetween(String value1, String value2) {
            addCriterion("WATER_NO not between", value1, value2, "waterNo");
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