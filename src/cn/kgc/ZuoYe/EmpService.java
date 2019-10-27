package cn.kgc.ZuoYe;

import java.util.List;

public interface EmpService {
    public boolean delEmpAandDept(int did);

    public List<Emp> queryLink(String ename);

    public boolean addEmp(Emp emp);
}
