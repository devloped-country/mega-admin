package com.mega.biz.attendance.model.dao;


import com.mega.biz.attendance.model.AttendanceQuery;
import com.mega.biz.attendance.model.dto.AttendanceDTO;
import com.mega.biz.attendance.model.dto.PageDTO;
import com.mega.config.database.JDBCUtils;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class AttendanceDAO {

    private final DataSource dataSource = JDBCUtils.getDataSource();

    private Connection conn = null;
    private PreparedStatement psmt = null;
    private ResultSet rs = null;

    // attendanceList

    public int getTotalUser(String keyword) {
        int count = 0;

        try {
            if (keyword != null) {
                conn = dataSource.getConnection();
                psmt = conn.prepareStatement(AttendanceQuery.ATTENDANCE_USER_COUNT.getQuery() + "WHERE name LIKE ?");
                psmt.setString(1, "%" + keyword + "%");
            } else {
                conn = dataSource.getConnection();
                psmt = conn.prepareStatement(AttendanceQuery.ATTENDANCE_USER_COUNT.getQuery());
            }
            rs = psmt.executeQuery();

            if (rs.next()) {
                count = rs.getInt("count(*)");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, psmt, rs);
        }

        return count;
    }


    public List<AttendanceDTO> getAttendanceList(PageDTO pageDTO) {
        List<AttendanceDTO> attendanceList = new ArrayList<>();

        try {
            conn = dataSource.getConnection();
            psmt = conn.prepareStatement(AttendanceQuery.ATTENDANCE_LIST.getQuery());

            psmt.setInt(1, PageDTO.POSTS_PER_PAGE);
            psmt.setInt(2, pageDTO.getStartIndex());

            rs = psmt.executeQuery();

            while (rs.next()) {
                AttendanceDTO attendanceDTO = new AttendanceDTO();

                attendanceDTO.setEmail(rs.getString("EMAIL"));
                attendanceDTO.setPassword(rs.getString("PASSWORD"));
                attendanceDTO.setName(rs.getString("NAME"));
                attendanceDTO.setPhone(rs.getString("PHONE"));
                attendanceList.add(attendanceDTO);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, psmt, rs);
        }

        return attendanceList;
    }

    public List<AttendanceDTO> getSearchList(String keyword, PageDTO pageDTO) {
        List<AttendanceDTO> searchList = new ArrayList<>();

        try {
            conn = dataSource.getConnection();
            psmt = conn.prepareStatement(AttendanceQuery.ATTENDANCE_SEARCH_LIST.getQuery());

            psmt.setString(1, "%" + keyword + "%");
            psmt.setInt(2, PageDTO.POSTS_PER_PAGE);
            psmt.setInt(3, pageDTO.getStartIndex());

            rs = psmt.executeQuery();

            while (rs.next()) {
                AttendanceDTO attendanceDTO = new AttendanceDTO();

                attendanceDTO.setEmail(rs.getString("EMAIL"));
                attendanceDTO.setPassword(rs.getString("PASSWORD"));
                attendanceDTO.setName(rs.getString("NAME"));
                attendanceDTO.setPhone(rs.getString("PHONE"));
                searchList.add(attendanceDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, psmt, rs);
        }

        return searchList;
    }

    // attendanceDetailList

    public int getAttendanceCount(String email) {
        int count = 0;

        try {
            conn = dataSource.getConnection();
            psmt = conn.prepareStatement(AttendanceQuery.ATTENDANCE_STATUS_COUNT.getQuery());
            psmt.setString(1, email);

            rs = psmt.executeQuery();

            if (rs.next()) {
                count = rs.getInt("count(*)");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, psmt, rs);
        }

        return count;
    }

    public List<AttendanceDTO> getDetailList(String email, PageDTO pageDTO) {
        List<AttendanceDTO> detailList = new ArrayList<>();

        try {
            conn = dataSource.getConnection();
            psmt = conn.prepareStatement(AttendanceQuery.ATTENDANCE_DETAIL_LIST.getQuery());

            psmt.setString(1, email);
            psmt.setInt(2, PageDTO.POSTS_PER_PAGE);
            psmt.setInt(3, pageDTO.getStartIndex());

            rs = psmt.executeQuery();

            while (rs.next()) {
                AttendanceDTO attendanceDTO = new AttendanceDTO();

                DateFormat formatter = new SimpleDateFormat("HH:mm");
                String getStartTime = formatter.format(rs.getTime("START_DATE"));
                String getEndTime = formatter.format(rs.getTime("END_DATE"));

                int getAttendanceStat = rs.getInt("ATTENDANCE_STAT");
                if (getAttendanceStat == 1) {
                    attendanceDTO.setAttendance_stat("미출결");
                } else if (getAttendanceStat == 2) {
                    attendanceDTO.setAttendance_stat("출석");
                } else if (getAttendanceStat == 3) {
                    attendanceDTO.setAttendance_stat("지각");
                } else if (getAttendanceStat == 4) {
                    attendanceDTO.setAttendance_stat("조퇴");
                } else if (getAttendanceStat == 5) {
                    attendanceDTO.setAttendance_stat("결석");
                } else if (getAttendanceStat == 6) {
                    attendanceDTO.setAttendance_stat("공가");
                } else if (getAttendanceStat == 7) {
                    attendanceDTO.setAttendance_stat("병가");
                }

                attendanceDTO.setId(rs.getInt("ID"));
                attendanceDTO.setName(rs.getString("NAME"));
                attendanceDTO.setEmail(rs.getString("EMAIL"));
                attendanceDTO.setDate(rs.getDate("START_DATE"));
                attendanceDTO.setStart_date(getStartTime);
                attendanceDTO.setEnd_date(getEndTime);
                attendanceDTO.setReason(rs.getString("REASON"));

                detailList.add(attendanceDTO);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, psmt, rs);
        }

        return detailList;

    }

    public int getDuration() {
        int duration = 0;

        try {
            conn = dataSource.getConnection();
            psmt = conn.prepareStatement(AttendanceQuery.GET_ATTENDANCE_DURATION.getQuery());

            rs = psmt.executeQuery();

            if(rs.next()) {
                duration = rs.getInt("DURATION");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, psmt);
        }

        return duration;
    }

    public List<AttendanceDTO> getDateList(String email, String startMonth, String endMonth, PageDTO pageDTO) {
        List<AttendanceDTO> dateList = new ArrayList<>();

        try {
            conn = dataSource.getConnection();
            psmt = conn.prepareStatement(AttendanceQuery.ATTENDANCE_DATE_LIST.getQuery());

            psmt.setString(1, email); // email
            psmt.setString(2, startMonth); // start between ?
            psmt.setString(3, endMonth); // and ?
            psmt.setInt(4, PageDTO.POSTS_PER_PAGE); // LIMIT ?
            psmt.setInt(5, pageDTO.getStartIndex()); // OFFSET ?

            System.out.println(startMonth);
            System.out.println(endMonth);

            rs = psmt.executeQuery();

            while (rs.next()) {
                AttendanceDTO attendanceDTO = new AttendanceDTO();

                DateFormat formatter = new SimpleDateFormat("HH:mm");
                String getStartTime = formatter.format(rs.getTime("START_DATE"));
                String getEndTime = formatter.format(rs.getTime("END_DATE"));

                int getAttendanceStat = rs.getInt("ATTENDANCE_STAT");
                if (getAttendanceStat == 1) {
                    attendanceDTO.setAttendance_stat("미출결");
                } else if (getAttendanceStat == 2) {
                    attendanceDTO.setAttendance_stat("출석");
                } else if (getAttendanceStat == 3) {
                    attendanceDTO.setAttendance_stat("지각");
                } else if (getAttendanceStat == 4) {
                    attendanceDTO.setAttendance_stat("조퇴");
                } else if (getAttendanceStat == 5) {
                    attendanceDTO.setAttendance_stat("결석");
                } else if (getAttendanceStat == 6) {
                    attendanceDTO.setAttendance_stat("공가");
                } else if (getAttendanceStat == 7) {
                    attendanceDTO.setAttendance_stat("병가");
                }

                attendanceDTO.setId(rs.getInt("ID"));
                attendanceDTO.setName(rs.getString("NAME"));
                attendanceDTO.setEmail(rs.getString("EMAIL"));
                attendanceDTO.setDate(rs.getDate("START_DATE"));
                attendanceDTO.setStart_date(getStartTime);
                attendanceDTO.setEnd_date(getEndTime);
                attendanceDTO.setReason(rs.getString("REASON"));

                dateList.add(attendanceDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, psmt);
        }

        return dateList;
    }

    public AttendanceDTO updateAttendance(AttendanceDTO attendanceDTO) {

        try {
            conn = dataSource.getConnection();
            psmt = conn.prepareStatement(AttendanceQuery.ATTENDANCE_UPDATE.getQuery());

            psmt.setInt(1, Integer.parseInt(attendanceDTO.getAttendance_stat())); // attendance_status
            psmt.setString(2, attendanceDTO.getStart_date()); // start_date
            psmt.setString(3, attendanceDTO.getEnd_date()); // end_date
            psmt.setString(4, attendanceDTO.getReason()); // reason
            psmt.setInt(5, attendanceDTO.getId());

            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, psmt);
        }

        return attendanceDTO;
    }

    public int getDateCount(String email, String startMonth, String endMonth) {
        int count = 0;

        try {
            conn = dataSource.getConnection();
            psmt = conn.prepareStatement(AttendanceQuery.ATTENDANCE_DATE_COUNT.getQuery());

            psmt.setString(1, email);
            psmt.setString(2, startMonth + "%");
            psmt.setString(3, endMonth +"%");

            rs = psmt.executeQuery();

            if(rs.next()) {
                count = rs.getInt("count(*)");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, psmt,rs);
        }

        return count;
    }

    public int updateDuration(int duration) {

        try {
            conn = dataSource.getConnection();
            psmt = conn.prepareStatement(AttendanceQuery.DURATION_UPDATE.getQuery());

            psmt.setInt(1, duration);

            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, psmt);
        }

        return duration;
    }
}
