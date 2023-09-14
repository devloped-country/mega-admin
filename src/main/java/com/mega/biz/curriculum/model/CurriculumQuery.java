package com.mega.biz.curriculum.model;

public enum CurriculumQuery {

    DELETE_CURRICULUM("delete from curriculum where id = ?"),

    GET_MAX_CURRICULUM_ID("select max(id) max from curriculum"),
    INSERT_DETAIL("insert into detail_subject (CURRICULUM_ID, CONTENT) values(?, ?)"),
    INSERT_CURRICULUM("insert into curriculum (SUBJECT, TIME, START_DATE, END_DATE) values(?, ?, ?, ?)"),
    CURRICULUM_LIST("select * from curriculum order by START_DATE"),
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
