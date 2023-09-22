package com.mega.biz.home.controller;

import com.mega.biz.home.model.dto.HomeDTO;
import com.mega.biz.home.model.dto.NoticeDTO;
import com.mega.biz.home.service.HomeService;
import com.mega.common.controller.Controller;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomeController implements Controller {
    HomeService service = new HomeService();

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HomeDTO homeDto = service.countAttendanceInfo();
        ArrayList<NoticeDTO> noticeDtos = service.loadRecentNotice();
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");

        request.setAttribute("attendance", homeDto);
        request.setAttribute("notices", noticeDtos);
        request.setAttribute("name", name);

        return "home";
    }
}
