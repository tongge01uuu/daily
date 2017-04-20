/*
 * Copyright(c) 2007-2010 by Yingzhi Tech.
 * All Rights Reserved
 */
package daily.business.util.rrd.util;

import java.util.Calendar;

/**
 * @author xiaoquan <quanliangfeng@yingzhitech.com>
 */
public interface Consts {

    /**
     * 列表每页大小
     */
    int PER_PAGE = 15;
    /**
     * 小图片文件名前缀
     */
    String SMALL_PIC_PREFIX = "s";
    /**
     * 临时文件夹
     */
    String TMP = "/upload/tmp";
    /**
     * 上传图片窗口的宽
     */
    double MEDIA_SCREEN_WIDTH = 300;
    /**
     * 上传图片窗口的高
     */
    double MEDIA_SCREEN_HEIGHT = 300;

    /**
     * 一秒的长度
     */
    long ONE_SECOND = 1000;

    /**
     * 一分钟的长度，修改此值将影响后台线程（自动投标、标状态检查、自动还款）的运行间隔
     */
    long ONE_MINUTE = 60L * 1000;
    /**
     * 一个小时的长度，修改此值将影响邮件验证过期的判断
     */
    long ONE_HOUR = ONE_MINUTE * 60;
    /**
     * 一天的长度，修改此值将影响逾期天数的计算
     */
    long ONE_DAY = ONE_HOUR * 24;
    // long ONE_DAY = 1L * 60 * 1000;
    /**
     * 一个月的长度，修改此值将影响信用认证的过期时间
     */
    long ONE_MONTH = 30 * ONE_DAY;
    // long ONE_MONTH = 60L * 60 * 1000;
    /**
     * 一年的长度
     */
    long ONE_YEAR = ONE_DAY * 365;
    /**
     * 分期还款每期的周期
     */
    int REPAY_TIME_UNIT = Calendar.MONTH;
    // int REPAY_TIME_UNIT = Calendar.MINUTE;
    /**
     * 还款周期系数
     */
    int REPAY_TIME = 1;

    /** 浮点数Round保留2位 */
    int ROUND_SCALE_2 = 2;
    /** 作为中间计算时,浮点数Round保留的标准位数:15位 */
    int ROUND_SCALE_STD = 15;

    // int REPAY_TIME = 30;
    String EMAIL_USER_NAME = "人人贷";
    String EMAIL_VERIFY_USER_NAME = "人人贷邮箱验证";
    String EMAIL_FIND_PASSWORD_USER_NAME = "人人贷帐户密码找回";
    String SECURITY_SESSION = "security_session";
    String SECURITY_TIME = "timestamp";
    String USER_SESSION = "USER_SESSION";
    String LOGIN_ERROR_PAGE = "/loginPage.action?error=true";
    String INDEX_PAGE = "/indexPage.action";
    /**
     * 人人贷私信运营帐号
     */
    String[]RRD_ACCOUNT = {"人人贷金贝贝","人人贷金妞妞","人人贷客服"};
}
