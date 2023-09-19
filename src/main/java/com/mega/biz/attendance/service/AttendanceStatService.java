package com.mega.biz.attendance.service;

import com.mega.biz.attendance.model.dao.AttendanceStatDAO;
import com.mega.biz.attendance.model.dto.AttendanceDatesDTO;
import com.mega.biz.attendance.model.dto.AttendanceInfoDTO;
import com.mega.biz.attendance.model.dto.AttendanceInfosDTO;
import com.mega.biz.attendance.model.dto.AttendanceUserDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AttendanceStatService {

  private final AttendanceStatDAO dao = new AttendanceStatDAO();

  public AttendanceInfosDTO getAttendanceInfo() {
    ArrayList<AttendanceUserDTO> attendanceUsersDTO = dao.selectAttendanceUserNames();
    AttendanceInfosDTO attendanceInfosDTO = new AttendanceInfosDTO();
    int duration = dao.selectAttendanceDuration();

    for (AttendanceUserDTO attendanceUserDTO : attendanceUsersDTO) {
      AttendanceInfoDTO attendanceInfoDTO = dao.selectAttendanceInfos(attendanceUserDTO);

      for (int i = 1; i < 8; i++) {
        attendanceInfoDTO.getStatCounts().add(dao.selectAttendanceStatCount(attendanceUserDTO, i, duration));
      }

      attendanceInfosDTO.getAttendanceInfos().add(attendanceInfoDTO);
    }

    return attendanceInfosDTO;
  }

  public AttendanceDatesDTO getAttendancePeriod() {
    return dao.selectAttendanceDates();
  }

  public AttendanceInfoDTO recordAttendanceDates() {
    AttendanceInfoDTO dto = new AttendanceInfoDTO();
    int duration = dao.selectAttendanceDuration();

    LocalDate localDate = LocalDate.now();
    int year = localDate.getYear();
    int month = localDate.getMonthValue();
    Calendar cal = Calendar.getInstance();

    for (int i = duration; i <= cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
      int newMonth = month - 1;
      String dateString = year + "-" + (newMonth >= 10 ? newMonth : "0" + newMonth) + "-" + (i >= 10 ? i : "0" + i);

      try {
        String dayOfWeekString = skipRecordAttendance(dateString);

        if(dayOfWeekString.equals("일요일") || dayOfWeekString.equals("토요일")) {
          continue;
        }
      } catch (Exception e) {
        e.printStackTrace();
      }

      dto.getAttendanceInfoo().put(dateString, 1);
    }

    for (int i = 1; i < duration; i++) {
      String dateString = year + "-" + (month >= 10 ? month : "0" + month) + "-" + (i >= 10 ? i : "0" + i);
      try {
        String dayOfWeekString = skipRecordAttendance(dateString);

        if(dayOfWeekString.equals("일요일") || dayOfWeekString.equals("토요일")) {
          continue;
        }
      } catch (Exception e) {
        e.printStackTrace();
      }

      dto.getAttendanceInfoo().put(dateString, 1);
    }

    return dto;
  }

  public String skipRecordAttendance(String dateString) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = null;

    try {
      date = dateFormat.parse(dateString);
    } catch (ParseException e) {
      e.printStackTrace();
    }

    if (date != null) {
      // Calendar 객체를 사용하여 요일을 얻기
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(date);

      int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

      // DAY_OF_WEEK 상수를 요일 문자열로 변환
      String[] daysOfWeek = {"일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"};
      String dayOfWeekString = daysOfWeek[dayOfWeek - 1];

      return dayOfWeekString;
    }

    throw new Error("요일 에러!");
  }
}
