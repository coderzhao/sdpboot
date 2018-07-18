package com.anytec.sdproperty.data.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbIpcExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbIpcExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andDoorIdIsNull() {
            addCriterion("door_id is null");
            return (Criteria) this;
        }

        public Criteria andDoorIdIsNotNull() {
            addCriterion("door_id is not null");
            return (Criteria) this;
        }

        public Criteria andDoorIdEqualTo(Integer value) {
            addCriterion("door_id =", value, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdNotEqualTo(Integer value) {
            addCriterion("door_id <>", value, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdGreaterThan(Integer value) {
            addCriterion("door_id >", value, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("door_id >=", value, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdLessThan(Integer value) {
            addCriterion("door_id <", value, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdLessThanOrEqualTo(Integer value) {
            addCriterion("door_id <=", value, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdIn(List<Integer> values) {
            addCriterion("door_id in", values, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdNotIn(List<Integer> values) {
            addCriterion("door_id not in", values, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdBetween(Integer value1, Integer value2) {
            addCriterion("door_id between", value1, value2, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("door_id not between", value1, value2, "doorId");
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

        public Criteria andCameraIdIsNull() {
            addCriterion("camera_id is null");
            return (Criteria) this;
        }

        public Criteria andCameraIdIsNotNull() {
            addCriterion("camera_id is not null");
            return (Criteria) this;
        }

        public Criteria andCameraIdEqualTo(String value) {
            addCriterion("camera_id =", value, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdNotEqualTo(String value) {
            addCriterion("camera_id <>", value, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdGreaterThan(String value) {
            addCriterion("camera_id >", value, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdGreaterThanOrEqualTo(String value) {
            addCriterion("camera_id >=", value, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdLessThan(String value) {
            addCriterion("camera_id <", value, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdLessThanOrEqualTo(String value) {
            addCriterion("camera_id <=", value, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdLike(String value) {
            addCriterion("camera_id like", value, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdNotLike(String value) {
            addCriterion("camera_id not like", value, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdIn(List<String> values) {
            addCriterion("camera_id in", values, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdNotIn(List<String> values) {
            addCriterion("camera_id not in", values, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdBetween(String value1, String value2) {
            addCriterion("camera_id between", value1, value2, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdNotBetween(String value1, String value2) {
            addCriterion("camera_id not between", value1, value2, "cameraId");
            return (Criteria) this;
        }

        public Criteria andSnapTimestampIsNull() {
            addCriterion("snap_timestamp is null");
            return (Criteria) this;
        }

        public Criteria andSnapTimestampIsNotNull() {
            addCriterion("snap_timestamp is not null");
            return (Criteria) this;
        }

        public Criteria andSnapTimestampEqualTo(String value) {
            addCriterion("snap_timestamp =", value, "snapTimestamp");
            return (Criteria) this;
        }

        public Criteria andSnapTimestampNotEqualTo(String value) {
            addCriterion("snap_timestamp <>", value, "snapTimestamp");
            return (Criteria) this;
        }

        public Criteria andSnapTimestampGreaterThan(String value) {
            addCriterion("snap_timestamp >", value, "snapTimestamp");
            return (Criteria) this;
        }

        public Criteria andSnapTimestampGreaterThanOrEqualTo(String value) {
            addCriterion("snap_timestamp >=", value, "snapTimestamp");
            return (Criteria) this;
        }

        public Criteria andSnapTimestampLessThan(String value) {
            addCriterion("snap_timestamp <", value, "snapTimestamp");
            return (Criteria) this;
        }

        public Criteria andSnapTimestampLessThanOrEqualTo(String value) {
            addCriterion("snap_timestamp <=", value, "snapTimestamp");
            return (Criteria) this;
        }

        public Criteria andSnapTimestampLike(String value) {
            addCriterion("snap_timestamp like", value, "snapTimestamp");
            return (Criteria) this;
        }

        public Criteria andSnapTimestampNotLike(String value) {
            addCriterion("snap_timestamp not like", value, "snapTimestamp");
            return (Criteria) this;
        }

        public Criteria andSnapTimestampIn(List<String> values) {
            addCriterion("snap_timestamp in", values, "snapTimestamp");
            return (Criteria) this;
        }

        public Criteria andSnapTimestampNotIn(List<String> values) {
            addCriterion("snap_timestamp not in", values, "snapTimestamp");
            return (Criteria) this;
        }

        public Criteria andSnapTimestampBetween(String value1, String value2) {
            addCriterion("snap_timestamp between", value1, value2, "snapTimestamp");
            return (Criteria) this;
        }

        public Criteria andSnapTimestampNotBetween(String value1, String value2) {
            addCriterion("snap_timestamp not between", value1, value2, "snapTimestamp");
            return (Criteria) this;
        }

        public Criteria andNetaddressIsNull() {
            addCriterion("netaddress is null");
            return (Criteria) this;
        }

        public Criteria andNetaddressIsNotNull() {
            addCriterion("netaddress is not null");
            return (Criteria) this;
        }

        public Criteria andNetaddressEqualTo(String value) {
            addCriterion("netaddress =", value, "netaddress");
            return (Criteria) this;
        }

        public Criteria andNetaddressNotEqualTo(String value) {
            addCriterion("netaddress <>", value, "netaddress");
            return (Criteria) this;
        }

        public Criteria andNetaddressGreaterThan(String value) {
            addCriterion("netaddress >", value, "netaddress");
            return (Criteria) this;
        }

        public Criteria andNetaddressGreaterThanOrEqualTo(String value) {
            addCriterion("netaddress >=", value, "netaddress");
            return (Criteria) this;
        }

        public Criteria andNetaddressLessThan(String value) {
            addCriterion("netaddress <", value, "netaddress");
            return (Criteria) this;
        }

        public Criteria andNetaddressLessThanOrEqualTo(String value) {
            addCriterion("netaddress <=", value, "netaddress");
            return (Criteria) this;
        }

        public Criteria andNetaddressLike(String value) {
            addCriterion("netaddress like", value, "netaddress");
            return (Criteria) this;
        }

        public Criteria andNetaddressNotLike(String value) {
            addCriterion("netaddress not like", value, "netaddress");
            return (Criteria) this;
        }

        public Criteria andNetaddressIn(List<String> values) {
            addCriterion("netaddress in", values, "netaddress");
            return (Criteria) this;
        }

        public Criteria andNetaddressNotIn(List<String> values) {
            addCriterion("netaddress not in", values, "netaddress");
            return (Criteria) this;
        }

        public Criteria andNetaddressBetween(String value1, String value2) {
            addCriterion("netaddress between", value1, value2, "netaddress");
            return (Criteria) this;
        }

        public Criteria andNetaddressNotBetween(String value1, String value2) {
            addCriterion("netaddress not between", value1, value2, "netaddress");
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