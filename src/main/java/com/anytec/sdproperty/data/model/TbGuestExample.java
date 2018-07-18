package com.anytec.sdproperty.data.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbGuestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbGuestExample() {
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

        public Criteria andImageIsNull() {
            addCriterion("image is null");
            return (Criteria) this;
        }

        public Criteria andImageIsNotNull() {
            addCriterion("image is not null");
            return (Criteria) this;
        }

        public Criteria andImageEqualTo(String value) {
            addCriterion("image =", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotEqualTo(String value) {
            addCriterion("image <>", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThan(String value) {
            addCriterion("image >", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThanOrEqualTo(String value) {
            addCriterion("image >=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThan(String value) {
            addCriterion("image <", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThanOrEqualTo(String value) {
            addCriterion("image <=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLike(String value) {
            addCriterion("image like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotLike(String value) {
            addCriterion("image not like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageIn(List<String> values) {
            addCriterion("image in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotIn(List<String> values) {
            addCriterion("image not in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageBetween(String value1, String value2) {
            addCriterion("image between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotBetween(String value1, String value2) {
            addCriterion("image not between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andGuestRoleIdIsNull() {
            addCriterion("guest_role_id is null");
            return (Criteria) this;
        }

        public Criteria andGuestRoleIdIsNotNull() {
            addCriterion("guest_role_id is not null");
            return (Criteria) this;
        }

        public Criteria andGuestRoleIdEqualTo(Integer value) {
            addCriterion("guest_role_id =", value, "guestRoleId");
            return (Criteria) this;
        }

        public Criteria andGuestRoleIdNotEqualTo(Integer value) {
            addCriterion("guest_role_id <>", value, "guestRoleId");
            return (Criteria) this;
        }

        public Criteria andGuestRoleIdGreaterThan(Integer value) {
            addCriterion("guest_role_id >", value, "guestRoleId");
            return (Criteria) this;
        }

        public Criteria andGuestRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("guest_role_id >=", value, "guestRoleId");
            return (Criteria) this;
        }

        public Criteria andGuestRoleIdLessThan(Integer value) {
            addCriterion("guest_role_id <", value, "guestRoleId");
            return (Criteria) this;
        }

        public Criteria andGuestRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("guest_role_id <=", value, "guestRoleId");
            return (Criteria) this;
        }

        public Criteria andGuestRoleIdIn(List<Integer> values) {
            addCriterion("guest_role_id in", values, "guestRoleId");
            return (Criteria) this;
        }

        public Criteria andGuestRoleIdNotIn(List<Integer> values) {
            addCriterion("guest_role_id not in", values, "guestRoleId");
            return (Criteria) this;
        }

        public Criteria andGuestRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("guest_role_id between", value1, value2, "guestRoleId");
            return (Criteria) this;
        }

        public Criteria andGuestRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("guest_role_id not between", value1, value2, "guestRoleId");
            return (Criteria) this;
        }

        public Criteria andFirstTimeIsNull() {
            addCriterion("first_time is null");
            return (Criteria) this;
        }

        public Criteria andFirstTimeIsNotNull() {
            addCriterion("first_time is not null");
            return (Criteria) this;
        }

        public Criteria andFirstTimeEqualTo(Date value) {
            addCriterion("first_time =", value, "firstTime");
            return (Criteria) this;
        }

        public Criteria andFirstTimeNotEqualTo(Date value) {
            addCriterion("first_time <>", value, "firstTime");
            return (Criteria) this;
        }

        public Criteria andFirstTimeGreaterThan(Date value) {
            addCriterion("first_time >", value, "firstTime");
            return (Criteria) this;
        }

        public Criteria andFirstTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("first_time >=", value, "firstTime");
            return (Criteria) this;
        }

        public Criteria andFirstTimeLessThan(Date value) {
            addCriterion("first_time <", value, "firstTime");
            return (Criteria) this;
        }

        public Criteria andFirstTimeLessThanOrEqualTo(Date value) {
            addCriterion("first_time <=", value, "firstTime");
            return (Criteria) this;
        }

        public Criteria andFirstTimeIn(List<Date> values) {
            addCriterion("first_time in", values, "firstTime");
            return (Criteria) this;
        }

        public Criteria andFirstTimeNotIn(List<Date> values) {
            addCriterion("first_time not in", values, "firstTime");
            return (Criteria) this;
        }

        public Criteria andFirstTimeBetween(Date value1, Date value2) {
            addCriterion("first_time between", value1, value2, "firstTime");
            return (Criteria) this;
        }

        public Criteria andFirstTimeNotBetween(Date value1, Date value2) {
            addCriterion("first_time not between", value1, value2, "firstTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeIsNull() {
            addCriterion("last_time is null");
            return (Criteria) this;
        }

        public Criteria andLastTimeIsNotNull() {
            addCriterion("last_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastTimeEqualTo(Date value) {
            addCriterion("last_time =", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeNotEqualTo(Date value) {
            addCriterion("last_time <>", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeGreaterThan(Date value) {
            addCriterion("last_time >", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_time >=", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeLessThan(Date value) {
            addCriterion("last_time <", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_time <=", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeIn(List<Date> values) {
            addCriterion("last_time in", values, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeNotIn(List<Date> values) {
            addCriterion("last_time not in", values, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeBetween(Date value1, Date value2) {
            addCriterion("last_time between", value1, value2, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_time not between", value1, value2, "lastTime");
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

        public Criteria andCardNoIsNull() {
            addCriterion("card_no is null");
            return (Criteria) this;
        }

        public Criteria andCardNoIsNotNull() {
            addCriterion("card_no is not null");
            return (Criteria) this;
        }

        public Criteria andCardNoEqualTo(String value) {
            addCriterion("card_no =", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotEqualTo(String value) {
            addCriterion("card_no <>", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoGreaterThan(String value) {
            addCriterion("card_no >", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("card_no >=", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLessThan(String value) {
            addCriterion("card_no <", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLessThanOrEqualTo(String value) {
            addCriterion("card_no <=", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLike(String value) {
            addCriterion("card_no like", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotLike(String value) {
            addCriterion("card_no not like", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoIn(List<String> values) {
            addCriterion("card_no in", values, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotIn(List<String> values) {
            addCriterion("card_no not in", values, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoBetween(String value1, String value2) {
            addCriterion("card_no between", value1, value2, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotBetween(String value1, String value2) {
            addCriterion("card_no not between", value1, value2, "cardNo");
            return (Criteria) this;
        }

        public Criteria andAccessGuestIdIsNull() {
            addCriterion("access_guest_id is null");
            return (Criteria) this;
        }

        public Criteria andAccessGuestIdIsNotNull() {
            addCriterion("access_guest_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccessGuestIdEqualTo(Integer value) {
            addCriterion("access_guest_id =", value, "accessGuestId");
            return (Criteria) this;
        }

        public Criteria andAccessGuestIdNotEqualTo(Integer value) {
            addCriterion("access_guest_id <>", value, "accessGuestId");
            return (Criteria) this;
        }

        public Criteria andAccessGuestIdGreaterThan(Integer value) {
            addCriterion("access_guest_id >", value, "accessGuestId");
            return (Criteria) this;
        }

        public Criteria andAccessGuestIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("access_guest_id >=", value, "accessGuestId");
            return (Criteria) this;
        }

        public Criteria andAccessGuestIdLessThan(Integer value) {
            addCriterion("access_guest_id <", value, "accessGuestId");
            return (Criteria) this;
        }

        public Criteria andAccessGuestIdLessThanOrEqualTo(Integer value) {
            addCriterion("access_guest_id <=", value, "accessGuestId");
            return (Criteria) this;
        }

        public Criteria andAccessGuestIdIn(List<Integer> values) {
            addCriterion("access_guest_id in", values, "accessGuestId");
            return (Criteria) this;
        }

        public Criteria andAccessGuestIdNotIn(List<Integer> values) {
            addCriterion("access_guest_id not in", values, "accessGuestId");
            return (Criteria) this;
        }

        public Criteria andAccessGuestIdBetween(Integer value1, Integer value2) {
            addCriterion("access_guest_id between", value1, value2, "accessGuestId");
            return (Criteria) this;
        }

        public Criteria andAccessGuestIdNotBetween(Integer value1, Integer value2) {
            addCriterion("access_guest_id not between", value1, value2, "accessGuestId");
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

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Integer value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Integer value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Integer value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Integer value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Integer value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Integer value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Integer> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Integer> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Integer value1, Integer value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Integer value1, Integer value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andRoomIsNull() {
            addCriterion("room is null");
            return (Criteria) this;
        }

        public Criteria andRoomIsNotNull() {
            addCriterion("room is not null");
            return (Criteria) this;
        }

        public Criteria andRoomEqualTo(String value) {
            addCriterion("room =", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomNotEqualTo(String value) {
            addCriterion("room <>", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomGreaterThan(String value) {
            addCriterion("room >", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomGreaterThanOrEqualTo(String value) {
            addCriterion("room >=", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomLessThan(String value) {
            addCriterion("room <", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomLessThanOrEqualTo(String value) {
            addCriterion("room <=", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomLike(String value) {
            addCriterion("room like", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomNotLike(String value) {
            addCriterion("room not like", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomIn(List<String> values) {
            addCriterion("room in", values, "room");
            return (Criteria) this;
        }

        public Criteria andRoomNotIn(List<String> values) {
            addCriterion("room not in", values, "room");
            return (Criteria) this;
        }

        public Criteria andRoomBetween(String value1, String value2) {
            addCriterion("room between", value1, value2, "room");
            return (Criteria) this;
        }

        public Criteria andRoomNotBetween(String value1, String value2) {
            addCriterion("room not between", value1, value2, "room");
            return (Criteria) this;
        }

        public Criteria andCountIsNull() {
            addCriterion("count is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("count is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(Integer value) {
            addCriterion("count =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(Integer value) {
            addCriterion("count <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(Integer value) {
            addCriterion("count >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("count >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(Integer value) {
            addCriterion("count <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(Integer value) {
            addCriterion("count <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<Integer> values) {
            addCriterion("count in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<Integer> values) {
            addCriterion("count not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(Integer value1, Integer value2) {
            addCriterion("count between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(Integer value1, Integer value2) {
            addCriterion("count not between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andLockStartTimeIsNull() {
            addCriterion("lock_start_time is null");
            return (Criteria) this;
        }

        public Criteria andLockStartTimeIsNotNull() {
            addCriterion("lock_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andLockStartTimeEqualTo(Date value) {
            addCriterion("lock_start_time =", value, "lockStartTime");
            return (Criteria) this;
        }

        public Criteria andLockStartTimeNotEqualTo(Date value) {
            addCriterion("lock_start_time <>", value, "lockStartTime");
            return (Criteria) this;
        }

        public Criteria andLockStartTimeGreaterThan(Date value) {
            addCriterion("lock_start_time >", value, "lockStartTime");
            return (Criteria) this;
        }

        public Criteria andLockStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lock_start_time >=", value, "lockStartTime");
            return (Criteria) this;
        }

        public Criteria andLockStartTimeLessThan(Date value) {
            addCriterion("lock_start_time <", value, "lockStartTime");
            return (Criteria) this;
        }

        public Criteria andLockStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("lock_start_time <=", value, "lockStartTime");
            return (Criteria) this;
        }

        public Criteria andLockStartTimeIn(List<Date> values) {
            addCriterion("lock_start_time in", values, "lockStartTime");
            return (Criteria) this;
        }

        public Criteria andLockStartTimeNotIn(List<Date> values) {
            addCriterion("lock_start_time not in", values, "lockStartTime");
            return (Criteria) this;
        }

        public Criteria andLockStartTimeBetween(Date value1, Date value2) {
            addCriterion("lock_start_time between", value1, value2, "lockStartTime");
            return (Criteria) this;
        }

        public Criteria andLockStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("lock_start_time not between", value1, value2, "lockStartTime");
            return (Criteria) this;
        }

        public Criteria andLockEndTimeIsNull() {
            addCriterion("lock_end_time is null");
            return (Criteria) this;
        }

        public Criteria andLockEndTimeIsNotNull() {
            addCriterion("lock_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andLockEndTimeEqualTo(Date value) {
            addCriterion("lock_end_time =", value, "lockEndTime");
            return (Criteria) this;
        }

        public Criteria andLockEndTimeNotEqualTo(Date value) {
            addCriterion("lock_end_time <>", value, "lockEndTime");
            return (Criteria) this;
        }

        public Criteria andLockEndTimeGreaterThan(Date value) {
            addCriterion("lock_end_time >", value, "lockEndTime");
            return (Criteria) this;
        }

        public Criteria andLockEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lock_end_time >=", value, "lockEndTime");
            return (Criteria) this;
        }

        public Criteria andLockEndTimeLessThan(Date value) {
            addCriterion("lock_end_time <", value, "lockEndTime");
            return (Criteria) this;
        }

        public Criteria andLockEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("lock_end_time <=", value, "lockEndTime");
            return (Criteria) this;
        }

        public Criteria andLockEndTimeIn(List<Date> values) {
            addCriterion("lock_end_time in", values, "lockEndTime");
            return (Criteria) this;
        }

        public Criteria andLockEndTimeNotIn(List<Date> values) {
            addCriterion("lock_end_time not in", values, "lockEndTime");
            return (Criteria) this;
        }

        public Criteria andLockEndTimeBetween(Date value1, Date value2) {
            addCriterion("lock_end_time between", value1, value2, "lockEndTime");
            return (Criteria) this;
        }

        public Criteria andLockEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("lock_end_time not between", value1, value2, "lockEndTime");
            return (Criteria) this;
        }

        public Criteria andUploadImageIsNull() {
            addCriterion("upload_image is null");
            return (Criteria) this;
        }

        public Criteria andUploadImageIsNotNull() {
            addCriterion("upload_image is not null");
            return (Criteria) this;
        }

        public Criteria andUploadImageEqualTo(String value) {
            addCriterion("upload_image =", value, "uploadImage");
            return (Criteria) this;
        }

        public Criteria andUploadImageNotEqualTo(String value) {
            addCriterion("upload_image <>", value, "uploadImage");
            return (Criteria) this;
        }

        public Criteria andUploadImageGreaterThan(String value) {
            addCriterion("upload_image >", value, "uploadImage");
            return (Criteria) this;
        }

        public Criteria andUploadImageGreaterThanOrEqualTo(String value) {
            addCriterion("upload_image >=", value, "uploadImage");
            return (Criteria) this;
        }

        public Criteria andUploadImageLessThan(String value) {
            addCriterion("upload_image <", value, "uploadImage");
            return (Criteria) this;
        }

        public Criteria andUploadImageLessThanOrEqualTo(String value) {
            addCriterion("upload_image <=", value, "uploadImage");
            return (Criteria) this;
        }

        public Criteria andUploadImageLike(String value) {
            addCriterion("upload_image like", value, "uploadImage");
            return (Criteria) this;
        }

        public Criteria andUploadImageNotLike(String value) {
            addCriterion("upload_image not like", value, "uploadImage");
            return (Criteria) this;
        }

        public Criteria andUploadImageIn(List<String> values) {
            addCriterion("upload_image in", values, "uploadImage");
            return (Criteria) this;
        }

        public Criteria andUploadImageNotIn(List<String> values) {
            addCriterion("upload_image not in", values, "uploadImage");
            return (Criteria) this;
        }

        public Criteria andUploadImageBetween(String value1, String value2) {
            addCriterion("upload_image between", value1, value2, "uploadImage");
            return (Criteria) this;
        }

        public Criteria andUploadImageNotBetween(String value1, String value2) {
            addCriterion("upload_image not between", value1, value2, "uploadImage");
            return (Criteria) this;
        }

        public Criteria andUserIdCreateIsNull() {
            addCriterion("user_id_create is null");
            return (Criteria) this;
        }

        public Criteria andUserIdCreateIsNotNull() {
            addCriterion("user_id_create is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdCreateEqualTo(Integer value) {
            addCriterion("user_id_create =", value, "userIdCreate");
            return (Criteria) this;
        }

        public Criteria andUserIdCreateNotEqualTo(Integer value) {
            addCriterion("user_id_create <>", value, "userIdCreate");
            return (Criteria) this;
        }

        public Criteria andUserIdCreateGreaterThan(Integer value) {
            addCriterion("user_id_create >", value, "userIdCreate");
            return (Criteria) this;
        }

        public Criteria andUserIdCreateGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id_create >=", value, "userIdCreate");
            return (Criteria) this;
        }

        public Criteria andUserIdCreateLessThan(Integer value) {
            addCriterion("user_id_create <", value, "userIdCreate");
            return (Criteria) this;
        }

        public Criteria andUserIdCreateLessThanOrEqualTo(Integer value) {
            addCriterion("user_id_create <=", value, "userIdCreate");
            return (Criteria) this;
        }

        public Criteria andUserIdCreateIn(List<Integer> values) {
            addCriterion("user_id_create in", values, "userIdCreate");
            return (Criteria) this;
        }

        public Criteria andUserIdCreateNotIn(List<Integer> values) {
            addCriterion("user_id_create not in", values, "userIdCreate");
            return (Criteria) this;
        }

        public Criteria andUserIdCreateBetween(Integer value1, Integer value2) {
            addCriterion("user_id_create between", value1, value2, "userIdCreate");
            return (Criteria) this;
        }

        public Criteria andUserIdCreateNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id_create not between", value1, value2, "userIdCreate");
            return (Criteria) this;
        }

        public Criteria andLastModifyUserIdIsNull() {
            addCriterion("last_modify_user_id is null");
            return (Criteria) this;
        }

        public Criteria andLastModifyUserIdIsNotNull() {
            addCriterion("last_modify_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andLastModifyUserIdEqualTo(Integer value) {
            addCriterion("last_modify_user_id =", value, "lastModifyUserId");
            return (Criteria) this;
        }

        public Criteria andLastModifyUserIdNotEqualTo(Integer value) {
            addCriterion("last_modify_user_id <>", value, "lastModifyUserId");
            return (Criteria) this;
        }

        public Criteria andLastModifyUserIdGreaterThan(Integer value) {
            addCriterion("last_modify_user_id >", value, "lastModifyUserId");
            return (Criteria) this;
        }

        public Criteria andLastModifyUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("last_modify_user_id >=", value, "lastModifyUserId");
            return (Criteria) this;
        }

        public Criteria andLastModifyUserIdLessThan(Integer value) {
            addCriterion("last_modify_user_id <", value, "lastModifyUserId");
            return (Criteria) this;
        }

        public Criteria andLastModifyUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("last_modify_user_id <=", value, "lastModifyUserId");
            return (Criteria) this;
        }

        public Criteria andLastModifyUserIdIn(List<Integer> values) {
            addCriterion("last_modify_user_id in", values, "lastModifyUserId");
            return (Criteria) this;
        }

        public Criteria andLastModifyUserIdNotIn(List<Integer> values) {
            addCriterion("last_modify_user_id not in", values, "lastModifyUserId");
            return (Criteria) this;
        }

        public Criteria andLastModifyUserIdBetween(Integer value1, Integer value2) {
            addCriterion("last_modify_user_id between", value1, value2, "lastModifyUserId");
            return (Criteria) this;
        }

        public Criteria andLastModifyUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("last_modify_user_id not between", value1, value2, "lastModifyUserId");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeIsNull() {
            addCriterion("last_modify_time is null");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeIsNotNull() {
            addCriterion("last_modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeEqualTo(Date value) {
            addCriterion("last_modify_time =", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeNotEqualTo(Date value) {
            addCriterion("last_modify_time <>", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeGreaterThan(Date value) {
            addCriterion("last_modify_time >", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_modify_time >=", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeLessThan(Date value) {
            addCriterion("last_modify_time <", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_modify_time <=", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeIn(List<Date> values) {
            addCriterion("last_modify_time in", values, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeNotIn(List<Date> values) {
            addCriterion("last_modify_time not in", values, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeBetween(Date value1, Date value2) {
            addCriterion("last_modify_time between", value1, value2, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_modify_time not between", value1, value2, "lastModifyTime");
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