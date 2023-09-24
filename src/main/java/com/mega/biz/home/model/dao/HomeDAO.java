package com.mega.biz.home.model.dao;

import com.mega.biz.home.model.HomeQuery;
import com.mega.biz.home.model.dto.HomeDTO;
import com.mega.biz.home.model.dto.NoticeDTO;
import com.mega.config.database.JDBCUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;

public class HomeDAO {

  private Connection conn = null;
  private PreparedStatement pstmt = null;
  private ResultSet rs = null;

  public HomeDTO selectAttendanceCount() {
    HomeDTO dto = new HomeDTO();

    try {
      DataSource dataSource = JDBCUtils.getDataSource();
      conn = dataSource.getConnection();
      pstmt = conn.prepareStatement(HomeQuery.ATTENDANCE_STUDENT_COUNT.getQuery());
      rs = pstmt.executeQuery();

      if(rs.next()) {
        dto.setAttendance(rs.getInt("count(*)"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JDBCUtils.close(conn, pstmt);
    }

    return dto;
  }

  public HomeDTO selectUnAttendanceCount() {
    HomeDTO dto = new HomeDTO();

    try {
      DataSource dataSource = JDBCUtils.getDataSource();
      conn = dataSource.getConnection();
      pstmt = conn.prepareStatement(HomeQuery.UN_ATTENDANCE_STUDENT_COUNT.getQuery());
      rs = pstmt.executeQuery();

      if(rs.next()) {
        dto.setUnAttendance(rs.getInt("count(*)"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JDBCUtils.close(conn, pstmt);
    }

    return dto;
  }

  public ArrayList<NoticeDTO> selectRecentNotice() {
    ArrayList<NoticeDTO> dtos = new ArrayList<>();

    try {
      DataSource dataSource = JDBCUtils.getDataSource();
      conn = dataSource.getConnection();
      pstmt = conn.prepareStatement(HomeQuery.RECENT_NOTICE_SELECT.getQuery());
      rs = pstmt.executeQuery();

      while(rs.next()) {
        NoticeDTO dto = new NoticeDTO();

        dto.setId(rs.getInt("id"));
        dto.setTag(rs.getInt("tag_id"));
        dto.setTitle(rs.getString("title"));
        dto.setContent(rs.getString("content"));
        dto.setAuthor(rs.getString("author"));
        dto.setCreated_date(rs.getDate("created_date"));

        dtos.add(dto);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JDBCUtils.close(conn, pstmt);
    }

    return dtos;
  }
}
