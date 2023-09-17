package com.mega.biz.home.controller;

import com.mega.biz.home.model.dto.HomeDTO;
import com.mega.biz.home.model.dto.NoticeDTO;
import com.mega.biz.home.service.HomeService;
import com.mega.common.controller.Controller;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController implements Controller {
    HomeService service = new HomeService();

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HomeDTO homeDto = service.countAttendanceInfo();
        ArrayList<NoticeDTO> noticeDtos = service.loadRecentNotice();

        request.setAttribute("attendance", homeDto);
        request.setAttribute("notices", noticeDtos);

        return "home";
    }
}
