package com.bjpowernode.crm.workbench.dao;

import com.bjpowernode.crm.workbench.entity.Activity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ActivityDao {
    int save(Activity activity);

    List<Activity> getActivityListByCondition(Map hashMap);

    long getTotalByCondition(Map hashMap);


    int deleteByActivity(String[] ids);

    Activity getById(String id);

    int updateInfo(Activity activity);

    Activity detailById(String id);
}
