package com.mega.biz.user;

import com.mega.biz.user.controller.GetUserListController;
import com.mega.biz.user.controller.UserApproveController;
import com.mega.common.controller.Controller;
import com.mega.common.controller.HandlerMapping;
import com.mega.biz.user.controller.UserDeleteController;


import java.util.HashMap;
import java.util.Map;

public class UserHandlerMapping extends HandlerMapping {

    private Map<String, Controller> mappings = new HashMap<>();

    public UserHandlerMapping() {

        mappings.put("/userapprove.do", new UserApproveController());
        mappings.put("/deleteuser.do", new UserDeleteController());
        mappings.put("/getuserlist.do", new GetUserListController());


    }

    @Override
    public Controller getController(String path) {
        return mappings.get(path);
    }
}
