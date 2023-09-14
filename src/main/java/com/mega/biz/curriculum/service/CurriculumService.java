package com.mega.biz.curriculum.service;

import com.mega.biz.curriculum.CurriculumDAO;
import com.mega.biz.curriculum.model.dto.CurriculumWithDetailDTO;
import com.mega.biz.curriculum.model.dto.DetailSubjectDTO;

import java.util.List;

public class CurriculumService {

    CurriculumDAO dao = new CurriculumDAO();

    public List<CurriculumWithDetailDTO> getAllCurriculumWithDetail() {

        List<CurriculumWithDetailDTO> allCurriculum = dao.getAllCurriculum();

        for (CurriculumWithDetailDTO curriculumWithDetailDTO : allCurriculum) {
            List<DetailSubjectDTO> detailByCurriculumId = dao.getDetailByCurriculumId(curriculumWithDetailDTO.getId());
            for (DetailSubjectDTO detailSubjectDTO : detailByCurriculumId) {
                curriculumWithDetailDTO.getDetailSubjectDTOList().add(detailSubjectDTO);
            }
        }

        return allCurriculum;
    }
}
