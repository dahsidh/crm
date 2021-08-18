package com.bjpowernode.crm.settings.servce.impl;

import com.bjpowernode.crm.exception.LoginException;
import com.bjpowernode.crm.settings.dao.UserDao;
import com.bjpowernode.crm.settings.eneity.User;
import com.bjpowernode.crm.settings.servce.UserServce;
import com.bjpowernode.crm.untils.DateTimeUntil;
import com.bjpowernode.crm.untils.MD5Until;
import com.bjpowernode.crm.untils.SqlSessionUtil;

import java.util.HashMap;
import java.util.Map;

public class UserServceImpl implements UserServce {
    private UserDao userDao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);

    @Override
    public User login(String loginAct, String loginPwd, String ip) throws LoginException {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("loginAct", loginAct);
        hashMap.put("loginPwd", MD5Until.getMD5(loginPwd));
        User user = userDao.login(hashMap);
        if (user == null)
            throw new LoginException("账号密码错误");

        String expireTime = DateTimeUntil.getSysTime();
        if (expireTime.compareTo(user.getExpireTime()) < 0)
            throw new LoginException("账号已失效");

        if ("0".equals(user.getLockState()))
            throw new LoginException("账号已锁定");

        if (!user.getAllowIps().contains(ip))
            throw new LoginException("ip地址受限");
            return user;
    }
}
