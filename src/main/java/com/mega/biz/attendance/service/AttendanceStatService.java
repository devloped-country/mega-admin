package com.mega.biz.attendance.service;

import com.mega.biz.attendance.model.dao.AttendanceStatDAO;
import com.mega.biz.attendance.model.dto.AttendanceDatesDTO;
import com.mega.biz.attendance.model.dto.AttendanceInfoDTO;
import com.mega.biz.attendance.model.dto.AttendanceInfosDTO;
import com.mega.biz.attendance.model.dto.AttendanceUserDTO;
import java.util.ArrayList;

public class AttendanceStatService {

  private final AttendanceStatDAO dao = new AttendanceStatDAO();

//  public HashMap<String, ArrayList<AttendanceStatDTO>> getAttendanceStat() {
//    HashMap<String, ArrayList<AttendanceStatDTO>> attendanceInfoDTO = new HashMap<>();
//
//    ArrayList<AttendanceUserDTO> attendanceUsersDTO =  dao.selectAttendanceUserNames();
//    for (AttendanceUserDTO attendanceUserDTO : attendanceUsersDTO) {
//      ArrayList<AttendanceStatDTO> attendanceStatsDTO = dao.selectAttendanceInfo(attendanceUserDTO);
//
//      LocalDate date = LocalDate.now();
//      int year = date.getYear();
//      int month = date.getMonthValue();
//      int day = date.getDayOfMonth();
//      Calendar cal = Calendar.getInstance();
//
//      int ATTENDANCE_DURATION = 19;
//
//      for(int i=ATTENDANCE_DURATION; i<cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
//        AttendanceStatDTO dto = new AttendanceStatDTO();
//        dto.setDate(Date.valueOf(year + "-" + (month - 1)+ "-" + i));
//        dto.setStatus(1);
//        attendanceStatsDTO.add(dto);
//      }
//
//      for(int i=1; i<ATTENDANCE_DURATION; i++) {
//        AttendanceStatDTO dto = new AttendanceStatDTO();
//        dto.setDate(Date.valueOf(year + "-" + month + "-" + i));
//        dto.setStatus(1);
//        attendanceStatsDTO.add(dto);
//      }
//
//      attendanceInfoDTO.put(attendanceUserDTO.getName(), attendanceStatsDTO);
//    }
//
//    return attendanceInfoDTO;
//  }

  public AttendanceInfosDTO getAttendanceInfo() {
    ArrayList<AttendanceUserDTO> attendanceUsersDTO = dao.selectAttendanceUserNames();
    AttendanceInfosDTO attendanceInfosDTO = new AttendanceInfosDTO();

    for (AttendanceUserDTO attendanceUserDTO : attendanceUsersDTO) {
      AttendanceInfoDTO attendanceInfoDTO = dao.selectAttendanceInfos(attendanceUserDTO);
      attendanceInfosDTO.getAttendanceInfos().add(attendanceInfoDTO);
    }

    return attendanceInfosDTO;
  }

  public AttendanceDatesDTO getAttendancePeriod() {
    return dao.selectAttendanceDates();
  }
}
