package com.mega.biz.attendance.model.dto;

import java.util.Date;

public class AttendanceDetailInfoDTO {

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
