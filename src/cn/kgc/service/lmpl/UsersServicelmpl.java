package cn.kgc.service.lmpl;

import cn.kgc.dao.UsersDao;
import cn.kgc.dao.lmpl.UsersDaolmpl;
import cn.kgc.domain.User;
import cn.kgc.service.UsersService;

public class UsersServicelmpl implements UsersService {
    public int zC(User user){
        UsersDao usersDao = new UsersDaolmpl();
        int i = usersDao.zC(user);
        return i;
    }
}
