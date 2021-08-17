package com.bjpowernode.crm.settings.dao;

import com.bjpowernode.crm.settings.eneity.User;

import java.util.HashMap;

public interface UserDao {

    User login(HashMap<String, String> hashMap);
}
