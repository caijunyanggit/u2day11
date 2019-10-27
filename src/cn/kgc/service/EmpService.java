package cn.kgc.service;

import cn.kgc.domain.Emp;

import java.util.List;

public interface EmpService {
    public List<Emp> sel();

    public List<Emp> selectLike(String ename,String esex,double epay);

    public List<Emp> select(int did);

    public int count();

    public int update(String ename, String esex, String estartime, double epay);

    public int del(String ename);
}
