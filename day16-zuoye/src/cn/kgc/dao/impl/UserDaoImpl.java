package cn.kgc.dao.impl;

import cn.kgc.dao.UserDao;
import cn.kgc.domain.User;
import cn.kgc.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    QueryRunner qr = new QueryRunner(C3P0Utils.dataSources());
    public boolean select(String uname,String upwd){
        String sql = " select * from users where uname = ? and upwd = ? ";
        try {
            List<User> userList = qr.query(sql,new BeanListHandler<User>(User.class),uname,upwd);
            if(userList!=null){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
