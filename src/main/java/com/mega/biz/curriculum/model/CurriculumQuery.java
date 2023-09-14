package com.mega.biz.curriculum.model;

public enum CurriculumQuery {

    CURRICULUM_LIST("select * from curriculum"),
    DETAIL_BY_CURRICULUM_ID("select * from detail_subject where curriculum_id = ?"),
    DETAIL_LIST("select * from detail_subject");

    private final String query;

    CurriculumQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
