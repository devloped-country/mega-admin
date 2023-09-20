package com.mega.biz.user.controller;



import com.mega.biz.login.model.LoginDAO;
import com.mega.biz.login.model.LoginDTO;
import com.mega.biz.user.model.UserDAO;
import com.mega.biz.user.model.UserDTO;
import com.mega.common.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class UserApproveController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request,
                                HttpServletResponse response) {
        System.out.println("가입 승인 처리");
        //가입승인처리



        // 1. 사용자 입력정보 추출
//        String user_status = request.getParameter("USER_STATUS");
        String email = request.getParameter("OK");
        System.out.println(email);
        // 2. DB 연동 처리
        UserDTO vo = new UserDTO();
        vo.setEmail(email);
//        vo.setUser_status(Integer.parseInt(user_status));

        UserDAO dao = new UserDAO();
        dao.userApprove(vo);

        // 3. 화면 이동

            return "getuserlist.do";
        }
    }


