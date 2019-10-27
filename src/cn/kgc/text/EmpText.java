package cn.kgc.text;

import cn.kgc.domain.Emp;
import cn.kgc.service.EmpService;
import cn.kgc.service.lmpl.EmpServicelmpl;
import org.junit.Test;

import java.util.List;

public class EmpText {
    @Test
    public void sel(){
        EmpService empService = new EmpServicelmpl();
        List<Emp> empList = empService.sel();
        for(Emp emp:empList){
            System.out.println(emp);
        }
    }
    @Test
    public void selLike(){
        EmpService empService = new EmpServicelmpl();
        List<Emp> empList = empService.selectLike("o","",0);
        for(Emp emp:empList){
            System.out.println(emp);
        }
    }
    @Test
    public void select(){
        EmpService empService = new EmpServicelmpl();
        List<Emp> empList = empService.select(3);
        for(Emp emp:empList){
            System.out.println(emp);
        }
    }
    @Test
    public void count(){
        EmpService empService = new EmpServicelmpl();
        int i = empService.count();
        System.out.println("总人数为: "+i);
    }
    @Test
    public void update(){
        EmpService empService = new EmpServicelmpl();
        int i = empService.update("tom","女","2008-3-1",8000);
        if(i>0){
            System.out.println("修改成功!");
        }else{
            System.out.println("修改失败!");
        }
    }
    @Test
    public void del(){
        EmpService empService = new EmpServicelmpl();
        int i = empService.del("suny");
        if(i>0){
            System.out.println("删除成功!");
        }else{
            System.out.println("删除失败!");
        }
    }
}
