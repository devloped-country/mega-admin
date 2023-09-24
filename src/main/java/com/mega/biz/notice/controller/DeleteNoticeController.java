package com.mega.biz.notice.controller;

import com.mega.biz.notice.model.NoticeDAO;
import com.mega.biz.notice.model.dto.NoticeDTO;
import com.mega.common.controller.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteNoticeController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        String id = request.getParameter("id");

        if (id != null && !id.isEmpty()) {
            try {
                long noticeId = Long.parseLong(id);
                NoticeDTO dto = new NoticeDTO();
                dto.setId(noticeId);

                NoticeDAO noticeDAO = new NoticeDAO();
                NoticeDTO existingNotice = noticeDAO.getNoticeById(noticeId);

                if (existingNotice != null) {
                    noticeDAO.deleteNotice(existingNotice);
                }

            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        return "getNoticeList.do";
    }
}
