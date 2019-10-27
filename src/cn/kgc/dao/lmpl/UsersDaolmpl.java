package cn.kgc.dao.lmpl;

import cn.kgc.dao.UsersDao;
import cn.kgc.domain.User;
import cn.kgc.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class UsersDaolmpl implements UsersDao {
    public int zC(User user){
        Connection conn = JDBCUtils.getConnection();
        String sql = "insert into user values (null,?,?,?)";
        PreparedStatement ps=null;
        int i = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getUserPwd());
            java.sql.Date date = new java.sql.Date(user.getLoginTime().getTime());
            ps.setDate(3,date);
            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.closeAll(conn,ps,null);
        return i;
    }
}
