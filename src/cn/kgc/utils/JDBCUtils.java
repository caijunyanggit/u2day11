package cn.kgc.utils;

import java.sql.*;
import java.util.ResourceBundle;

public class JDBCUtils {
    private static String driverName;
    private static String url;
    private static String user;
    private static String pwd;
    static {
        ResourceBundle db=ResourceBundle.getBundle("db");
        driverName=db.getString("driverName");
        url=db.getString("url");
        user=db.getString("user");
        pwd=db.getString("pwd");
    }
    static {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,user,pwd);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public static void closeAll(Connection conn, Statement stmt, ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Connection conn= JDBCUtils.getConnection();
        System.out.println(conn);
    }
}
