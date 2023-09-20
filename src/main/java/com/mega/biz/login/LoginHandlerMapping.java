package com.mega.biz.login;

import com.mega.biz.login.controller.LoginController;
import com.mega.common.controller.Controller;
import com.mega.common.controller.HandlerMapping;

import java.util.HashMap;
import java.util.Map;

public class LoginHandlerMapping extends HandlerMapping {

    private Map<String, Controller> mappings = new HashMap<>();

    public LoginHandlerMapping() {
        mappings.put("/login.do", new LoginController());

    }

    @Override
    public Controller getController(String path) {
        return mappings.get(path);
    }
}
