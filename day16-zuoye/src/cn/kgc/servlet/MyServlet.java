package cn.kgc.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class MyServlet extends GenericServlet {
    @Override
    public void init() throws ServletException {
        String user = getInitParameter("user");
        System.out.println("user: "+user);

    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("处理请求与响应!");
    }
}
