package com.we.contract.util;

/**
 * 提供日期的加减转换等功能 包含多数常用的日期格式
 *
 * @author shipengzhi
 * @version 1.0
 */

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DateUtil {

    public static final String DATE_FORMAT_DAY_SHORT = "yyyyMMdd";
    public static final String DATE_FORMAT_DAY_SLASH = "yyyy/MM/dd";
    public static final String DATE_FORMAT_DAY = "yyyy-MM-dd";
    public static final String DATE_FORMAT_SECOND = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_SECOND_SHORT = "yyyyMMddHHmmss";
    public static final String DATE_FORMAT_MILLS_SHORT = "yyyyMMddHHmmssSSS";
    public static final String DATE_FORMAT_MILLS_SHORT_ALISDK = "yyyy-MM-ddHH:mm:ss.SSS";

	/* ------------------------- format/parse ------------------------- */

    public static String formatDate(Date date) {
        return format(date, DATE_FORMAT_DAY);
    }

    public static String formatCompactDate(Date date) {
        return format(date, DATE_FORMAT_DAY_SHORT);
    }

    public static String formatTime(Date time) {
        return format(time, DATE_FORMAT_SECOND);
    }

    /**
     * 获取某一日期的起始时间（0点0分0秒），参数为null时则返回当前日期的起始时间
     *
     * @param date
     * @return Date
     */
    public static Date getStartTime(Date date) {
        Calendar now = Calendar.getInstance();
        if (date != null) {
            now.setTime(date);
        }
        now.set(Calendar.HOUR_OF_DAY, 0);
        now.set(Calendar.MINUTE, 0);
        now.set(Calendar.SECOND, 0);
        now.set(Calendar.MILLISECOND, 0);
        return now.getTime();
    }

    /**
     * 获取某一日期的结束时间（23点59分59秒），参数为null时则返回当前日期的结束时间
     *
     * @param date
     * @return Date
     */
    public static Date getEndTime(Date date) {
        Calendar now = Calendar.getInstance();
        if (date != null) {
            now.setTime(date);
        }
        now.set(Calendar.HOUR_OF_DAY, 23);
        now.set(Calendar.MINUTE, 59);
        now.set(Calendar.SECOND, 59);
        now.set(Calendar.MILLISECOND, 999);
        return now.getTime();
    }

    /**
     * 从String类型的时间获取年份
     */
    public static int getYear(String time, String pattern) {
        Date date = parse(time, pattern);
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        int year = ca.get(Calendar.YEAR);
        return year;
    }

    /**
     * 从String类型的时间获取月份
     */
    public static int getMonth(String time, String pattern) {
        Date date = parse(time, pattern);
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        int month = ca.get(Calendar.MONTH); // 一月为0
        return month + 1;
    }

    /**
     * 从String类型的时间获取日期
     */
    public static int getDay(String time, String pattern) {
        Date date = parse(time, pattern);
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        int day = ca.get(Calendar.DATE);
        return day;
    }

    /**
     * 将Date类型的时间按某种格式转换为String型
     */
    public static String format(Date time, String pattern) {
        if (time == null || StringUtils.isEmpty(pattern)) {
            return StringUtils.EMPTY;
        }
        SimpleDateFormat format = getFormat(pattern);
        return format.format(time);
    }

    /**
     * 将String类型的时间转换为Date型
     * 支持格式有：yyyyMMdd
     *
     * @param time
     * @return
     */
    public static Date parse(String time) {
        try {
            if (time.length() == 8) {
                return parse(time, DATE_FORMAT_DAY_SHORT);
            } else if (time.length() == 14) {
                return parse(time, DATE_FORMAT_SECOND_SHORT);
            } else if (time.length() == 19) {
                return parse(time, DATE_FORMAT_SECOND_SHORT);
            } else {
                throw new IllegalArgumentException("Parse Date Error: " + time);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Parse Date Error: " + time);
        }
    }

    /**
     * 将String类型的时间按某种格式转换为Date型
     */
    public static Date parse(String time, String pattern) {
        try {
            SimpleDateFormat format = getFormat(pattern);
            return format.parse(time);
        } catch (Exception e) {
            throw new IllegalArgumentException("Parse Date Error: " + time + ", With Pattern: " + pattern);
        }
    }

    /**
     * 获取Date所属月的第一天日期
     *
     * @return Date 默认null
     */
    public static Date getMonthFirstDate(Date date) {
        if (null == date) {
            return null;
        }

        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.set(Calendar.HOUR_OF_DAY, 0);
        ca.set(Calendar.MINUTE, 0);
        ca.set(Calendar.SECOND, 0);
        ca.set(Calendar.DAY_OF_MONTH, 1);

        Date firstDate = ca.getTime();
        return firstDate;
    }

    /**
     * 获取Date所属月的第一天日期
     *
     * @param pattern 时间格式,默认为yyyy-MM-dd
     * @return String 默认null
     */
    public static String getMonthFirstDate(Date date, String pattern) {
        Date firstDate = getMonthFirstDate(date);
        if (null == firstDate) {
            return null;
        }

        if (StringUtils.isBlank(pattern)) {
            pattern = DATE_FORMAT_DAY;
        }

        return format(firstDate, pattern);
    }

    /**
     * 获取Date所属月的最后一天日期
     *
     * @return Date 默认null
     */
    public static Date getMonthLastDate(Date date) {
        if (null == date) {
            return null;
        }

        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.set(Calendar.HOUR_OF_DAY, 23);
        ca.set(Calendar.MINUTE, 59);
        ca.set(Calendar.SECOND, 59);
        ca.set(Calendar.DAY_OF_MONTH, 1);
        ca.add(Calendar.MONTH, 1);
        ca.add(Calendar.DAY_OF_MONTH, -1);

        Date lastDate = ca.getTime();
        return lastDate;
    }

    /**
     * 获取Date所属月的最后一天日期
     *
     * @param pattern 时间格式,默认为yyyy-MM-dd
     * @return String 默认null
     */
    public static String getMonthLastDate(Date date, String pattern) {
        Date lastDate = getMonthLastDate(date);
        if (null == lastDate) {
            return null;
        }

        if (StringUtils.isBlank(pattern)) {
            pattern = DATE_FORMAT_DAY;
        }

        return format(lastDate, pattern);
    }

    /**
     * 计算两个日期间隔的秒数
     *
     * @param firstDate 小者
     * @param lastDate  大者
     * @return int 默认-1
     */
    public static long getTimeIntervalMins(Date firstDate, Date lastDate) {
        if (null == firstDate || null == lastDate) {
            return -1;
        }

        long intervalMilli = lastDate.getTime() - firstDate.getTime();
        return (intervalMilli / (1000));
    }

    /**
     * 计算两个日期间隔的天数
     *
     * @param firstDate 小者
     * @param lastDate  大者
     * @return int 默认-1
     */
    public static int getDayNum(Date firstDate, Date lastDate) {
        long timeInterval = getTimeIntervalMins(firstDate, lastDate);
        long between_days = timeInterval / (3600 * 24);
        return Integer.parseInt(String.valueOf(between_days));
    }

	/* ------------------------- format/parse impl ------------------------- */

    static SimpleDateFormat getFormat(String pattern) {
        Map<String, SimpleDateFormat> cache = _simpleDateFormatCache.get();
        SimpleDateFormat format = cache.get(pattern);
        if (format != null) {
            return format;
        }

        // 防止cache过大
        if (cache.size() > 20) {
            cache.clear();
        }
        cache.put(pattern, format = new SimpleDateFormat(pattern));
        return format;
    }

    static
    ThreadLocal<Map<String, SimpleDateFormat>>
            _simpleDateFormatCache =
            new ThreadLocal<Map<String, SimpleDateFormat>>() {
                protected Map<String, SimpleDateFormat> initialValue() {
                    return new ConcurrentHashMap<String, SimpleDateFormat>();
                }
            };
    static final Date _emptyDate = new Date(0);


    public static int getIntervalSec(long t1, long t2) {
        return (int) (t1 - t2);
    }

    public static String getDateByTimeStamp(long timestamp) {
        Long timestampMs = timestamp * 1000;
        String date = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss").format(new Date(timestampMs));
        return date;
    }

    /**
     * 在文件服务中，生成T-1日 15:00:00 至 T日 14：59：59 跨天类型
     * 后续会在这里进行容错，-1 -2 -3 进行之前三天的时间获取
     *
     * created by shuaizhiguo
     * @return
     */
    public static Map<String, Date> generateDate(String right, String left) {
        final SimpleDateFormat dealDate = new SimpleDateFormat("yyyy-MM-dd");
        final SimpleDateFormat dealDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        String today = dealDate.format(calendar.getTime());
        calendar.add(Calendar.DATE, -1);
        String yesterday = dealDate.format(calendar.getTime());
        today += right;
        yesterday += left;
        Map<String, Date> dateMap = new HashMap<>();
        Date todayDate = null;
        Date yesterdayDate = null;
        try {
            todayDate = dealDateTime.parse(today);
            yesterdayDate = dealDateTime.parse(yesterday);
        } catch (Exception e) {
            e.printStackTrace();
        }
        dateMap.put("rightDate", todayDate);
        dateMap.put("leftDate", yesterdayDate);

        return dateMap;
    }
    /**
     * 文件服务中，上传文件需要用到的时间， 当天类型
     * 后续会在这里进行容错，-1 -2 -3 进行之前三天的时间获取
     *
     * created by shuaizhiguo
     * @return
     */
    public static Map<String, Date> generateUploadDate() {

        final SimpleDateFormat dealDate = new SimpleDateFormat("yyyy-MM-dd");
        final SimpleDateFormat dealDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        /**
         * 右侧时间为当前时间
         * 左侧时间默认为当前日的15：00：00
         */
        //calendar.add(Calendar.DATE, -1);
        String right = dealDate.format(calendar.getTime());
        String left  = dealDate.format(calendar.getTime());
        left  += " 15:00:00";
        right += " 17:00:00";
        Map<String, Date> dateMap = new HashMap<>();
        Date rightDate = null;
        Date leftDate = null;
        try {
            rightDate = dealDateTime.parse(right);
            leftDate = dealDateTime.parse(left);
        } catch (Exception e) {
            e.printStackTrace();
        }
        dateMap.put("rightDate", rightDate);
        dateMap.put("leftDate", leftDate);

        return dateMap;
    }

    /**
     * 获取偏移量日期
     * created by qibaichao
     *
     * @param Offset
     * @return
     */
    public  static String getOffsetDateStr(int Offset) {

        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, Offset);
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String offsetDate = format.format(ca.getTime());
        return offsetDate;
    }
    public  static Date getOffsetDate(int Offset) {

        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, Offset);
        return ca.getTime();
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
