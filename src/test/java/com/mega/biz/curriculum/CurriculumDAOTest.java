package com.mega.biz.curriculum;

import com.mega.biz.curriculum.model.dto.CurriculumDTO;
import com.mega.biz.curriculum.model.dto.CurriculumWithDetailDTO;
import com.mega.biz.curriculum.model.dto.DetailSubjectDTO;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CurriculumDAOTest {

    CurriculumDAO dao = new CurriculumDAO();

    @Test
    void test01() {
        List<DetailSubjectDTO> detail = dao.getDetail();
        for (DetailSubjectDTO detailSubjectDTO : detail) {
            System.out.println("detailSubjectDTO = " + detailSubjectDTO);
        }
    }

    @Test
    void test02() {
        List<DetailSubjectDTO> detailByCurriculumId = dao.getDetailByCurriculumId(1L);
        for (DetailSubjectDTO detailSubjectDTO : detailByCurriculumId) {
            System.out.println("detailSubjectDTO = " + detailSubjectDTO);
        }
    }

    @Test
    void test03() {
        List<CurriculumWithDetailDTO> allCurriculum = dao.getAllCurriculum();
        for (CurriculumWithDetailDTO curriculumDTO : allCurriculum) {
            System.out.println("curriculumDTO = " + curriculumDTO);
        }
    }

    @Test
    void insertCurri() {
        CurriculumWithDetailDTO dto = new CurriculumWithDetailDTO();
        dto.setSubject("테스트");
        dto.setTime(15);
        dto.setStartDate(Date.valueOf("2023-09-01"));
        dto.setEndDate(Date.valueOf("2023-09-15"));

        dao.insertCurriculum(dto);
    }

    @Test
    void getMax() {
        Long maxCurriculumId = dao.getMaxCurriculumId();
        System.out.println("maxCurriculumId = " + maxCurriculumId);
    }

}