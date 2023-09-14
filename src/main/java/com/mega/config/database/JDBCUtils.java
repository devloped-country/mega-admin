package com.mega.config.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBCUtils {

    private static DataSource dataSource;

    public static DataSource getDataSource() {
        if (dataSource == null) {
            HikariConfig config = new HikariConfig();

            Properties properties = new Properties();
            try (InputStream input = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties")) {
                properties.load(input);

                config.setDriverClassName(properties.getProperty("jdbc.driver"));
                config.setJdbcUrl(properties.getProperty("jdbc.url"));
                config.setUsername(properties.getProperty("jdbc.user"));
                config.setPassword(properties.getProperty("jdbc.password"));

                config.setMaximumPoolSize(10);
                config.setAutoCommit(true);
                config.addDataSourceProperty("cachePrepStmts", "true");
                config.addDataSourceProperty("prepStmtCacheSize", "250");
                config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

                dataSource = new HikariDataSource(config);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return dataSource;
    }

    public static void close(Connection conn, PreparedStatement pstmt) {
        try {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
