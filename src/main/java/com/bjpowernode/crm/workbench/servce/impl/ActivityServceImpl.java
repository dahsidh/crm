package com.bjpowernode.crm.workbench.servce.impl;

import com.bjpowernode.crm.untils.SqlSessionUtil;
import com.bjpowernode.crm.workbench.dao.ActivityDao;
import com.bjpowernode.crm.workbench.servce.ActivityServce;


public class ActivityServceImpl implements ActivityServce {
    private ActivityDao activityDao = SqlSessionUtil.getSqlSession().getMapper(ActivityDao.class);
}
