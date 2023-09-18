package com.mega.biz.home;

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

@WebServlet("/home/*")
public class HomeDispatcherServlet extends HttpServlet {

    private HandlerMapping handlerMapping;
    private ViewResolver viewResolver;

    public void init() throws ServletException {
        handlerMapping = new HomeHandlerMapping();
        viewResolver = new ViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/home/");
    }

    @Override
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
                // mapping이 .do로 끝나지 않는다면
                if (viewName.equals("index")) {
                    // index라면 index.jsp
                    view = viewName + ".jsp";
                } else {
                    // index가 아니라면 /WEB-INF/view/home/{viewName}.jsp
                    view = viewResolver.getView(viewName);
                }
            } else {
                // mapping이 .do로 끝난다면
                view = viewName;
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher(view);
            dispatcher.forward(request, response);
        }
    }
}
