package com.kaicom.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BikeVersionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BikeVersionExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andVendorIdIsNull() {
            addCriterion("vendor_id is null");
            return (Criteria) this;
        }

        public Criteria andVendorIdIsNotNull() {
            addCriterion("vendor_id is not null");
            return (Criteria) this;
        }

        public Criteria andVendorIdEqualTo(String value) {
            addCriterion("vendor_id =", value, "vendorId");
            return (Criteria) this;
        }

        public Criteria andVendorIdNotEqualTo(String value) {
            addCriterion("vendor_id <>", value, "vendorId");
            return (Criteria) this;
        }

        public Criteria andVendorIdGreaterThan(String value) {
            addCriterion("vendor_id >", value, "vendorId");
            return (Criteria) this;
        }

        public Criteria andVendorIdGreaterThanOrEqualTo(String value) {
            addCriterion("vendor_id >=", value, "vendorId");
            return (Criteria) this;
        }

        public Criteria andVendorIdLessThan(String value) {
            addCriterion("vendor_id <", value, "vendorId");
            return (Criteria) this;
        }

        public Criteria andVendorIdLessThanOrEqualTo(String value) {
            addCriterion("vendor_id <=", value, "vendorId");
            return (Criteria) this;
        }

        public Criteria andVendorIdLike(String value) {
            addCriterion("vendor_id like", value, "vendorId");
            return (Criteria) this;
        }

        public Criteria andVendorIdNotLike(String value) {
            addCriterion("vendor_id not like", value, "vendorId");
            return (Criteria) this;
        }

        public Criteria andVendorIdIn(List<String> values) {
            addCriterion("vendor_id in", values, "vendorId");
            return (Criteria) this;
        }

        public Criteria andVendorIdNotIn(List<String> values) {
            addCriterion("vendor_id not in", values, "vendorId");
            return (Criteria) this;
        }

        public Criteria andVendorIdBetween(String value1, String value2) {
            addCriterion("vendor_id between", value1, value2, "vendorId");
            return (Criteria) this;
        }

        public Criteria andVendorIdNotBetween(String value1, String value2) {
            addCriterion("vendor_id not between", value1, value2, "vendorId");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(String value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(String value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(String value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(String value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(String value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(String value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLike(String value) {
            addCriterion("product_id like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotLike(String value) {
            addCriterion("product_id not like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<String> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<String> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(String value1, String value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(String value1, String value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andGsmUrlIsNull() {
            addCriterion("gsm_url is null");
            return (Criteria) this;
        }

        public Criteria andGsmUrlIsNotNull() {
            addCriterion("gsm_url is not null");
            return (Criteria) this;
        }

        public Criteria andGsmUrlEqualTo(String value) {
            addCriterion("gsm_url =", value, "gsmUrl");
            return (Criteria) this;
        }

        public Criteria andGsmUrlNotEqualTo(String value) {
            addCriterion("gsm_url <>", value, "gsmUrl");
            return (Criteria) this;
        }

        public Criteria andGsmUrlGreaterThan(String value) {
            addCriterion("gsm_url >", value, "gsmUrl");
            return (Criteria) this;
        }

        public Criteria andGsmUrlGreaterThanOrEqualTo(String value) {
            addCriterion("gsm_url >=", value, "gsmUrl");
            return (Criteria) this;
        }

        public Criteria andGsmUrlLessThan(String value) {
            addCriterion("gsm_url <", value, "gsmUrl");
            return (Criteria) this;
        }

        public Criteria andGsmUrlLessThanOrEqualTo(String value) {
            addCriterion("gsm_url <=", value, "gsmUrl");
            return (Criteria) this;
        }

        public Criteria andGsmUrlLike(String value) {
            addCriterion("gsm_url like", value, "gsmUrl");
            return (Criteria) this;
        }

        public Criteria andGsmUrlNotLike(String value) {
            addCriterion("gsm_url not like", value, "gsmUrl");
            return (Criteria) this;
        }

        public Criteria andGsmUrlIn(List<String> values) {
            addCriterion("gsm_url in", values, "gsmUrl");
            return (Criteria) this;
        }

        public Criteria andGsmUrlNotIn(List<String> values) {
            addCriterion("gsm_url not in", values, "gsmUrl");
            return (Criteria) this;
        }

        public Criteria andGsmUrlBetween(String value1, String value2) {
            addCriterion("gsm_url between", value1, value2, "gsmUrl");
            return (Criteria) this;
        }

        public Criteria andGsmUrlNotBetween(String value1, String value2) {
            addCriterion("gsm_url not between", value1, value2, "gsmUrl");
            return (Criteria) this;
        }

        public Criteria andBtUrlIsNull() {
            addCriterion("bt_url is null");
            return (Criteria) this;
        }

        public Criteria andBtUrlIsNotNull() {
            addCriterion("bt_url is not null");
            return (Criteria) this;
        }

        public Criteria andBtUrlEqualTo(String value) {
            addCriterion("bt_url =", value, "btUrl");
            return (Criteria) this;
        }

        public Criteria andBtUrlNotEqualTo(String value) {
            addCriterion("bt_url <>", value, "btUrl");
            return (Criteria) this;
        }

        public Criteria andBtUrlGreaterThan(String value) {
            addCriterion("bt_url >", value, "btUrl");
            return (Criteria) this;
        }

        public Criteria andBtUrlGreaterThanOrEqualTo(String value) {
            addCriterion("bt_url >=", value, "btUrl");
            return (Criteria) this;
        }

        public Criteria andBtUrlLessThan(String value) {
            addCriterion("bt_url <", value, "btUrl");
            return (Criteria) this;
        }

        public Criteria andBtUrlLessThanOrEqualTo(String value) {
            addCriterion("bt_url <=", value, "btUrl");
            return (Criteria) this;
        }

        public Criteria andBtUrlLike(String value) {
            addCriterion("bt_url like", value, "btUrl");
            return (Criteria) this;
        }

        public Criteria andBtUrlNotLike(String value) {
            addCriterion("bt_url not like", value, "btUrl");
            return (Criteria) this;
        }

        public Criteria andBtUrlIn(List<String> values) {
            addCriterion("bt_url in", values, "btUrl");
            return (Criteria) this;
        }

        public Criteria andBtUrlNotIn(List<String> values) {
            addCriterion("bt_url not in", values, "btUrl");
            return (Criteria) this;
        }

        public Criteria andBtUrlBetween(String value1, String value2) {
            addCriterion("bt_url between", value1, value2, "btUrl");
            return (Criteria) this;
        }

        public Criteria andBtUrlNotBetween(String value1, String value2) {
            addCriterion("bt_url not between", value1, value2, "btUrl");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andGsmVersionIsNull() {
            addCriterion("gsm_version is null");
            return (Criteria) this;
        }

        public Criteria andGsmVersionIsNotNull() {
            addCriterion("gsm_version is not null");
            return (Criteria) this;
        }

        public Criteria andGsmVersionEqualTo(Integer value) {
            addCriterion("gsm_version =", value, "gsmVersion");
            return (Criteria) this;
        }

        public Criteria andGsmVersionNotEqualTo(Integer value) {
            addCriterion("gsm_version <>", value, "gsmVersion");
            return (Criteria) this;
        }

        public Criteria andGsmVersionGreaterThan(Integer value) {
            addCriterion("gsm_version >", value, "gsmVersion");
            return (Criteria) this;
        }

        public Criteria andGsmVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("gsm_version >=", value, "gsmVersion");
            return (Criteria) this;
        }

        public Criteria andGsmVersionLessThan(Integer value) {
            addCriterion("gsm_version <", value, "gsmVersion");
            return (Criteria) this;
        }

        public Criteria andGsmVersionLessThanOrEqualTo(Integer value) {
            addCriterion("gsm_version <=", value, "gsmVersion");
            return (Criteria) this;
        }

        public Criteria andGsmVersionIn(List<Integer> values) {
            addCriterion("gsm_version in", values, "gsmVersion");
            return (Criteria) this;
        }

        public Criteria andGsmVersionNotIn(List<Integer> values) {
            addCriterion("gsm_version not in", values, "gsmVersion");
            return (Criteria) this;
        }

        public Criteria andGsmVersionBetween(Integer value1, Integer value2) {
            addCriterion("gsm_version between", value1, value2, "gsmVersion");
            return (Criteria) this;
        }

        public Criteria andGsmVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("gsm_version not between", value1, value2, "gsmVersion");
            return (Criteria) this;
        }

        public Criteria andBtVersionIsNull() {
            addCriterion("bt_version is null");
            return (Criteria) this;
        }

        public Criteria andBtVersionIsNotNull() {
            addCriterion("bt_version is not null");
            return (Criteria) this;
        }

        public Criteria andBtVersionEqualTo(Integer value) {
            addCriterion("bt_version =", value, "btVersion");
            return (Criteria) this;
        }

        public Criteria andBtVersionNotEqualTo(Integer value) {
            addCriterion("bt_version <>", value, "btVersion");
            return (Criteria) this;
        }

        public Criteria andBtVersionGreaterThan(Integer value) {
            addCriterion("bt_version >", value, "btVersion");
            return (Criteria) this;
        }

        public Criteria andBtVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("bt_version >=", value, "btVersion");
            return (Criteria) this;
        }

        public Criteria andBtVersionLessThan(Integer value) {
            addCriterion("bt_version <", value, "btVersion");
            return (Criteria) this;
        }

        public Criteria andBtVersionLessThanOrEqualTo(Integer value) {
            addCriterion("bt_version <=", value, "btVersion");
            return (Criteria) this;
        }

        public Criteria andBtVersionIn(List<Integer> values) {
            addCriterion("bt_version in", values, "btVersion");
            return (Criteria) this;
        }

        public Criteria andBtVersionNotIn(List<Integer> values) {
            addCriterion("bt_version not in", values, "btVersion");
            return (Criteria) this;
        }

        public Criteria andBtVersionBetween(Integer value1, Integer value2) {
            addCriterion("bt_version between", value1, value2, "btVersion");
            return (Criteria) this;
        }

        public Criteria andBtVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("bt_version not between", value1, value2, "btVersion");
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