package com.bjpowernode.crm.untils;

import junit.framework.TestCase;
import org.apache.log4j.chainsaw.Main;
import org.junit.Test;

public class DateTimeUntilTest extends TestCase {

    public void testGetSysTime() {
        String expireTime = "2018-08-10 10:10:10";
        String currntTime = DateTimeUntil.getSysTime();
        int count = expireTime.compareTo(currntTime);
        System.out.println(count);
    }

    @Test
    public void ifThe(){
        char a = '1';
        System.out.println((a==1)+"你好");
    }

    public static void main(String[] args) {
        char a = 128;
        System.out.println((a==128));
    }
}