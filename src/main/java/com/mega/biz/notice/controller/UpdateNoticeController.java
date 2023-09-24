package com.mega.biz.notice.controller;

import com.mega.biz.login.model.LoginDTO;
import com.mega.biz.notice.model.NoticeDAO;
import com.mega.biz.notice.model.dto.NoticeDTO;
import com.mega.common.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateNoticeController implements Controller {

    NoticeDAO dao = new NoticeDAO();

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        LoginDTO loginDto = (LoginDTO) session.getAttribute("admin");

        // 폼에서 전송된 데이터 가져오기
        Long noticeId = Long.valueOf(request.getParameter("noticeId"));
        Long tagId = Long.valueOf(request.getParameter("tag"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        if (loginDto == null) {
            System.out.println("로그인을 하세요 ㅜㅜ");
            return "getNoticeList.do";
        }

        // 해당 noticeId에 대한 공지를 데이터베이스에서 가져옴
        NoticeDTO noticeDTO = dao.getNoticeById(noticeId);

        if (noticeDTO == null) {
            System.out.println("공지가 없어요 ㅜㅜ");
            return "getNoticeList.do";
        }

        // 로그인된 사용자와 게시물의 저자가 일치하는지 확인
        if (loginDto.getName().equals(noticeDTO.getAuthor())) {
            // NoticeDTO 객체 생성
            NoticeDTO dto = new NoticeDTO();
            dto.setId(noticeId);
            dto.setTagId(tagId);
            dto.setTitle(title);
            dto.setContent(content);

            // 데이터베이스 업데이트 수행
            dao.updateNotice(dto);

            // 수정이 완료되면 수정된 페이지로 이동
            System.out.println("수정완료~");
            return "noticeDetail.do?id=" + noticeId; // 수정 후 상세 페이지로 이동

        }

        // 수정이 실패하거나 권한이 없는 경우 목록 페이지로 이동
        System.out.println("수정에 실패하였습니다~~");
        return "getNoticeList.do";
    }
}
