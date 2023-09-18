package com.mega.biz.qr.controller;

import com.mega.common.controller.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QrController implements Controller {

  @Override
  public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

    return "qr";
  }
}
