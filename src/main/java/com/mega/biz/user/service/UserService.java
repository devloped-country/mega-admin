package com.mega.biz.user.service;

import com.mega.biz.user.model.UserDAO;
import com.mega.biz.user.model.UserDTO;

import java.util.List;


public class UserService {

    private final UserDAO dao = new UserDAO();

    public List<UserDTO> getUserList() {
        return dao.getUserList();
    }

    public void userApprove(UserDTO userDTO) {
        dao.userApprove(userDTO);
    }

    public void deleteUser(UserDTO userDTO) {
        dao.deleteUser(userDTO);
    }
}
