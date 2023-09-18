package com.mega.biz.curriculum.controller;

import com.mega.biz.curriculum.service.CurriculumService;
import com.mega.common.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCurriculumController implements Controller {

    private final CurriculumService service = new CurriculumService();

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {


        String[] parameterValues = request.getParameterValues("curriculumId");

        for (String parameterValue : parameterValues) {
            long curriculumId = Long.parseLong(parameterValue);
            service.deleteCurriculum(curriculumId);
        }

        return "getCurriculumList.do";
    }
}
