package com.mega.biz.attendance.model.dto;

import java.sql.Date;

public class AttendanceDateDTO {
  Date date;
  String day;

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getDay() {
    return day;
  }

  public void setDay(String day) {
    this.day = day;
  }
}
