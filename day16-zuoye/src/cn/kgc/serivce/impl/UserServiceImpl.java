package cn.kgc.serivce.impl;

import cn.kgc.dao.UserDao;
import cn.kgc.dao.impl.UserDaoImpl;
import cn.kgc.serivce.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    public boolean select(String uname,String upwd){
        return userDao.select(uname,upwd);
    }
}
