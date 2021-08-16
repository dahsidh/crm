package com.bjpowernode.crm.settings.web.Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入控制器");
        String path = request.getServletPath();
        if ("/settings/user/xxx.dao".equals(path)){

        }else {

        }
    }
}
