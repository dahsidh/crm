package com.bjpowernode.crm.settings.servce;

import com.bjpowernode.crm.exception.LoginException;
import com.bjpowernode.crm.settings.eneity.User;

import java.util.List;

public interface UserServce {
    User login(String loginAct, String loginPwd, String ip) throws LoginException;

    List<User> findUserAll();
}
