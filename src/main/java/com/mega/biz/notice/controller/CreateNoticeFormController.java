package com.mega.biz.notice.controller;

import com.mega.common.controller.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateNoticeFormController implements Controller {


    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        return "createNotice";
    }
}
