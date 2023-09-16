package com.mega.biz.curriculum.controller;

import com.mega.biz.curriculum.model.dto.CurriculumWithDetailDTO;
import com.mega.biz.curriculum.service.CurriculumService;
import com.mega.common.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateCurriculumFormController implements Controller {

    private final CurriculumService service = new CurriculumService();

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        long curriculumId = Long.parseLong(request.getParameter("curriculumId"));

        CurriculumWithDetailDTO curriculum = service.getCurriculumWithDetailById(curriculumId);

        request.setAttribute("curriculum", curriculum);
        return "updateForm";
    }
}
