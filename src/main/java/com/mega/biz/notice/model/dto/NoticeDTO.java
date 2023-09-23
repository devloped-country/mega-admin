package com.mega.biz.notice.model.dto;

import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Data
public class NoticeDTO {

    private Long id;
    private Long tagId;
    private String title;
    private String content;
    private String author;
    private Timestamp createdDate;
}
