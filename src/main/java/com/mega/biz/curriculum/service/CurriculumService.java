package com.mega.biz.curriculum.service;

import com.mega.biz.curriculum.model.CurriculumDAO;
import com.mega.biz.curriculum.model.dto.CurriculumWithDetailDTO;
import com.mega.biz.curriculum.model.dto.DetailSubjectDTO;

import java.util.List;

public class CurriculumService {

    private final CurriculumDAO dao = new CurriculumDAO();

    public List<CurriculumWithDetailDTO> getAllCurriculumWithDetail() {

        List<CurriculumWithDetailDTO> allCurriculum = dao.getAllCurriculum();

        for (CurriculumWithDetailDTO curriculumWithDetailDTO : allCurriculum) {
            List<DetailSubjectDTO> detailsByCurriculumId = dao.getDetailListByCurriculumId(curriculumWithDetailDTO.getId());
            for (DetailSubjectDTO detailSubjectDTO : detailsByCurriculumId) {
                curriculumWithDetailDTO.getDetailSubjectDTOList().add(detailSubjectDTO);
            }
        }

        return allCurriculum;
    }

    public void insertDetail(Long curriculumId, DetailSubjectDTO detailSubjectDTO) {
        dao.insertDetail(curriculumId, detailSubjectDTO);
    }

    public void updateDetail(String detailContent, Long curriculumId, Long detailId) {
        dao.updateDetail(detailContent, curriculumId, detailId);
    }

    public void updateCurriculum(Long curriculumId, CurriculumWithDetailDTO curriculumWithDetailDTO) {
        dao.updateCurriculum(curriculumId, curriculumWithDetailDTO);
    }

    public void deleteDetail(Long detailId) {
        dao.deleteDetail(detailId);
    }

    public CurriculumWithDetailDTO getCurriculumWithDetailById(Long curriculumId) {

        CurriculumWithDetailDTO curriculum = dao.getCurriculumById(curriculumId);

        List<DetailSubjectDTO> detailList = dao.getDetailListByCurriculumId(curriculumId);
        for (DetailSubjectDTO detailSubjectDTO : detailList) {
            curriculum.getDetailSubjectDTOList().add(detailSubjectDTO);
        }

        return curriculum;
    }

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
}
