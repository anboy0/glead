package com.kaicom.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BikeLocationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BikeLocationExample() {
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

        public Criteria andAltIsNull() {
            addCriterion("alt is null");
            return (Criteria) this;
        }

        public Criteria andAltIsNotNull() {
            addCriterion("alt is not null");
            return (Criteria) this;
        }

        public Criteria andAltEqualTo(Short value) {
            addCriterion("alt =", value, "alt");
            return (Criteria) this;
        }

        public Criteria andAltNotEqualTo(Short value) {
            addCriterion("alt <>", value, "alt");
            return (Criteria) this;
        }

        public Criteria andAltGreaterThan(Short value) {
            addCriterion("alt >", value, "alt");
            return (Criteria) this;
        }

        public Criteria andAltGreaterThanOrEqualTo(Short value) {
            addCriterion("alt >=", value, "alt");
            return (Criteria) this;
        }

        public Criteria andAltLessThan(Short value) {
            addCriterion("alt <", value, "alt");
            return (Criteria) this;
        }

        public Criteria andAltLessThanOrEqualTo(Short value) {
            addCriterion("alt <=", value, "alt");
            return (Criteria) this;
        }

        public Criteria andAltIn(List<Short> values) {
            addCriterion("alt in", values, "alt");
            return (Criteria) this;
        }

        public Criteria andAltNotIn(List<Short> values) {
            addCriterion("alt not in", values, "alt");
            return (Criteria) this;
        }

        public Criteria andAltBetween(Short value1, Short value2) {
            addCriterion("alt between", value1, value2, "alt");
            return (Criteria) this;
        }

        public Criteria andAltNotBetween(Short value1, Short value2) {
            addCriterion("alt not between", value1, value2, "alt");
            return (Criteria) this;
        }

        public Criteria andSpeedIsNull() {
            addCriterion("speed is null");
            return (Criteria) this;
        }

        public Criteria andSpeedIsNotNull() {
            addCriterion("speed is not null");
            return (Criteria) this;
        }

        public Criteria andSpeedEqualTo(Short value) {
            addCriterion("speed =", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedNotEqualTo(Short value) {
            addCriterion("speed <>", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedGreaterThan(Short value) {
            addCriterion("speed >", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedGreaterThanOrEqualTo(Short value) {
            addCriterion("speed >=", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedLessThan(Short value) {
            addCriterion("speed <", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedLessThanOrEqualTo(Short value) {
            addCriterion("speed <=", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedIn(List<Short> values) {
            addCriterion("speed in", values, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedNotIn(List<Short> values) {
            addCriterion("speed not in", values, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedBetween(Short value1, Short value2) {
            addCriterion("speed between", value1, value2, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedNotBetween(Short value1, Short value2) {
            addCriterion("speed not between", value1, value2, "speed");
            return (Criteria) this;
        }

        public Criteria andCourseIsNull() {
            addCriterion("course is null");
            return (Criteria) this;
        }

        public Criteria andCourseIsNotNull() {
            addCriterion("course is not null");
            return (Criteria) this;
        }

        public Criteria andCourseEqualTo(Short value) {
            addCriterion("course =", value, "course");
            return (Criteria) this;
        }

        public Criteria andCourseNotEqualTo(Short value) {
            addCriterion("course <>", value, "course");
            return (Criteria) this;
        }

        public Criteria andCourseGreaterThan(Short value) {
            addCriterion("course >", value, "course");
            return (Criteria) this;
        }

        public Criteria andCourseGreaterThanOrEqualTo(Short value) {
            addCriterion("course >=", value, "course");
            return (Criteria) this;
        }

        public Criteria andCourseLessThan(Short value) {
            addCriterion("course <", value, "course");
            return (Criteria) this;
        }

        public Criteria andCourseLessThanOrEqualTo(Short value) {
            addCriterion("course <=", value, "course");
            return (Criteria) this;
        }

        public Criteria andCourseIn(List<Short> values) {
            addCriterion("course in", values, "course");
            return (Criteria) this;
        }

        public Criteria andCourseNotIn(List<Short> values) {
            addCriterion("course not in", values, "course");
            return (Criteria) this;
        }

        public Criteria andCourseBetween(Short value1, Short value2) {
            addCriterion("course between", value1, value2, "course");
            return (Criteria) this;
        }

        public Criteria andCourseNotBetween(Short value1, Short value2) {
            addCriterion("course not between", value1, value2, "course");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andSignalDbIsNull() {
            addCriterion("signal_db is null");
            return (Criteria) this;
        }

        public Criteria andSignalDbIsNotNull() {
            addCriterion("signal_db is not null");
            return (Criteria) this;
        }

        public Criteria andSignalDbEqualTo(Byte value) {
            addCriterion("signal_db =", value, "signalDb");
            return (Criteria) this;
        }

        public Criteria andSignalDbNotEqualTo(Byte value) {
            addCriterion("signal_db <>", value, "signalDb");
            return (Criteria) this;
        }

        public Criteria andSignalDbGreaterThan(Byte value) {
            addCriterion("signal_db >", value, "signalDb");
            return (Criteria) this;
        }

        public Criteria andSignalDbGreaterThanOrEqualTo(Byte value) {
            addCriterion("signal_db >=", value, "signalDb");
            return (Criteria) this;
        }

        public Criteria andSignalDbLessThan(Byte value) {
            addCriterion("signal_db <", value, "signalDb");
            return (Criteria) this;
        }

        public Criteria andSignalDbLessThanOrEqualTo(Byte value) {
            addCriterion("signal_db <=", value, "signalDb");
            return (Criteria) this;
        }

        public Criteria andSignalDbIn(List<Byte> values) {
            addCriterion("signal_db in", values, "signalDb");
            return (Criteria) this;
        }

        public Criteria andSignalDbNotIn(List<Byte> values) {
            addCriterion("signal_db not in", values, "signalDb");
            return (Criteria) this;
        }

        public Criteria andSignalDbBetween(Byte value1, Byte value2) {
            addCriterion("signal_db between", value1, value2, "signalDb");
            return (Criteria) this;
        }

        public Criteria andSignalDbNotBetween(Byte value1, Byte value2) {
            addCriterion("signal_db not between", value1, value2, "signalDb");
            return (Criteria) this;
        }

        public Criteria andGnssIsNull() {
            addCriterion("gnss is null");
            return (Criteria) this;
        }

        public Criteria andGnssIsNotNull() {
            addCriterion("gnss is not null");
            return (Criteria) this;
        }

        public Criteria andGnssEqualTo(Byte value) {
            addCriterion("gnss =", value, "gnss");
            return (Criteria) this;
        }

        public Criteria andGnssNotEqualTo(Byte value) {
            addCriterion("gnss <>", value, "gnss");
            return (Criteria) this;
        }

        public Criteria andGnssGreaterThan(Byte value) {
            addCriterion("gnss >", value, "gnss");
            return (Criteria) this;
        }

        public Criteria andGnssGreaterThanOrEqualTo(Byte value) {
            addCriterion("gnss >=", value, "gnss");
            return (Criteria) this;
        }

        public Criteria andGnssLessThan(Byte value) {
            addCriterion("gnss <", value, "gnss");
            return (Criteria) this;
        }

        public Criteria andGnssLessThanOrEqualTo(Byte value) {
            addCriterion("gnss <=", value, "gnss");
            return (Criteria) this;
        }

        public Criteria andGnssIn(List<Byte> values) {
            addCriterion("gnss in", values, "gnss");
            return (Criteria) this;
        }

        public Criteria andGnssNotIn(List<Byte> values) {
            addCriterion("gnss not in", values, "gnss");
            return (Criteria) this;
        }

        public Criteria andGnssBetween(Byte value1, Byte value2) {
            addCriterion("gnss between", value1, value2, "gnss");
            return (Criteria) this;
        }

        public Criteria andGnssNotBetween(Byte value1, Byte value2) {
            addCriterion("gnss not between", value1, value2, "gnss");
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

        public Criteria andLockStatusEqualTo(Byte value) {
            addCriterion("lock_status =", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusNotEqualTo(Byte value) {
            addCriterion("lock_status <>", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusGreaterThan(Byte value) {
            addCriterion("lock_status >", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("lock_status >=", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusLessThan(Byte value) {
            addCriterion("lock_status <", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusLessThanOrEqualTo(Byte value) {
            addCriterion("lock_status <=", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusIn(List<Byte> values) {
            addCriterion("lock_status in", values, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusNotIn(List<Byte> values) {
            addCriterion("lock_status not in", values, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusBetween(Byte value1, Byte value2) {
            addCriterion("lock_status between", value1, value2, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("lock_status not between", value1, value2, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andUploadStatusIsNull() {
            addCriterion("upload_status is null");
            return (Criteria) this;
        }

        public Criteria andUploadStatusIsNotNull() {
            addCriterion("upload_status is not null");
            return (Criteria) this;
        }

        public Criteria andUploadStatusEqualTo(Byte value) {
            addCriterion("upload_status =", value, "uploadStatus");
            return (Criteria) this;
        }

        public Criteria andUploadStatusNotEqualTo(Byte value) {
            addCriterion("upload_status <>", value, "uploadStatus");
            return (Criteria) this;
        }

        public Criteria andUploadStatusGreaterThan(Byte value) {
            addCriterion("upload_status >", value, "uploadStatus");
            return (Criteria) this;
        }

        public Criteria andUploadStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("upload_status >=", value, "uploadStatus");
            return (Criteria) this;
        }

        public Criteria andUploadStatusLessThan(Byte value) {
            addCriterion("upload_status <", value, "uploadStatus");
            return (Criteria) this;
        }

        public Criteria andUploadStatusLessThanOrEqualTo(Byte value) {
            addCriterion("upload_status <=", value, "uploadStatus");
            return (Criteria) this;
        }

        public Criteria andUploadStatusIn(List<Byte> values) {
            addCriterion("upload_status in", values, "uploadStatus");
            return (Criteria) this;
        }

        public Criteria andUploadStatusNotIn(List<Byte> values) {
            addCriterion("upload_status not in", values, "uploadStatus");
            return (Criteria) this;
        }

        public Criteria andUploadStatusBetween(Byte value1, Byte value2) {
            addCriterion("upload_status between", value1, value2, "uploadStatus");
            return (Criteria) this;
        }

        public Criteria andUploadStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("upload_status not between", value1, value2, "uploadStatus");
            return (Criteria) this;
        }

        public Criteria andMccIsNull() {
            addCriterion("mcc is null");
            return (Criteria) this;
        }

        public Criteria andMccIsNotNull() {
            addCriterion("mcc is not null");
            return (Criteria) this;
        }

        public Criteria andMccEqualTo(Short value) {
            addCriterion("mcc =", value, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccNotEqualTo(Short value) {
            addCriterion("mcc <>", value, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccGreaterThan(Short value) {
            addCriterion("mcc >", value, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccGreaterThanOrEqualTo(Short value) {
            addCriterion("mcc >=", value, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccLessThan(Short value) {
            addCriterion("mcc <", value, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccLessThanOrEqualTo(Short value) {
            addCriterion("mcc <=", value, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccIn(List<Short> values) {
            addCriterion("mcc in", values, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccNotIn(List<Short> values) {
            addCriterion("mcc not in", values, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccBetween(Short value1, Short value2) {
            addCriterion("mcc between", value1, value2, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccNotBetween(Short value1, Short value2) {
            addCriterion("mcc not between", value1, value2, "mcc");
            return (Criteria) this;
        }

        public Criteria andMncIsNull() {
            addCriterion("mnc is null");
            return (Criteria) this;
        }

        public Criteria andMncIsNotNull() {
            addCriterion("mnc is not null");
            return (Criteria) this;
        }

        public Criteria andMncEqualTo(Short value) {
            addCriterion("mnc =", value, "mnc");
            return (Criteria) this;
        }

        public Criteria andMncNotEqualTo(Short value) {
            addCriterion("mnc <>", value, "mnc");
            return (Criteria) this;
        }

        public Criteria andMncGreaterThan(Short value) {
            addCriterion("mnc >", value, "mnc");
            return (Criteria) this;
        }

        public Criteria andMncGreaterThanOrEqualTo(Short value) {
            addCriterion("mnc >=", value, "mnc");
            return (Criteria) this;
        }

        public Criteria andMncLessThan(Short value) {
            addCriterion("mnc <", value, "mnc");
            return (Criteria) this;
        }

        public Criteria andMncLessThanOrEqualTo(Short value) {
            addCriterion("mnc <=", value, "mnc");
            return (Criteria) this;
        }

        public Criteria andMncIn(List<Short> values) {
            addCriterion("mnc in", values, "mnc");
            return (Criteria) this;
        }

        public Criteria andMncNotIn(List<Short> values) {
            addCriterion("mnc not in", values, "mnc");
            return (Criteria) this;
        }

        public Criteria andMncBetween(Short value1, Short value2) {
            addCriterion("mnc between", value1, value2, "mnc");
            return (Criteria) this;
        }

        public Criteria andMncNotBetween(Short value1, Short value2) {
            addCriterion("mnc not between", value1, value2, "mnc");
            return (Criteria) this;
        }

        public Criteria andLacIsNull() {
            addCriterion("lac is null");
            return (Criteria) this;
        }

        public Criteria andLacIsNotNull() {
            addCriterion("lac is not null");
            return (Criteria) this;
        }

        public Criteria andLacEqualTo(String value) {
            addCriterion("lac =", value, "lac");
            return (Criteria) this;
        }

        public Criteria andLacNotEqualTo(String value) {
            addCriterion("lac <>", value, "lac");
            return (Criteria) this;
        }

        public Criteria andLacGreaterThan(String value) {
            addCriterion("lac >", value, "lac");
            return (Criteria) this;
        }

        public Criteria andLacGreaterThanOrEqualTo(String value) {
            addCriterion("lac >=", value, "lac");
            return (Criteria) this;
        }

        public Criteria andLacLessThan(String value) {
            addCriterion("lac <", value, "lac");
            return (Criteria) this;
        }

        public Criteria andLacLessThanOrEqualTo(String value) {
            addCriterion("lac <=", value, "lac");
            return (Criteria) this;
        }

        public Criteria andLacLike(String value) {
            addCriterion("lac like", value, "lac");
            return (Criteria) this;
        }

        public Criteria andLacNotLike(String value) {
            addCriterion("lac not like", value, "lac");
            return (Criteria) this;
        }

        public Criteria andLacIn(List<String> values) {
            addCriterion("lac in", values, "lac");
            return (Criteria) this;
        }

        public Criteria andLacNotIn(List<String> values) {
            addCriterion("lac not in", values, "lac");
            return (Criteria) this;
        }

        public Criteria andLacBetween(String value1, String value2) {
            addCriterion("lac between", value1, value2, "lac");
            return (Criteria) this;
        }

        public Criteria andLacNotBetween(String value1, String value2) {
            addCriterion("lac not between", value1, value2, "lac");
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

        public Criteria andAlarmIsNull() {
            addCriterion("alarm is null");
            return (Criteria) this;
        }

        public Criteria andAlarmIsNotNull() {
            addCriterion("alarm is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmEqualTo(String value) {
            addCriterion("alarm =", value, "alarm");
            return (Criteria) this;
        }

        public Criteria andAlarmNotEqualTo(String value) {
            addCriterion("alarm <>", value, "alarm");
            return (Criteria) this;
        }

        public Criteria andAlarmGreaterThan(String value) {
            addCriterion("alarm >", value, "alarm");
            return (Criteria) this;
        }

        public Criteria andAlarmGreaterThanOrEqualTo(String value) {
            addCriterion("alarm >=", value, "alarm");
            return (Criteria) this;
        }

        public Criteria andAlarmLessThan(String value) {
            addCriterion("alarm <", value, "alarm");
            return (Criteria) this;
        }

        public Criteria andAlarmLessThanOrEqualTo(String value) {
            addCriterion("alarm <=", value, "alarm");
            return (Criteria) this;
        }

        public Criteria andAlarmLike(String value) {
            addCriterion("alarm like", value, "alarm");
            return (Criteria) this;
        }

        public Criteria andAlarmNotLike(String value) {
            addCriterion("alarm not like", value, "alarm");
            return (Criteria) this;
        }

        public Criteria andAlarmIn(List<String> values) {
            addCriterion("alarm in", values, "alarm");
            return (Criteria) this;
        }

        public Criteria andAlarmNotIn(List<String> values) {
            addCriterion("alarm not in", values, "alarm");
            return (Criteria) this;
        }

        public Criteria andAlarmBetween(String value1, String value2) {
            addCriterion("alarm between", value1, value2, "alarm");
            return (Criteria) this;
        }

        public Criteria andAlarmNotBetween(String value1, String value2) {
            addCriterion("alarm not between", value1, value2, "alarm");
            return (Criteria) this;
        }

        public Criteria andGpsStatusIsNull() {
            addCriterion("gps_status is null");
            return (Criteria) this;
        }

        public Criteria andGpsStatusIsNotNull() {
            addCriterion("gps_status is not null");
            return (Criteria) this;
        }

        public Criteria andGpsStatusEqualTo(String value) {
            addCriterion("gps_status =", value, "gpsStatus");
            return (Criteria) this;
        }

        public Criteria andGpsStatusNotEqualTo(String value) {
            addCriterion("gps_status <>", value, "gpsStatus");
            return (Criteria) this;
        }

        public Criteria andGpsStatusGreaterThan(String value) {
            addCriterion("gps_status >", value, "gpsStatus");
            return (Criteria) this;
        }

        public Criteria andGpsStatusGreaterThanOrEqualTo(String value) {
            addCriterion("gps_status >=", value, "gpsStatus");
            return (Criteria) this;
        }

        public Criteria andGpsStatusLessThan(String value) {
            addCriterion("gps_status <", value, "gpsStatus");
            return (Criteria) this;
        }

        public Criteria andGpsStatusLessThanOrEqualTo(String value) {
            addCriterion("gps_status <=", value, "gpsStatus");
            return (Criteria) this;
        }

        public Criteria andGpsStatusLike(String value) {
            addCriterion("gps_status like", value, "gpsStatus");
            return (Criteria) this;
        }

        public Criteria andGpsStatusNotLike(String value) {
            addCriterion("gps_status not like", value, "gpsStatus");
            return (Criteria) this;
        }

        public Criteria andGpsStatusIn(List<String> values) {
            addCriterion("gps_status in", values, "gpsStatus");
            return (Criteria) this;
        }

        public Criteria andGpsStatusNotIn(List<String> values) {
            addCriterion("gps_status not in", values, "gpsStatus");
            return (Criteria) this;
        }

        public Criteria andGpsStatusBetween(String value1, String value2) {
            addCriterion("gps_status between", value1, value2, "gpsStatus");
            return (Criteria) this;
        }

        public Criteria andGpsStatusNotBetween(String value1, String value2) {
            addCriterion("gps_status not between", value1, value2, "gpsStatus");
            return (Criteria) this;
        }

        public Criteria andCnIsNull() {
            addCriterion("cn is null");
            return (Criteria) this;
        }

        public Criteria andCnIsNotNull() {
            addCriterion("cn is not null");
            return (Criteria) this;
        }

        public Criteria andCnEqualTo(Short value) {
            addCriterion("cn =", value, "cn");
            return (Criteria) this;
        }

        public Criteria andCnNotEqualTo(Short value) {
            addCriterion("cn <>", value, "cn");
            return (Criteria) this;
        }

        public Criteria andCnGreaterThan(Short value) {
            addCriterion("cn >", value, "cn");
            return (Criteria) this;
        }

        public Criteria andCnGreaterThanOrEqualTo(Short value) {
            addCriterion("cn >=", value, "cn");
            return (Criteria) this;
        }

        public Criteria andCnLessThan(Short value) {
            addCriterion("cn <", value, "cn");
            return (Criteria) this;
        }

        public Criteria andCnLessThanOrEqualTo(Short value) {
            addCriterion("cn <=", value, "cn");
            return (Criteria) this;
        }

        public Criteria andCnIn(List<Short> values) {
            addCriterion("cn in", values, "cn");
            return (Criteria) this;
        }

        public Criteria andCnNotIn(List<Short> values) {
            addCriterion("cn not in", values, "cn");
            return (Criteria) this;
        }

        public Criteria andCnBetween(Short value1, Short value2) {
            addCriterion("cn between", value1, value2, "cn");
            return (Criteria) this;
        }

        public Criteria andCnNotBetween(Short value1, Short value2) {
            addCriterion("cn not between", value1, value2, "cn");
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