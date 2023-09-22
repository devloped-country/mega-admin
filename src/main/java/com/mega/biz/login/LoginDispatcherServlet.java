package com.mega.biz.login;

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

@WebServlet("/login.do")
public class LoginDispatcherServlet extends HttpServlet  {
        private static final long serialVersionUID = 1L;
        private LoginHandlerMapping loginHandlerMapping;//컨트롤러 목록관리 클레스
        private ViewResolver viewResolver;//퍼워딩 정보 완성시켜줌
        @Override
        public void init() throws ServletException {
            loginHandlerMapping = new LoginHandlerMapping();
            viewResolver = new ViewResolver();

            viewResolver.setPrefix("/"); //경로
            viewResolver.setSuffix(".jsp");
            //이래야 초기화가 가능
        }

        protected void service(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            // 1. 사용자 요청 path를 추출한다.
            String uri = request.getRequestURI();
            String path = uri.substring(uri.lastIndexOf("/"));

            Controller ctrl = loginHandlerMapping.getController(path);//uri을 이용해서 컨트롤러를 뽑아올거다
            //handlerMapping정보를 이용해서 컨트롤러를 뽑아올거다
            //요청에 대한 컨트롤러를 가져옴

            if (ctrl == null) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/errors/error.jsp");
                dispatcher.forward(request, response);
            } else {
                //가져온 컨트롤러를 가지고 요청을 처리하면 된다. (세션바인딩,디비연동도 하고 -> 포워딩 정보 리턴)
                String viewName = ctrl.handleRequest(request, response); // 반환타입의 다형성!! 적용됨
                //       ㄴ> 어디로 반환할지 문자열로 받고 아래에서 판단한다
                //그렇게 처리다된 정보를 가져와서 포워딩정보를 구성한다
                String view = null;

                if (!viewName.contains(".do")) {//.do가 아니라는건 화면으로 옮겨야하는것이라 화면을 만들어야해서 viewReslol를 이용해야됨
                    if (viewName.equals("index")) {
                        view = viewName + ".jsp"; //이것만 웹 INF안이 아니고 하나뿐이라 바로 jsp만 붙여줌
                    } else {
                        view = viewResolver.getView(viewName);//이걸로 풀 경롤를 만들어줄거라 이걸 포워딩 하면된다
                    }// 여기까진 컨트롤러에서 컨트롤러로 이동하기위한 if문

                } else {

                    view = viewName;
                }

//            위 2가지 중 하나로 정보를 보냄
                RequestDispatcher dispatcher = request.getRequestDispatcher(view);//view로 포워딩
                dispatcher.forward(request, response);
            }
        }
    }
