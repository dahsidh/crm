package com.bjpowernode.crm.workbench.servce.impl;

import com.bjpowernode.crm.settings.dao.UserDao;
import com.bjpowernode.crm.settings.eneity.User;
import com.bjpowernode.crm.untils.SqlSessionUtil;
import com.bjpowernode.crm.vo.PaginationVO;
import com.bjpowernode.crm.workbench.dao.ActivityDao;
import com.bjpowernode.crm.workbench.dao.ActivityRemarkDao;
import com.bjpowernode.crm.workbench.entity.Activity;
import com.bjpowernode.crm.workbench.entity.ActivityRemark;
import com.bjpowernode.crm.workbench.servce.ActivityServce;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ActivityServceImpl implements ActivityServce {
    private ActivityDao activityDao = SqlSessionUtil.getSqlSession().getMapper(ActivityDao.class);
    private ActivityRemarkDao remarkDao = SqlSessionUtil.getSqlSession().getMapper(ActivityRemarkDao.class);
    private UserDao userDao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);

    @Override
    public boolean save(Activity activity) {
        return activityDao.save(activity) > 0;
    }

    @Override
    public PaginationVO pageList(HashMap<String, Object> hashMap) {
        return new PaginationVO(activityDao.getTotalByCondition(hashMap),
                activityDao.getActivityListByCondition(hashMap));
    }

    @Override
    public boolean deleteInfo(String[] ids) {
        return remarkDao.selectCountByRemarks(ids) == remarkDao.deleteByInfo(ids)
                && activityDao.deleteByActivity(ids) == ids.length;
    }

    @Override
    public Map<String, Object> getUserListAndActivity(String id) {
        List<User> uList = userDao.findAll();
        Activity a = activityDao.getById(id);
        Map<String, Object> map = new HashMap<>();
        map.put("uList", uList);
        map.put("a", a);
        return map;
    }

    @Override
    public boolean update(Activity activity) {
        return activityDao.updateInfo(activity) > 0;
    }

    @Override
    public Activity getdetail(String id) {
        return activityDao.detailById(id);
    }

    @Override
    public List<ActivityRemark> getRemarkListByAid(String id) {
        return remarkDao.getRemarkListByAid(id);
    }

    @Override
    public boolean deleteRemark(String id) {
        return remarkDao.deleteRemarkById(id) > 0;
    }

    @Override
    public boolean saveReark(ActivityRemark remark) {
        return remarkDao.saveReark(remark) > 0;
    }

    @Override
    public boolean updateRemark(ActivityRemark remark) {
        return remarkDao.updateRemark(remark) > 0;
    }


}
