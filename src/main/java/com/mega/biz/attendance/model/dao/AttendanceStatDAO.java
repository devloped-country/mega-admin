package com.mega.biz.attendance.model.dao;

import com.mega.biz.attendance.model.AttendanceStatQuery;
import com.mega.biz.attendance.model.dto.AttendanceDateDTO;
import com.mega.biz.attendance.model.dto.AttendanceDatesDTO;
import com.mega.biz.attendance.model.dto.AttendanceDetailInfoDTO;
import com.mega.biz.attendance.model.dto.AttendanceInfoDTO;
import com.mega.biz.attendance.model.dto.AttendanceUserDTO;
import com.mega.config.database.JDBCUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
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

  public AttendanceInfoDTO selectAttendanceInfos(AttendanceUserDTO attendanceUserDTO) {
    String name = attendanceUserDTO.getName();

    AttendanceInfoDTO attendanceInfoDTO = new AttendanceInfoDTO();
    attendanceInfoDTO.setName(name);

    try {
      DataSource dataSource = JDBCUtils.getDataSource();
      conn = dataSource.getConnection();
      pstmt = conn.prepareStatement(AttendanceStatQuery.ATTENDANCE_STAT_SELECT.getQuery());
      pstmt.setString(1, name);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        AttendanceDetailInfoDTO attendanceDetailInfoDTO = new AttendanceDetailInfoDTO();
        attendanceDetailInfoDTO.setStatus(rs.getInt("attendance_stat"));
        attendanceDetailInfoDTO.setDate(rs.getDate("start_date"));

        attendanceInfoDTO.getAttendanceInfos().add(attendanceDetailInfoDTO);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JDBCUtils.close(conn, pstmt);
    }

    return attendanceInfoDTO;
  }

  public AttendanceDatesDTO selectAttendanceDates() {
    AttendanceDatesDTO attendanceDatesDTO = new AttendanceDatesDTO();

    try {
      DataSource dataSource = JDBCUtils.getDataSource();
      conn = dataSource.getConnection();
      pstmt = conn.prepareStatement(AttendanceStatQuery.ATTENDANCE_DURATION_SELECT.getQuery());
      rs = pstmt.executeQuery();

      if(rs.next()) {
        int duration = rs.getInt("duration");

        attendanceDatesDTO.setDuration(duration);

        LocalDate date = LocalDate.now();
        // 해당 달을 적용해야함
        int year = date.getYear();
        int month = date.getMonthValue();

        Calendar cal = Calendar.getInstance();

        for(int i=duration; i<=cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
          AttendanceDateDTO attendanceDateDTO = new AttendanceDateDTO();

          LocalDate localDate = LocalDate.of(year, month-1, i);
          DayOfWeek dayOfWeek = localDate.getDayOfWeek();

          if(dayOfWeek.toString().equals("SATURDAY") || dayOfWeek.toString().equals("SUNDAY")) {
            continue;
          }

          attendanceDateDTO.setDate(Date.valueOf(localDate));
          attendanceDateDTO.setDay(dayOfWeek.getDisplayName(TextStyle.NARROW, Locale.KOREAN));

          attendanceDatesDTO.getAttendanceDates().add(attendanceDateDTO);
        }

        for(int i=1; i<duration; i++) {
          AttendanceDateDTO attendanceDateDTO = new AttendanceDateDTO();

          LocalDate localDate = LocalDate.of(year, month, i);
          DayOfWeek dayOfWeek = localDate.getDayOfWeek();

          if(dayOfWeek.toString().equals("SATURDAY") || dayOfWeek.toString().equals("SUNDAY")) {
            continue;
          }

          attendanceDateDTO.setDate(Date.valueOf(localDate));
          attendanceDateDTO.setDay(dayOfWeek.getDisplayName(TextStyle.NARROW, Locale.KOREAN));

          attendanceDatesDTO.getAttendanceDates().add(attendanceDateDTO);
        }
      }

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JDBCUtils.close(conn, pstmt);
    }

    return attendanceDatesDTO;
  }

  public int selectAttendanceStatCount(AttendanceUserDTO attendanceUserDTO, int statIndex, int duration) {
    int count = 1;
    LocalDate localStartDateString =  LocalDate.now().minusMonths(1);
    LocalDate localEndDateString =  LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    String startDate = localStartDateString.format(formatter).toString().substring(0,8) + ((duration < 10) ? "0" + duration : duration);
    String endDate = localEndDateString.format(formatter).toString().substring(0,8) + ((duration < 10) ? "0" + duration : duration);

    try {
      DataSource dataSource = JDBCUtils.getDataSource();
      conn = dataSource.getConnection();
      pstmt = conn.prepareStatement(AttendanceStatQuery.ATTENDANCE_STAT_COUNT_SELECT.getQuery());
      pstmt.setString(1, attendanceUserDTO.getName());
      pstmt.setInt(2, statIndex);
      pstmt.setString(3, startDate);
      pstmt.setString(4, endDate);
      rs = pstmt.executeQuery();

      if(rs.next()) {
        count = rs.getInt("attendance_stat_count");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JDBCUtils.close(conn, pstmt);
    }
    
    return count;
  }

  public int selectAttendanceDuration() {
    int duration = 0;

    try {
      DataSource dataSource = JDBCUtils.getDataSource();
      conn = dataSource.getConnection();
      pstmt = conn.prepareStatement(AttendanceStatQuery.ATTENDANCE_DURATION_SELECT.getQuery());
      rs = pstmt.executeQuery();

      if(rs.next()) {
        duration = rs.getInt("duration");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JDBCUtils.close(conn, pstmt);
    }

    return duration;
  }
}

