package cn.kgc.service.lmpl;

import cn.kgc.dao.EmpDao;
import cn.kgc.dao.lmpl.EmpDaolmpl;
import cn.kgc.domain.Emp;
import cn.kgc.service.EmpService;

import java.util.List;

public class EmpServicelmpl implements EmpService {
    public List<Emp> sel(){
        EmpDao empDao = new EmpDaolmpl();
        return empDao.sel();
    }

    public List<Emp> selectLike(String ename,String esex,double epay){
        EmpDao empDao = new EmpDaolmpl();
        return empDao.selectLike(ename,esex,epay);
    }

    public List<Emp> select(int did){
        EmpDao empDao = new EmpDaolmpl();
        return empDao.select(did);
    }

    public int count(){
        EmpDao empDao = new EmpDaolmpl();
        return empDao.count();
    }
    public int update(String ename, String esex, String estartime, double epay){
        EmpDao empDao = new EmpDaolmpl();
        return empDao.update(ename,esex,estartime,epay);
    }

    public int del(String ename){
        EmpDao empDao = new EmpDaolmpl();
        return empDao.del(ename);
    }
}
