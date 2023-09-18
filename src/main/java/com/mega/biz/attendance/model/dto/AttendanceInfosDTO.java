package com.mega.biz.attendance.model.dto;

import java.util.ArrayList;

public class AttendanceInfosDTO {
  private ArrayList<AttendanceInfoDTO> attendanceInfos;

  public AttendanceInfosDTO() {
    this.attendanceInfos = new ArrayList<>();
  }

  public ArrayList<AttendanceInfoDTO> getAttendanceInfos() {
    return attendanceInfos;
  }

  public void setAttendanceInfos(
      ArrayList<AttendanceInfoDTO> attendanceInfos) {
    this.attendanceInfos = attendanceInfos;
  }
}
