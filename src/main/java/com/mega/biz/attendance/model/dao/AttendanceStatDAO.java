package com.mega.biz.attendance.model.dao;

import com.mega.biz.attendance.model.AttendanceStatQuery;
import com.mega.biz.attendance.model.dto.AttendanceStatDTO;
import com.mega.biz.attendance.model.dto.AttendanceUserDTO;
import com.mega.config.database.JDBCUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;


public class AttendanceStatDAO {

  private Connection conn = null;
  private PreparedStatement pstmt = null;
  private ResultSet rs = null;

  public ArrayList<AttendanceUserDTO> selectAttendanceUserNames() {
    ArrayList<AttendanceUserDTO> attendanceUsersDTO = new ArrayList<>();

    try {
      DataSource dataSource = JDBCUtils.getDataSource();
      conn = dataSource.getConnection();
      pstmt = conn.prepareStatement(AttendanceStatQuery.USER_SELECT.getQuery());
      rs = pstmt.executeQuery();

      while (rs.next()) {
        AttendanceUserDTO attendanceUserDTO = new AttendanceUserDTO();
        attendanceUserDTO.setName(rs.getString("name"));
        attendanceUsersDTO.add(attendanceUserDTO);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JDBCUtils.close(conn, pstmt);
    }

    return attendanceUsersDTO;
  }

  public ArrayList<AttendanceStatDTO> selectAttendanceInfo(AttendanceUserDTO attendanceUserDTO) {
    ArrayList<AttendanceStatDTO> attendanceStatsDTO = new ArrayList<>();

    try {
      DataSource dataSource = JDBCUtils.getDataSource();
      conn = dataSource.getConnection();
      pstmt = conn.prepareStatement(AttendanceStatQuery.ATTENDANCE_STAT_SELECT.getQuery());
      pstmt.setString(1, attendanceUserDTO.getName());
      rs = pstmt.executeQuery();

      while (rs.next()) {
        AttendanceStatDTO dto = new AttendanceStatDTO();
        dto.setStatus(rs.getInt("attendance_stat"));
        dto.setDate(rs.getDate("start_date"));

        attendanceStatsDTO.add(dto);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JDBCUtils.close(conn, pstmt);
    }

    return attendanceStatsDTO;
  }
}
