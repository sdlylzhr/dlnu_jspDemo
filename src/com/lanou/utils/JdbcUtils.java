package com.lanou.utils;

import java.sql.*;

/**
 * 数据库工具类
 */
public class JdbcUtils {

    private static String url = "jdbc:mysql://114.116.0.137:3306/dlnu?useSSL=false";
    private static String username = "root";
    private static String password = "Lanou_2018";
    // 静态代码块只执行一次，因为静态代码块在类加载时执行，类永远只加载一次
    static {
        try {
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public static void release(Connection conn, Statement st, ResultSet rs) {

        if (rs!=null) {
            try {
                rs.close(); // 假设throw异常
            } catch (Exception e) {
                e.printStackTrace(); // 只需在后台记录异常
            }
            rs = null; // 假设rs对象没有释放，将其置为null，该对象就变成垃圾，由Java垃圾回收器回收
        }
        if (st!=null) {
            try {
                st.close(); // 假设throw异常
            } catch (Exception e) {
                e.printStackTrace(); // 只需在后台记录异常
            }
            st = null;
        }
        if (conn!=null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace(); // 只需在后台记录异常
            }
        }

    }
}