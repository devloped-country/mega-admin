package com.mega.biz.attendance;

import com.mega.biz.attendance.controller.GetAttendanceDetailListController;
import com.mega.biz.attendance.controller.GetAttendanceListController;
import com.mega.common.controller.Controller;
import com.mega.common.controller.HandlerMapping;

import java.util.HashMap;
import java.util.Map;

public class AttendanceHandlerMapping extends HandlerMapping {

    private Map<String, Controller> mappings = new HashMap<>();

    public AttendanceHandlerMapping() {
        mappings.put("/attendance.do", new GetAttendanceListController());
        mappings.put("/attendanceDetail.do", new GetAttendanceDetailListController());
    }

    @Override
    public Controller getController(String path) {
        return mappings.get(path);
    }
}
