package com.bjpowernode.crm.workbench.dao;

import com.bjpowernode.crm.workbench.entity.Activity;

import java.util.HashMap;
import java.util.List;

public interface ActivityDao {
    int save(Activity activity);

    List<Activity> getActivityListByCondition(HashMap<String, Object> hashMap);

    long getTotalByCondition();
}
