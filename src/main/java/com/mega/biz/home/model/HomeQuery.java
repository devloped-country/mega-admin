package com.mega.biz.home.model;

public enum HomeQuery {
  ATTENDANCE_STUDENT_COUNT("select count(*) from attendance where DATE_FORMAT(start_date, '%Y-%m-%d')=CURDATE() and DATE_FORMAT(start_date, '%H:%i:%s') NOT LIKE '00:00:00'"),
  UN_ATTENDANCE_STUDENT_COUNT("select count(*) from attendance where DATE_FORMAT(start_date, '%Y-%m-%d')=CURDATE() and DATE_FORMAT(start_date, '%H:%i:%s') LIKE '00:00:00'"),
  RECENT_NOTICE_SELECT("select * from notice limit 5");

  private final String query;

  HomeQuery(String query) {
    this.query = query;
  }

  public String getQuery() {
    return query;
  }
}
