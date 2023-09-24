package com.mega.biz.attendance.model.dto;

import lombok.*;

@Data
public class PageDTO {

    public static final int PAGES_PER_BLOCK = 5;
    public static final int POSTS_PER_PAGE = 9;
    private int totalPost;
    private int startIndex;
    private int totalPage;

//    private void Paging(String keyword) {
//
//        // 현재 페이지 블록의 범위 = ((현재 페이지 - 1) / 블록당 페이지 수) * 블록당 페이지 수 + 1;
//        int currentPageBlock = ((currentPage - 1) / PAGES_PER_BLOCK) * PAGES_PER_BLOCK + 1;
//        // 페이지에서 시작하는 번호 = (현재 페이지 -1) * 페이지 당 게시글 수 => mysql 에서 offset 값 설정
//        int startIndex = (currentPage - 1) * POSTS_PER_PAGE;
//        // limit 값 지정, 현재는 10개만 보이게 해둠 0 <= ? < 10
//        int num = POSTS_PER_PAGE;
//        // 페이지 블록 수 = (수학올림적용(총 게시글 수)/페이지 당 게시글 수)
//        int totalPage = ((int)Math.ceil((double).getTotalUser(keyword)/POSTS_PER_PAGE));
//
//    }
}
