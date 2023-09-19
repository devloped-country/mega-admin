package com.mega.biz.curriculum;

import com.mega.biz.curriculum.controller.*;
import com.mega.common.controller.Controller;
import com.mega.common.controller.HandlerMapping;

import java.util.HashMap;
import java.util.Map;

public class CurriculumHandlerMapping extends HandlerMapping {

    private Map<String, Controller> mappings = new HashMap<>();

    public CurriculumHandlerMapping() {
        mappings.put("/test.do", new TestController());
        mappings.put("/getCurriculumList.do", new GetCurriculumListController());
        mappings.put("/createCurriculumForm.do", new CreateCurriculumFormController());
        mappings.put("/createCurriculum.do", new CreateCurriculumController());
        mappings.put("/deleteCurriculum.do", new DeleteCurriculumController());
        mappings.put("/updateCurriculumForm.do", new UpdateCurriculumFormController());
        mappings.put("/updateCurriculum.do", new UpdateCurriculumController());
    }

    @Override
    public Controller getController(String path) {
        return mappings.get(path);
    }
}

