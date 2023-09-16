package com.mega.biz.curriculum.controller;

import com.mega.biz.curriculum.model.dto.CurriculumWithDetailDTO;
import com.mega.biz.curriculum.model.dto.DetailSubjectDTO;
import com.mega.biz.curriculum.service.CurriculumService;
import com.mega.common.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UpdateCurriculumController implements Controller {

    private final CurriculumService service = new CurriculumService();

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        // 디테일 삭제 로직
        String[] parameterValues = request.getParameterValues("removedDetails");

        if (parameterValues != null) {
            for (String parameterValue : parameterValues) {
                long detailId = Long.parseLong(parameterValue);
                service.deleteDetail(detailId);
            }
        }

        // 커리큘럼 업데이트
        long curriculumId = Long.parseLong(request.getParameter("curriculumId"));
        CurriculumWithDetailDTO curriculumDto = setCurriculumDto(request);
        service.updateCurriculum(curriculumId, curriculumDto);

        // 디테일 업데이트
        Map<String, String> detailMap = setDetailMap(request);
        Set<String> detailIds = detailMap.keySet();
        for (String detailId : detailIds) {
            long id = Long.parseLong(detailId);
            String detailContent = detailMap.get(detailId);

            service.updateDetail(detailContent, curriculumId, id);
        }

        // 디테일 Insert
        String[] addDetailContentList = request.getParameterValues("addDetail");
        if (addDetailContentList != null) {
            for (String detail : addDetailContentList) {
                DetailSubjectDTO dto = new DetailSubjectDTO(detail);
                service.insertDetail(curriculumId, dto);
            }
        }
        return "getCurriculumList.do";
    }

    private CurriculumWithDetailDTO setCurriculumDto(HttpServletRequest request) {
        String subject = request.getParameter("subject");
        int time = Integer.parseInt(request.getParameter("time"));
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");

        CurriculumWithDetailDTO curriculumDto = new CurriculumWithDetailDTO(subject, time, Date.valueOf(startDate), Date.valueOf(endDate));
        return curriculumDto;
    }

    private Map<String, String > setDetailMap(HttpServletRequest request) {
        String[] detailContents = request.getParameterValues("detail");
        String[] detailIds = request.getParameterValues("detailId");

        Map<String, String> detailMap = new HashMap<>();

        if (detailIds != null && detailContents != null && detailIds.length == detailContents.length) {

            for (int i = 0; i < detailIds.length; i++) {
                detailMap.put(detailIds[i], detailContents[i]);
            }
        }

        return detailMap;
    }
}
