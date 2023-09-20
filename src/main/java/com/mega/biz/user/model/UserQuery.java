package com.mega.biz.user.model;

public enum UserQuery {

    ADMIN_USER_DELETE_ATTENDANCE("delete from attendance where email=?"),

    ADMIN_USER_DELETE_USER("delete from user where email=?"),

    USER_LIST("select email, password, name, phone, user_status  from user"),

    ADMIN_USER_APPROVE("update user set user_status=2 where email=?");
//    ADMIN_USER_APPROVE_STUTES("update board set title=?, content=? where seq=?");

    private final String query;

    UserQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}

