package com.mega.biz.notice.model;

import com.mega.biz.notice.model.dto.NoticeDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NoticeDAOTest {

    NoticeDAO dao = new NoticeDAO();

    @Test
    void count() {
        int noticeCount = dao.getNoticeCount();
        System.out.println("noticeCount = " + noticeCount);
    }

    @Test
    void getOne() {
        NoticeDTO noticeById = dao.getNoticeById(1L);
        System.out.println("noticeById = " + noticeById);
    }
}