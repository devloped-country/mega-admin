package com.mega.biz.curriculum.service;

import com.mega.biz.curriculum.model.dto.CurriculumWithDetailDTO;
import com.mega.biz.curriculum.model.dto.DetailSubjectDTO;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.List;

class CurriculumServiceTest {

    CurriculumService service = new CurriculumService();

    @Test
    void getAllCurriculum() {
        List<CurriculumWithDetailDTO> allCurriculum = service.getAllCurriculumWithDetail();
        String test = "test";
    }

    @Test
    void insertCurri() {

        CurriculumWithDetailDTO dto = new CurriculumWithDetailDTO();
        dto.setSubject("테스트3");
        dto.setTime(15);
        dto.setStartDate(Date.valueOf("2023-09-16"));
        dto.setEndDate(Date.valueOf("2023-09-30"));


        DetailSubjectDTO detail1 = new DetailSubjectDTO();
        detail1.setContent("테스트3-테스트1");
        dto.getDetailSubjectDTOList().add(detail1);

        DetailSubjectDTO detail2 = new DetailSubjectDTO();
        detail2.setContent("테스트3-테스트2");
        dto.getDetailSubjectDTOList().add(detail2);

        DetailSubjectDTO detail3 = new DetailSubjectDTO();
        detail3.setContent("테스트3-테스트3");
        dto.getDetailSubjectDTOList().add(detail3);

        service.registerCurriculum(dto);
    }

    @Test
    void deleteCurri() {
        service.deleteCurriculum(2L);
    }

    @Test
    void getCurriById() {
        CurriculumWithDetailDTO curriculumWithDetailById = service.getCurriculumWithDetailById(1L);
        String test = "";
    }
}