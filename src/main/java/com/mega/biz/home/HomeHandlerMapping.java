package com.mega.biz.home;

import com.mega.common.controller.Controller;
import com.mega.common.controller.HandlerMapping;
import com.mega.biz.home.controller.HomeController;


import java.util.HashMap;
import java.util.Map;

public class HomeHandlerMapping extends HandlerMapping {

    private Map<String, Controller> mappings = new HashMap<>();

    public HomeHandlerMapping() {
        mappings.put("/home", new HomeController());
    }

    @Override
    public Controller getController(String path) {
        return mappings.get(path);
    }
}
