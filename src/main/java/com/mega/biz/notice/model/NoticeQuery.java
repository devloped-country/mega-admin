package com.mega.biz.notice.model;

public enum NoticeQuery {


    NOTICE_INSERT("insert into notice2 (tag_id, title, content, author) values(?, ?, ?, ?)"),
    NOTICE_GET_BY_ID("select * from notice2 where id = ?"),
    NOTICE_LIST("select * from notice2 order by created_date desc LIMIT ? OFFSET ?"),
    NOTICE_COUNT_GET("select count(*) from notice2"),
    NOTICE_DELETE("DELETE FROM notice2 WHERE id=?"),
    NOTICE_UPDATE("UPDATE notice2 SET title=?, tag_id=?, content=? WHERE id=?");

    private final String query;

    NoticeQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
