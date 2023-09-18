package com.mega.biz.attendance.model.dto;

import java.sql.Date;

public class  AttendanceStatDTO {

  private int status;
  private Date date;

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

}
