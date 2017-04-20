package daily.business.util;

import daily.business.util.rrd.util.DateTools;
import org.apache.poi.ss.usermodel.DateUtil;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.*;

/**
 * Created by yukai on 2017/4/19.
 */
public class OrderNoGenerator {
    public static void main(String[] args) {
        ExecutorService executor= Executors.newCachedThreadPool();
        FutureTask futureTask1=new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                return getOrderIdByUUId();
            }
        });
        FutureTask futureTask2=new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                return getOrderId("555");
            }
        });
        for (int i=0;i<100;i++)
        executor.execute(futureTask1);
        executor.execute(futureTask2);
        try {
            System.out.println(futureTask1.get());
            System.out.println(futureTask2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();

    }
    public static String getOrderIdByUUId() {
        int machineId = 1;//最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if(hashCodeV < 0) {//有可能是负数
            hashCodeV = - hashCodeV;
        }
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        return machineId+String.format("%015d", hashCodeV);
    }
    public static String getOrderId(String businessType)
    {
        Date date=new Date();
        String dateStr= DateTools.dateToString(date,DateTools.DATE_PATTERN_FULL);
        StringBuilder result=new StringBuilder(businessType);
        result.append(dateStr);
        return result.toString();


    }
}
