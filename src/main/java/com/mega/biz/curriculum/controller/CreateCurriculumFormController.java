package com.mega.biz.curriculum.controller;

import com.mega.common.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateCurriculumFormController implements Controller {


    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        return "createForm";
    }
}
