package com.mega.biz.qr;

import com.mega.biz.qr.controller.QrController;
import com.mega.biz.qr.controller.QrImgController;
import com.mega.common.controller.Controller;
import com.mega.common.controller.HandlerMapping;
import com.mega.common.controller.ViewResolver;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/qr/*")
public class QrDispatcherServlet extends HttpServlet {

  private HandlerMapping handlerMapping;
  private ViewResolver viewResolver;

  public void init() throws ServletException {
    handlerMapping = new QrHandlerMapping();
    viewResolver = new ViewResolver();
    viewResolver.setPrefix("/WEB-INF/view/qr/");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String uri = request.getRequestURI();
    String path = uri.substring(uri.lastIndexOf("/"));

    Controller ctrl = handlerMapping.getController(path);

    if (ctrl == null) {
      RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/errors/error.jsp");
      dispatcher.forward(request, response);
    } else {
      String viewName = ctrl.handleRequest(request, response);
      String view = null;

      if (!viewName.contains(".do")) {
        if (viewName.equals("index")) {
          view = viewName + ".jsp";
        } else if (viewName.equals("img")) {
          ((QrImgController)ctrl).responseQr(response);
        } else {
          view = viewResolver.getView(viewName);
        }
      } else {
        view = viewName;
      }

      RequestDispatcher dispatcher = request.getRequestDispatcher(view);
      dispatcher.forward(request, response);
    }
  }
}
