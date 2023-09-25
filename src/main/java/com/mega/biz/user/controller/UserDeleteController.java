package com.mega.biz.user.controller;



import com.mega.biz.login.model.LoginDAO;
import com.mega.biz.login.model.LoginDTO;
import com.mega.biz.user.model.UserDAO;
import com.mega.biz.user.model.UserDTO;
import com.mega.biz.user.model.UserPageDTO;
import com.mega.biz.user.service.UserService;
import com.mega.common.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


public class UserDeleteController implements Controller {
UserService service = new UserService();

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
        service.deleteUser(vo);

        // 3. 화면 이동


        int page = 1;

        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
//        System.out.println("page : " + page);
        // UserPageDTO를 사용하여 페이징 정보 설정
        UserPageDTO paging = new UserPageDTO();
        paging.setPage(page);
        // 전체 사용자 수를 설정 (이 값을 실제 DB에서 가져와야 함)
        int totalCount = dao.getTotalUser(); // 예시로 메서드 호출
//        System.out.println(totalCount);
        paging.setTotalCount(totalCount);

        // 사용자 리스트를 페이징된 결과로 가져옴
        List<UserDTO> list = dao.selectAllMember(page);

        // request에 사용자 리스트와 페이징 정보를 설정
        request.setAttribute("userList", list);
        request.setAttribute("paging", paging);
        request.setAttribute("page", page);

        return "getuserlist.do?page=" + page ;
    }
}

