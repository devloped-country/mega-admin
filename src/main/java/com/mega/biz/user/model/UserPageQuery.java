package com.mega.biz.user.model;

public enum UserPageQuery {

    USER_LIST(" SELECT * FROM user1  ORDER BY name LIMIT 10 OFFSET ? "),

    USER_COUNT(" SELECT count(*) FROM user1 ");


    private final String query;

    UserPageQuery(String query) { this.query = query; }

    public String getQuery() { return query; }
}

