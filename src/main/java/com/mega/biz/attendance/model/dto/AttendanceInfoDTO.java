package com.mega.biz.attendance.model.dto;

import java.util.ArrayList;
import java.util.HashMap;

public class AttendanceInfoDTO {

  private HashMap<String, ArrayList<AttendanceStatDTO>> attendanceInfo;

  public AttendanceInfoDTO() {
    attendanceInfo = new HashMap<>();
  }

  public HashMap<String, ArrayList<AttendanceStatDTO>> getAttendanceInfo() {
    return attendanceInfo;
  }

  public void setAttendanceInfo(HashMap<String, ArrayList<AttendanceStatDTO>> attendanceInfo) {
    this.attendanceInfo = attendanceInfo;
  }
}
