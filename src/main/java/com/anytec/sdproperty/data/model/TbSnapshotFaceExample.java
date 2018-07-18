package com.anytec.sdproperty.data.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbSnapshotFaceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbSnapshotFaceExample() {
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

        public Criteria andSnapshotIdIsNull() {
            addCriterion("snapshot_id is null");
            return (Criteria) this;
        }

        public Criteria andSnapshotIdIsNotNull() {
            addCriterion("snapshot_id is not null");
            return (Criteria) this;
        }

        public Criteria andSnapshotIdEqualTo(Integer value) {
            addCriterion("snapshot_id =", value, "snapshotId");
            return (Criteria) this;
        }

        public Criteria andSnapshotIdNotEqualTo(Integer value) {
            addCriterion("snapshot_id <>", value, "snapshotId");
            return (Criteria) this;
        }

        public Criteria andSnapshotIdGreaterThan(Integer value) {
            addCriterion("snapshot_id >", value, "snapshotId");
            return (Criteria) this;
        }

        public Criteria andSnapshotIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("snapshot_id >=", value, "snapshotId");
            return (Criteria) this;
        }

        public Criteria andSnapshotIdLessThan(Integer value) {
            addCriterion("snapshot_id <", value, "snapshotId");
            return (Criteria) this;
        }

        public Criteria andSnapshotIdLessThanOrEqualTo(Integer value) {
            addCriterion("snapshot_id <=", value, "snapshotId");
            return (Criteria) this;
        }

        public Criteria andSnapshotIdIn(List<Integer> values) {
            addCriterion("snapshot_id in", values, "snapshotId");
            return (Criteria) this;
        }

        public Criteria andSnapshotIdNotIn(List<Integer> values) {
            addCriterion("snapshot_id not in", values, "snapshotId");
            return (Criteria) this;
        }

        public Criteria andSnapshotIdBetween(Integer value1, Integer value2) {
            addCriterion("snapshot_id between", value1, value2, "snapshotId");
            return (Criteria) this;
        }

        public Criteria andSnapshotIdNotBetween(Integer value1, Integer value2) {
            addCriterion("snapshot_id not between", value1, value2, "snapshotId");
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

        public Criteria andGalleriesIsNull() {
            addCriterion("galleries is null");
            return (Criteria) this;
        }

        public Criteria andGalleriesIsNotNull() {
            addCriterion("galleries is not null");
            return (Criteria) this;
        }

        public Criteria andGalleriesEqualTo(String value) {
            addCriterion("galleries =", value, "galleries");
            return (Criteria) this;
        }

        public Criteria andGalleriesNotEqualTo(String value) {
            addCriterion("galleries <>", value, "galleries");
            return (Criteria) this;
        }

        public Criteria andGalleriesGreaterThan(String value) {
            addCriterion("galleries >", value, "galleries");
            return (Criteria) this;
        }

        public Criteria andGalleriesGreaterThanOrEqualTo(String value) {
            addCriterion("galleries >=", value, "galleries");
            return (Criteria) this;
        }

        public Criteria andGalleriesLessThan(String value) {
            addCriterion("galleries <", value, "galleries");
            return (Criteria) this;
        }

        public Criteria andGalleriesLessThanOrEqualTo(String value) {
            addCriterion("galleries <=", value, "galleries");
            return (Criteria) this;
        }

        public Criteria andGalleriesLike(String value) {
            addCriterion("galleries like", value, "galleries");
            return (Criteria) this;
        }

        public Criteria andGalleriesNotLike(String value) {
            addCriterion("galleries not like", value, "galleries");
            return (Criteria) this;
        }

        public Criteria andGalleriesIn(List<String> values) {
            addCriterion("galleries in", values, "galleries");
            return (Criteria) this;
        }

        public Criteria andGalleriesNotIn(List<String> values) {
            addCriterion("galleries not in", values, "galleries");
            return (Criteria) this;
        }

        public Criteria andGalleriesBetween(String value1, String value2) {
            addCriterion("galleries between", value1, value2, "galleries");
            return (Criteria) this;
        }

        public Criteria andGalleriesNotBetween(String value1, String value2) {
            addCriterion("galleries not between", value1, value2, "galleries");
            return (Criteria) this;
        }

        public Criteria andMetaIsNull() {
            addCriterion("meta is null");
            return (Criteria) this;
        }

        public Criteria andMetaIsNotNull() {
            addCriterion("meta is not null");
            return (Criteria) this;
        }

        public Criteria andMetaEqualTo(String value) {
            addCriterion("meta =", value, "meta");
            return (Criteria) this;
        }

        public Criteria andMetaNotEqualTo(String value) {
            addCriterion("meta <>", value, "meta");
            return (Criteria) this;
        }

        public Criteria andMetaGreaterThan(String value) {
            addCriterion("meta >", value, "meta");
            return (Criteria) this;
        }

        public Criteria andMetaGreaterThanOrEqualTo(String value) {
            addCriterion("meta >=", value, "meta");
            return (Criteria) this;
        }

        public Criteria andMetaLessThan(String value) {
            addCriterion("meta <", value, "meta");
            return (Criteria) this;
        }

        public Criteria andMetaLessThanOrEqualTo(String value) {
            addCriterion("meta <=", value, "meta");
            return (Criteria) this;
        }

        public Criteria andMetaLike(String value) {
            addCriterion("meta like", value, "meta");
            return (Criteria) this;
        }

        public Criteria andMetaNotLike(String value) {
            addCriterion("meta not like", value, "meta");
            return (Criteria) this;
        }

        public Criteria andMetaIn(List<String> values) {
            addCriterion("meta in", values, "meta");
            return (Criteria) this;
        }

        public Criteria andMetaNotIn(List<String> values) {
            addCriterion("meta not in", values, "meta");
            return (Criteria) this;
        }

        public Criteria andMetaBetween(String value1, String value2) {
            addCriterion("meta between", value1, value2, "meta");
            return (Criteria) this;
        }

        public Criteria andMetaNotBetween(String value1, String value2) {
            addCriterion("meta not between", value1, value2, "meta");
            return (Criteria) this;
        }

        public Criteria andPhotoIsNull() {
            addCriterion("photo is null");
            return (Criteria) this;
        }

        public Criteria andPhotoIsNotNull() {
            addCriterion("photo is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoEqualTo(String value) {
            addCriterion("photo =", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotEqualTo(String value) {
            addCriterion("photo <>", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThan(String value) {
            addCriterion("photo >", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("photo >=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThan(String value) {
            addCriterion("photo <", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThanOrEqualTo(String value) {
            addCriterion("photo <=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLike(String value) {
            addCriterion("photo like", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotLike(String value) {
            addCriterion("photo not like", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoIn(List<String> values) {
            addCriterion("photo in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotIn(List<String> values) {
            addCriterion("photo not in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoBetween(String value1, String value2) {
            addCriterion("photo between", value1, value2, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotBetween(String value1, String value2) {
            addCriterion("photo not between", value1, value2, "photo");
            return (Criteria) this;
        }

        public Criteria andTimestampIsNull() {
            addCriterion("timestamp is null");
            return (Criteria) this;
        }

        public Criteria andTimestampIsNotNull() {
            addCriterion("timestamp is not null");
            return (Criteria) this;
        }

        public Criteria andTimestampEqualTo(Date value) {
            addCriterion("timestamp =", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotEqualTo(Date value) {
            addCriterion("timestamp <>", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampGreaterThan(Date value) {
            addCriterion("timestamp >", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampGreaterThanOrEqualTo(Date value) {
            addCriterion("timestamp >=", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampLessThan(Date value) {
            addCriterion("timestamp <", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampLessThanOrEqualTo(Date value) {
            addCriterion("timestamp <=", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampIn(List<Date> values) {
            addCriterion("timestamp in", values, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotIn(List<Date> values) {
            addCriterion("timestamp not in", values, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampBetween(Date value1, Date value2) {
            addCriterion("timestamp between", value1, value2, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotBetween(Date value1, Date value2) {
            addCriterion("timestamp not between", value1, value2, "timestamp");
            return (Criteria) this;
        }

        public Criteria andX1IsNull() {
            addCriterion("x1 is null");
            return (Criteria) this;
        }

        public Criteria andX1IsNotNull() {
            addCriterion("x1 is not null");
            return (Criteria) this;
        }

        public Criteria andX1EqualTo(Integer value) {
            addCriterion("x1 =", value, "x1");
            return (Criteria) this;
        }

        public Criteria andX1NotEqualTo(Integer value) {
            addCriterion("x1 <>", value, "x1");
            return (Criteria) this;
        }

        public Criteria andX1GreaterThan(Integer value) {
            addCriterion("x1 >", value, "x1");
            return (Criteria) this;
        }

        public Criteria andX1GreaterThanOrEqualTo(Integer value) {
            addCriterion("x1 >=", value, "x1");
            return (Criteria) this;
        }

        public Criteria andX1LessThan(Integer value) {
            addCriterion("x1 <", value, "x1");
            return (Criteria) this;
        }

        public Criteria andX1LessThanOrEqualTo(Integer value) {
            addCriterion("x1 <=", value, "x1");
            return (Criteria) this;
        }

        public Criteria andX1In(List<Integer> values) {
            addCriterion("x1 in", values, "x1");
            return (Criteria) this;
        }

        public Criteria andX1NotIn(List<Integer> values) {
            addCriterion("x1 not in", values, "x1");
            return (Criteria) this;
        }

        public Criteria andX1Between(Integer value1, Integer value2) {
            addCriterion("x1 between", value1, value2, "x1");
            return (Criteria) this;
        }

        public Criteria andX1NotBetween(Integer value1, Integer value2) {
            addCriterion("x1 not between", value1, value2, "x1");
            return (Criteria) this;
        }

        public Criteria andX2IsNull() {
            addCriterion("x2 is null");
            return (Criteria) this;
        }

        public Criteria andX2IsNotNull() {
            addCriterion("x2 is not null");
            return (Criteria) this;
        }

        public Criteria andX2EqualTo(Integer value) {
            addCriterion("x2 =", value, "x2");
            return (Criteria) this;
        }

        public Criteria andX2NotEqualTo(Integer value) {
            addCriterion("x2 <>", value, "x2");
            return (Criteria) this;
        }

        public Criteria andX2GreaterThan(Integer value) {
            addCriterion("x2 >", value, "x2");
            return (Criteria) this;
        }

        public Criteria andX2GreaterThanOrEqualTo(Integer value) {
            addCriterion("x2 >=", value, "x2");
            return (Criteria) this;
        }

        public Criteria andX2LessThan(Integer value) {
            addCriterion("x2 <", value, "x2");
            return (Criteria) this;
        }

        public Criteria andX2LessThanOrEqualTo(Integer value) {
            addCriterion("x2 <=", value, "x2");
            return (Criteria) this;
        }

        public Criteria andX2In(List<Integer> values) {
            addCriterion("x2 in", values, "x2");
            return (Criteria) this;
        }

        public Criteria andX2NotIn(List<Integer> values) {
            addCriterion("x2 not in", values, "x2");
            return (Criteria) this;
        }

        public Criteria andX2Between(Integer value1, Integer value2) {
            addCriterion("x2 between", value1, value2, "x2");
            return (Criteria) this;
        }

        public Criteria andX2NotBetween(Integer value1, Integer value2) {
            addCriterion("x2 not between", value1, value2, "x2");
            return (Criteria) this;
        }

        public Criteria andY1IsNull() {
            addCriterion("y1 is null");
            return (Criteria) this;
        }

        public Criteria andY1IsNotNull() {
            addCriterion("y1 is not null");
            return (Criteria) this;
        }

        public Criteria andY1EqualTo(Integer value) {
            addCriterion("y1 =", value, "y1");
            return (Criteria) this;
        }

        public Criteria andY1NotEqualTo(Integer value) {
            addCriterion("y1 <>", value, "y1");
            return (Criteria) this;
        }

        public Criteria andY1GreaterThan(Integer value) {
            addCriterion("y1 >", value, "y1");
            return (Criteria) this;
        }

        public Criteria andY1GreaterThanOrEqualTo(Integer value) {
            addCriterion("y1 >=", value, "y1");
            return (Criteria) this;
        }

        public Criteria andY1LessThan(Integer value) {
            addCriterion("y1 <", value, "y1");
            return (Criteria) this;
        }

        public Criteria andY1LessThanOrEqualTo(Integer value) {
            addCriterion("y1 <=", value, "y1");
            return (Criteria) this;
        }

        public Criteria andY1In(List<Integer> values) {
            addCriterion("y1 in", values, "y1");
            return (Criteria) this;
        }

        public Criteria andY1NotIn(List<Integer> values) {
            addCriterion("y1 not in", values, "y1");
            return (Criteria) this;
        }

        public Criteria andY1Between(Integer value1, Integer value2) {
            addCriterion("y1 between", value1, value2, "y1");
            return (Criteria) this;
        }

        public Criteria andY1NotBetween(Integer value1, Integer value2) {
            addCriterion("y1 not between", value1, value2, "y1");
            return (Criteria) this;
        }

        public Criteria andY2IsNull() {
            addCriterion("y2 is null");
            return (Criteria) this;
        }

        public Criteria andY2IsNotNull() {
            addCriterion("y2 is not null");
            return (Criteria) this;
        }

        public Criteria andY2EqualTo(Integer value) {
            addCriterion("y2 =", value, "y2");
            return (Criteria) this;
        }

        public Criteria andY2NotEqualTo(Integer value) {
            addCriterion("y2 <>", value, "y2");
            return (Criteria) this;
        }

        public Criteria andY2GreaterThan(Integer value) {
            addCriterion("y2 >", value, "y2");
            return (Criteria) this;
        }

        public Criteria andY2GreaterThanOrEqualTo(Integer value) {
            addCriterion("y2 >=", value, "y2");
            return (Criteria) this;
        }

        public Criteria andY2LessThan(Integer value) {
            addCriterion("y2 <", value, "y2");
            return (Criteria) this;
        }

        public Criteria andY2LessThanOrEqualTo(Integer value) {
            addCriterion("y2 <=", value, "y2");
            return (Criteria) this;
        }

        public Criteria andY2In(List<Integer> values) {
            addCriterion("y2 in", values, "y2");
            return (Criteria) this;
        }

        public Criteria andY2NotIn(List<Integer> values) {
            addCriterion("y2 not in", values, "y2");
            return (Criteria) this;
        }

        public Criteria andY2Between(Integer value1, Integer value2) {
            addCriterion("y2 between", value1, value2, "y2");
            return (Criteria) this;
        }

        public Criteria andY2NotBetween(Integer value1, Integer value2) {
            addCriterion("y2 not between", value1, value2, "y2");
            return (Criteria) this;
        }

        public Criteria andNormalizedIsNull() {
            addCriterion("normalized is null");
            return (Criteria) this;
        }

        public Criteria andNormalizedIsNotNull() {
            addCriterion("normalized is not null");
            return (Criteria) this;
        }

        public Criteria andNormalizedEqualTo(String value) {
            addCriterion("normalized =", value, "normalized");
            return (Criteria) this;
        }

        public Criteria andNormalizedNotEqualTo(String value) {
            addCriterion("normalized <>", value, "normalized");
            return (Criteria) this;
        }

        public Criteria andNormalizedGreaterThan(String value) {
            addCriterion("normalized >", value, "normalized");
            return (Criteria) this;
        }

        public Criteria andNormalizedGreaterThanOrEqualTo(String value) {
            addCriterion("normalized >=", value, "normalized");
            return (Criteria) this;
        }

        public Criteria andNormalizedLessThan(String value) {
            addCriterion("normalized <", value, "normalized");
            return (Criteria) this;
        }

        public Criteria andNormalizedLessThanOrEqualTo(String value) {
            addCriterion("normalized <=", value, "normalized");
            return (Criteria) this;
        }

        public Criteria andNormalizedLike(String value) {
            addCriterion("normalized like", value, "normalized");
            return (Criteria) this;
        }

        public Criteria andNormalizedNotLike(String value) {
            addCriterion("normalized not like", value, "normalized");
            return (Criteria) this;
        }

        public Criteria andNormalizedIn(List<String> values) {
            addCriterion("normalized in", values, "normalized");
            return (Criteria) this;
        }

        public Criteria andNormalizedNotIn(List<String> values) {
            addCriterion("normalized not in", values, "normalized");
            return (Criteria) this;
        }

        public Criteria andNormalizedBetween(String value1, String value2) {
            addCriterion("normalized between", value1, value2, "normalized");
            return (Criteria) this;
        }

        public Criteria andNormalizedNotBetween(String value1, String value2) {
            addCriterion("normalized not between", value1, value2, "normalized");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Integer value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Integer value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Integer value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Integer value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Integer> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Integer> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andThumbnailIsNull() {
            addCriterion("thumbnail is null");
            return (Criteria) this;
        }

        public Criteria andThumbnailIsNotNull() {
            addCriterion("thumbnail is not null");
            return (Criteria) this;
        }

        public Criteria andThumbnailEqualTo(String value) {
            addCriterion("thumbnail =", value, "thumbnail");
            return (Criteria) this;
        }

        public Criteria andThumbnailNotEqualTo(String value) {
            addCriterion("thumbnail <>", value, "thumbnail");
            return (Criteria) this;
        }

        public Criteria andThumbnailGreaterThan(String value) {
            addCriterion("thumbnail >", value, "thumbnail");
            return (Criteria) this;
        }

        public Criteria andThumbnailGreaterThanOrEqualTo(String value) {
            addCriterion("thumbnail >=", value, "thumbnail");
            return (Criteria) this;
        }

        public Criteria andThumbnailLessThan(String value) {
            addCriterion("thumbnail <", value, "thumbnail");
            return (Criteria) this;
        }

        public Criteria andThumbnailLessThanOrEqualTo(String value) {
            addCriterion("thumbnail <=", value, "thumbnail");
            return (Criteria) this;
        }

        public Criteria andThumbnailLike(String value) {
            addCriterion("thumbnail like", value, "thumbnail");
            return (Criteria) this;
        }

        public Criteria andThumbnailNotLike(String value) {
            addCriterion("thumbnail not like", value, "thumbnail");
            return (Criteria) this;
        }

        public Criteria andThumbnailIn(List<String> values) {
            addCriterion("thumbnail in", values, "thumbnail");
            return (Criteria) this;
        }

        public Criteria andThumbnailNotIn(List<String> values) {
            addCriterion("thumbnail not in", values, "thumbnail");
            return (Criteria) this;
        }

        public Criteria andThumbnailBetween(String value1, String value2) {
            addCriterion("thumbnail between", value1, value2, "thumbnail");
            return (Criteria) this;
        }

        public Criteria andThumbnailNotBetween(String value1, String value2) {
            addCriterion("thumbnail not between", value1, value2, "thumbnail");
            return (Criteria) this;
        }

        public Criteria andPhotoHashIsNull() {
            addCriterion("photo_hash is null");
            return (Criteria) this;
        }

        public Criteria andPhotoHashIsNotNull() {
            addCriterion("photo_hash is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoHashEqualTo(String value) {
            addCriterion("photo_hash =", value, "photoHash");
            return (Criteria) this;
        }

        public Criteria andPhotoHashNotEqualTo(String value) {
            addCriterion("photo_hash <>", value, "photoHash");
            return (Criteria) this;
        }

        public Criteria andPhotoHashGreaterThan(String value) {
            addCriterion("photo_hash >", value, "photoHash");
            return (Criteria) this;
        }

        public Criteria andPhotoHashGreaterThanOrEqualTo(String value) {
            addCriterion("photo_hash >=", value, "photoHash");
            return (Criteria) this;
        }

        public Criteria andPhotoHashLessThan(String value) {
            addCriterion("photo_hash <", value, "photoHash");
            return (Criteria) this;
        }

        public Criteria andPhotoHashLessThanOrEqualTo(String value) {
            addCriterion("photo_hash <=", value, "photoHash");
            return (Criteria) this;
        }

        public Criteria andPhotoHashLike(String value) {
            addCriterion("photo_hash like", value, "photoHash");
            return (Criteria) this;
        }

        public Criteria andPhotoHashNotLike(String value) {
            addCriterion("photo_hash not like", value, "photoHash");
            return (Criteria) this;
        }

        public Criteria andPhotoHashIn(List<String> values) {
            addCriterion("photo_hash in", values, "photoHash");
            return (Criteria) this;
        }

        public Criteria andPhotoHashNotIn(List<String> values) {
            addCriterion("photo_hash not in", values, "photoHash");
            return (Criteria) this;
        }

        public Criteria andPhotoHashBetween(String value1, String value2) {
            addCriterion("photo_hash between", value1, value2, "photoHash");
            return (Criteria) this;
        }

        public Criteria andPhotoHashNotBetween(String value1, String value2) {
            addCriterion("photo_hash not between", value1, value2, "photoHash");
            return (Criteria) this;
        }

        public Criteria andPersonIdIsNull() {
            addCriterion("person_id is null");
            return (Criteria) this;
        }

        public Criteria andPersonIdIsNotNull() {
            addCriterion("person_id is not null");
            return (Criteria) this;
        }

        public Criteria andPersonIdEqualTo(Integer value) {
            addCriterion("person_id =", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotEqualTo(Integer value) {
            addCriterion("person_id <>", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdGreaterThan(Integer value) {
            addCriterion("person_id >", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("person_id >=", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdLessThan(Integer value) {
            addCriterion("person_id <", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdLessThanOrEqualTo(Integer value) {
            addCriterion("person_id <=", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdIn(List<Integer> values) {
            addCriterion("person_id in", values, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotIn(List<Integer> values) {
            addCriterion("person_id not in", values, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdBetween(Integer value1, Integer value2) {
            addCriterion("person_id between", value1, value2, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotBetween(Integer value1, Integer value2) {
            addCriterion("person_id not between", value1, value2, "personId");
            return (Criteria) this;
        }

        public Criteria andFaceIdIsNull() {
            addCriterion("face_id is null");
            return (Criteria) this;
        }

        public Criteria andFaceIdIsNotNull() {
            addCriterion("face_id is not null");
            return (Criteria) this;
        }

        public Criteria andFaceIdEqualTo(Long value) {
            addCriterion("face_id =", value, "faceId");
            return (Criteria) this;
        }

        public Criteria andFaceIdNotEqualTo(Long value) {
            addCriterion("face_id <>", value, "faceId");
            return (Criteria) this;
        }

        public Criteria andFaceIdGreaterThan(Long value) {
            addCriterion("face_id >", value, "faceId");
            return (Criteria) this;
        }

        public Criteria andFaceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("face_id >=", value, "faceId");
            return (Criteria) this;
        }

        public Criteria andFaceIdLessThan(Long value) {
            addCriterion("face_id <", value, "faceId");
            return (Criteria) this;
        }

        public Criteria andFaceIdLessThanOrEqualTo(Long value) {
            addCriterion("face_id <=", value, "faceId");
            return (Criteria) this;
        }

        public Criteria andFaceIdIn(List<Long> values) {
            addCriterion("face_id in", values, "faceId");
            return (Criteria) this;
        }

        public Criteria andFaceIdNotIn(List<Long> values) {
            addCriterion("face_id not in", values, "faceId");
            return (Criteria) this;
        }

        public Criteria andFaceIdBetween(Long value1, Long value2) {
            addCriterion("face_id between", value1, value2, "faceId");
            return (Criteria) this;
        }

        public Criteria andFaceIdNotBetween(Long value1, Long value2) {
            addCriterion("face_id not between", value1, value2, "faceId");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(String value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(String value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(String value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(String value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(String value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(String value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLike(String value) {
            addCriterion("gender like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotLike(String value) {
            addCriterion("gender not like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<String> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<String> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(String value1, String value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(String value1, String value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andConfidenceIsNull() {
            addCriterion("confidence is null");
            return (Criteria) this;
        }

        public Criteria andConfidenceIsNotNull() {
            addCriterion("confidence is not null");
            return (Criteria) this;
        }

        public Criteria andConfidenceEqualTo(Float value) {
            addCriterion("confidence =", value, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceNotEqualTo(Float value) {
            addCriterion("confidence <>", value, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceGreaterThan(Float value) {
            addCriterion("confidence >", value, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceGreaterThanOrEqualTo(Float value) {
            addCriterion("confidence >=", value, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceLessThan(Float value) {
            addCriterion("confidence <", value, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceLessThanOrEqualTo(Float value) {
            addCriterion("confidence <=", value, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceIn(List<Float> values) {
            addCriterion("confidence in", values, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceNotIn(List<Float> values) {
            addCriterion("confidence not in", values, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceBetween(Float value1, Float value2) {
            addCriterion("confidence between", value1, value2, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceNotBetween(Float value1, Float value2) {
            addCriterion("confidence not between", value1, value2, "confidence");
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