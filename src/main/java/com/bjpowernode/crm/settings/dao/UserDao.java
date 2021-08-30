package com.bjpowernode.crm.settings.dao;

import com.bjpowernode.crm.settings.eneity.User;

import java.util.HashMap;
import java.util.List;

public interface UserDao {

    User login(HashMap<String, String> hashMap);

    List<User> findAll();


}
