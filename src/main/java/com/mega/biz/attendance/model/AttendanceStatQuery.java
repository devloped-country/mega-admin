package com.mega.biz.attendance.model;

public enum AttendanceStatQuery {
  USER_SELECT("select name from user"),
  ATTENDANCE_STAT_SELECT("select attendance_stat, start_date, u.name as name from attendance as a join user as u on a.email=u.email where name=?"),
  ATTENDANCE_STAT_COUNT_SELECT("select IFNULL(COUNT(attendance_stat), 0) as attendance_stat_count from attendance as a join user as u on a.email=u.email where u.name=? and attendance_stat=? and start_date between ? and ?"),
  ATTENDANCE_DURATION_SELECT("select duration from attendance_duration");
  private final String query;

  AttendanceStatQuery(String query) {
    this.query = query;
  }

  public String getQuery() {
    return query;
  }
}
