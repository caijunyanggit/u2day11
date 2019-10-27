package cn.kgc.servlet;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet(urlPatterns = "/doimg")
public class DoImgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = "a.jpg";
        InputStream in = getServletContext().getResourceAsStream("/download/" + str);
        OutputStream out = response.getOutputStream();
        response.setHeader("content-disposition", "attachment;filename="+str);
        IOUtils.copy(in,out);
    }
}
