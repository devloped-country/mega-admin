package com.mega.biz.curriculum.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DetailSubjectDTO {

    private Long id;
    private Long curriculumId;
    private String content;

    public DetailSubjectDTO(String content) {
        this.content = content;
    }
}
