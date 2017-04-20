/*
 * Copyright(c) 2007-2011 by Yingzhi Tech
 * All Rights Reserved
 * Created at 2011-06-14 11:36:45
 */
package daily.business.util.rrd.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author liqin
 */
public class IDVerifierUtil {
    private static Log log = LogFactory.getLog(IDVerifierUtil.class);
    private static final Map<String, String> PROVINCE_MAP = new HashMap<String, String>();
    private static final int MAX_YEARS = 150;
    private static final char[] LAST_DIGITS = { '1', '0', 'x', '9', '8', '7', '6', '5', '4', '3', '2' };
    private static final int[] WEIGHTS = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
    private static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]*");
    private static final Pattern DATE_PATTERN = Pattern
            .compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|"
                    + "(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|"
                    + "(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?"
                    + "((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|"
                    + "([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?"
                    + "((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?"
                    + "((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|"
                    + "(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?"
                    + "[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");

    static {
        PROVINCE_MAP.put("11", "北京");
        PROVINCE_MAP.put("12", "天津");
        PROVINCE_MAP.put("13", "河北");
        PROVINCE_MAP.put("14", "山西");
        PROVINCE_MAP.put("15", "内蒙古");
        PROVINCE_MAP.put("21", "辽宁");
        PROVINCE_MAP.put("22", "吉林");
        PROVINCE_MAP.put("23", "黑龙江");
        PROVINCE_MAP.put("31", "上海");
        PROVINCE_MAP.put("32", "江苏");
        PROVINCE_MAP.put("33", "浙江");
        PROVINCE_MAP.put("34", "安徽");
        PROVINCE_MAP.put("35", "福建");
        PROVINCE_MAP.put("36", "江西");
        PROVINCE_MAP.put("37", "山东");
        PROVINCE_MAP.put("41", "河南");
        PROVINCE_MAP.put("42", "湖北");
        PROVINCE_MAP.put("43", "湖南");
        PROVINCE_MAP.put("44", "广东");
        PROVINCE_MAP.put("45", "广西");
        PROVINCE_MAP.put("46", "海南");
        PROVINCE_MAP.put("50", "重庆");
        PROVINCE_MAP.put("51", "四川");
        PROVINCE_MAP.put("52", "贵州");
        PROVINCE_MAP.put("53", "云南");
        PROVINCE_MAP.put("54", "西藏");
        PROVINCE_MAP.put("61", "陕西");
        PROVINCE_MAP.put("62", "甘肃");
        PROVINCE_MAP.put("63", "青海");
        PROVINCE_MAP.put("64", "宁夏");
        PROVINCE_MAP.put("65", "新疆");
        PROVINCE_MAP.put("71", "台湾");
        PROVINCE_MAP.put("81", "香港");
        PROVINCE_MAP.put("82", "澳门");
        PROVINCE_MAP.put("91", "国外");
    }

    /**
     * 功能：身份证的有效验证
     * 
     * @param idStr
     *            身份证号
     * @return 有效：true 无效：false
     * @throws ParseException
     */
    public static boolean validate(String idStr) throws ParseException {
        if (idStr == null) {
            return false;
        }

        String formattedIDStr = "";
        int len = idStr.length();

        // 号码的长度15位或18位
        if (len != 15 && len != 18) {
            log.debug("号码长度应该为15位或18位");
            return false;
        }

        // 数字除最后一位都为数字
        if (len == 18) {
            formattedIDStr = idStr.substring(0, 17);
        } else if (len == 15) {
            formattedIDStr = idStr.substring(0, 6) + "19" + idStr.substring(6, 15);
        }

        if (!isNumeric(formattedIDStr)) {
            log.debug("15位号码都应为数字；18位号码除最后一位外，都应为数字");
            return false;
        }

        // 出生年月是否有效
        int year = Integer.parseInt(formattedIDStr.substring(6, 10)); // 年份
        int month = Integer.parseInt(formattedIDStr.substring(10, 12)); // 月份
        int day = Integer.parseInt(formattedIDStr.substring(12, 14)); // 月份
        String strDate = year + "-" + month + "-" + day;

        if (!isDate(strDate)) {
            log.debug("生日无效");
            return false;
        }

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        if ((calendar.get(Calendar.YEAR) - year) > MAX_YEARS
                || (calendar.getTime().getTime() - s.parse(strDate).getTime()) < 0) {
            log.debug("生日不在有效范围");
            return false;
        }

        if (month > 12 || month == 0) {
            log.debug("月份无效");
            return false;
        }

        if (day > 31 || day == 0) {
            log.debug("日期无效");
            return false;
        }

        // 地区码是否有效
        String province = PROVINCE_MAP.get(formattedIDStr.substring(0, 2));
        if (province == null) {
            log.debug("地区编码错误");
            return false;
        }

        if (idStr.length() == 15) {
            return true;
        }

        // 判断最后一位的值
        int weightedSum = 0;
        for (int i = 0; i < 17; i++) {
            weightedSum += ((formattedIDStr.charAt(i) - '0') * WEIGHTS[i]);
        }
        weightedSum %= 11;
        char charVerifyCode = LAST_DIGITS[weightedSum];

        if (idStr.length() == 18) {
            if (charVerifyCode != idStr.charAt(17) && 'X' != idStr.charAt(17)) {
                log.debug("最后一位错误");
                return false;
            }
        }

        return true;
    }

    /**
     * 功能：判断字符串是否为数字
     * 
     * @param str
     * @return
     */
    private static boolean isNumeric(String str) {
        return NUMBER_PATTERN.matcher(str).matches();
    }

    /**
     * 功能：判断字符串是否为日期格式
     * 
     * @param strDate
     * @return
     */
    private static boolean isDate(String strDate) {
        return DATE_PATTERN.matcher(strDate).matches();
    }
}
