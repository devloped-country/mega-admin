package com.mega.biz.user.controller;



import com.mega.biz.login.model.LoginDAO;
import com.mega.biz.login.model.LoginDTO;
import com.mega.biz.user.model.UserDAO;
import com.mega.biz.user.model.UserDTO;
import com.mega.common.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class UserDeleteController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request,
                                HttpServletResponse response) {
        System.out.println("회원 탈퇴 처리");

        // 1. 사용자 입력정보 추출
        String email = request.getParameter("NO");

        // 2. DB 연동 처리
        UserDTO vo = new UserDTO();
        vo.setEmail(email);

        UserDAO dao = new UserDAO();
        dao.deleteUser(vo);

        // 3. 화면 이동

        return "getuserlist.do";

    }
}

