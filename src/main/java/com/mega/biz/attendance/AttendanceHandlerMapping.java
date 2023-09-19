package com.mega.biz.attendance;

import com.mega.common.controller.Controller;
import com.mega.common.controller.HandlerMapping;
import com.mega.biz.attendance.controller.AttendanceStatController;

import java.util.HashMap;
import java.util.Map;

public class AttendanceHandlerMapping extends HandlerMapping {

    private Map<String, Controller> mappings = new HashMap<>();

    public AttendanceHandlerMapping() {
        mappings.put("/attendance_stat", new AttendanceStatController());
    }

    @Override
    public Controller getController(String path) {
        return mappings.get(path);
    }
}
