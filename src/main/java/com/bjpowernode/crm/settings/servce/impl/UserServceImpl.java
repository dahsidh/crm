package com.bjpowernode.crm.settings.servce.impl;

import com.bjpowernode.crm.settings.dao.UserDao;
import com.bjpowernode.crm.settings.servce.UserServce;
import com.bjpowernode.crm.untils.MyBatisUntil;

public class UserServceImpl implements UserServce {
    private UserDao userDao = MyBatisUntil.getSqlSession().getMapper(UserDao.class);
}
