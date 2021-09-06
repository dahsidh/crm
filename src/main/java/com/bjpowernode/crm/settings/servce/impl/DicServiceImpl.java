package com.bjpowernode.crm.settings.servce.impl;

import com.bjpowernode.crm.settings.dao.DicTypeDao;
import com.bjpowernode.crm.settings.dao.DicValueDao;
import com.bjpowernode.crm.settings.servce.DicService;
import com.bjpowernode.crm.untils.SqlSessionUtil;

public class DicServiceImpl implements DicService {
    private DicTypeDao typeDao = SqlSessionUtil.getSqlSession().getMapper(DicTypeDao.class);
    private DicValueDao dicValueDao = SqlSessionUtil.getSqlSession().getMapper(DicValueDao.class);

}
