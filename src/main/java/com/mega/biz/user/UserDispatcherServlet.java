package com.mega.biz.user;

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

@WebServlet("/user/*")
public class UserDispatcherServlet extends HttpServlet {

    private UserHandlerMapping userHandlerMapping;
    private ViewResolver viewResolver;

    public void init() throws ServletException {
        userHandlerMapping = new UserHandlerMapping();
        viewResolver = new ViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/user/");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String page = "1";
        if (request.getParameter("page") != null) {
            page = request.getParameter("page");
//            log.info("page : {}", page);
        }

        String uri = request.getRequestURI();
        String path = uri.substring(uri.lastIndexOf("/"));

        request.setAttribute("page", page);

        Controller ctrl = userHandlerMapping.getController(path);

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







//        String uri = request.getRequestURI();
//        String path = uri.substring(uri.lastIndexOf("/"));
//        System.out.println(path);
//        Controller ctrl = userHandlerMapping.getController(path);
//
//        if (ctrl == null) {
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/errors/error.jsp");
//            dispatcher.forward(request, response);
//        } else {
//            String viewName = ctrl.handleRequest(request, response);
//            String view = null;
//
//            if (!viewName.contains(".do")) {
//                if (viewName.equals("index")) {
//                    view = viewName + ".jsp";
//                } else {
//                    view = viewResolver.getView(viewName);
//                }
//            } else {
//                view = viewName;
//            }
//
//            RequestDispatcher dispatcher = request.getRequestDispatcher(view);
//            dispatcher.forward(request, response);
//        }
//    }
//}
