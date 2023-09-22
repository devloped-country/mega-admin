package com.mega.biz.attendance.model;

public enum AttendanceQuery {

    ATTENDANCE_LIST(" SELECT * FROM user  ORDER BY name LIMIT ? OFFSET ? "),
    ATTENDANCE_SEARCH_LIST(" SELECT * FROM user WHERE name like ? ORDER BY name LIMIT ? OFFSET ? "),
    ATTENDANCE_USER_COUNT(" SELECT count(*) FROM user "),

    ATTENDANCE_DETAIL_LIST(" SELECT a.*, u.name FROM ( SELECT * FROM attendance WHERE email=? ) a LEFT JOIN user u ON a.email = u.email ORDER BY start_date LIMIT ? OFFSET ? "),
    ATTENDANCE_STATUS_COUNT(" SELECT count(*) FROM attendance WHERE email=? "),
    ATTENDANCE_UPDATE(" UPDATE attendance SET attendance_stat=?, start_date=?, end_date=?, reason=? WHERE id=? "),

    ATTENDANCE_DATE_LIST(" SELECT a.*, u.name \n" +
            "FROM ( SELECT * FROM attendance \n" +
            "WHERE email=? && start_date BETWEEN ? AND ? ) a \n" +
            "LEFT JOIN user u \n" +
            "ON a.email = u.email\n" +
            "ORDER BY start_date \n" +
            "LIMIT ? OFFSET ? "),
    ATTENDANCE_DATE_COUNT(" SELECT count(*) FROM attendance WHERE email=? && start_date BETWEEN ? AND ? "),

    GET_ATTENDANCE_DURATION(" SELECT duration FROM attendance_duration WHERE id='1' "),
    DURATION_UPDATE(" UPDATE attendance_duration SET duration=? WHERE id='1' ");


    private final String query;

    AttendanceQuery(String query) { this.query = query; }

    public String getQuery() { return query; }
}