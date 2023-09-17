package com.mega.biz.qr.controller;

import com.google.zxing.WriterException;
import com.mega.biz.qr.service.QrService;
import com.mega.common.controller.Controller;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QrImgController implements Controller {
  QrService service = new QrService();

  @Override
  public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

    return "img";
  }

  public void responseQr(HttpServletResponse response) {

    try {
      byte[] qrBytes = service.createQr();

      response.setContentType("image/png");
      try (OutputStream os = response.getOutputStream()) {
        os.write(qrBytes);
      }
    } catch (WriterException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
