package com.mega.biz.curriculum.model.dto;

import lombok.Data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
public class CurriculumDTO {

    private Long id;
    private String subject;
    private int time;
    private Date starDate;
    private Date endDate;
}
