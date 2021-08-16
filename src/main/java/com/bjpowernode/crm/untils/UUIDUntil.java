package com.bjpowernode.crm.untils;

import java.util.UUID;
public class UUIDUntil {
    private UUIDUntil(){}

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
