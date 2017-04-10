package com.kaicom.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BikeDeviceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BikeDeviceExample() {
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

        public Criteria andVendorIsNull() {
            addCriterion("vendor is null");
            return (Criteria) this;
        }

        public Criteria andVendorIsNotNull() {
            addCriterion("vendor is not null");
            return (Criteria) this;
        }

        public Criteria andVendorEqualTo(String value) {
            addCriterion("vendor =", value, "vendor");
            return (Criteria) this;
        }

        public Criteria andVendorNotEqualTo(String value) {
            addCriterion("vendor <>", value, "vendor");
            return (Criteria) this;
        }

        public Criteria andVendorGreaterThan(String value) {
            addCriterion("vendor >", value, "vendor");
            return (Criteria) this;
        }

        public Criteria andVendorGreaterThanOrEqualTo(String value) {
            addCriterion("vendor >=", value, "vendor");
            return (Criteria) this;
        }

        public Criteria andVendorLessThan(String value) {
            addCriterion("vendor <", value, "vendor");
            return (Criteria) this;
        }

        public Criteria andVendorLessThanOrEqualTo(String value) {
            addCriterion("vendor <=", value, "vendor");
            return (Criteria) this;
        }

        public Criteria andVendorLike(String value) {
            addCriterion("vendor like", value, "vendor");
            return (Criteria) this;
        }

        public Criteria andVendorNotLike(String value) {
            addCriterion("vendor not like", value, "vendor");
            return (Criteria) this;
        }

        public Criteria andVendorIn(List<String> values) {
            addCriterion("vendor in", values, "vendor");
            return (Criteria) this;
        }

        public Criteria andVendorNotIn(List<String> values) {
            addCriterion("vendor not in", values, "vendor");
            return (Criteria) this;
        }

        public Criteria andVendorBetween(String value1, String value2) {
            addCriterion("vendor between", value1, value2, "vendor");
            return (Criteria) this;
        }

        public Criteria andVendorNotBetween(String value1, String value2) {
            addCriterion("vendor not between", value1, value2, "vendor");
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

        public Criteria andDeviceIdIsNull() {
            addCriterion("device_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNotNull() {
            addCriterion("device_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdEqualTo(String value) {
            addCriterion("device_id =", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotEqualTo(String value) {
            addCriterion("device_id <>", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThan(String value) {
            addCriterion("device_id >", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThanOrEqualTo(String value) {
            addCriterion("device_id >=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThan(String value) {
            addCriterion("device_id <", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThanOrEqualTo(String value) {
            addCriterion("device_id <=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLike(String value) {
            addCriterion("device_id like", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotLike(String value) {
            addCriterion("device_id not like", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIn(List<String> values) {
            addCriterion("device_id in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotIn(List<String> values) {
            addCriterion("device_id not in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdBetween(String value1, String value2) {
            addCriterion("device_id between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotBetween(String value1, String value2) {
            addCriterion("device_id not between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andApnIsNull() {
            addCriterion("apn is null");
            return (Criteria) this;
        }

        public Criteria andApnIsNotNull() {
            addCriterion("apn is not null");
            return (Criteria) this;
        }

        public Criteria andApnEqualTo(String value) {
            addCriterion("apn =", value, "apn");
            return (Criteria) this;
        }

        public Criteria andApnNotEqualTo(String value) {
            addCriterion("apn <>", value, "apn");
            return (Criteria) this;
        }

        public Criteria andApnGreaterThan(String value) {
            addCriterion("apn >", value, "apn");
            return (Criteria) this;
        }

        public Criteria andApnGreaterThanOrEqualTo(String value) {
            addCriterion("apn >=", value, "apn");
            return (Criteria) this;
        }

        public Criteria andApnLessThan(String value) {
            addCriterion("apn <", value, "apn");
            return (Criteria) this;
        }

        public Criteria andApnLessThanOrEqualTo(String value) {
            addCriterion("apn <=", value, "apn");
            return (Criteria) this;
        }

        public Criteria andApnLike(String value) {
            addCriterion("apn like", value, "apn");
            return (Criteria) this;
        }

        public Criteria andApnNotLike(String value) {
            addCriterion("apn not like", value, "apn");
            return (Criteria) this;
        }

        public Criteria andApnIn(List<String> values) {
            addCriterion("apn in", values, "apn");
            return (Criteria) this;
        }

        public Criteria andApnNotIn(List<String> values) {
            addCriterion("apn not in", values, "apn");
            return (Criteria) this;
        }

        public Criteria andApnBetween(String value1, String value2) {
            addCriterion("apn between", value1, value2, "apn");
            return (Criteria) this;
        }

        public Criteria andApnNotBetween(String value1, String value2) {
            addCriterion("apn not between", value1, value2, "apn");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andPortIsNull() {
            addCriterion("port is null");
            return (Criteria) this;
        }

        public Criteria andPortIsNotNull() {
            addCriterion("port is not null");
            return (Criteria) this;
        }

        public Criteria andPortEqualTo(Integer value) {
            addCriterion("port =", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotEqualTo(Integer value) {
            addCriterion("port <>", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThan(Integer value) {
            addCriterion("port >", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThanOrEqualTo(Integer value) {
            addCriterion("port >=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThan(Integer value) {
            addCriterion("port <", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThanOrEqualTo(Integer value) {
            addCriterion("port <=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortIn(List<Integer> values) {
            addCriterion("port in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotIn(List<Integer> values) {
            addCriterion("port not in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortBetween(Integer value1, Integer value2) {
            addCriterion("port between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotBetween(Integer value1, Integer value2) {
            addCriterion("port not between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andUploadIntervalIsNull() {
            addCriterion("upload_interval is null");
            return (Criteria) this;
        }

        public Criteria andUploadIntervalIsNotNull() {
            addCriterion("upload_interval is not null");
            return (Criteria) this;
        }

        public Criteria andUploadIntervalEqualTo(Short value) {
            addCriterion("upload_interval =", value, "uploadInterval");
            return (Criteria) this;
        }

        public Criteria andUploadIntervalNotEqualTo(Short value) {
            addCriterion("upload_interval <>", value, "uploadInterval");
            return (Criteria) this;
        }

        public Criteria andUploadIntervalGreaterThan(Short value) {
            addCriterion("upload_interval >", value, "uploadInterval");
            return (Criteria) this;
        }

        public Criteria andUploadIntervalGreaterThanOrEqualTo(Short value) {
            addCriterion("upload_interval >=", value, "uploadInterval");
            return (Criteria) this;
        }

        public Criteria andUploadIntervalLessThan(Short value) {
            addCriterion("upload_interval <", value, "uploadInterval");
            return (Criteria) this;
        }

        public Criteria andUploadIntervalLessThanOrEqualTo(Short value) {
            addCriterion("upload_interval <=", value, "uploadInterval");
            return (Criteria) this;
        }

        public Criteria andUploadIntervalIn(List<Short> values) {
            addCriterion("upload_interval in", values, "uploadInterval");
            return (Criteria) this;
        }

        public Criteria andUploadIntervalNotIn(List<Short> values) {
            addCriterion("upload_interval not in", values, "uploadInterval");
            return (Criteria) this;
        }

        public Criteria andUploadIntervalBetween(Short value1, Short value2) {
            addCriterion("upload_interval between", value1, value2, "uploadInterval");
            return (Criteria) this;
        }

        public Criteria andUploadIntervalNotBetween(Short value1, Short value2) {
            addCriterion("upload_interval not between", value1, value2, "uploadInterval");
            return (Criteria) this;
        }

        public Criteria andLockCanUploadIsNull() {
            addCriterion("lock_can_upload is null");
            return (Criteria) this;
        }

        public Criteria andLockCanUploadIsNotNull() {
            addCriterion("lock_can_upload is not null");
            return (Criteria) this;
        }

        public Criteria andLockCanUploadEqualTo(Short value) {
            addCriterion("lock_can_upload =", value, "lockCanUpload");
            return (Criteria) this;
        }

        public Criteria andLockCanUploadNotEqualTo(Short value) {
            addCriterion("lock_can_upload <>", value, "lockCanUpload");
            return (Criteria) this;
        }

        public Criteria andLockCanUploadGreaterThan(Short value) {
            addCriterion("lock_can_upload >", value, "lockCanUpload");
            return (Criteria) this;
        }

        public Criteria andLockCanUploadGreaterThanOrEqualTo(Short value) {
            addCriterion("lock_can_upload >=", value, "lockCanUpload");
            return (Criteria) this;
        }

        public Criteria andLockCanUploadLessThan(Short value) {
            addCriterion("lock_can_upload <", value, "lockCanUpload");
            return (Criteria) this;
        }

        public Criteria andLockCanUploadLessThanOrEqualTo(Short value) {
            addCriterion("lock_can_upload <=", value, "lockCanUpload");
            return (Criteria) this;
        }

        public Criteria andLockCanUploadIn(List<Short> values) {
            addCriterion("lock_can_upload in", values, "lockCanUpload");
            return (Criteria) this;
        }

        public Criteria andLockCanUploadNotIn(List<Short> values) {
            addCriterion("lock_can_upload not in", values, "lockCanUpload");
            return (Criteria) this;
        }

        public Criteria andLockCanUploadBetween(Short value1, Short value2) {
            addCriterion("lock_can_upload between", value1, value2, "lockCanUpload");
            return (Criteria) this;
        }

        public Criteria andLockCanUploadNotBetween(Short value1, Short value2) {
            addCriterion("lock_can_upload not between", value1, value2, "lockCanUpload");
            return (Criteria) this;
        }

        public Criteria andLockUploadIntervalIsNull() {
            addCriterion("lock_upload_interval is null");
            return (Criteria) this;
        }

        public Criteria andLockUploadIntervalIsNotNull() {
            addCriterion("lock_upload_interval is not null");
            return (Criteria) this;
        }

        public Criteria andLockUploadIntervalEqualTo(Short value) {
            addCriterion("lock_upload_interval =", value, "lockUploadInterval");
            return (Criteria) this;
        }

        public Criteria andLockUploadIntervalNotEqualTo(Short value) {
            addCriterion("lock_upload_interval <>", value, "lockUploadInterval");
            return (Criteria) this;
        }

        public Criteria andLockUploadIntervalGreaterThan(Short value) {
            addCriterion("lock_upload_interval >", value, "lockUploadInterval");
            return (Criteria) this;
        }

        public Criteria andLockUploadIntervalGreaterThanOrEqualTo(Short value) {
            addCriterion("lock_upload_interval >=", value, "lockUploadInterval");
            return (Criteria) this;
        }

        public Criteria andLockUploadIntervalLessThan(Short value) {
            addCriterion("lock_upload_interval <", value, "lockUploadInterval");
            return (Criteria) this;
        }

        public Criteria andLockUploadIntervalLessThanOrEqualTo(Short value) {
            addCriterion("lock_upload_interval <=", value, "lockUploadInterval");
            return (Criteria) this;
        }

        public Criteria andLockUploadIntervalIn(List<Short> values) {
            addCriterion("lock_upload_interval in", values, "lockUploadInterval");
            return (Criteria) this;
        }

        public Criteria andLockUploadIntervalNotIn(List<Short> values) {
            addCriterion("lock_upload_interval not in", values, "lockUploadInterval");
            return (Criteria) this;
        }

        public Criteria andLockUploadIntervalBetween(Short value1, Short value2) {
            addCriterion("lock_upload_interval between", value1, value2, "lockUploadInterval");
            return (Criteria) this;
        }

        public Criteria andLockUploadIntervalNotBetween(Short value1, Short value2) {
            addCriterion("lock_upload_interval not between", value1, value2, "lockUploadInterval");
            return (Criteria) this;
        }

        public Criteria andGsonserEnableIsNull() {
            addCriterion("gsonser_enable is null");
            return (Criteria) this;
        }

        public Criteria andGsonserEnableIsNotNull() {
            addCriterion("gsonser_enable is not null");
            return (Criteria) this;
        }

        public Criteria andGsonserEnableEqualTo(Byte value) {
            addCriterion("gsonser_enable =", value, "gsonserEnable");
            return (Criteria) this;
        }

        public Criteria andGsonserEnableNotEqualTo(Byte value) {
            addCriterion("gsonser_enable <>", value, "gsonserEnable");
            return (Criteria) this;
        }

        public Criteria andGsonserEnableGreaterThan(Byte value) {
            addCriterion("gsonser_enable >", value, "gsonserEnable");
            return (Criteria) this;
        }

        public Criteria andGsonserEnableGreaterThanOrEqualTo(Byte value) {
            addCriterion("gsonser_enable >=", value, "gsonserEnable");
            return (Criteria) this;
        }

        public Criteria andGsonserEnableLessThan(Byte value) {
            addCriterion("gsonser_enable <", value, "gsonserEnable");
            return (Criteria) this;
        }

        public Criteria andGsonserEnableLessThanOrEqualTo(Byte value) {
            addCriterion("gsonser_enable <=", value, "gsonserEnable");
            return (Criteria) this;
        }

        public Criteria andGsonserEnableIn(List<Byte> values) {
            addCriterion("gsonser_enable in", values, "gsonserEnable");
            return (Criteria) this;
        }

        public Criteria andGsonserEnableNotIn(List<Byte> values) {
            addCriterion("gsonser_enable not in", values, "gsonserEnable");
            return (Criteria) this;
        }

        public Criteria andGsonserEnableBetween(Byte value1, Byte value2) {
            addCriterion("gsonser_enable between", value1, value2, "gsonserEnable");
            return (Criteria) this;
        }

        public Criteria andGsonserEnableNotBetween(Byte value1, Byte value2) {
            addCriterion("gsonser_enable not between", value1, value2, "gsonserEnable");
            return (Criteria) this;
        }

        public Criteria andGsonserWakeupUploadEnableIsNull() {
            addCriterion("gsonser_wakeup_upload_enable is null");
            return (Criteria) this;
        }

        public Criteria andGsonserWakeupUploadEnableIsNotNull() {
            addCriterion("gsonser_wakeup_upload_enable is not null");
            return (Criteria) this;
        }

        public Criteria andGsonserWakeupUploadEnableEqualTo(Byte value) {
            addCriterion("gsonser_wakeup_upload_enable =", value, "gsonserWakeupUploadEnable");
            return (Criteria) this;
        }

        public Criteria andGsonserWakeupUploadEnableNotEqualTo(Byte value) {
            addCriterion("gsonser_wakeup_upload_enable <>", value, "gsonserWakeupUploadEnable");
            return (Criteria) this;
        }

        public Criteria andGsonserWakeupUploadEnableGreaterThan(Byte value) {
            addCriterion("gsonser_wakeup_upload_enable >", value, "gsonserWakeupUploadEnable");
            return (Criteria) this;
        }

        public Criteria andGsonserWakeupUploadEnableGreaterThanOrEqualTo(Byte value) {
            addCriterion("gsonser_wakeup_upload_enable >=", value, "gsonserWakeupUploadEnable");
            return (Criteria) this;
        }

        public Criteria andGsonserWakeupUploadEnableLessThan(Byte value) {
            addCriterion("gsonser_wakeup_upload_enable <", value, "gsonserWakeupUploadEnable");
            return (Criteria) this;
        }

        public Criteria andGsonserWakeupUploadEnableLessThanOrEqualTo(Byte value) {
            addCriterion("gsonser_wakeup_upload_enable <=", value, "gsonserWakeupUploadEnable");
            return (Criteria) this;
        }

        public Criteria andGsonserWakeupUploadEnableIn(List<Byte> values) {
            addCriterion("gsonser_wakeup_upload_enable in", values, "gsonserWakeupUploadEnable");
            return (Criteria) this;
        }

        public Criteria andGsonserWakeupUploadEnableNotIn(List<Byte> values) {
            addCriterion("gsonser_wakeup_upload_enable not in", values, "gsonserWakeupUploadEnable");
            return (Criteria) this;
        }

        public Criteria andGsonserWakeupUploadEnableBetween(Byte value1, Byte value2) {
            addCriterion("gsonser_wakeup_upload_enable between", value1, value2, "gsonserWakeupUploadEnable");
            return (Criteria) this;
        }

        public Criteria andGsonserWakeupUploadEnableNotBetween(Byte value1, Byte value2) {
            addCriterion("gsonser_wakeup_upload_enable not between", value1, value2, "gsonserWakeupUploadEnable");
            return (Criteria) this;
        }

        public Criteria andLedIsNull() {
            addCriterion("led is null");
            return (Criteria) this;
        }

        public Criteria andLedIsNotNull() {
            addCriterion("led is not null");
            return (Criteria) this;
        }

        public Criteria andLedEqualTo(String value) {
            addCriterion("led =", value, "led");
            return (Criteria) this;
        }

        public Criteria andLedNotEqualTo(String value) {
            addCriterion("led <>", value, "led");
            return (Criteria) this;
        }

        public Criteria andLedGreaterThan(String value) {
            addCriterion("led >", value, "led");
            return (Criteria) this;
        }

        public Criteria andLedGreaterThanOrEqualTo(String value) {
            addCriterion("led >=", value, "led");
            return (Criteria) this;
        }

        public Criteria andLedLessThan(String value) {
            addCriterion("led <", value, "led");
            return (Criteria) this;
        }

        public Criteria andLedLessThanOrEqualTo(String value) {
            addCriterion("led <=", value, "led");
            return (Criteria) this;
        }

        public Criteria andLedLike(String value) {
            addCriterion("led like", value, "led");
            return (Criteria) this;
        }

        public Criteria andLedNotLike(String value) {
            addCriterion("led not like", value, "led");
            return (Criteria) this;
        }

        public Criteria andLedIn(List<String> values) {
            addCriterion("led in", values, "led");
            return (Criteria) this;
        }

        public Criteria andLedNotIn(List<String> values) {
            addCriterion("led not in", values, "led");
            return (Criteria) this;
        }

        public Criteria andLedBetween(String value1, String value2) {
            addCriterion("led between", value1, value2, "led");
            return (Criteria) this;
        }

        public Criteria andLedNotBetween(String value1, String value2) {
            addCriterion("led not between", value1, value2, "led");
            return (Criteria) this;
        }

        public Criteria andUnlockTimesIsNull() {
            addCriterion("unlock_times is null");
            return (Criteria) this;
        }

        public Criteria andUnlockTimesIsNotNull() {
            addCriterion("unlock_times is not null");
            return (Criteria) this;
        }

        public Criteria andUnlockTimesEqualTo(Integer value) {
            addCriterion("unlock_times =", value, "unlockTimes");
            return (Criteria) this;
        }

        public Criteria andUnlockTimesNotEqualTo(Integer value) {
            addCriterion("unlock_times <>", value, "unlockTimes");
            return (Criteria) this;
        }

        public Criteria andUnlockTimesGreaterThan(Integer value) {
            addCriterion("unlock_times >", value, "unlockTimes");
            return (Criteria) this;
        }

        public Criteria andUnlockTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("unlock_times >=", value, "unlockTimes");
            return (Criteria) this;
        }

        public Criteria andUnlockTimesLessThan(Integer value) {
            addCriterion("unlock_times <", value, "unlockTimes");
            return (Criteria) this;
        }

        public Criteria andUnlockTimesLessThanOrEqualTo(Integer value) {
            addCriterion("unlock_times <=", value, "unlockTimes");
            return (Criteria) this;
        }

        public Criteria andUnlockTimesIn(List<Integer> values) {
            addCriterion("unlock_times in", values, "unlockTimes");
            return (Criteria) this;
        }

        public Criteria andUnlockTimesNotIn(List<Integer> values) {
            addCriterion("unlock_times not in", values, "unlockTimes");
            return (Criteria) this;
        }

        public Criteria andUnlockTimesBetween(Integer value1, Integer value2) {
            addCriterion("unlock_times between", value1, value2, "unlockTimes");
            return (Criteria) this;
        }

        public Criteria andUnlockTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("unlock_times not between", value1, value2, "unlockTimes");
            return (Criteria) this;
        }

        public Criteria andLockStatusIsNull() {
            addCriterion("lock_status is null");
            return (Criteria) this;
        }

        public Criteria andLockStatusIsNotNull() {
            addCriterion("lock_status is not null");
            return (Criteria) this;
        }

        public Criteria andLockStatusEqualTo(Short value) {
            addCriterion("lock_status =", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusNotEqualTo(Short value) {
            addCriterion("lock_status <>", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusGreaterThan(Short value) {
            addCriterion("lock_status >", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("lock_status >=", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusLessThan(Short value) {
            addCriterion("lock_status <", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusLessThanOrEqualTo(Short value) {
            addCriterion("lock_status <=", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusIn(List<Short> values) {
            addCriterion("lock_status in", values, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusNotIn(List<Short> values) {
            addCriterion("lock_status not in", values, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusBetween(Short value1, Short value2) {
            addCriterion("lock_status between", value1, value2, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusNotBetween(Short value1, Short value2) {
            addCriterion("lock_status not between", value1, value2, "lockStatus");
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

        public Criteria andChargeStatusIsNull() {
            addCriterion("charge_status is null");
            return (Criteria) this;
        }

        public Criteria andChargeStatusIsNotNull() {
            addCriterion("charge_status is not null");
            return (Criteria) this;
        }

        public Criteria andChargeStatusEqualTo(Byte value) {
            addCriterion("charge_status =", value, "chargeStatus");
            return (Criteria) this;
        }

        public Criteria andChargeStatusNotEqualTo(Byte value) {
            addCriterion("charge_status <>", value, "chargeStatus");
            return (Criteria) this;
        }

        public Criteria andChargeStatusGreaterThan(Byte value) {
            addCriterion("charge_status >", value, "chargeStatus");
            return (Criteria) this;
        }

        public Criteria andChargeStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("charge_status >=", value, "chargeStatus");
            return (Criteria) this;
        }

        public Criteria andChargeStatusLessThan(Byte value) {
            addCriterion("charge_status <", value, "chargeStatus");
            return (Criteria) this;
        }

        public Criteria andChargeStatusLessThanOrEqualTo(Byte value) {
            addCriterion("charge_status <=", value, "chargeStatus");
            return (Criteria) this;
        }

        public Criteria andChargeStatusIn(List<Byte> values) {
            addCriterion("charge_status in", values, "chargeStatus");
            return (Criteria) this;
        }

        public Criteria andChargeStatusNotIn(List<Byte> values) {
            addCriterion("charge_status not in", values, "chargeStatus");
            return (Criteria) this;
        }

        public Criteria andChargeStatusBetween(Byte value1, Byte value2) {
            addCriterion("charge_status between", value1, value2, "chargeStatus");
            return (Criteria) this;
        }

        public Criteria andChargeStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("charge_status not between", value1, value2, "chargeStatus");
            return (Criteria) this;
        }

        public Criteria andBtKeyIsNull() {
            addCriterion("bt_key is null");
            return (Criteria) this;
        }

        public Criteria andBtKeyIsNotNull() {
            addCriterion("bt_key is not null");
            return (Criteria) this;
        }

        public Criteria andBtKeyEqualTo(String value) {
            addCriterion("bt_key =", value, "btKey");
            return (Criteria) this;
        }

        public Criteria andBtKeyNotEqualTo(String value) {
            addCriterion("bt_key <>", value, "btKey");
            return (Criteria) this;
        }

        public Criteria andBtKeyGreaterThan(String value) {
            addCriterion("bt_key >", value, "btKey");
            return (Criteria) this;
        }

        public Criteria andBtKeyGreaterThanOrEqualTo(String value) {
            addCriterion("bt_key >=", value, "btKey");
            return (Criteria) this;
        }

        public Criteria andBtKeyLessThan(String value) {
            addCriterion("bt_key <", value, "btKey");
            return (Criteria) this;
        }

        public Criteria andBtKeyLessThanOrEqualTo(String value) {
            addCriterion("bt_key <=", value, "btKey");
            return (Criteria) this;
        }

        public Criteria andBtKeyLike(String value) {
            addCriterion("bt_key like", value, "btKey");
            return (Criteria) this;
        }

        public Criteria andBtKeyNotLike(String value) {
            addCriterion("bt_key not like", value, "btKey");
            return (Criteria) this;
        }

        public Criteria andBtKeyIn(List<String> values) {
            addCriterion("bt_key in", values, "btKey");
            return (Criteria) this;
        }

        public Criteria andBtKeyNotIn(List<String> values) {
            addCriterion("bt_key not in", values, "btKey");
            return (Criteria) this;
        }

        public Criteria andBtKeyBetween(String value1, String value2) {
            addCriterion("bt_key between", value1, value2, "btKey");
            return (Criteria) this;
        }

        public Criteria andBtKeyNotBetween(String value1, String value2) {
            addCriterion("bt_key not between", value1, value2, "btKey");
            return (Criteria) this;
        }

        public Criteria andBtPwdIsNull() {
            addCriterion("bt_pwd is null");
            return (Criteria) this;
        }

        public Criteria andBtPwdIsNotNull() {
            addCriterion("bt_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andBtPwdEqualTo(String value) {
            addCriterion("bt_pwd =", value, "btPwd");
            return (Criteria) this;
        }

        public Criteria andBtPwdNotEqualTo(String value) {
            addCriterion("bt_pwd <>", value, "btPwd");
            return (Criteria) this;
        }

        public Criteria andBtPwdGreaterThan(String value) {
            addCriterion("bt_pwd >", value, "btPwd");
            return (Criteria) this;
        }

        public Criteria andBtPwdGreaterThanOrEqualTo(String value) {
            addCriterion("bt_pwd >=", value, "btPwd");
            return (Criteria) this;
        }

        public Criteria andBtPwdLessThan(String value) {
            addCriterion("bt_pwd <", value, "btPwd");
            return (Criteria) this;
        }

        public Criteria andBtPwdLessThanOrEqualTo(String value) {
            addCriterion("bt_pwd <=", value, "btPwd");
            return (Criteria) this;
        }

        public Criteria andBtPwdLike(String value) {
            addCriterion("bt_pwd like", value, "btPwd");
            return (Criteria) this;
        }

        public Criteria andBtPwdNotLike(String value) {
            addCriterion("bt_pwd not like", value, "btPwd");
            return (Criteria) this;
        }

        public Criteria andBtPwdIn(List<String> values) {
            addCriterion("bt_pwd in", values, "btPwd");
            return (Criteria) this;
        }

        public Criteria andBtPwdNotIn(List<String> values) {
            addCriterion("bt_pwd not in", values, "btPwd");
            return (Criteria) this;
        }

        public Criteria andBtPwdBetween(String value1, String value2) {
            addCriterion("bt_pwd between", value1, value2, "btPwd");
            return (Criteria) this;
        }

        public Criteria andBtPwdNotBetween(String value1, String value2) {
            addCriterion("bt_pwd not between", value1, value2, "btPwd");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(Short value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(Short value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(Short value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(Short value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(Short value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(Short value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<Short> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<Short> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(Short value1, Short value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(Short value1, Short value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(Short value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(Short value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(Short value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(Short value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(Short value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(Short value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<Short> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<Short> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(Short value1, Short value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(Short value1, Short value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Byte value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Byte value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Byte value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Byte value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Byte value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Byte> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Byte> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Byte value1, Byte value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andBtMacIsNull() {
            addCriterion("bt_mac is null");
            return (Criteria) this;
        }

        public Criteria andBtMacIsNotNull() {
            addCriterion("bt_mac is not null");
            return (Criteria) this;
        }

        public Criteria andBtMacEqualTo(String value) {
            addCriterion("bt_mac =", value, "btMac");
            return (Criteria) this;
        }

        public Criteria andBtMacNotEqualTo(String value) {
            addCriterion("bt_mac <>", value, "btMac");
            return (Criteria) this;
        }

        public Criteria andBtMacGreaterThan(String value) {
            addCriterion("bt_mac >", value, "btMac");
            return (Criteria) this;
        }

        public Criteria andBtMacGreaterThanOrEqualTo(String value) {
            addCriterion("bt_mac >=", value, "btMac");
            return (Criteria) this;
        }

        public Criteria andBtMacLessThan(String value) {
            addCriterion("bt_mac <", value, "btMac");
            return (Criteria) this;
        }

        public Criteria andBtMacLessThanOrEqualTo(String value) {
            addCriterion("bt_mac <=", value, "btMac");
            return (Criteria) this;
        }

        public Criteria andBtMacLike(String value) {
            addCriterion("bt_mac like", value, "btMac");
            return (Criteria) this;
        }

        public Criteria andBtMacNotLike(String value) {
            addCriterion("bt_mac not like", value, "btMac");
            return (Criteria) this;
        }

        public Criteria andBtMacIn(List<String> values) {
            addCriterion("bt_mac in", values, "btMac");
            return (Criteria) this;
        }

        public Criteria andBtMacNotIn(List<String> values) {
            addCriterion("bt_mac not in", values, "btMac");
            return (Criteria) this;
        }

        public Criteria andBtMacBetween(String value1, String value2) {
            addCriterion("bt_mac between", value1, value2, "btMac");
            return (Criteria) this;
        }

        public Criteria andBtMacNotBetween(String value1, String value2) {
            addCriterion("bt_mac not between", value1, value2, "btMac");
            return (Criteria) this;
        }

        public Criteria andIccidIsNull() {
            addCriterion("iccid is null");
            return (Criteria) this;
        }

        public Criteria andIccidIsNotNull() {
            addCriterion("iccid is not null");
            return (Criteria) this;
        }

        public Criteria andIccidEqualTo(String value) {
            addCriterion("iccid =", value, "iccid");
            return (Criteria) this;
        }

        public Criteria andIccidNotEqualTo(String value) {
            addCriterion("iccid <>", value, "iccid");
            return (Criteria) this;
        }

        public Criteria andIccidGreaterThan(String value) {
            addCriterion("iccid >", value, "iccid");
            return (Criteria) this;
        }

        public Criteria andIccidGreaterThanOrEqualTo(String value) {
            addCriterion("iccid >=", value, "iccid");
            return (Criteria) this;
        }

        public Criteria andIccidLessThan(String value) {
            addCriterion("iccid <", value, "iccid");
            return (Criteria) this;
        }

        public Criteria andIccidLessThanOrEqualTo(String value) {
            addCriterion("iccid <=", value, "iccid");
            return (Criteria) this;
        }

        public Criteria andIccidLike(String value) {
            addCriterion("iccid like", value, "iccid");
            return (Criteria) this;
        }

        public Criteria andIccidNotLike(String value) {
            addCriterion("iccid not like", value, "iccid");
            return (Criteria) this;
        }

        public Criteria andIccidIn(List<String> values) {
            addCriterion("iccid in", values, "iccid");
            return (Criteria) this;
        }

        public Criteria andIccidNotIn(List<String> values) {
            addCriterion("iccid not in", values, "iccid");
            return (Criteria) this;
        }

        public Criteria andIccidBetween(String value1, String value2) {
            addCriterion("iccid between", value1, value2, "iccid");
            return (Criteria) this;
        }

        public Criteria andIccidNotBetween(String value1, String value2) {
            addCriterion("iccid not between", value1, value2, "iccid");
            return (Criteria) this;
        }

        public Criteria andRegTimeIsNull() {
            addCriterion("reg_time is null");
            return (Criteria) this;
        }

        public Criteria andRegTimeIsNotNull() {
            addCriterion("reg_time is not null");
            return (Criteria) this;
        }

        public Criteria andRegTimeEqualTo(Date value) {
            addCriterion("reg_time =", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeNotEqualTo(Date value) {
            addCriterion("reg_time <>", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeGreaterThan(Date value) {
            addCriterion("reg_time >", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("reg_time >=", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeLessThan(Date value) {
            addCriterion("reg_time <", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeLessThanOrEqualTo(Date value) {
            addCriterion("reg_time <=", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeIn(List<Date> values) {
            addCriterion("reg_time in", values, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeNotIn(List<Date> values) {
            addCriterion("reg_time not in", values, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeBetween(Date value1, Date value2) {
            addCriterion("reg_time between", value1, value2, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeNotBetween(Date value1, Date value2) {
            addCriterion("reg_time not between", value1, value2, "regTime");
            return (Criteria) this;
        }

        public Criteria andIsRegIsNull() {
            addCriterion("is_reg is null");
            return (Criteria) this;
        }

        public Criteria andIsRegIsNotNull() {
            addCriterion("is_reg is not null");
            return (Criteria) this;
        }

        public Criteria andIsRegEqualTo(Byte value) {
            addCriterion("is_reg =", value, "isReg");
            return (Criteria) this;
        }

        public Criteria andIsRegNotEqualTo(Byte value) {
            addCriterion("is_reg <>", value, "isReg");
            return (Criteria) this;
        }

        public Criteria andIsRegGreaterThan(Byte value) {
            addCriterion("is_reg >", value, "isReg");
            return (Criteria) this;
        }

        public Criteria andIsRegGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_reg >=", value, "isReg");
            return (Criteria) this;
        }

        public Criteria andIsRegLessThan(Byte value) {
            addCriterion("is_reg <", value, "isReg");
            return (Criteria) this;
        }

        public Criteria andIsRegLessThanOrEqualTo(Byte value) {
            addCriterion("is_reg <=", value, "isReg");
            return (Criteria) this;
        }

        public Criteria andIsRegIn(List<Byte> values) {
            addCriterion("is_reg in", values, "isReg");
            return (Criteria) this;
        }

        public Criteria andIsRegNotIn(List<Byte> values) {
            addCriterion("is_reg not in", values, "isReg");
            return (Criteria) this;
        }

        public Criteria andIsRegBetween(Byte value1, Byte value2) {
            addCriterion("is_reg between", value1, value2, "isReg");
            return (Criteria) this;
        }

        public Criteria andIsRegNotBetween(Byte value1, Byte value2) {
            addCriterion("is_reg not between", value1, value2, "isReg");
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

        public Criteria andUploadTimeIsNull() {
            addCriterion("upload_time is null");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIsNotNull() {
            addCriterion("upload_time is not null");
            return (Criteria) this;
        }

        public Criteria andUploadTimeEqualTo(Date value) {
            addCriterion("upload_time =", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotEqualTo(Date value) {
            addCriterion("upload_time <>", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeGreaterThan(Date value) {
            addCriterion("upload_time >", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("upload_time >=", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeLessThan(Date value) {
            addCriterion("upload_time <", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeLessThanOrEqualTo(Date value) {
            addCriterion("upload_time <=", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIn(List<Date> values) {
            addCriterion("upload_time in", values, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotIn(List<Date> values) {
            addCriterion("upload_time not in", values, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeBetween(Date value1, Date value2) {
            addCriterion("upload_time between", value1, value2, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotBetween(Date value1, Date value2) {
            addCriterion("upload_time not between", value1, value2, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andLatIsNull() {
            addCriterion("lat is null");
            return (Criteria) this;
        }

        public Criteria andLatIsNotNull() {
            addCriterion("lat is not null");
            return (Criteria) this;
        }

        public Criteria andLatEqualTo(Double value) {
            addCriterion("lat =", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotEqualTo(Double value) {
            addCriterion("lat <>", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThan(Double value) {
            addCriterion("lat >", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThanOrEqualTo(Double value) {
            addCriterion("lat >=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThan(Double value) {
            addCriterion("lat <", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThanOrEqualTo(Double value) {
            addCriterion("lat <=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatIn(List<Double> values) {
            addCriterion("lat in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotIn(List<Double> values) {
            addCriterion("lat not in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatBetween(Double value1, Double value2) {
            addCriterion("lat between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotBetween(Double value1, Double value2) {
            addCriterion("lat not between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLngIsNull() {
            addCriterion("lng is null");
            return (Criteria) this;
        }

        public Criteria andLngIsNotNull() {
            addCriterion("lng is not null");
            return (Criteria) this;
        }

        public Criteria andLngEqualTo(Double value) {
            addCriterion("lng =", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotEqualTo(Double value) {
            addCriterion("lng <>", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThan(Double value) {
            addCriterion("lng >", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThanOrEqualTo(Double value) {
            addCriterion("lng >=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThan(Double value) {
            addCriterion("lng <", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThanOrEqualTo(Double value) {
            addCriterion("lng <=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngIn(List<Double> values) {
            addCriterion("lng in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotIn(List<Double> values) {
            addCriterion("lng not in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngBetween(Double value1, Double value2) {
            addCriterion("lng between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotBetween(Double value1, Double value2) {
            addCriterion("lng not between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andBatVolIsNull() {
            addCriterion("bat_vol is null");
            return (Criteria) this;
        }

        public Criteria andBatVolIsNotNull() {
            addCriterion("bat_vol is not null");
            return (Criteria) this;
        }

        public Criteria andBatVolEqualTo(Byte value) {
            addCriterion("bat_vol =", value, "batVol");
            return (Criteria) this;
        }

        public Criteria andBatVolNotEqualTo(Byte value) {
            addCriterion("bat_vol <>", value, "batVol");
            return (Criteria) this;
        }

        public Criteria andBatVolGreaterThan(Byte value) {
            addCriterion("bat_vol >", value, "batVol");
            return (Criteria) this;
        }

        public Criteria andBatVolGreaterThanOrEqualTo(Byte value) {
            addCriterion("bat_vol >=", value, "batVol");
            return (Criteria) this;
        }

        public Criteria andBatVolLessThan(Byte value) {
            addCriterion("bat_vol <", value, "batVol");
            return (Criteria) this;
        }

        public Criteria andBatVolLessThanOrEqualTo(Byte value) {
            addCriterion("bat_vol <=", value, "batVol");
            return (Criteria) this;
        }

        public Criteria andBatVolIn(List<Byte> values) {
            addCriterion("bat_vol in", values, "batVol");
            return (Criteria) this;
        }

        public Criteria andBatVolNotIn(List<Byte> values) {
            addCriterion("bat_vol not in", values, "batVol");
            return (Criteria) this;
        }

        public Criteria andBatVolBetween(Byte value1, Byte value2) {
            addCriterion("bat_vol between", value1, value2, "batVol");
            return (Criteria) this;
        }

        public Criteria andBatVolNotBetween(Byte value1, Byte value2) {
            addCriterion("bat_vol not between", value1, value2, "batVol");
            return (Criteria) this;
        }

        public Criteria andConfigChangedIsNull() {
            addCriterion("config_changed is null");
            return (Criteria) this;
        }

        public Criteria andConfigChangedIsNotNull() {
            addCriterion("config_changed is not null");
            return (Criteria) this;
        }

        public Criteria andConfigChangedEqualTo(Byte value) {
            addCriterion("config_changed =", value, "configChanged");
            return (Criteria) this;
        }

        public Criteria andConfigChangedNotEqualTo(Byte value) {
            addCriterion("config_changed <>", value, "configChanged");
            return (Criteria) this;
        }

        public Criteria andConfigChangedGreaterThan(Byte value) {
            addCriterion("config_changed >", value, "configChanged");
            return (Criteria) this;
        }

        public Criteria andConfigChangedGreaterThanOrEqualTo(Byte value) {
            addCriterion("config_changed >=", value, "configChanged");
            return (Criteria) this;
        }

        public Criteria andConfigChangedLessThan(Byte value) {
            addCriterion("config_changed <", value, "configChanged");
            return (Criteria) this;
        }

        public Criteria andConfigChangedLessThanOrEqualTo(Byte value) {
            addCriterion("config_changed <=", value, "configChanged");
            return (Criteria) this;
        }

        public Criteria andConfigChangedIn(List<Byte> values) {
            addCriterion("config_changed in", values, "configChanged");
            return (Criteria) this;
        }

        public Criteria andConfigChangedNotIn(List<Byte> values) {
            addCriterion("config_changed not in", values, "configChanged");
            return (Criteria) this;
        }

        public Criteria andConfigChangedBetween(Byte value1, Byte value2) {
            addCriterion("config_changed between", value1, value2, "configChanged");
            return (Criteria) this;
        }

        public Criteria andConfigChangedNotBetween(Byte value1, Byte value2) {
            addCriterion("config_changed not between", value1, value2, "configChanged");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("tel not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andLastChargeIsNull() {
            addCriterion("last_charge is null");
            return (Criteria) this;
        }

        public Criteria andLastChargeIsNotNull() {
            addCriterion("last_charge is not null");
            return (Criteria) this;
        }

        public Criteria andLastChargeEqualTo(Short value) {
            addCriterion("last_charge =", value, "lastCharge");
            return (Criteria) this;
        }

        public Criteria andLastChargeNotEqualTo(Short value) {
            addCriterion("last_charge <>", value, "lastCharge");
            return (Criteria) this;
        }

        public Criteria andLastChargeGreaterThan(Short value) {
            addCriterion("last_charge >", value, "lastCharge");
            return (Criteria) this;
        }

        public Criteria andLastChargeGreaterThanOrEqualTo(Short value) {
            addCriterion("last_charge >=", value, "lastCharge");
            return (Criteria) this;
        }

        public Criteria andLastChargeLessThan(Short value) {
            addCriterion("last_charge <", value, "lastCharge");
            return (Criteria) this;
        }

        public Criteria andLastChargeLessThanOrEqualTo(Short value) {
            addCriterion("last_charge <=", value, "lastCharge");
            return (Criteria) this;
        }

        public Criteria andLastChargeIn(List<Short> values) {
            addCriterion("last_charge in", values, "lastCharge");
            return (Criteria) this;
        }

        public Criteria andLastChargeNotIn(List<Short> values) {
            addCriterion("last_charge not in", values, "lastCharge");
            return (Criteria) this;
        }

        public Criteria andLastChargeBetween(Short value1, Short value2) {
            addCriterion("last_charge between", value1, value2, "lastCharge");
            return (Criteria) this;
        }

        public Criteria andLastChargeNotBetween(Short value1, Short value2) {
            addCriterion("last_charge not between", value1, value2, "lastCharge");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNull() {
            addCriterion("group_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("group_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(Integer value) {
            addCriterion("group_id =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(Integer value) {
            addCriterion("group_id <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(Integer value) {
            addCriterion("group_id >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("group_id >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(Integer value) {
            addCriterion("group_id <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("group_id <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<Integer> values) {
            addCriterion("group_id in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<Integer> values) {
            addCriterion("group_id not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(Integer value1, Integer value2) {
            addCriterion("group_id between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("group_id not between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdsIsNull() {
            addCriterion("group_ids is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdsIsNotNull() {
            addCriterion("group_ids is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdsEqualTo(String value) {
            addCriterion("group_ids =", value, "groupIds");
            return (Criteria) this;
        }

        public Criteria andGroupIdsNotEqualTo(String value) {
            addCriterion("group_ids <>", value, "groupIds");
            return (Criteria) this;
        }

        public Criteria andGroupIdsGreaterThan(String value) {
            addCriterion("group_ids >", value, "groupIds");
            return (Criteria) this;
        }

        public Criteria andGroupIdsGreaterThanOrEqualTo(String value) {
            addCriterion("group_ids >=", value, "groupIds");
            return (Criteria) this;
        }

        public Criteria andGroupIdsLessThan(String value) {
            addCriterion("group_ids <", value, "groupIds");
            return (Criteria) this;
        }

        public Criteria andGroupIdsLessThanOrEqualTo(String value) {
            addCriterion("group_ids <=", value, "groupIds");
            return (Criteria) this;
        }

        public Criteria andGroupIdsLike(String value) {
            addCriterion("group_ids like", value, "groupIds");
            return (Criteria) this;
        }

        public Criteria andGroupIdsNotLike(String value) {
            addCriterion("group_ids not like", value, "groupIds");
            return (Criteria) this;
        }

        public Criteria andGroupIdsIn(List<String> values) {
            addCriterion("group_ids in", values, "groupIds");
            return (Criteria) this;
        }

        public Criteria andGroupIdsNotIn(List<String> values) {
            addCriterion("group_ids not in", values, "groupIds");
            return (Criteria) this;
        }

        public Criteria andGroupIdsBetween(String value1, String value2) {
            addCriterion("group_ids between", value1, value2, "groupIds");
            return (Criteria) this;
        }

        public Criteria andGroupIdsNotBetween(String value1, String value2) {
            addCriterion("group_ids not between", value1, value2, "groupIds");
            return (Criteria) this;
        }

        public Criteria andTransIsNull() {
            addCriterion("trans is null");
            return (Criteria) this;
        }

        public Criteria andTransIsNotNull() {
            addCriterion("trans is not null");
            return (Criteria) this;
        }

        public Criteria andTransEqualTo(String value) {
            addCriterion("trans =", value, "trans");
            return (Criteria) this;
        }

        public Criteria andTransNotEqualTo(String value) {
            addCriterion("trans <>", value, "trans");
            return (Criteria) this;
        }

        public Criteria andTransGreaterThan(String value) {
            addCriterion("trans >", value, "trans");
            return (Criteria) this;
        }

        public Criteria andTransGreaterThanOrEqualTo(String value) {
            addCriterion("trans >=", value, "trans");
            return (Criteria) this;
        }

        public Criteria andTransLessThan(String value) {
            addCriterion("trans <", value, "trans");
            return (Criteria) this;
        }

        public Criteria andTransLessThanOrEqualTo(String value) {
            addCriterion("trans <=", value, "trans");
            return (Criteria) this;
        }

        public Criteria andTransLike(String value) {
            addCriterion("trans like", value, "trans");
            return (Criteria) this;
        }

        public Criteria andTransNotLike(String value) {
            addCriterion("trans not like", value, "trans");
            return (Criteria) this;
        }

        public Criteria andTransIn(List<String> values) {
            addCriterion("trans in", values, "trans");
            return (Criteria) this;
        }

        public Criteria andTransNotIn(List<String> values) {
            addCriterion("trans not in", values, "trans");
            return (Criteria) this;
        }

        public Criteria andTransBetween(String value1, String value2) {
            addCriterion("trans between", value1, value2, "trans");
            return (Criteria) this;
        }

        public Criteria andTransNotBetween(String value1, String value2) {
            addCriterion("trans not between", value1, value2, "trans");
            return (Criteria) this;
        }

        public Criteria andReceiveIsNull() {
            addCriterion("receive is null");
            return (Criteria) this;
        }

        public Criteria andReceiveIsNotNull() {
            addCriterion("receive is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveEqualTo(String value) {
            addCriterion("receive =", value, "receive");
            return (Criteria) this;
        }

        public Criteria andReceiveNotEqualTo(String value) {
            addCriterion("receive <>", value, "receive");
            return (Criteria) this;
        }

        public Criteria andReceiveGreaterThan(String value) {
            addCriterion("receive >", value, "receive");
            return (Criteria) this;
        }

        public Criteria andReceiveGreaterThanOrEqualTo(String value) {
            addCriterion("receive >=", value, "receive");
            return (Criteria) this;
        }

        public Criteria andReceiveLessThan(String value) {
            addCriterion("receive <", value, "receive");
            return (Criteria) this;
        }

        public Criteria andReceiveLessThanOrEqualTo(String value) {
            addCriterion("receive <=", value, "receive");
            return (Criteria) this;
        }

        public Criteria andReceiveLike(String value) {
            addCriterion("receive like", value, "receive");
            return (Criteria) this;
        }

        public Criteria andReceiveNotLike(String value) {
            addCriterion("receive not like", value, "receive");
            return (Criteria) this;
        }

        public Criteria andReceiveIn(List<String> values) {
            addCriterion("receive in", values, "receive");
            return (Criteria) this;
        }

        public Criteria andReceiveNotIn(List<String> values) {
            addCriterion("receive not in", values, "receive");
            return (Criteria) this;
        }

        public Criteria andReceiveBetween(String value1, String value2) {
            addCriterion("receive between", value1, value2, "receive");
            return (Criteria) this;
        }

        public Criteria andReceiveNotBetween(String value1, String value2) {
            addCriterion("receive not between", value1, value2, "receive");
            return (Criteria) this;
        }

        public Criteria andTtsIsNull() {
            addCriterion("tts is null");
            return (Criteria) this;
        }

        public Criteria andTtsIsNotNull() {
            addCriterion("tts is not null");
            return (Criteria) this;
        }

        public Criteria andTtsEqualTo(String value) {
            addCriterion("tts =", value, "tts");
            return (Criteria) this;
        }

        public Criteria andTtsNotEqualTo(String value) {
            addCriterion("tts <>", value, "tts");
            return (Criteria) this;
        }

        public Criteria andTtsGreaterThan(String value) {
            addCriterion("tts >", value, "tts");
            return (Criteria) this;
        }

        public Criteria andTtsGreaterThanOrEqualTo(String value) {
            addCriterion("tts >=", value, "tts");
            return (Criteria) this;
        }

        public Criteria andTtsLessThan(String value) {
            addCriterion("tts <", value, "tts");
            return (Criteria) this;
        }

        public Criteria andTtsLessThanOrEqualTo(String value) {
            addCriterion("tts <=", value, "tts");
            return (Criteria) this;
        }

        public Criteria andTtsLike(String value) {
            addCriterion("tts like", value, "tts");
            return (Criteria) this;
        }

        public Criteria andTtsNotLike(String value) {
            addCriterion("tts not like", value, "tts");
            return (Criteria) this;
        }

        public Criteria andTtsIn(List<String> values) {
            addCriterion("tts in", values, "tts");
            return (Criteria) this;
        }

        public Criteria andTtsNotIn(List<String> values) {
            addCriterion("tts not in", values, "tts");
            return (Criteria) this;
        }

        public Criteria andTtsBetween(String value1, String value2) {
            addCriterion("tts between", value1, value2, "tts");
            return (Criteria) this;
        }

        public Criteria andTtsNotBetween(String value1, String value2) {
            addCriterion("tts not between", value1, value2, "tts");
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