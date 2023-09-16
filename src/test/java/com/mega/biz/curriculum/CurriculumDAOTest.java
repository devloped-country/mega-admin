package com.mega.biz.curriculum;

import com.mega.biz.curriculum.model.CurriculumDAO;
import com.mega.biz.curriculum.model.dto.CurriculumWithDetailDTO;
import com.mega.biz.curriculum.model.dto.DetailSubjectDTO;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.List;

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
        List<DetailSubjectDTO> detailByCurriculumId = dao.getDetailListByCurriculumId(1L);
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

    @Test
    void getCurriculumById() {
        CurriculumWithDetailDTO curriculumById = dao.getCurriculumById(1L);
        System.out.println("curriculumById = " + curriculumById);
    }

    @Test
    void updateCurri() {
        dao.updateCurriculum(2L, new CurriculumWithDetailDTO("333", 10, Date.valueOf("2023-06-01"), Date.valueOf("2023-06-02")));
    }

    @Test
    void updateDetail() {
//        dao.updateDetail(2L, );
    }

}