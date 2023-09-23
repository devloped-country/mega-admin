package com.mega.biz.notice.model.dto;

import lombok.Data;

@Data
public class PageDTO {

    public static final int PAGES_PER_BLOCK = 5;
    public static final int POSTS_PER_PAGE = 10;
    private int totalPost;
    private int startIndex;
    private int totalPage;
}
