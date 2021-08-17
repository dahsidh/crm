package com.bjpowernode.crm.untils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUntil {
    private DateTimeUntil(){

    }

    public static String getSysTime(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }
}
