package com.example.be.util;

import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {
    public static Date getTime() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

//    public String convertDate(Date date) {
//        //    String dateTimeInput = "2023-07-17T09:17:44.000+00:00";
//        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
//        SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//
//        try {
////            Date dateTime = inputDateFormat.parse(String.valueOf(date));
//            String formattedDateTime = outputDateFormat.format(date);
//            return formattedDateTime;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "2023-01-01 12:12:12";
//        }
//    }

}
