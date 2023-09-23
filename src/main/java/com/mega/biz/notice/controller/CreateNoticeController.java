package com.mega.biz.notice.controller;

import com.mega.biz.login.model.LoginDTO;
import com.mega.biz.notice.model.NoticeDAO;
import com.mega.biz.notice.model.dto.NoticeDTO;
import com.mega.common.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateNoticeController implements Controller {

    private final NoticeDAO dao = new NoticeDAO();

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        String tag = request.getParameter("tag");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        HttpSession session = request.getSession();
        LoginDTO loginDto = (LoginDTO) session.getAttribute("admin");
        String author = loginDto.getName();

        NoticeDTO noticeDTO = new NoticeDTO();
        noticeDTO.setTagId(Long.parseLong(tag));
        noticeDTO.setTitle(title);
        noticeDTO.setContent(content);
        noticeDTO.setAuthor(author);

        dao.insertNotice(noticeDTO);

        return "getNoticeList.do";
    }
}
