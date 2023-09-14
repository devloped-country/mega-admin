package com.mega.biz.curriculum.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class CurriculumWithDetailDTO {

    private Long id;
    private String subject;
    private int time;
    private Date startDate;
    private Date endDate;

    private List<DetailSubjectDTO> detailSubjectDTOList = new ArrayList<>();

    public CurriculumWithDetailDTO(String subject, int time, Date startDate, Date endDate) {
        this.subject = subject;
        this.time = time;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
