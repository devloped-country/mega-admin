package com.mega.biz.login.model;


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

public class LoginDAO {

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;



    //디비랑 연결되는 객체이고
    //각 DB에서 받을 데이터 를 함수로 만들어서 딴데서 호출 할수 있도 록 만들기


    //DAO의 어드민유저 정보를 뽑아와서 로그인정보 취득후 어느페이지로 갈지를 리턴


    public LoginDTO getAdmin(LoginDTO vo) {
        LoginDTO admin = null;
        try {

            conn = JDBCUtils.getDataSource().getConnection();
            pstmt = conn.prepareStatement(ADMIN_GET.getQuery()); //<<---!!!!!!매개변수 생각잘하기!!!!!
            pstmt.setString(1, vo.getAccount());
            rs = pstmt.executeQuery();

//            while(rs.next()) {
                admin = new LoginDTO();
            if(rs.next()) {

                admin.setAccount(rs.getString("ACCOUNT"));
                admin.setPassword(rs.getString("PASSWORD"));
                admin.setName(rs.getString("NAME"));
            }

//            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt);
        }
        return admin;
    }
}