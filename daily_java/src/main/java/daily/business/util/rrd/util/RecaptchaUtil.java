/*
 * Copyright(c) 2007-2010 by Yingzhi Tech.
 * All Rights Reserved
 */
package daily.business.util.rrd.util;

import java.util.Random;

/**
 * @author ijay
 */
public class RecaptchaUtil {
    private static Random r = new Random(System.currentTimeMillis());

    /**
     * 生成仅包含数字的随机验证码
     * 
     * @param length
     *            验证码长度
     * @return 验证码
     */
    public static String generateNumberOnlyRecaptcha(int length) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(r.nextInt(10));
        }

        return sb.toString();
    }

    /**
     * 生产随机字符串（小写）
     * 
     * @param length
     *            长度
     * @param str
     *            生成大写 65 生成小写 97 随机大小写 null
     */
    public static String generateLowStrRecaptcha(int length) {
        return generateStrRecaptcha(length, 97);
    }

    /**
     * 生产随机字符串（大写）
     * 
     * @param length
     *            长度
     */
    public static String generateUpStrRecaptcha(int length) {
        return generateStrRecaptcha(length, 65);
    }

    private static String generateStrRecaptcha(int length, int s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = (char) (s + r.nextInt(26));
            sb.append(c);
        }
        return sb.toString();
    }
}
