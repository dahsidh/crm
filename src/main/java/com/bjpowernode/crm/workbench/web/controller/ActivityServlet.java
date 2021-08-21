package com.bjpowernode.crm.workbench.web.controller;

import com.bjpowernode.crm.settings.eneity.User;
import com.bjpowernode.crm.settings.servce.UserServce;
import com.bjpowernode.crm.settings.servce.impl.UserServceImpl;
import com.bjpowernode.crm.untils.DateTimeUntil;
import com.bjpowernode.crm.untils.PrintJson;
import com.bjpowernode.crm.untils.ServiceFactory;
import com.bjpowernode.crm.untils.UUIDUntil;
import com.bjpowernode.crm.workbench.entity.Activity;
import com.bjpowernode.crm.workbench.servce.ActivityServce;
import com.bjpowernode.crm.workbench.servce.impl.ActivityServceImpl;

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

        if ("/workbench/activity/getUserList.do".equals(path)) {
            getUserList(request, response);
        } else if ("/workbench/activity/save.do".equals(path)) {
            save(request,response);
        } else if ("/workbench/activity/pageList.do".equals(path)){
            pageList(request,response);
        }
    }

    private void pageList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String owner = request.getParameter("owner");
        String StartDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");

        String pageNoStr = request.getParameter("pageNo");
        String pageSizeStr = request.getParameter("pageSize ");
        int pageNo = Integer.parseInt(pageNoStr);
        int pageSize = Integer.parseInt(pageSizeStr);
        int skipCont  = (pageNo-1)*pageSize;

    }

    private void getUserList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserServce userServce = (UserServce) ServiceFactory.getService(new UserServceImpl());
        List userList = userServce.findUserAll();
        PrintJson.printJsonObj(response, userList);
    }

    private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ActivityServce activityServce = (ActivityServce) ServiceFactory.getService(new ActivityServceImpl());
        String id = UUIDUntil.getUUID();
        String owner = request.getParameter("owner");
        String name = request.getParameter("name");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String cost = request.getParameter("cost");
        String description =request.getParameter("description");
        String createTime = DateTimeUntil.getSysTime();
        String createBy = ((User)request.getSession().getAttribute("user")).getName();
        Activity activity = new Activity();
        activity.setId(id);
        activity.setName(name);
        activity.setCost(cost);
        activity.setCreateBy(createBy);
        activity.setCreateTime(createTime);
        activity.setDescription(description);
        activity.setEndDate(endDate);
        activity.setStartDate(startDate);
        activity.setOwner(owner);
        boolean flag = activityServce.save(activity);
        PrintJson.printJsonFlag(response,flag);
    }
}
