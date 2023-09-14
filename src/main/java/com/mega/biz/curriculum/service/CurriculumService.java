package com.mega.biz.curriculum.service;

import com.mega.biz.curriculum.CurriculumDAO;
import com.mega.biz.curriculum.model.dto.CurriculumWithDetailDTO;
import com.mega.biz.curriculum.model.dto.DetailSubjectDTO;

import java.util.List;

public class CurriculumService {

    CurriculumDAO dao = new CurriculumDAO();

    public void deleteCurriculum(Long curriculumId) {
        dao.deleteCurriculum(curriculumId);
    }

    public void registerCurriculum(CurriculumWithDetailDTO dto) {
        dao.insertCurriculum(dto);

        Long id = dao.getMaxCurriculumId();

        List<DetailSubjectDTO> detailSubjectDTOList = dto.getDetailSubjectDTOList();
        for (DetailSubjectDTO detailSubjectDTO : detailSubjectDTOList) {
            dao.insertDetail(id, detailSubjectDTO);
        }
    }

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
