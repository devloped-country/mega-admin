package com.mega.biz.attendance.controller;

import com.mega.biz.attendance.service.AttendanceService;
import com.mega.common.controller.Controller;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class SetDurationController implements Controller {

    private final AttendanceService service = new AttendanceService();

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        int getDuration = Integer.parseInt(request.getParameter("getDuration"));

        log.info("getDuration : {}", getDuration);

        service.updateDuration(getDuration);

        return "attendance.do";
    }
}
