package com.mega.biz.attendance.controller;

import com.mega.biz.attendance.model.dto.AttendanceDatesDTO;
import com.mega.biz.attendance.model.dto.AttendanceDetailInfoDTO;
import com.mega.biz.attendance.model.dto.AttendanceInfoDTO;
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

        for(AttendanceInfoDTO attendanceInfoDTO: attendanceInfosDTO.getAttendanceInfos()) {
            AttendanceInfoDTO attendanceInfooDTO = service.recordAttendanceDates();
            attendanceInfoDTO.setAttendanceInfoo(attendanceInfooDTO.getAttendanceInfoo());
            for(AttendanceDetailInfoDTO attendanceDetailInfoDTO : attendanceInfoDTO.getAttendanceInfo()) {
                if(attendanceInfoDTO.getAttendanceInfoo().containsKey(attendanceDetailInfoDTO.getDate().toString())) {
                    attendanceInfoDTO.getAttendanceInfoo().put(attendanceDetailInfoDTO.getDate().toString(), attendanceDetailInfoDTO.getStatus());
                }
            }
        }

        request.setAttribute("attendanceDates", attendanceDatesDTO.getAttendanceDates());
        request.setAttribute("attendanceInfos", attendanceInfosDTO.getAttendanceInfos());

        return "attendanceStat";
    }
}
