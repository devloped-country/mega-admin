package com.mega.biz.attendance.model;

public enum AttendanceQuery {

    ATTENDANCE_LIST(" SELECT * FROM user  ORDER BY name LIMIT ? OFFSET ? "),
    ATTENDANCE_SEARCH_LIST(" SELECT * FROM user WHERE name like ? ORDER BY name LIMIT ? OFFSET ? "),
    ATTENDANCE_USER_COUNT(" SELECT count(*) FROM user "),

    ATTENDANCE_DETAIL_LIST(" SELECT a.*, u.name FROM ( SELECT * FROM attendance WHERE email=? ) a LEFT JOIN user u ON a.email = u.email ORDER BY start_date LIMIT ? OFFSET ? "),
    ATTENDANCE_STATUS_COUNT(" SELECT count(*) FROM attendance WHERE email=? "),
    ATTENDANCE_UPDATE_ATTENDANCE(" UPDATE attendance SET attendance_status=?, start_date=?, end_date=?, reason=? WHERE id=? "),

    GET_ATTENDANCE_NAME( " SELECT name FROM user WHERE email=? ");

    private final String query;

    AttendanceQuery(String query) { this.query = query; }

    public String getQuery() { return query; }
}
