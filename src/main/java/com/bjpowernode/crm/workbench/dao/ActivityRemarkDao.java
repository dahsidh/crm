package com.bjpowernode.crm.workbench.dao;

public interface ActivityRemarkDao {
    int deleteByInfo(String[] ids);

    int selectCountByRemarks(String[] ids);
}
