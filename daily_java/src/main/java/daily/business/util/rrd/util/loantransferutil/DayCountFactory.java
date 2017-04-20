package daily.business.util.rrd.util.loantransferutil;

public class DayCountFactory {
    public static DayCountInterface getInstance() {
        return new DayCount30360USA();
    }
}
