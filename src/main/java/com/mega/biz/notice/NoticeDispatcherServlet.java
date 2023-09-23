package com.mega.biz.notice;

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

@WebServlet("/notice/*")
public class NoticeDispatcherServlet extends HttpServlet {

    private HandlerMapping handlerMapping;
    private ViewResolver viewResolver;

    public void init() throws ServletException {
        handlerMapping = new NoticeHandlerMapping();
        viewResolver = new ViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/notice/");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String page = "1";
        if (request.getParameter("page") != null) {
            page = request.getParameter("page");
        }

        String uri = request.getRequestURI();
        String path = uri.substring(uri.lastIndexOf("/"));

        request.setAttribute("currentPage", page);

        Controller ctrl = handlerMapping.getController(path);

        if (ctrl == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/errors/error.jsp");
            dispatcher.forward(request, response);
        } else if (request.getMethod().equals("POST")) {
            String view = ctrl.handleRequest(request, response);
            response.sendRedirect(view);
        } else {
            String viewName = ctrl.handleRequest(request, response);
            String view = null;

            if (!viewName.contains(".do")) {
                if (viewName.equals("index")) {
                    view = viewName + ".jsp";
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
