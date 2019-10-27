package cn.kgc.servlet;

import javax.servlet.*;
import java.io.IOException;

public class MyServlet2 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        String pwd = servletConfig.getInitParameter("pwd");
        System.out.println("pwd: "+pwd);
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("处理请求和响应");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
