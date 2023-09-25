//package com.mega.biz.user.controller;
//
//import com.mega.biz.user.model.UserDAO;
//import com.mega.biz.user.model.UserDTO;
//import com.mega.biz.user.model.UserPageDTO;
//import com.mega.biz.user.service.UserService;
//import com.mega.common.controller.Controller;
//import lombok.extern.slf4j.Slf4j;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.List;
//
//@Slf4j
//public class GetUserListControllerPage implements Controller {
//    private final UserService service = new UserService();
//    @Override
//    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
//        System.out.println("회원목록출력합니다.");
//
//        UserDAO userDAO = new UserDAO();
//
//        int page = Integer.parseInt(request.getParameter("page")); //현제페이지를 여기넣고 +  추가로 다른 곳에서 처음오면 1페이로 가게만들기???
//        System.out.println("page="+ page);
//
//
//        if (request.getParameter("page") != null) {
//            page = Integer.parseInt(request.getParameter("page"));
//        }
//        System.out.println(page);
//        // UserPageDTO를 사용하여 페이징 정보 설정
//        UserPageDTO paging = new UserPageDTO();
//        paging.setPage(page);
//        // 전체 사용자 수를 설정 (이 값을 실제 DB에서 가져와야 함)
//        int totalCount = userDAO.getTotalUser(); // 예시로 메서드 호출
//        System.out.println(totalCount);
//        paging.setTotalCount(totalCount);
//
//        // 사용자 리스트를 페이징된 결과로 가져옴
//        List<UserDTO> list = userDAO.selectAllMember(page);
//
//        // request에 사용자 리스트와 페이징 정보를 설정
//        request.setAttribute("userList", list);
//        request.setAttribute("paging", paging);
//
//
//        return "userManagement";
//
//    }
//}
