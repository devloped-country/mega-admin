package com.mega.biz.attendance.controller;

import com.mega.biz.attendance.model.dto.AttendanceInfoDTO;
import com.mega.biz.attendance.model.dto.AttendanceStatDTO;
import com.mega.biz.attendance.model.dto.AttendanceUserDTO;
import com.mega.biz.attendance.service.AttendanceStatService;
import com.mega.common.controller.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AttendanceStatController implements Controller {

    private AttendanceStatService service = new AttendanceStatService();

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HashMap<String, ArrayList<AttendanceStatDTO>> attendanceInfoDTO = service.getAttendanceStat();

        request.setAttribute("attendanceInfos", attendanceInfoDTO);

        return "attendance_stat";
    }
}
