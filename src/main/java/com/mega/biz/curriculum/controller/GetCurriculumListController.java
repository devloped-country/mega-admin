package com.mega.biz.curriculum.controller;

import com.mega.biz.curriculum.model.dto.CurriculumWithDetailDTO;
import com.mega.biz.curriculum.service.CurriculumService;
import com.mega.common.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetCurriculumListController implements Controller {

    CurriculumService service = new CurriculumService();
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        List<CurriculumWithDetailDTO> allCurriculumWithDetail = service.getAllCurriculumWithDetail();
        request.setAttribute("curriculumList", allCurriculumWithDetail);

        return "curriculumList";
    }
}
