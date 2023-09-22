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

        mappings.put("/userapprove.do", new UserApproveController()); //return값을 보내줄때 필요한 매핑이고 vs form으로 보내는 주소는 바로 딱 ! 보내주는것다
        mappings.put("/deleteuser.do", new UserDeleteController());
        mappings.put("/getuserlist.do", new GetUserListController());


    }

    @Override
    public Controller getController(String path) {
        return mappings.get(path);
    }
}
