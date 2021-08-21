package com.bjpowernode.crm.workbench.servce.impl;

import com.bjpowernode.crm.untils.SqlSessionUtil;
import com.bjpowernode.crm.vo.PaginationVO;
import com.bjpowernode.crm.workbench.dao.ActivityDao;
import com.bjpowernode.crm.workbench.entity.Activity;
import com.bjpowernode.crm.workbench.servce.ActivityServce;

import java.util.HashMap;
import java.util.List;


public class ActivityServceImpl implements ActivityServce {
    private ActivityDao activityDao = SqlSessionUtil.getSqlSession().getMapper(ActivityDao.class);

    @Override
    public boolean save(Activity activity) {
        return activityDao.save(activity) > 0;
    }

    @Override
    public PaginationVO pageList(HashMap<String, Object> hashMap) {
        long total = activityDao.getTotalByCondition();
        List<Activity> dataList = activityDao.getActivityListByCondition(hashMap);
        return new PaginationVO(total, dataList);
    }
}
