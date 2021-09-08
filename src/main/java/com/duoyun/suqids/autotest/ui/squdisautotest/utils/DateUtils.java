package com.duoyun.suqids.autotest.ui.squdisautotest.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String getTimeStamp(){
        return String.valueOf(System.currentTimeMillis());
    }

    public static String getmmss(){
        Date curTime = new Date();
        SimpleDateFormat time = new SimpleDateFormat("mmss");
        return time.format(curTime).toString();
    }
}
