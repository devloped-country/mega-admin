package com.mega.biz.notice.model;

import com.mega.biz.attendance.model.dto.AttendanceDTO;
import com.mega.biz.curriculum.model.CurriculumQuery;
import com.mega.biz.notice.model.dto.NoticeDTO;
import com.mega.biz.notice.model.dto.PageDTO;
import com.mega.config.database.JDBCUtils;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoticeDAO {

    private final DataSource dataSource = JDBCUtils.getDataSource();

    private Connection conn = null;
    private PreparedStatement psmt = null;
    private ResultSet rs = null;

    public void insertNotice(NoticeDTO noticeDTO) {
        try {
            DataSource dataSource = JDBCUtils.getDataSource();
            conn = dataSource.getConnection();
            psmt = conn.prepareStatement(NoticeQuery.NOTICE_INSERT.getQuery());

            psmt.setLong(1, noticeDTO.getTagId());
            psmt.setString(2, noticeDTO.getTitle());
            psmt.setString(3, noticeDTO.getContent());
            psmt.setString(4, noticeDTO.getAuthor());

            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, psmt);
        }
    }

    public NoticeDTO getNoticeById(Long id) {
        NoticeDTO noticeDTO = new NoticeDTO();

        try {
            conn = dataSource.getConnection();
            psmt = conn.prepareStatement(NoticeQuery.NOTICE_GET_BY_ID.getQuery());
            psmt.setLong(1, id);
            rs = psmt.executeQuery();

            while (rs.next()) {

                noticeDTO.setId(rs.getLong("id"));
                noticeDTO.setTagId(rs.getLong("tag_id"));
                noticeDTO.setTitle(rs.getString("title"));
                noticeDTO.setContent(rs.getString("content"));
                noticeDTO.setAuthor(rs.getString("author"));
//                noticeDTO.setCreatedDate(rs.getTimestamp("created_date"));

                Timestamp dbTimestamp = rs.getTimestamp("created_date");
                long nineHoursInMillis = 9 * 60 * 60 * 1000;
                long adjustedTimeInMillis = dbTimestamp.getTime() - nineHoursInMillis;
                noticeDTO.setCreatedDate(new Timestamp(adjustedTimeInMillis));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, psmt, rs);
        }

        return noticeDTO;
    }

    public List<NoticeDTO> getNoticeList(PageDTO pageDTO) {
        List<NoticeDTO> noticeDTOList = new ArrayList<>();

        try {
            conn = dataSource.getConnection();
            psmt = conn.prepareStatement(NoticeQuery.NOTICE_LIST.getQuery());

            psmt.setInt(1, PageDTO.POSTS_PER_PAGE);
            psmt.setInt(2, pageDTO.getStartIndex());

            rs = psmt.executeQuery();

            while (rs.next()) {
                NoticeDTO noticeDTO = new NoticeDTO();

                noticeDTO.setId(rs.getLong("id"));
                noticeDTO.setTagId(rs.getLong("tag_id"));
                noticeDTO.setTitle(rs.getString("title"));
                noticeDTO.setContent(rs.getString("content"));
                noticeDTO.setAuthor(rs.getString("author"));
//                noticeDTO.setCreatedDate(rs.getTimestamp("created_date"));

                Timestamp dbTimestamp = rs.getTimestamp("created_date");
                long nineHoursInMillis = 9 * 60 * 60 * 1000;
                long adjustedTimeInMillis = dbTimestamp.getTime() - nineHoursInMillis;
                noticeDTO.setCreatedDate(new Timestamp(adjustedTimeInMillis));

                noticeDTOList.add(noticeDTO);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, psmt, rs);
        }

        return noticeDTOList;
    }

    public int getNoticeCount() {
        int count = 0;

        try {
            conn = dataSource.getConnection();
            psmt = conn.prepareStatement(NoticeQuery.NOTICE_COUNT_GET.getQuery());
            rs = psmt.executeQuery();

            while (rs.next()) {
                count = rs.getInt("count(*)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, psmt, rs);
        }

        return count;
    }

    public void deleteNotice(NoticeDTO dto) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(
                        NoticeQuery.NOTICE_DELETE.getQuery())
        ) {
            pstmt.setLong(1, dto.getId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, psmt);
        }
    }

    public void updateNotice(NoticeDTO dto) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(
                        NoticeQuery.NOTICE_UPDATE.getQuery())) {

            pstmt.setString(1, dto.getTitle());
            pstmt.setLong(2, dto.getTagId());
            pstmt.setString(3, dto.getContent());
//            pstmt.setString(4, dto.getAuthor());
            pstmt.setLong(4, dto.getId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, psmt);
        }
    }

}
