package com.mega.biz.user.controller;

import com.mega.biz.user.model.UserDTO;
import com.mega.biz.user.service.UserService;
import com.mega.common.controller.Controller;
import com.mega.biz.sample.model.dto.SampleDTO;
import com.mega.biz.sample.service.SampleService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
public class GetUserListController implements Controller {
    private final UserService service = new UserService();
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("회원목록출력합니다.");

        String test = "test01";

        log.info("log test = {}", test);
        log.info("class = {}", getClass());

        List<UserDTO> userList = service.getUserList();
        request.setAttribute("userList", userList);


        return "userManagement";

    }
}
