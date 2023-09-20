package com.mega.biz.login.model;

public enum LoginQuery {

    ADMIN_GET("select * from admin where account = ?");
    private final String query;

    LoginQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}

