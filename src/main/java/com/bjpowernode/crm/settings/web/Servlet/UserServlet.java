package com.bjpowernode.crm.settings.web.Servlet;

import com.bjpowernode.crm.settings.dao.UserDao;
import com.bjpowernode.crm.settings.eneity.User;
import com.bjpowernode.crm.settings.servce.impl.UserServceImpl;
import com.bjpowernode.crm.untils.PrintJson;
import com.bjpowernode.crm.untils.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

import com.bjpowernode.crm.settings.servce.UserServce;

public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if ("/settings/user/login.do".equals(path)) {
            login(request,response);
        } else{

        }
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginAct = request.getParameter("loginAct");
        String loginPwd = request.getParameter("loginPwd");
        String ip = request.getRemoteAddr();
        UserServce userServce = (UserServce) ServiceFactory.getService(new UserServceImpl());
        try {
            User user = userServce.login(loginAct, loginPwd, ip);
            request.getSession().setAttribute("user", user);
            PrintJson.printJsonFlag(response,true);
        } catch (Exception e) {
            e.printStackTrace();
            HashMap<String,Object> hashMap = new HashMap<>();
            String msg = e.getMessage();
            hashMap.put("success",false);
            hashMap.put("msg",msg);
            PrintJson.printJsonObj(response,hashMap);
        }
    }


}
