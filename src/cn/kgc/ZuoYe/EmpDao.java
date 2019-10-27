package cn.kgc.ZuoYe;

import java.util.List;

public interface EmpDao {
    public int delemp(int did);

    public int deldept(int did);

    public int add(Emp emp);

    public List<Emp> queryLike(String ename);
}
