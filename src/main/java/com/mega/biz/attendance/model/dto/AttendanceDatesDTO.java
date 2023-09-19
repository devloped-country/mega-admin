package com.mega.biz.attendance.model.dto;

import java.util.ArrayList;

public class AttendanceDatesDTO {
  int duration;
  ArrayList<AttendanceDateDTO> attendanceDates;

  public AttendanceDatesDTO() {
    this.attendanceDates = new ArrayList<>();
  }

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public ArrayList<AttendanceDateDTO> getAttendanceDates() {
    return attendanceDates;
  }

  public void setAttendanceDates(
      ArrayList<AttendanceDateDTO> attendanceDates) {
    this.attendanceDates = attendanceDates;
  }
}
