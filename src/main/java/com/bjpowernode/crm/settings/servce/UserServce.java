package com.bjpowernode.crm.settings.servce;

import com.bjpowernode.crm.exception.LoginException;
import com.bjpowernode.crm.settings.eneity.User;

public interface UserServce {
    User login(String loginAct, String loginPwd, String ip) throws LoginException;
}
