package com.bjpowernode.crm.untils;

import junit.framework.TestCase;

public class MD5UntilTest extends TestCase {

    public void testGetMD5() {
        String str1 = MD5Until.getMD5("1234512ab");
        String str2 = MD5Until.getMD5("1234512ab");
        System.out.println(str1+"\t"+str2 );
    }
}