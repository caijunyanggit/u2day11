package cn.kgc.servlet;

import cn.kgc.serivce.UserService;
import cn.kgc.serivce.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        UserService userService = new UserServiceImpl();
        boolean b = userService.select(name,pwd);
        if(b){
            response.getWriter().write("<h1>登陆成功!</h1>");
        }else{
            //response.getWriter().write("<h1>登陆失败!</h1>");
            response.setStatus(302);
            response.setHeader("location","/day16_zuoye/login.html");
        }
    }

    /*@Test
    public void select(){
        UserService userService = new UserServiceImpl();
        boolean b = userService.select("asd", "asd");
        if(b){
            System.out.println("成功");
        }else{
            System.out.println("失败");
        }
    }*/
}
