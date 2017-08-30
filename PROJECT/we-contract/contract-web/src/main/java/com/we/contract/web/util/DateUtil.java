package com.we.contract.web.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * User:hgq
 * Datetime:2016/5/16 21:54
 */
public class DateUtil {

    /**
     * @param date1 需要比较的时间 不能为空(null),需要正确的日期格式
     * @param date2 被比较的时间  为空(null)则为当前时间
     * @return
     */
    public static int compareDate(String date1,String date2){
        int n = 0;

        String[] u = {"天","月","年"};
        String formatStyle = "yyyyMMdd";
        date2 = date2==null?DateUtil.getCurrentDate():date2;
        DateFormat df = new SimpleDateFormat(formatStyle);
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        try {
            c1.setTime(df.parse(date1));
            c2.setTime(df.parse(date2));
        } catch (Exception e3) {
            System.out.println("wrong occured");
        }
        while (!c1.after(c2)) {                     // 循环对比，直到相等，n 就是所要的结果
            n++;
            c1.add(Calendar.DATE, 1);           // 比较天数，日期+1
        }

        n = n-1;
        n = (int)n/365;
        return n;
    }

    /**
     * 得到当前日期
     * @return
     */
    public static String getCurrentDate() {
        Calendar c = Calendar.getInstance();
        Date date = c.getTime();
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
        return simple.format(date);
    }

    /**
     * 格式化成   01月01日格式
     * @return
     */
    public static String getMonthDay(Date now) {
        String monthDay;
        Calendar c = Calendar.getInstance();
        c.setTime(now);
        int month = c.get(Calendar.MONTH);
        int date = c.get(Calendar.DATE);
        if (month < 9) {
            monthDay = "0" + (month + 1) + "月";
        } else {
            monthDay = String.valueOf(month + 1) + "月";
        }
        if (date < 10) {
            monthDay = monthDay + "0" + date + "日";
        } else {
            monthDay = monthDay + date + "日";
        }
        return monthDay;
    }
}
