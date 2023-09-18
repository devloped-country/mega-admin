package com.mega.biz.attendance.service;

import com.mega.biz.attendance.model.dao.AttendanceStatDAO;
import com.mega.biz.attendance.model.dto.AttendanceInfoDTO;
import com.mega.biz.attendance.model.dto.AttendanceStatDTO;
import com.mega.biz.attendance.model.dto.AttendanceUserDTO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class AttendanceStatService {

  private AttendanceStatDAO dao = new AttendanceStatDAO();

  public HashMap<String, ArrayList<AttendanceStatDTO>> getAttendanceStat() {
    HashMap<String, ArrayList<AttendanceStatDTO>> attendanceInfoDTO = new HashMap<>();

    ArrayList<AttendanceUserDTO> attendanceUsersDTO =  dao.selectAttendanceUserNames();
    for (AttendanceUserDTO attendanceUserDTO : attendanceUsersDTO) {
      ArrayList<AttendanceStatDTO> attendanceStatsDTO = dao.selectAttendanceInfo(attendanceUserDTO);

      attendanceInfoDTO.put(attendanceUserDTO.getName(), attendanceStatsDTO);
    }
    LocalDate date = LocalDate.now();
    int year = date.getYear();
    int month = date.getMonthValue();
    int day = date.getDayOfMonth();
    Calendar cal = Calendar.getInstance();

    int ATTENDANCE_DURATION = 16;

    for(int i=ATTENDANCE_DURATION; i<cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {

    }

    cal.set(year, month - 2, 1);
    System.out.println(cal.getActualMaximum(Calendar.DAY_OF_MONTH));

    return attendanceInfoDTO;
  }
}
