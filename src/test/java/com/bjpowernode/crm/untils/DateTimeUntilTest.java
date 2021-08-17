package com.bjpowernode.crm.untils;

import junit.framework.TestCase;

public class DateTimeUntilTest extends TestCase {

    public void testGetSysTime() {
        String expireTime = "2018-08-10 10:10:10";
        String currntTime = DateTimeUntil.getSysTime();
        int count = expireTime.compareTo(currntTime);
        System.out.println(count);
    }
}