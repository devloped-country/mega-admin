package com.mega.biz.curriculum.controller;

import com.mega.biz.curriculum.service.CurriculumService;
import com.mega.common.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateCurriculumController implements Controller {

    private final CurriculumService service = new CurriculumService();

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {




        return "getCurriculumList.do";
    }
}
