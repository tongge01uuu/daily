package daily.business.util.rrd.util.loantransferutil;

import java.util.Calendar;
import java.util.Date;

/**
 * Day Count Convention 30/360 USA
 * 参考链接http://www.deltaquants.com/day-count-conventions.html
 * 
 * @author sillywolf
 */
public class DayCount30360USA implements DayCountInterface {

    @Override
    public int DayCount(Date from, Date to) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(from);
        cal2.setTime(to);

        // 条件1
        if (isLastDayOfFeb(from) && isLastDayOfFeb(to))
            cal2.set(Calendar.DATE, 30);
        // 条件2
        if (isLastDayOfFeb(from))
            cal1.set(Calendar.DATE, 30);
        // 条件3
        if (cal2.get(Calendar.DATE) == 31 && cal1.get(Calendar.DATE) >= 30)
            cal2.set(Calendar.DATE, 30);
        // 条件4
        if (cal1.get(Calendar.DATE) == 31)
            cal1.set(Calendar.DATE, 30);

        int num = (cal2.get(Calendar.DATE) - cal1.get(Calendar.DATE)) + 30
                * (cal2.get(Calendar.MONTH) - cal1.get(Calendar.MONTH)) + 360
                * (cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR));
        return num;

    }

    private boolean isLastDayOfFeb(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DATE);
        day = day + 1;
        cal.set(Calendar.DATE, day);
        int month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DATE);
        if (month == Calendar.MARCH && day == 1)
            return true;
        else
            return false;

    }

    public static void main(String args[]) {
        DayCountInterface dci = DayCountFactory.getInstance();
        Calendar calFrom = Calendar.getInstance();
        calFrom.set(2012, 1, 28, 20, 0, 0);
        Calendar calTo = Calendar.getInstance();
        calTo.set(2012, 3, 1, 20, 0, 0);
        int count = dci.DayCount(calTo.getTime(), calFrom.getTime());

        Calendar calDiff = Calendar.getInstance();
        int diffInDays = (int) ((calTo.getTimeInMillis() - calFrom.getTimeInMillis()) / (1000 * 60 * 60 * 24));
        System.out.println(diffInDays);
        System.out.println("count = " + count);
    }

}
