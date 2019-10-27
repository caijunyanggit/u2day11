package cn.kgc.ZuoYe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDaolmpl implements EmpDao {
    public int delemp(int did){
        Connection conn=JDBCUtils.getConnection();
        String sql = " delete from emp where did = ?";
        PreparedStatement ps=null;
        int i =0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,did);
            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.closeAll(conn,ps,null);
        return i;
    }
    public int deldept(int did){
        Connection conn=JDBCUtils.getConnection();
        String sql = " delete from dept where did = ?";
        PreparedStatement ps = null;
        int i =0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,did);
            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.closeAll(conn,ps,null);
        return i;
    }
    public List<Emp> queryLike(String ename){
        List<Emp> empList = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = JDBCUtils.getConnection();
        String sql = " select * from emp where 1 = 1 ";
        if(ename!=null&&!ename.isEmpty()){
            sql = sql + "and ename like ? ";
        }
        try {
            ps = conn.prepareStatement(sql);
            if(ename!=null&&!ename.isEmpty()){
                ps.setString(1,"%"+ename+"%");
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
    public int add(Emp emp){
        Connection conn = JDBCUtils.getConnection();
        String sql = "insert into emp values (?,?,?,?,?,?)";
        int i = 0;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,emp.getEid());
            ps.setString(2,emp.getEname());
            ps.setString(3,emp.getEsex());
            ps.setDate(4,emp.getEstartime());
            ps.setDouble(5,emp.getEpay());
            ps.setInt(6,emp.getDid());
            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.closeAll(conn,ps,null);
        return i;
    }
}
