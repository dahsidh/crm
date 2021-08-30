package com.bjpowernode.crm.workbench.dao;

import com.bjpowernode.crm.workbench.entity.ActivityRemark;

import java.util.List;

public interface ActivityRemarkDao {
    int deleteByInfo(String[] ids);

    int selectCountByRemarks(String[] ids);

    List<ActivityRemark> getRemarkListByAid(String id);
}
