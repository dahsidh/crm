package com.bjpowernode.crm.workbench.web.controller;

import com.bjpowernode.crm.settings.servce.UserServce;
import com.bjpowernode.crm.settings.servce.impl.UserServceImpl;
import com.bjpowernode.crm.untils.PrintJson;
import com.bjpowernode.crm.untils.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ActivityServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String path = request.getServletPath();

       if ("/workbench/activity/xxx.do".equals(path)){

       }
    }

    private void getUserList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        UserServce userServce = (UserServce) ServiceFactory.getService(new UserServceImpl());
        List userList = userServce.findUserAll();
        PrintJson.printJsonObj(response,userList);
    }
}
