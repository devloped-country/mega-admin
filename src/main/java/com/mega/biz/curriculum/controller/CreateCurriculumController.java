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

        CurriculumWithDetailDTO curriculumDto = new CurriculumWithDetailDTO(subject, time, Date.valueOf(startDate), Date.valueOf(endDate));

        String[] parameterValues = request.getParameterValues("detail");

        for (String parameterValue : parameterValues) {
            DetailSubjectDTO dto = new DetailSubjectDTO(parameterValue);
            curriculumDto.getDetailSubjectDTOList().add(dto);
        }

        service.registerCurriculum(curriculumDto);

        return "getCurriculumList.do";
    }
}
