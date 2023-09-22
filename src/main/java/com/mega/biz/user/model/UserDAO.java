package com.mega.biz.user.model;


import com.mega.biz.login.model.LoginDTO;
import com.mega.biz.sample.model.SampleQuery;
import com.mega.config.database.JDBCUtils;
import com.mega.biz.sample.model.dto.SampleDTO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.mega.biz.login.model.LoginQuery.ADMIN_GET;
import static com.mega.biz.sample.model.SampleQuery.USER_LIST;
import static com.mega.config.database.JDBCUtils.dataSource;
import static com.mega.config.database.JDBCUtils.getDataSource;

public class UserDAO {

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;


    //디비랑 연결되는 객체이고
    //각 DB에서 받을 데이터 를 함수로 만들어서 딴데서 호출 할수 있도 록 만들기


    //DAO의 어드민유저 정보를 뽑아와서 로그인정보 취득후 어느페이지로 갈지를 리턴


    ////pj=여기서 DB의 유저정보삭제하는 메서드랑 + 회원상태정보 변경하게 만드는 메서드를 맘들어야됨
    //// ,근데 회원승인해주는 메서드에서 한번에 회원상태아이디를 1->2로 ,상태를 0->1로 만들어야 되겠지??


    // 회원가입 승인 (회원정보 수정)
    public void userApprove(UserDTO vo) {
        try {
            conn = JDBCUtils.getDataSource().getConnection();
            pstmt = conn.prepareStatement(UserQuery.ADMIN_USER_APPROVE.getQuery());

//            pstmt.setInt(1, vo.getUser_status());
            pstmt.setString(1, vo.getEmail());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt);
        }

    }

    public void deleteUser(UserDTO vo) {

        try {
            DataSource dataSource = JDBCUtils.getDataSource();
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(UserQuery.ADMIN_USER_DELETE_ATTENDANCE.getQuery());
            pstmt.setString(1, vo.getEmail());
            pstmt.executeUpdate();

            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(UserQuery.ADMIN_USER_DELETE_USER.getQuery());
            pstmt.setString(1, vo.getEmail());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // ResultSet이 없을 때 close
            JDBCUtils.close(conn, pstmt);
        }
    }

    // 회원관리 메인페이지 이동왔을때 회원목록 출력하기위한 메서드 생성
    public List<UserDTO> getUserList() {
        List<UserDTO> userList = new ArrayList<UserDTO>();
        try {
            conn = JDBCUtils.getDataSource().getConnection();
            pstmt = conn.prepareStatement(UserQuery.USER_LIST.getQuery());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                UserDTO user = new UserDTO();
                user.setEmail(rs.getString("EMAIL"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setName(rs.getString("NAME"));
                user.setPhone(rs.getString("PHONE"));
                user.setUser_status(rs.getInt("USER_STATUS"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt);
        }
        return userList;
    }


    public List<UserDTO> selectAllMember(int page) {
        //1번 페이지 1~10
        //2번 페이지 11~20
        int startNum = (page - 1) * 10 + 1;
//        int endNum = page * 10;
//        String sql = "SELECT * FROM user1  ORDER BY name LIMIT 10 OFFSET ?";
        List<UserDTO> userList = new ArrayList<UserDTO>();
        try {
            conn = JDBCUtils.getDataSource().getConnection();
            pstmt = conn.prepareStatement(UserPageQuery.USER_LIST.getQuery());
            pstmt.setInt(1, startNum);
//            pstmt.setInt(2, endNum);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                UserDTO user = new UserDTO();
                user.setEmail(rs.getString("EMAIL"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setName(rs.getString("NAME"));
                user.setPhone(rs.getString("PHONE"));
                user.setUser_status(rs.getInt("USER_STATUS"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt);
        }
        return userList;
    }

    public int getTotalUser() {
        int count = 0;

        try {
//            if (keyword != null) {
//                conn = dataSource.getConnection();
//                pstmt = conn.prepareStatement(UserPageQuery.ATTENDANCE_USER_COUNT.getQuery() + "WHERE name LIKE ?");
//                pstmt.setString(1, "%" + keyword + "%");
//            } else
            DataSource dataSource = getDataSource();
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(UserPageQuery.USER_COUNT.getQuery());

            rs = pstmt.executeQuery();

            if (rs.next()) {
                count = rs.getInt("count(*)");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt, rs);
        }

        return count;
    }


//    //■ 전체 페이지 구하는 메소드
//    public int getPageCount(int numPerPage, int dataCount) {
//        int pageCount = 0;
//
//        pageCount = dataCount / numPerPage;
//
//        if (dataCount % numPerPage != 0)
//            pageCount++;
//
//
//        return pageCount;
//    }
//


}

