package com.mega.biz.notice;

import com.mega.biz.notice.controller.*;
import com.mega.common.controller.Controller;
import com.mega.common.controller.HandlerMapping;


import java.util.HashMap;
import java.util.Map;

public class NoticeHandlerMapping extends HandlerMapping {

    private Map<String, Controller> mappings = new HashMap<>();

    public NoticeHandlerMapping() {
        mappings.put("/test.do", new TestController());
        mappings.put("/getNoticeList.do", new GetNoticeListController());
        mappings.put("/noticeDetail.do", new GetNoticeDetailController());
        mappings.put("/createNoticeForm.do", new CreateNoticeFormController());
        mappings.put("/createNotice.do", new CreateNoticeController());
        mappings.put("/deleteNotice.do", new DeleteNoticeController());
        mappings.put("/updateNoticeForm.do", new UpdateNoticeFormController());
        mappings.put("/updateNotice.do", new UpdateNoticeController());
    }

    @Override
    public Controller getController(String path) {
        return mappings.get(path);
    }
}
