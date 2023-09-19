package com.mega.biz.attendance.model.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class AttendanceInfoDTO {

  private String name;
  private ArrayList<AttendanceDetailInfoDTO> attendanceInfo;
  private TreeMap<String, Integer> attendanceInfoo;
  private ArrayList<Integer> statCounts;

  public AttendanceInfoDTO() {
    this.attendanceInfo = new ArrayList<>();
    this.attendanceInfoo = new TreeMap<>();
    this.statCounts = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public TreeMap<String, Integer> getAttendanceInfoo() {
    return attendanceInfoo;
  }

  public void setAttendanceInfoo(TreeMap<String, Integer> attendanceInfoo) {
    this.attendanceInfoo = attendanceInfoo;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ArrayList<AttendanceDetailInfoDTO> getAttendanceInfos() {
    return attendanceInfo;
  }

  public void setAttendanceInfos(ArrayList<AttendanceDetailInfoDTO> attendanceInfos) {
    this.attendanceInfo = attendanceInfos;
  }

  public ArrayList<AttendanceDetailInfoDTO> getAttendanceInfo() {
    return attendanceInfo;
  }

  public void setAttendanceInfo(ArrayList<AttendanceDetailInfoDTO> attendanceInfo) {
    this.attendanceInfo = attendanceInfo;
  }

  public ArrayList<Integer> getStatCounts() {
    return statCounts;
  }

  public void setStatCounts(ArrayList<Integer> statCounts) {
    this.statCounts = statCounts;
  }
}
