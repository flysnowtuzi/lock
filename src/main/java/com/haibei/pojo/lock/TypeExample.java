package com.haibei.pojo.lock;

import java.util.ArrayList;
import java.util.List;

public class TypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int rowsPerPage = -1;

    public TypeExample() {
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

        public Criteria andTypeNameIsNull() {
            addCriterion("TYPE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNotNull() {
            addCriterion("TYPE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTypeNameEqualTo(String value) {
            addCriterion("TYPE_NAME =", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotEqualTo(String value) {
            addCriterion("TYPE_NAME <>", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThan(String value) {
            addCriterion("TYPE_NAME >", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE_NAME >=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThan(String value) {
            addCriterion("TYPE_NAME <", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThanOrEqualTo(String value) {
            addCriterion("TYPE_NAME <=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLike(String value) {
            addCriterion("TYPE_NAME like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotLike(String value) {
            addCriterion("TYPE_NAME not like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameIn(List<String> values) {
            addCriterion("TYPE_NAME in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotIn(List<String> values) {
            addCriterion("TYPE_NAME not in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameBetween(String value1, String value2) {
            addCriterion("TYPE_NAME between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotBetween(String value1, String value2) {
            addCriterion("TYPE_NAME not between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andDevCrcIsNull() {
            addCriterion("DEV_CRC is null");
            return (Criteria) this;
        }

        public Criteria andDevCrcIsNotNull() {
            addCriterion("DEV_CRC is not null");
            return (Criteria) this;
        }

        public Criteria andDevCrcEqualTo(Short value) {
            addCriterion("DEV_CRC =", value, "devCrc");
            return (Criteria) this;
        }

        public Criteria andDevCrcNotEqualTo(Short value) {
            addCriterion("DEV_CRC <>", value, "devCrc");
            return (Criteria) this;
        }

        public Criteria andDevCrcGreaterThan(Short value) {
            addCriterion("DEV_CRC >", value, "devCrc");
            return (Criteria) this;
        }

        public Criteria andDevCrcGreaterThanOrEqualTo(Short value) {
            addCriterion("DEV_CRC >=", value, "devCrc");
            return (Criteria) this;
        }

        public Criteria andDevCrcLessThan(Short value) {
            addCriterion("DEV_CRC <", value, "devCrc");
            return (Criteria) this;
        }

        public Criteria andDevCrcLessThanOrEqualTo(Short value) {
            addCriterion("DEV_CRC <=", value, "devCrc");
            return (Criteria) this;
        }

        public Criteria andDevCrcIn(List<Short> values) {
            addCriterion("DEV_CRC in", values, "devCrc");
            return (Criteria) this;
        }

        public Criteria andDevCrcNotIn(List<Short> values) {
            addCriterion("DEV_CRC not in", values, "devCrc");
            return (Criteria) this;
        }

        public Criteria andDevCrcBetween(Short value1, Short value2) {
            addCriterion("DEV_CRC between", value1, value2, "devCrc");
            return (Criteria) this;
        }

        public Criteria andDevCrcNotBetween(Short value1, Short value2) {
            addCriterion("DEV_CRC not between", value1, value2, "devCrc");
            return (Criteria) this;
        }

        public Criteria andDevEncryptIsNull() {
            addCriterion("DEV_ENCRYPT is null");
            return (Criteria) this;
        }

        public Criteria andDevEncryptIsNotNull() {
            addCriterion("DEV_ENCRYPT is not null");
            return (Criteria) this;
        }

        public Criteria andDevEncryptEqualTo(Short value) {
            addCriterion("DEV_ENCRYPT =", value, "devEncrypt");
            return (Criteria) this;
        }

        public Criteria andDevEncryptNotEqualTo(Short value) {
            addCriterion("DEV_ENCRYPT <>", value, "devEncrypt");
            return (Criteria) this;
        }

        public Criteria andDevEncryptGreaterThan(Short value) {
            addCriterion("DEV_ENCRYPT >", value, "devEncrypt");
            return (Criteria) this;
        }

        public Criteria andDevEncryptGreaterThanOrEqualTo(Short value) {
            addCriterion("DEV_ENCRYPT >=", value, "devEncrypt");
            return (Criteria) this;
        }

        public Criteria andDevEncryptLessThan(Short value) {
            addCriterion("DEV_ENCRYPT <", value, "devEncrypt");
            return (Criteria) this;
        }

        public Criteria andDevEncryptLessThanOrEqualTo(Short value) {
            addCriterion("DEV_ENCRYPT <=", value, "devEncrypt");
            return (Criteria) this;
        }

        public Criteria andDevEncryptIn(List<Short> values) {
            addCriterion("DEV_ENCRYPT in", values, "devEncrypt");
            return (Criteria) this;
        }

        public Criteria andDevEncryptNotIn(List<Short> values) {
            addCriterion("DEV_ENCRYPT not in", values, "devEncrypt");
            return (Criteria) this;
        }

        public Criteria andDevEncryptBetween(Short value1, Short value2) {
            addCriterion("DEV_ENCRYPT between", value1, value2, "devEncrypt");
            return (Criteria) this;
        }

        public Criteria andDevEncryptNotBetween(Short value1, Short value2) {
            addCriterion("DEV_ENCRYPT not between", value1, value2, "devEncrypt");
            return (Criteria) this;
        }

        public Criteria andDevKeyIsNull() {
            addCriterion("DEV_KEY is null");
            return (Criteria) this;
        }

        public Criteria andDevKeyIsNotNull() {
            addCriterion("DEV_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andDevKeyEqualTo(String value) {
            addCriterion("DEV_KEY =", value, "devKey");
            return (Criteria) this;
        }

        public Criteria andDevKeyNotEqualTo(String value) {
            addCriterion("DEV_KEY <>", value, "devKey");
            return (Criteria) this;
        }

        public Criteria andDevKeyGreaterThan(String value) {
            addCriterion("DEV_KEY >", value, "devKey");
            return (Criteria) this;
        }

        public Criteria andDevKeyGreaterThanOrEqualTo(String value) {
            addCriterion("DEV_KEY >=", value, "devKey");
            return (Criteria) this;
        }

        public Criteria andDevKeyLessThan(String value) {
            addCriterion("DEV_KEY <", value, "devKey");
            return (Criteria) this;
        }

        public Criteria andDevKeyLessThanOrEqualTo(String value) {
            addCriterion("DEV_KEY <=", value, "devKey");
            return (Criteria) this;
        }

        public Criteria andDevKeyLike(String value) {
            addCriterion("DEV_KEY like", value, "devKey");
            return (Criteria) this;
        }

        public Criteria andDevKeyNotLike(String value) {
            addCriterion("DEV_KEY not like", value, "devKey");
            return (Criteria) this;
        }

        public Criteria andDevKeyIn(List<String> values) {
            addCriterion("DEV_KEY in", values, "devKey");
            return (Criteria) this;
        }

        public Criteria andDevKeyNotIn(List<String> values) {
            addCriterion("DEV_KEY not in", values, "devKey");
            return (Criteria) this;
        }

        public Criteria andDevKeyBetween(String value1, String value2) {
            addCriterion("DEV_KEY between", value1, value2, "devKey");
            return (Criteria) this;
        }

        public Criteria andDevKeyNotBetween(String value1, String value2) {
            addCriterion("DEV_KEY not between", value1, value2, "devKey");
            return (Criteria) this;
        }

        public Criteria andDevParsingIsNull() {
            addCriterion("DEV_PARSING is null");
            return (Criteria) this;
        }

        public Criteria andDevParsingIsNotNull() {
            addCriterion("DEV_PARSING is not null");
            return (Criteria) this;
        }

        public Criteria andDevParsingEqualTo(String value) {
            addCriterion("DEV_PARSING =", value, "devParsing");
            return (Criteria) this;
        }

        public Criteria andDevParsingNotEqualTo(String value) {
            addCriterion("DEV_PARSING <>", value, "devParsing");
            return (Criteria) this;
        }

        public Criteria andDevParsingGreaterThan(String value) {
            addCriterion("DEV_PARSING >", value, "devParsing");
            return (Criteria) this;
        }

        public Criteria andDevParsingGreaterThanOrEqualTo(String value) {
            addCriterion("DEV_PARSING >=", value, "devParsing");
            return (Criteria) this;
        }

        public Criteria andDevParsingLessThan(String value) {
            addCriterion("DEV_PARSING <", value, "devParsing");
            return (Criteria) this;
        }

        public Criteria andDevParsingLessThanOrEqualTo(String value) {
            addCriterion("DEV_PARSING <=", value, "devParsing");
            return (Criteria) this;
        }

        public Criteria andDevParsingLike(String value) {
            addCriterion("DEV_PARSING like", value, "devParsing");
            return (Criteria) this;
        }

        public Criteria andDevParsingNotLike(String value) {
            addCriterion("DEV_PARSING not like", value, "devParsing");
            return (Criteria) this;
        }

        public Criteria andDevParsingIn(List<String> values) {
            addCriterion("DEV_PARSING in", values, "devParsing");
            return (Criteria) this;
        }

        public Criteria andDevParsingNotIn(List<String> values) {
            addCriterion("DEV_PARSING not in", values, "devParsing");
            return (Criteria) this;
        }

        public Criteria andDevParsingBetween(String value1, String value2) {
            addCriterion("DEV_PARSING between", value1, value2, "devParsing");
            return (Criteria) this;
        }

        public Criteria andDevParsingNotBetween(String value1, String value2) {
            addCriterion("DEV_PARSING not between", value1, value2, "devParsing");
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