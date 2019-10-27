package cn.kgc.ZuoYe;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo1 {
    public static void main(String[] args) throws Exception {
        //Class.forName("com.mysql.jdbc.Driver");
        Connection conn=JDBCUtils.getConnection();
        //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?charsetEncoding=utf8", "root", "root");
        String sql = "select * from emp where ename = 'tom'";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next()) {
            String s = rs.getString(2);
            System.out.println(s);
        } else {
            System.out.println("未查到");
        }
        /*rs.close();
        stmt.close();
        conn.close();*/
        JDBCUtils.closeAll(conn,stmt,rs);
    }
    @Test
    public void add() throws Exception{
        Connection conn=JDBCUtils.getConnection();
        Statement stmt=conn.createStatement();
        String sql=" INSERT INTO emp (eid,ename,esex) values (NULL,'鹿晗','男')";
        int i =stmt.executeUpdate(sql);
        if(i>0){
            System.out.println("插入成功");
        }else{
            System.out.println("插入失败");
        }
        JDBCUtils.closeAll(conn,stmt,null);
    }
    @Test
    public void del() throws Exception{
        Connection conn=JDBCUtils.getConnection();
        String sql=" delete from emp where ename = '鹿晗' ";
        Statement stmt=conn.createStatement();
        int i =stmt.executeUpdate(sql);
        if(i>0){
            System.out.println("删除成功!");
        }else{
            System.out.println("删除失败");
        }
        JDBCUtils.closeAll(conn,stmt,null);
    }
    @Test
    public void ud() throws Exception{
        Connection conn=JDBCUtils.getConnection();
        String sql="update emp set esex = '女' where ename = 'tom' ";
        Statement stmt=conn.createStatement();
        int i = stmt.executeUpdate(sql);
        if(i>0){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
        JDBCUtils.closeAll(conn,stmt,null);
    }
    @Test
    public void add2() throws Exception{
        Connection conn=JDBCUtils.getConnection();
        String sql="insert into emp (eid,ename,esex) values (null,'黄子韬','男')";
        PreparedStatement ps =conn.prepareStatement(sql);
        int i = ps.executeUpdate();
        if(i>0){
            System.out.println("插入成功");
        }else{
            System.out.println("插入失败");
        }
        JDBCUtils.closeAll(conn,ps,null);
    }
    @Test
    public void del2() throws Exception{
        Connection conn = JDBCUtils.getConnection();
        String sql=" delete from emp where ename = '黄子韬'";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i =ps.executeUpdate();
        if(i>0){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
        JDBCUtils.closeAll(conn,ps,null);
    }
    @Test
    public void uD2() throws Exception{
        Connection conn = JDBCUtils.getConnection();
        String sql = "update emp set esex = '男' where ename = 'tom'";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i =ps.executeUpdate();
        if(i>0){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
        JDBCUtils.closeAll(conn,ps,null);
    }
    @Test
    public void sel() throws Exception{
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from emp ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            String ename =rs.getString("ename");
            String esex = rs.getString("esex");
            System.out.println(ename+" "+esex);
        }
        JDBCUtils.closeAll(conn,ps,rs);
    }
}

