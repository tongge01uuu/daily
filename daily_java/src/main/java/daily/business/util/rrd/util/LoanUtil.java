/*
 * Copyright(c) 2007-2011 by Yingzhi Tech
 * All Rights Reserved
 * Created at 2011-01-29 13:36:48
 */

package daily.business.util.rrd.util;

import java.util.Calendar;
import java.util.Date;

/**
 * 交易相关Util
 * 
 * @author fred
 */
public final class LoanUtil {
    private LoanUtil() {
    }

    public static Date getLatestRefundDay(Date passTime, final Calendar calNow) {
        Calendar passCalendar = Calendar.getInstance();
        passCalendar.setTime(passTime);
        int monthDiff = calNow.get(Calendar.MONTH) - passCalendar.get(Calendar.MONTH);
        int dayDiff = calNow.get(Calendar.DATE) - passCalendar.get(Calendar.DATE);
        int yearDiff = calNow.get(Calendar.YEAR) - passCalendar.get(Calendar.YEAR);
        if (yearDiff == 0 && monthDiff == 0 && dayDiff == 0) { // 当天放出的交易，还款日应该在下一个月
            passCalendar.add(Calendar.MONTH, 1);
        } else {
            if (monthDiff >= 0) {
                if (dayDiff <= 0) { // 放款日 2010-01-20 今天 2010-03-15，则还款日为
                                    // 2010-03-20
                    passCalendar.add(Calendar.MONTH, monthDiff);
                } else { // 放款日 2010-01-20 今天 2010-03-30，则还款日为 2010-04-20
                    passCalendar.add(Calendar.MONTH, monthDiff + 1);
                }
            } else {
                monthDiff += 12;
                if (dayDiff <= 0) { // 放款日 2010-11-20 今天 2011-03-15，则还款日为
                                    // 2011-03-20
                    passCalendar.add(Calendar.MONTH, monthDiff);
                } else { // 放款日 2010-11-20 今天 2011-03-30，则还款日为 2011-04-20
                    passCalendar.add(Calendar.MONTH, monthDiff + 1);
                }
            }
        }
        return passCalendar.getTime();
    }
}
