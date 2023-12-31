package com.mega.biz.user.model;

public enum UserQuery {

    ADMIN_USER_DELETE_ATTENDANCE("delete from attendance2 where email=?"),

    ADMIN_USER_DELETE_USER("delete from user3 where email=?"),

    USER_LIST("select email, password, name, phone, user_status  from user3"),

    ADMIN_USER_APPROVE("update user3 set user_status=2 where email=?");


    private final String query;

    UserQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}

