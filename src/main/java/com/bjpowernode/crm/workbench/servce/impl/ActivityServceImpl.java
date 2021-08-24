package com.bjpowernode.crm.workbench.servce.impl;

import com.bjpowernode.crm.untils.SqlSessionUtil;
import com.bjpowernode.crm.vo.PaginationVO;
import com.bjpowernode.crm.workbench.dao.ActivityDao;
import com.bjpowernode.crm.workbench.dao.ActivityRemarkDao;
import com.bjpowernode.crm.workbench.entity.Activity;
import com.bjpowernode.crm.workbench.servce.ActivityServce;

import java.util.HashMap;
import java.util.List;


public class ActivityServceImpl implements ActivityServce {
    private ActivityDao activityDao = SqlSessionUtil.getSqlSession().getMapper(ActivityDao.class);
    private ActivityRemarkDao remarkDao = SqlSessionUtil.getSqlSession().getMapper(ActivityRemarkDao.class);

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
        return remarkDao.selectCountByRemarks(ids) == remarkDao.deleteByInfo(ids) && activityDao.deleteByActivity(ids) == ids.length;
    }
}
