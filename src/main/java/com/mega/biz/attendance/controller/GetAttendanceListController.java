package com.mega.biz.attendance.controller;

import com.mega.biz.attendance.model.dto.AttendanceDTO;
import com.mega.biz.attendance.model.dto.PageDTO;
import com.mega.common.controller.Controller;
import com.mega.biz.attendance.service.AttendanceService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
public class GetAttendanceListController implements Controller {

    private final AttendanceService service = new AttendanceService();

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String keyword = request.getParameter("keyword");
        String currentPage = request.getAttribute("currentPage").toString();
//        int getDuration = Integer.parseInt(request.getParameter("getDuration"));

//        log.info("keyword : {}", keyword);

        AttendanceDTO attendanceDTO = new AttendanceDTO();
        PageDTO pageDTO = new PageDTO();

        pageDTO.setStartIndex((Integer.parseInt(currentPage)-1)*pageDTO.POSTS_PER_PAGE);
        int endNum = ((int)Math.ceil((double)service.getTotalUser(keyword)/pageDTO.POSTS_PER_PAGE));
        int currentPageBlock = ((Integer.parseInt(currentPage) - 1) / pageDTO.PAGES_PER_BLOCK) * pageDTO.PAGES_PER_BLOCK + 1;

//        log.info("currentPage : {}", currentPage);
//        log.info("currenPageBlock : {}", currentPageBlock);
//        log.info("endNum: {}", endNum);

        if (keyword == null) {
            List<AttendanceDTO> attendanceList = service.getAttendanceList(pageDTO);
//            log.info("keyword = null !!");
            request.setAttribute("attendanceList", attendanceList);
        } else {
            attendanceDTO.setName(keyword.replace(" ", ""));
            List<AttendanceDTO> searchList = service.getSearchList(keyword, pageDTO);
//            log.info("keyword != null !!");
            request.setAttribute("attendanceList", searchList);
        }

        request.setAttribute("keyword", keyword);
        request.setAttribute("endNum", endNum);
        request.setAttribute("currentPageBlock", currentPageBlock);

        return "attendanceList";
    }
}
