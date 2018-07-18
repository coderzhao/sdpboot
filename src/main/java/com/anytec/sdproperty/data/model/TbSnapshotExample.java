package com.anytec.sdproperty.data.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbSnapshotExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbSnapshotExample() {
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

        public Criteria andImagefileIsNull() {
            addCriterion("imagefile is null");
            return (Criteria) this;
        }

        public Criteria andImagefileIsNotNull() {
            addCriterion("imagefile is not null");
            return (Criteria) this;
        }

        public Criteria andImagefileEqualTo(String value) {
            addCriterion("imagefile =", value, "imagefile");
            return (Criteria) this;
        }

        public Criteria andImagefileNotEqualTo(String value) {
            addCriterion("imagefile <>", value, "imagefile");
            return (Criteria) this;
        }

        public Criteria andImagefileGreaterThan(String value) {
            addCriterion("imagefile >", value, "imagefile");
            return (Criteria) this;
        }

        public Criteria andImagefileGreaterThanOrEqualTo(String value) {
            addCriterion("imagefile >=", value, "imagefile");
            return (Criteria) this;
        }

        public Criteria andImagefileLessThan(String value) {
            addCriterion("imagefile <", value, "imagefile");
            return (Criteria) this;
        }

        public Criteria andImagefileLessThanOrEqualTo(String value) {
            addCriterion("imagefile <=", value, "imagefile");
            return (Criteria) this;
        }

        public Criteria andImagefileLike(String value) {
            addCriterion("imagefile like", value, "imagefile");
            return (Criteria) this;
        }

        public Criteria andImagefileNotLike(String value) {
            addCriterion("imagefile not like", value, "imagefile");
            return (Criteria) this;
        }

        public Criteria andImagefileIn(List<String> values) {
            addCriterion("imagefile in", values, "imagefile");
            return (Criteria) this;
        }

        public Criteria andImagefileNotIn(List<String> values) {
            addCriterion("imagefile not in", values, "imagefile");
            return (Criteria) this;
        }

        public Criteria andImagefileBetween(String value1, String value2) {
            addCriterion("imagefile between", value1, value2, "imagefile");
            return (Criteria) this;
        }

        public Criteria andImagefileNotBetween(String value1, String value2) {
            addCriterion("imagefile not between", value1, value2, "imagefile");
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

        public Criteria andIpcIdIsNull() {
            addCriterion("ipc_id is null");
            return (Criteria) this;
        }

        public Criteria andIpcIdIsNotNull() {
            addCriterion("ipc_id is not null");
            return (Criteria) this;
        }

        public Criteria andIpcIdEqualTo(Integer value) {
            addCriterion("ipc_id =", value, "ipcId");
            return (Criteria) this;
        }

        public Criteria andIpcIdNotEqualTo(Integer value) {
            addCriterion("ipc_id <>", value, "ipcId");
            return (Criteria) this;
        }

        public Criteria andIpcIdGreaterThan(Integer value) {
            addCriterion("ipc_id >", value, "ipcId");
            return (Criteria) this;
        }

        public Criteria andIpcIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ipc_id >=", value, "ipcId");
            return (Criteria) this;
        }

        public Criteria andIpcIdLessThan(Integer value) {
            addCriterion("ipc_id <", value, "ipcId");
            return (Criteria) this;
        }

        public Criteria andIpcIdLessThanOrEqualTo(Integer value) {
            addCriterion("ipc_id <=", value, "ipcId");
            return (Criteria) this;
        }

        public Criteria andIpcIdIn(List<Integer> values) {
            addCriterion("ipc_id in", values, "ipcId");
            return (Criteria) this;
        }

        public Criteria andIpcIdNotIn(List<Integer> values) {
            addCriterion("ipc_id not in", values, "ipcId");
            return (Criteria) this;
        }

        public Criteria andIpcIdBetween(Integer value1, Integer value2) {
            addCriterion("ipc_id between", value1, value2, "ipcId");
            return (Criteria) this;
        }

        public Criteria andIpcIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ipc_id not between", value1, value2, "ipcId");
            return (Criteria) this;
        }

        public Criteria andGuestCodeIsNull() {
            addCriterion("guest_code is null");
            return (Criteria) this;
        }

        public Criteria andGuestCodeIsNotNull() {
            addCriterion("guest_code is not null");
            return (Criteria) this;
        }

        public Criteria andGuestCodeEqualTo(String value) {
            addCriterion("guest_code =", value, "guestCode");
            return (Criteria) this;
        }

        public Criteria andGuestCodeNotEqualTo(String value) {
            addCriterion("guest_code <>", value, "guestCode");
            return (Criteria) this;
        }

        public Criteria andGuestCodeGreaterThan(String value) {
            addCriterion("guest_code >", value, "guestCode");
            return (Criteria) this;
        }

        public Criteria andGuestCodeGreaterThanOrEqualTo(String value) {
            addCriterion("guest_code >=", value, "guestCode");
            return (Criteria) this;
        }

        public Criteria andGuestCodeLessThan(String value) {
            addCriterion("guest_code <", value, "guestCode");
            return (Criteria) this;
        }

        public Criteria andGuestCodeLessThanOrEqualTo(String value) {
            addCriterion("guest_code <=", value, "guestCode");
            return (Criteria) this;
        }

        public Criteria andGuestCodeLike(String value) {
            addCriterion("guest_code like", value, "guestCode");
            return (Criteria) this;
        }

        public Criteria andGuestCodeNotLike(String value) {
            addCriterion("guest_code not like", value, "guestCode");
            return (Criteria) this;
        }

        public Criteria andGuestCodeIn(List<String> values) {
            addCriterion("guest_code in", values, "guestCode");
            return (Criteria) this;
        }

        public Criteria andGuestCodeNotIn(List<String> values) {
            addCriterion("guest_code not in", values, "guestCode");
            return (Criteria) this;
        }

        public Criteria andGuestCodeBetween(String value1, String value2) {
            addCriterion("guest_code between", value1, value2, "guestCode");
            return (Criteria) this;
        }

        public Criteria andGuestCodeNotBetween(String value1, String value2) {
            addCriterion("guest_code not between", value1, value2, "guestCode");
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