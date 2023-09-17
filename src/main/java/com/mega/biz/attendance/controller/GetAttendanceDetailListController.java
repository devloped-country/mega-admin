package com.mega.biz.attendance.controller;

import com.mega.biz.attendance.model.dto.AttendanceDTO;
import com.mega.biz.attendance.model.dto.PageDTO;
import com.mega.biz.attendance.service.AttendanceService;
import com.mega.common.controller.Controller;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
public class  GetAttendanceDetailListController implements Controller {

    private final AttendanceService service = new AttendanceService();

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String currentPage = request.getAttribute("currentPage").toString();

        log.info("email : {}", email);

        PageDTO pageDTO = new PageDTO();

        pageDTO.setStartIndex((Integer.parseInt(currentPage)-1)*pageDTO.POSTS_PER_PAGE);
        int endNum = ((int)Math.ceil((double)service.getAttendanceCount(email)/pageDTO.POSTS_PER_PAGE));
        int currentPageBlock = ((Integer.parseInt(currentPage) - 1) / pageDTO.PAGES_PER_BLOCK) * pageDTO.PAGES_PER_BLOCK + 1;

        log.info("currentPage : {}", currentPage);
        log.info("currenPageBlock : {}", currentPageBlock);
        log.info("endNum: {}", endNum);

        List<AttendanceDTO> detailList = service.getDetailList(email, pageDTO);

        log.info("detailList : {}", detailList);

        request.setAttribute("detailList", detailList);
        request.setAttribute("email", email);
        request.setAttribute("endNum", endNum);
        request.setAttribute("currentPageBlock", currentPageBlock);

        return "attendanceDetailList";
    }
}
