package com.bjpowernode.crm.untils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class MyBatisUntil {
    private static SqlSessionFactory factory;

    static {
        String path = "mybatis.xml";
        try {
            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession() {
        if (factory != null) {
            return factory.openSession();
        }
        return null;
    }
}
