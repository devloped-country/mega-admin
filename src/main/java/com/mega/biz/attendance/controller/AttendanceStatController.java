package com.mega.biz.attendance.controller;

import com.mega.biz.attendance.model.dto.AttendanceDatesDTO;
import com.mega.biz.attendance.model.dto.AttendanceInfosDTO;
import com.mega.biz.attendance.service.AttendanceStatService;
import com.mega.common.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AttendanceStatController implements Controller {

    private AttendanceStatService service = new AttendanceStatService();

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        AttendanceDatesDTO attendanceDatesDTO = service.getAttendancePeriod();
        AttendanceInfosDTO attendanceInfosDTO = service.getAttendanceInfo();
//        HashMap<String, ArrayList<AttendanceStatDTO>> attendanceInfoDTO = service.getAttendanceStat();

        request.setAttribute("attendanceDates", attendanceDatesDTO.getAttendanceDates());
        request.setAttribute("attendanceInfos", attendanceInfosDTO.getAttendanceInfos());
//        request.setAttribute("attendanceInfos", attendanceInfoDTO);

        return "attendance_stat";
    }
}
