package com.mega.biz.notice.controller;

import com.mega.biz.notice.model.NoticeDAO;
import com.mega.biz.notice.model.dto.NoticeDTO;
import com.mega.biz.notice.model.dto.PageDTO;
import com.mega.common.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetNoticeListController implements Controller {

    private final NoticeDAO dao = new NoticeDAO();
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        String currentPage = request.getAttribute("currentPage").toString();
        PageDTO pageDTO = new PageDTO();

        pageDTO.setStartIndex((Integer.parseInt(currentPage) - 1) * PageDTO.POSTS_PER_PAGE);

        List<NoticeDTO> noticeList = dao.getNoticeList(pageDTO);

        int endNum = (int) Math.ceil((double) dao.getNoticeCount() / PageDTO.POSTS_PER_PAGE);
        int currentPageBlock = ((Integer.parseInt(currentPage) - 1) / PageDTO.PAGES_PER_BLOCK) * PageDTO.PAGES_PER_BLOCK + 1;

        request.setAttribute("noticeList", noticeList);
        request.setAttribute("endNum", endNum);
        request.setAttribute("currentPageBlock", currentPageBlock);

        return "noticeList";
    }
}
