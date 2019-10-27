package cn.kgc.dao.lmpl;

import cn.kgc.dao.EmpDao;
import cn.kgc.domain.Dept;
import cn.kgc.domain.Emp;
import cn.kgc.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmpDaolmpl implements EmpDao {
    public List<Emp> selectLike(String ename,String esex,double epay){
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from emp where 1 = 1";
        List<Emp> empList = new ArrayList<>();
        List<Object> sList=new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if(ename!=null&&!ename.isEmpty()){
            sql=sql+" and ename like ?";
            sList.add("%"+ename+"%");
        }
        if(esex!=null&&!esex.isEmpty()){
            sql=sql+" and esex = ?";
            sList.add(esex);
        }
        if(epay>0){
            sql=sql+"and epay = ?";
            sList.add(epay);
        }
        try {
            ps = conn.prepareStatement(sql);
            for(int i=0;i<sList.size();i++){
                ps.setObject(i+1,sList.get(i));
            }
            rs = ps.executeQuery();
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.closeAll(conn,ps,rs);
        return empList;
    }

    public List<Emp> sel(){
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from emp e,dept d where e.did=d.did";
        List<Emp> empList = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Emp emp=new Emp();
                Dept dept=new Dept();
                emp.setDid(rs.getInt(1));
                emp.setEname(rs.getString(2));
                emp.setEsex(rs.getString(3));
                emp.setEstartime(rs.getDate(4));
                emp.setEpay(rs.getDouble(5));
                emp.setDid(rs.getInt(6));
                dept.setDname(rs.getString(8));
                dept.setDtel(rs.getString(9));
                emp.setDept(dept);
                empList.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.closeAll(conn,ps,rs);
        return empList;
    }
    public List<Emp> select(int did){
        Connection conn = JDBCUtils.getConnection();
        List<Emp> empList = new ArrayList<>();
        String sql = "select e.* from emp e,dept d where e.did=d.did and d.did = ?";
        PreparedStatement ps = null;
        ResultSet rs= null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,did);
            rs = ps.executeQuery();
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.closeAll(conn,ps,rs);
        return empList;
    }
    public int count(){
        Connection conn = JDBCUtils.getConnection();
        String sql = "select count(ename) from emp";
        PreparedStatement ps = null;
        ResultSet rs = null;
        int i = 0;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                i = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.closeAll(conn,ps,rs);
        return i;
    }
    public int update(String ename, String esex, String estartime, double epay){
        Connection conn = JDBCUtils.getConnection();
        Date date = null;
        int i = 0;
        PreparedStatement ps= null;
        String sql = "update emp set esex = ? ,estartime = ? , epay = ? where ename = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,esex);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date=simpleDateFormat.parse(estartime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            java.sql.Date sDate=new java.sql.Date(date.getTime());
            ps.setDate(2,sDate);
            ps.setDouble(3,epay);
            ps.setString(4,ename);
            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.closeAll(conn,ps,null);
        return i;
    }
    public int del(String ename){
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement ps = null;
        int i = 0;
        String sql = "delete from emp where ename = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,ename);
            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.closeAll(conn,ps,null);
        return i;
    }
}
