package com.haibei.pojo.lock;

import java.util.ArrayList;
import java.util.List;

public class DeviceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int rowsPerPage = -1;

    public DeviceExample() {
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

        public Criteria andBuildingIdIsNull() {
            addCriterion("BUILDING_ID is null");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIsNotNull() {
            addCriterion("BUILDING_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingIdEqualTo(String value) {
            addCriterion("BUILDING_ID =", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotEqualTo(String value) {
            addCriterion("BUILDING_ID <>", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdGreaterThan(String value) {
            addCriterion("BUILDING_ID >", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdGreaterThanOrEqualTo(String value) {
            addCriterion("BUILDING_ID >=", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLessThan(String value) {
            addCriterion("BUILDING_ID <", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLessThanOrEqualTo(String value) {
            addCriterion("BUILDING_ID <=", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLike(String value) {
            addCriterion("BUILDING_ID like", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotLike(String value) {
            addCriterion("BUILDING_ID not like", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIn(List<String> values) {
            addCriterion("BUILDING_ID in", values, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotIn(List<String> values) {
            addCriterion("BUILDING_ID not in", values, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdBetween(String value1, String value2) {
            addCriterion("BUILDING_ID between", value1, value2, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotBetween(String value1, String value2) {
            addCriterion("BUILDING_ID not between", value1, value2, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingNameIsNull() {
            addCriterion("BUILDING_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBuildingNameIsNotNull() {
            addCriterion("BUILDING_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingNameEqualTo(String value) {
            addCriterion("BUILDING_NAME =", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameNotEqualTo(String value) {
            addCriterion("BUILDING_NAME <>", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameGreaterThan(String value) {
            addCriterion("BUILDING_NAME >", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameGreaterThanOrEqualTo(String value) {
            addCriterion("BUILDING_NAME >=", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameLessThan(String value) {
            addCriterion("BUILDING_NAME <", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameLessThanOrEqualTo(String value) {
            addCriterion("BUILDING_NAME <=", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameLike(String value) {
            addCriterion("BUILDING_NAME like", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameNotLike(String value) {
            addCriterion("BUILDING_NAME not like", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameIn(List<String> values) {
            addCriterion("BUILDING_NAME in", values, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameNotIn(List<String> values) {
            addCriterion("BUILDING_NAME not in", values, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameBetween(String value1, String value2) {
            addCriterion("BUILDING_NAME between", value1, value2, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameNotBetween(String value1, String value2) {
            addCriterion("BUILDING_NAME not between", value1, value2, "buildingName");
            return (Criteria) this;
        }

        public Criteria andDevStatusIsNull() {
            addCriterion("DEV_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andDevStatusIsNotNull() {
            addCriterion("DEV_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andDevStatusEqualTo(Short value) {
            addCriterion("DEV_STATUS =", value, "devStatus");
            return (Criteria) this;
        }

        public Criteria andDevStatusNotEqualTo(Short value) {
            addCriterion("DEV_STATUS <>", value, "devStatus");
            return (Criteria) this;
        }

        public Criteria andDevStatusGreaterThan(Short value) {
            addCriterion("DEV_STATUS >", value, "devStatus");
            return (Criteria) this;
        }

        public Criteria andDevStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("DEV_STATUS >=", value, "devStatus");
            return (Criteria) this;
        }

        public Criteria andDevStatusLessThan(Short value) {
            addCriterion("DEV_STATUS <", value, "devStatus");
            return (Criteria) this;
        }

        public Criteria andDevStatusLessThanOrEqualTo(Short value) {
            addCriterion("DEV_STATUS <=", value, "devStatus");
            return (Criteria) this;
        }

        public Criteria andDevStatusIn(List<Short> values) {
            addCriterion("DEV_STATUS in", values, "devStatus");
            return (Criteria) this;
        }

        public Criteria andDevStatusNotIn(List<Short> values) {
            addCriterion("DEV_STATUS not in", values, "devStatus");
            return (Criteria) this;
        }

        public Criteria andDevStatusBetween(Short value1, Short value2) {
            addCriterion("DEV_STATUS between", value1, value2, "devStatus");
            return (Criteria) this;
        }

        public Criteria andDevStatusNotBetween(Short value1, Short value2) {
            addCriterion("DEV_STATUS not between", value1, value2, "devStatus");
            return (Criteria) this;
        }

        public Criteria andDevMemoIsNull() {
            addCriterion("DEV_MEMO is null");
            return (Criteria) this;
        }

        public Criteria andDevMemoIsNotNull() {
            addCriterion("DEV_MEMO is not null");
            return (Criteria) this;
        }

        public Criteria andDevMemoEqualTo(String value) {
            addCriterion("DEV_MEMO =", value, "devMemo");
            return (Criteria) this;
        }

        public Criteria andDevMemoNotEqualTo(String value) {
            addCriterion("DEV_MEMO <>", value, "devMemo");
            return (Criteria) this;
        }

        public Criteria andDevMemoGreaterThan(String value) {
            addCriterion("DEV_MEMO >", value, "devMemo");
            return (Criteria) this;
        }

        public Criteria andDevMemoGreaterThanOrEqualTo(String value) {
            addCriterion("DEV_MEMO >=", value, "devMemo");
            return (Criteria) this;
        }

        public Criteria andDevMemoLessThan(String value) {
            addCriterion("DEV_MEMO <", value, "devMemo");
            return (Criteria) this;
        }

        public Criteria andDevMemoLessThanOrEqualTo(String value) {
            addCriterion("DEV_MEMO <=", value, "devMemo");
            return (Criteria) this;
        }

        public Criteria andDevMemoLike(String value) {
            addCriterion("DEV_MEMO like", value, "devMemo");
            return (Criteria) this;
        }

        public Criteria andDevMemoNotLike(String value) {
            addCriterion("DEV_MEMO not like", value, "devMemo");
            return (Criteria) this;
        }

        public Criteria andDevMemoIn(List<String> values) {
            addCriterion("DEV_MEMO in", values, "devMemo");
            return (Criteria) this;
        }

        public Criteria andDevMemoNotIn(List<String> values) {
            addCriterion("DEV_MEMO not in", values, "devMemo");
            return (Criteria) this;
        }

        public Criteria andDevMemoBetween(String value1, String value2) {
            addCriterion("DEV_MEMO between", value1, value2, "devMemo");
            return (Criteria) this;
        }

        public Criteria andDevMemoNotBetween(String value1, String value2) {
            addCriterion("DEV_MEMO not between", value1, value2, "devMemo");
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

        public Criteria andDevTypeIsNull() {
            addCriterion("DEV_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andDevTypeIsNotNull() {
            addCriterion("DEV_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andDevTypeEqualTo(Short value) {
            addCriterion("DEV_TYPE =", value, "devType");
            return (Criteria) this;
        }

        public Criteria andDevTypeNotEqualTo(Short value) {
            addCriterion("DEV_TYPE <>", value, "devType");
            return (Criteria) this;
        }

        public Criteria andDevTypeGreaterThan(Short value) {
            addCriterion("DEV_TYPE >", value, "devType");
            return (Criteria) this;
        }

        public Criteria andDevTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("DEV_TYPE >=", value, "devType");
            return (Criteria) this;
        }

        public Criteria andDevTypeLessThan(Short value) {
            addCriterion("DEV_TYPE <", value, "devType");
            return (Criteria) this;
        }

        public Criteria andDevTypeLessThanOrEqualTo(Short value) {
            addCriterion("DEV_TYPE <=", value, "devType");
            return (Criteria) this;
        }

        public Criteria andDevTypeIn(List<Short> values) {
            addCriterion("DEV_TYPE in", values, "devType");
            return (Criteria) this;
        }

        public Criteria andDevTypeNotIn(List<Short> values) {
            addCriterion("DEV_TYPE not in", values, "devType");
            return (Criteria) this;
        }

        public Criteria andDevTypeBetween(Short value1, Short value2) {
            addCriterion("DEV_TYPE between", value1, value2, "devType");
            return (Criteria) this;
        }

        public Criteria andDevTypeNotBetween(Short value1, Short value2) {
            addCriterion("DEV_TYPE not between", value1, value2, "devType");
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