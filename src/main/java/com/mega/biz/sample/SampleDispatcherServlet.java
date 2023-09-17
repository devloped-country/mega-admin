package com.mega.biz.sample;

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

@WebServlet("/sample/*")
public class SampleDispatcherServlet extends HttpServlet {

    private HandlerMapping handlerMapping;
    private ViewResolver viewResolver;

    public void init() throws ServletException {
        handlerMapping = new SampleHandlerMapping();
        viewResolver = new ViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/sample/");
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
                    // index.jsp로 이동
                    view = viewName + ".jsp";
                } else {
                    // /WEB-INF/view/sample/qr.jsp로 이동
                    view = viewResolver.getView(viewName);
                }
            } else {
                // qr.do로 이동
                view = viewName;
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher(view);
            dispatcher.forward(request, response);
        }
    }
}
