package cn.kgc.ZuoYe;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Date;

public class JDBCdemo2 {
    public List<Emp> quary() throws Exception{
        List<Emp> empList=new ArrayList<>();
        Connection conn=JDBCUtils.getConnection();
        String sql = "select * from emp";
        PreparedStatement ps =((Connection) conn).prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Emp emp = new Emp();
            emp.setEid(rs.getInt(1));
            emp.setEname(rs.getString(2));
            emp.setEsex(rs.getString(3));
            emp.setEstartime(rs.getDate(4));
            emp.setEpay(rs.getDouble(5));
            emp.setDid(rs.getInt(6));
            empList.add(emp);
        }
        return empList;
    }
    @Test
    public void textquary() throws Exception{
        List<Emp> empList =quary();
        for(Emp emp:empList){
            System.out.println(emp);
        }
    }
    @Test
    public void textDate() throws Exception{
        Connection conn=JDBCUtils.getConnection();
        String sql=" insert into dt values (?,?,?)";
        PreparedStatement ps =conn.prepareStatement(sql);
        Date nowDate=new Date();
        java.sql.Date date = new java.sql.Date(nowDate.getTime());
        ps.setDate(1,date);
        Time time=new Time(nowDate.getTime());
        ps.setTime(2,time);
        Timestamp ts=new Timestamp(nowDate.getTime());
        ps.setTimestamp(3,ts);
        int i =ps.executeUpdate();
        if(i>0){
            System.out.println("插入成功");
        }else{
            System.out.println("插入失败");
        }
        JDBCUtils.closeAll(conn,ps,null);
    }
    @Test
    public void addBold() throws Exception{
        Connection conn=JDBCUtils.getConnection();
        String sql = " insert into tab_bin values (null,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,"1.jpg");
        InputStream in =new FileInputStream("D:\\k9507__u1\\u2day11\\src\\1.jpg");
        ps.setBlob(2,in);
        int i = ps.executeUpdate();
        if(i>0){
            System.out.println("插入成功");
        }else{
            System.out.println("插入失败");
        }
        JDBCUtils.closeAll(conn,ps,null);
    }
    @Test
    public void textRead() throws Exception{
        Connection conn=JDBCUtils.getConnection();
        String sql="select * from tab_bin where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,1);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            String st=rs.getString(2);
            InputStream  stream = rs.getBinaryStream(3);
            OutputStream out = new FileOutputStream("1_back.jpg");
            IOUtils.copy(stream,out);
            out.close();
            stream.close();
            System.out.println("图片名: "+st);
        }
        JDBCUtils.closeAll(conn,ps,rs);
    }
    @Test
    public void pi() throws Exception{
        Connection conn = JDBCUtils.getConnection();
        String sql=" insert into dept values (null,?,?)";
         PreparedStatement ps = conn.prepareStatement(sql);
         for(int i=0;i<10;i++){
             ps.setString(1,"市场部"+i);
             ps.setString(2,"111111"+i);
             ps.addBatch();
         }
         int [] arr=ps.executeBatch();
        System.out.println(Arrays.toString(arr));
        System.out.println("插入完成");
    }
    @Test
    public void text(){
        EmpService empS=new EmpServicelmpl();
        boolean b = empS.delEmpAandDept(2);
        if(b){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
    }
    @Test
    public void textQuary(){
        EmpService empService=new EmpServicelmpl();
        List<Emp> empList=empService.queryLink("o");
        for(Emp emp:empList){
            System.out.println(emp);
        }
    }
    @Test
    public void textAdd(){
        EmpService empService = new EmpServicelmpl();
        Date date=new Date("2019-1-2");
        Emp emp = new Emp(20,"哪吒","男",new java.sql.Date(date.getTime()),8000,4);
        boolean b=empService.addEmp(emp);
        if(b){
            System.out.println("插入成功");
        }else{
            System.out.println("插入失败");
        }
    }
}
