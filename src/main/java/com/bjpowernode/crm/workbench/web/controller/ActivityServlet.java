package com.bjpowernode.crm.workbench.web.controller;

import com.bjpowernode.crm.settings.eneity.User;
import com.bjpowernode.crm.settings.servce.UserServce;
import com.bjpowernode.crm.settings.servce.impl.UserServceImpl;
import com.bjpowernode.crm.untils.DateTimeUntil;
import com.bjpowernode.crm.untils.PrintJson;
import com.bjpowernode.crm.untils.ServiceFactory;
import com.bjpowernode.crm.untils.UUIDUntil;
import com.bjpowernode.crm.vo.PaginationVO;
import com.bjpowernode.crm.workbench.entity.Activity;
import com.bjpowernode.crm.workbench.servce.ActivityServce;
import com.bjpowernode.crm.workbench.servce.impl.ActivityServceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();

        if ("/workbench/activity/getUserList.do".equals(path)) {
            getUserList(request, response);
        } else if ("/workbench/activity/save.do".equals(path)) {
            save(request, response);
        } else if ("/workbench/activity/pageList.do".equals(path)) {
            pageList(request, response);
        } else if ("/workbench/activity/delete.do".equals(path)) {
            delete(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ActivityServce servce = (ActivityServce) ServiceFactory.getService(new ActivityServceImpl());
        String[] ids = request.getParameterValues("par");
        boolean flag = servce.deleteInfo(ids);
        PrintJson.printJsonFlag(response,flag);
    }

    private void pageList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ActivityServce servce = (ActivityServce) ServiceFactory.getService(new ActivityServceImpl());
        int pageNo = Integer.parseInt(request.getParameter("pageNo"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("name", request.getParameter("name"));
        hashMap.put("owner", request.getParameter("owner"));
        hashMap.put("startDate", request.getParameter("startDate"));
        hashMap.put("endDate", request.getParameter("endDate"));
        hashMap.put("skipCont", (pageNo - 1) * pageSize);
        hashMap.put("pageSize", pageSize);
        PaginationVO paginationVO = servce.pageList(hashMap);
        PrintJson.printJsonObj(response, paginationVO);


    }

    private void getUserList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserServce userServce = (UserServce) ServiceFactory.getService(new UserServceImpl());
        List userList = userServce.findUserAll();
        PrintJson.printJsonObj(response, userList);
    }

    private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ActivityServce activityServce = (ActivityServce) ServiceFactory.getService(new ActivityServceImpl());
        String createTime = DateTimeUntil.getSysTime();
        String createBy = ((User) request.getSession().getAttribute("user")).getName();
        Activity activity = new Activity();
        activity.setId(UUIDUntil.getUUID());
        activity.setName(request.getParameter("name"));
        activity.setCost(request.getParameter("cost"));
        activity.setCreateBy(createBy);
        activity.setCreateTime(createTime);
        activity.setDescription(request.getParameter("description"));
        activity.setEndDate(request.getParameter("endDate"));
        activity.setStartDate(request.getParameter("startDate"));
        activity.setOwner(request.getParameter("owner"));
        boolean flag = activityServce.save(activity);
        PrintJson.printJsonFlag(response, flag);
    }
}
