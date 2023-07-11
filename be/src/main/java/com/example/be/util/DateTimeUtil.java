package com.example.be.util;

import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {
    public static Date getTime(){
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }
}
