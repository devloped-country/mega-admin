package com.mega.biz.curriculum;

import com.mega.biz.curriculum.controller.CreateCurriculumFormController;
import com.mega.biz.curriculum.controller.GetCurriculumListController;
import com.mega.common.controller.Controller;
import com.mega.common.controller.HandlerMapping;
import com.mega.biz.curriculum.controller.TestController;

import java.util.HashMap;
import java.util.Map;

public class CurriculumHandlerMapping extends HandlerMapping {

    private Map<String, Controller> mappings = new HashMap<>();

    public CurriculumHandlerMapping() {
        mappings.put("/test.do", new TestController());
        mappings.put("/getCurriculumList.do", new GetCurriculumListController());
        mappings.put("/createForm.do", new CreateCurriculumFormController());
    }

    @Override
    public Controller getController(String path) {
        return mappings.get(path);
    }
}

