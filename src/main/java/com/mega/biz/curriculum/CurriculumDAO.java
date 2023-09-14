package com.mega.biz.curriculum;

import com.mega.biz.curriculum.model.CurriculumQuery;
import com.mega.biz.curriculum.model.dto.CurriculumWithDetailDTO;
import com.mega.biz.curriculum.model.dto.DetailSubjectDTO;
import com.mega.config.database.JDBCUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CurriculumDAO {

    private final DataSource dataSource = JDBCUtils.getDataSource();

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public void deleteCurriculum(Long curriculumId) {
        try {
            DataSource dataSource = JDBCUtils.getDataSource();
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(CurriculumQuery.DELETE_CURRICULUM.getQuery());

            pstmt.setLong(1, curriculumId);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt);
        }
    }

    public void insertDetail(Long curriculumId, DetailSubjectDTO detailSubjectDTO) {
        try {
            DataSource dataSource = JDBCUtils.getDataSource();
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(CurriculumQuery.INSERT_DETAIL.getQuery());

            pstmt.setLong(1, curriculumId);
            pstmt.setString(2, detailSubjectDTO.getContent());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt);
        }

    }

    public void insertCurriculum(CurriculumWithDetailDTO curriculumWithDetailDTO) {

        try {
            DataSource dataSource = JDBCUtils.getDataSource();
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(CurriculumQuery.INSERT_CURRICULUM.getQuery());

            pstmt.setString(1, curriculumWithDetailDTO.getSubject());
            pstmt.setInt(2, curriculumWithDetailDTO.getTime());
            pstmt.setDate(3, curriculumWithDetailDTO.getStartDate());
            pstmt.setDate(4, curriculumWithDetailDTO.getEndDate());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt);
        }
    }

    public List<DetailSubjectDTO> getDetailByCurriculumId(Long curriculumId) {
        List<DetailSubjectDTO> detailList = new ArrayList<>();

        try {
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(CurriculumQuery.DETAIL_BY_CURRICULUM_ID.getQuery());
            pstmt.setLong(1, curriculumId);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                DetailSubjectDTO detail = new DetailSubjectDTO();

                detail.setId(rs.getLong("ID"));
                detail.setCurriculumId(rs.getLong("CURRICULUM_ID"));
                detail.setContent(rs.getString("CONTENT"));
                detailList.add(detail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt, rs);
        }

        return detailList;
    }

    public Long getMaxCurriculumId() {

        Long maxId = 0L;

        try {
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(CurriculumQuery.GET_MAX_CURRICULUM_ID.getQuery());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                maxId = rs.getLong("max");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt, rs);
        }
        return maxId;
    }


    // test 용

    public List<CurriculumWithDetailDTO> getAllCurriculum() {
        List<CurriculumWithDetailDTO> curriculumDTOList = new ArrayList<>();

        try {
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(CurriculumQuery.CURRICULUM_LIST.getQuery());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                CurriculumWithDetailDTO curriculumDTO = new CurriculumWithDetailDTO();

                curriculumDTO.setId(rs.getLong("ID"));
                curriculumDTO.setSubject(rs.getString("SUBJECT"));
                curriculumDTO.setTime(rs.getInt("TIME"));
                curriculumDTO.setStartDate(rs.getDate("START_DATE"));
                curriculumDTO.setEndDate(rs.getDate("END_DATE"));

                curriculumDTOList.add(curriculumDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt, rs);
        }

        return curriculumDTOList;
    }

    public List<DetailSubjectDTO> getDetail() {
        List<DetailSubjectDTO> detailList = new ArrayList<>();

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(CurriculumQuery.DETAIL_LIST.getQuery());
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                DetailSubjectDTO detail = new DetailSubjectDTO();
                detail.setId(rs.getLong("ID"));
                detail.setCurriculumId(rs.getLong("CURRICULUM_ID"));
                detail.setContent(rs.getString("CONTENT"));
                detailList.add(detail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return detailList;
    }
}
