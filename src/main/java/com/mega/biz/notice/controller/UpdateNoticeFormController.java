package com.mega.biz.notice.controller;

import com.mega.biz.notice.model.NoticeDAO;
import com.mega.biz.notice.model.dto.NoticeDTO;
import com.mega.common.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateNoticeFormController implements Controller {

    NoticeDAO dao = new NoticeDAO();

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        long updateId = Long.parseLong(request.getParameter("id"));


            try {
                NoticeDTO noticeDTO = dao.getNoticeById(updateId);

                if (noticeDTO != null) {
                    request.setAttribute("noticeId", noticeDTO.getId());
                    request.setAttribute("selectedTagId", noticeDTO.getTagId());
                    request.setAttribute("noticeTitle", noticeDTO.getTitle());
                    request.setAttribute("noticeContent", noticeDTO.getContent());

                    return "updateNotice";
                } else {
                    System.out.println("자료 없음");
                }

            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

        return "updateNotice";
    }
}
