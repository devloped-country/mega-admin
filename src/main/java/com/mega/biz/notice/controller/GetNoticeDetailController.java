package com.mega.biz.notice.controller;

import com.mega.biz.notice.model.NoticeDAO;
import com.mega.biz.notice.model.dto.NoticeDTO;
import com.mega.common.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetNoticeDetailController implements Controller {

    private final NoticeDAO dao = new NoticeDAO();
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        String idString = request.getParameter("id");
        long id = Long.parseLong(idString);

        NoticeDTO notice = dao.getNoticeById(id);

        request.setAttribute("notice", notice);
        return "detailNotice";
    }
}
