package com.mega.biz.curriculum.controller;

import com.mega.biz.curriculum.model.dto.CurriculumWithDetailDTO;
import com.mega.biz.curriculum.model.dto.DetailSubjectDTO;
import com.mega.biz.curriculum.service.CurriculumService;
import com.mega.common.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

public class CreateCurriculumController implements Controller {

    private final CurriculumService service = new CurriculumService();

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        String subject = request.getParameter("subject");
        int time = Integer.parseInt(request.getParameter("time"));
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");

        String dto1 = request.getParameter("dto1");
        String dto2 = request.getParameter("dto2");
        String dto3 = request.getParameter("dto3");

        DetailSubjectDTO detailSubjectDTO1 = new DetailSubjectDTO(dto1);
        DetailSubjectDTO detailSubjectDTO2 = new DetailSubjectDTO(dto2);
        DetailSubjectDTO detailSubjectDTO3 = new DetailSubjectDTO(dto3);

        CurriculumWithDetailDTO curriculumDto = new CurriculumWithDetailDTO(subject, time, Date.valueOf(startDate), Date.valueOf(endDate));

        curriculumDto.getDetailSubjectDTOList().add(detailSubjectDTO1);
        curriculumDto.getDetailSubjectDTOList().add(detailSubjectDTO2);
        curriculumDto.getDetailSubjectDTOList().add(detailSubjectDTO3);

        service.registerCurriculum(curriculumDto);

        return "getCurriculumList.do";
    }
}
