package com.mega.biz.attendance.controller;

import com.mega.biz.attendance.model.dto.AttendanceDTO;
import com.mega.biz.attendance.service.AttendanceService;
import com.mega.common.controller.Controller;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class UpdateAttendanceController implements Controller {

    private final AttendanceService service = new AttendanceService();

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        String email = request.getParameter("email");
        String month = request.getParameter("month");
        String currentPage = request.getAttribute("currentPage").toString();

        String attendance_stat = request.getParameter("updateAttendanceStat");
        String start_date = request.getParameter("updateStartDate");
        String end_date = request.getParameter("updateEndDate");
        String reason = request.getParameter("updateReason");

        AttendanceDTO attendanceDTO = new AttendanceDTO();

        int attendanceID = Integer.parseInt(request.getParameter("attendanceID"));

        log.info("month : {}", month);
        log.info("attendance_stat : {}", attendance_stat);
        log.info("start_date : {}", start_date);
        log.info("attendanceID : {}", attendanceID);

        switch (attendance_stat) {
            case "미출결":
                attendanceDTO.setAttendance_stat("1");
                break;
            case "출석":
                attendanceDTO.setAttendance_stat("2");
                break;
            case "지각":
                attendanceDTO.setAttendance_stat("3");
                break;
            case "조퇴":
                attendanceDTO.setAttendance_stat("4");
                break;
            case "결석":
                attendanceDTO.setAttendance_stat("5");
                break;
            case "공가":
                attendanceDTO.setAttendance_stat("6");
                break;
            case "병가":
                attendanceDTO.setAttendance_stat("7");
                break;
            default:
                attendanceDTO.setAttendance_stat(null);
                break;
        }

        attendanceDTO.setId(attendanceID);
        attendanceDTO.setStart_date(start_date);
        attendanceDTO.setEnd_date(end_date);
        attendanceDTO.setReason(reason);

        log.info("attendanceDto : {}", attendanceDTO);

        service.updateAttendance(attendanceDTO);

        request.setAttribute("page", currentPage);
        request.setAttribute("month", month);
        request.setAttribute("email", email);

//        return "attendanceDetail.do";
        return "attendanceDetail.do?email=" + email + "&page=" + currentPage + "&month=" + month;
    }
}
