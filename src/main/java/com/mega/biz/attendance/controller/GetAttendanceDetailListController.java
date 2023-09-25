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
        String month = request.getParameter("month");



        PageDTO pageDTO = new PageDTO();

        pageDTO.setStartIndex((Integer.parseInt(currentPage)-1)*pageDTO.POSTS_PER_PAGE);
        int endNum = 0;
        int currentPageBlock = ((Integer.parseInt(currentPage) - 1) / pageDTO.PAGES_PER_BLOCK) * pageDTO.PAGES_PER_BLOCK + 1;

        log.info("currentPage : {}", currentPage);
        log.info("currenPageBlock : {}", currentPageBlock);

        if (month == null || month.isEmpty() || month.equals(" ")) {
            endNum = ((int)Math.ceil((double)service.getAttendanceCount(email)/pageDTO.POSTS_PER_PAGE));
            List<AttendanceDTO> detailList = service.getDetailList(email, pageDTO);
            request.setAttribute("detailList", detailList);
        } else {
            int duration = service.getDuration();

            String endMonth = month + "-" + (duration-1);

            int getMonth = Integer.parseInt(endMonth.substring(5,7)) -1;
            int getYear = Integer.parseInt(endMonth.substring(0,4));

            if (getMonth == 0) {
                getMonth = 12;
                getYear = getYear-1;
            }

//            String startMonth;
//            if (getMonth < 10) {
//                startMonth = endMonth.substring(0,5) + "0" +getMonth + "-" + duration;
//            } else {
//                startMonth = endMonth.substring(0,5) + getMonth + "-" + duration;
//            }

            String startMonth =  getYear + "-" + getMonth + "-" + duration;

            log.info("getMonth : {}", getMonth);
            log.info("endMonth : {}", endMonth);
            log.info("startMonth: {}", startMonth);
            log.info("duration : {}", duration);

            request.setAttribute("startMonth", startMonth);
            request.setAttribute("endMonth", endMonth);

            endNum = ((int)Math.ceil((double)service.getDateCount(email, startMonth, endMonth)/pageDTO.POSTS_PER_PAGE));
            List<AttendanceDTO> dateList = service.getDateList(email, startMonth, endMonth, pageDTO);
            request.setAttribute("detailList", dateList);

            currentPage = "1";
        }

        log.info("endNum: {}", endNum);
        log.info("page : {}", currentPage);

        request.setAttribute("page", currentPage);
        request.setAttribute("email", email);
        request.setAttribute("endNum", endNum);
        request.setAttribute("currentPageBlock", currentPageBlock);
        request.setAttribute("month", month);

        return "attendanceDetailList";
    }
}
