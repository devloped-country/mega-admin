package com.mega.biz.attendance.model.dto;

import java.util.ArrayList;

public class AttendanceInfoDTO {
  private String name;
  private ArrayList<AttendanceDetailInfoDTO> attendanceInfo;
  private int attendance;
  private int late;
  private int earlyLeave;
  private int officialLeave;
  private int absent;

  public AttendanceInfoDTO() {
    this.attendanceInfo = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ArrayList<AttendanceDetailInfoDTO> getAttendanceInfos() {
    return attendanceInfo;
  }

  public void setAttendanceInfos(
      ArrayList<AttendanceDetailInfoDTO> attendanceInfos) {
    this.attendanceInfo = attendanceInfos;
  }

  public ArrayList<AttendanceDetailInfoDTO> getAttendanceInfo() {
    return attendanceInfo;
  }

  public void setAttendanceInfo(
      ArrayList<AttendanceDetailInfoDTO> attendanceInfo) {
    this.attendanceInfo = attendanceInfo;
  }

  public int getAttendance() {
    return attendance;
  }

  public void setAttendance(int attendance) {
    this.attendance = attendance;
  }

  public int getLate() {
    return late;
  }

  public void setLate(int late) {
    this.late = late;
  }

  public int getEarlyLeave() {
    return earlyLeave;
  }

  public void setEarlyLeave(int earlyLeave) {
    this.earlyLeave = earlyLeave;
  }

  public int getOfficialLeave() {
    return officialLeave;
  }

  public void setOfficialLeave(int officialLeave) {
    this.officialLeave = officialLeave;
  }

  public int getAbsent() {
    return absent;
  }

  public void setAbsent(int absent) {
    this.absent = absent;
  }
}
