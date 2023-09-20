package com.mega.biz.login.controller;


import com.mega.biz.login.model.LoginDAO;
import com.mega.biz.login.model.LoginDTO;
import com.mega.common.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


public class LoginController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request,
                                HttpServletResponse response) {
        System.out.println("로그인 처리");

        // 1. 사용자 입력정보 추출
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        // 2. DB 연동 처리
        LoginDTO vo = new LoginDTO();
        vo.setAccount(account);

        LoginDAO dao = new LoginDAO();
        LoginDTO admin = dao.getAdmin(vo);

        // 3. 화면 이동
        HttpSession session = request.getSession();
        if (admin != null && admin.getPassword().equals(password)) {
            // 상태 정보를 세션에 저장한다.
            session.setAttribute("admin", admin);
            // 글 목록 화면으로 이동한다.
            return "WEB-INF/view/home/home";   //index 아니면 이걸로
        } else {
            request.setAttribute("loginError", "아이디 또는 비밀번호가 일치하지 않습니다.");
            return "index";
        }
    }
}



//
//public class LoginController extends HttpServlet {
//
//        public LoginController() {
//            super();
//            System.out.println("===> LoginServlet 생성");
//            // TODO Auto-generated constructor stub
//        }
//
//        protected void service(HttpServletRequest request, HttpServletResponse response)
//                throws ServletException, IOException {
//            // TODO Auto-generated method stub
//            String id = request.getParameter("id");
//            String password = request.getParameter("password");
//
//            LoginDTO vo = new LoginDTO();
//            vo.setId(id);
//            vo.setPassword(password);
//
//            LoginDAO dao = new LoginDAO();
//            LoginDTO admin = dao.getAdimin(vo);
//
//            //인코딩 정보를 공유해서 사용할 수 있도록 고려해야 함.
//            response.setContentType("text/html;charset=UTF-8");
//
//            //reponse의 메소드를 이용해서 PrintWriter를 가져옴
//            PrintWriter out = response.getWriter(); //  System.out.println 대신에 out.으로 출력가능하다
//
//            //등록된 관리자
//            if (admin != null) {
//                if (admin.getPassword().equals(password)) {
//                    //브라우저에서 html로 출력이 되도록함
//                    out.println(admin.getName() + "님 반갑습니다.<br>");
//                    out.println("<a href='/index.jsp'>관리자 메인페이지 입니다</a>");
//                } else {
//                    out.println("아이디 또는 비밀번호가 틀렸습니다<br>");
//                    out.println("<a href ='/home.jsp' 다시로그인 ></a>");
//                }
//            } else {
//                out.println("아이디 또는 비밀번호가 틀렸습니다<br>");
//                out.println("<a href ='/home.jsp' 다시로그인 ></a>");
//            }
//        }
//    }