package cn.kgc.ZuoYe;

import java.util.List;

public class EmpServicelmpl implements EmpService{
    public boolean delEmpAandDept(int did){
        EmpDao empDao=new EmpDaolmpl();
        int delemp = empDao.delemp(did);
        int deldept = empDao.deldept(did);
        if(delemp>0&&deldept>0){
            return true;
        }else {
            return false;
        }
    }
    public List<Emp> queryLink(String ename){
        EmpDao empDao=new EmpDaolmpl();
        return empDao.queryLike(ename);
    }
    public boolean addEmp(Emp emp){
        EmpDao empDao=new EmpDaolmpl();
        int i = empDao.add(emp);
        if(i>0){
            return true;
        }else {
            return false;
        }
    }
}
