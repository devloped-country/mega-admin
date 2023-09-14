package com.mega.biz.curriculum.model.dto;

import lombok.Data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
public class CurriculumWithDetailDTO {

    private Long id;
    private String subject;
    private int time;
    private Date startDate;
    private Date endDate;

    private List<DetailSubjectDTO> detailSubjectDTOList = new ArrayList<>();
}
