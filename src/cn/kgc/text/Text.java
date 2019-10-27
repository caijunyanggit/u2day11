package cn.kgc.text;

import cn.kgc.domain.User;
import cn.kgc.service.UsersService;
import cn.kgc.service.lmpl.UsersServicelmpl;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Text {
    @Test
    public void zCText() throws Exception{
        Scanner input = new Scanner(System.in);
        System.out.print("请输入用户名: ");
        String userName=input.nextLine();
        System.out.print("请输入密码:");
        String userPwd=input.nextLine();
        System.out.print("请输入日期:");
        String date = input.nextLine();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date loginTime = simpleDateFormat.parse(date);
        UsersService usersService= new UsersServicelmpl();
        User user=new User(0,userName,userPwd,loginTime);
        int i = usersService.zC(user);
        if(i>0){
            System.out.println("注册成功!");
        }else{
            System.out.println("注册失败!");
        }
    }
}
