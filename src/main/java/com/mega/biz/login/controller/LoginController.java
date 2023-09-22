package com.mega.biz.login.controller;


import com.mega.biz.login.model.LoginDAO;
import com.mega.biz.login.model.LoginDTO;
import com.mega.common.controller.Controller;
import com.mega.common.encrypt.EncryptUtils;
import com.mega.common.encrypt.sha256.SHA256;

import javax.naming.spi.DirStateFactory;
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

        EncryptUtils encryptUtils = new EncryptUtils();

        // 2. DB 연동 처리
        LoginDTO vo = new LoginDTO();
        vo.setAccount(account);

        LoginDAO dao = new LoginDAO();
        LoginDTO admin = dao.getAdmin(vo); //admin객체안에 account,password,name이 들어있다

        String salt = admin.getSalt();
        String dbPassword =  admin.getPassword();

        String finalPassword = encryptUtils.getEncrypt(password, salt );




        // 3. 화면 이동
        HttpSession session = request.getSession();
        if (admin != null && finalPassword.equals(dbPassword)) {
            // 상태 정보를 세션에 저장한다.
            session.setAttribute("admin", admin);
            session.setAttribute("name", admin.getName());

            // 글 목록 화면으로 이동한다.
            return "WEB-INF/view/home/home";   //index 아니면 이걸로
        } else {
            request.setAttribute("loginError", "아이디 또는 비밀번호가 일치하지 않습니다.");
            return "index";
        }
    }
}







/////////////////////////////////////////////////////////////////////////////

//
//public class LoginController implements Controller {
//
//    @Override
//    public String handleRequest(HttpServletRequest request,
//                                HttpServletResponse response) {
//        System.out.println("로그인 처리");
//
//        // 1. 사용자 입력정보 추출
//        String account = request.getParameter("account");
//        String password = request.getParameter("password");
//
//        // 2. DB 연동 처리
//        LoginDTO vo = new LoginDTO();
//        vo.setAccount(account);
//
//        LoginDAO dao = new LoginDAO();
//        LoginDTO admin = dao.getAdmin(vo);
//
//        // 3. 화면 이동
//        HttpSession session = request.getSession();
//        if (admin != null && admin.getPassword().equals(password)) {
//            // 상태 정보를 세션에 저장한다.
//            session.setAttribute("admin", admin);
//            // 글 목록 화면으로 이동한다.
//            return "WEB-INF/view/home/home";   //index 아니면 이걸로
//        } else {
//            request.setAttribute("loginError", "아이디 또는 비밀번호가 일치하지 않습니다.");
//            return "index";
//        }
//    }
//}
//




////////////////////////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////////////////////////

