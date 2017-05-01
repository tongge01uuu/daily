package test.business.util;

import daily.business.util.OrderNoGenerator;
import daily.business.util.SerialNumberGenerator;
import daily.business.util.ZookeeperUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.concurrent.*;

/**
 * Created by yukai on 2017/5/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/application.xml")
public class ZookeeperCounterTest {
    @Value("${zookeeper.client.url}")
    private String zookeeperUrl;
    @Value("${zookeeper.client.port}")
    private String zookeeperPort;
    @Value("${zookeeper.client.session.timeout}")
    private String sessionTimeOut;
    @Value("${zookeeper.client.connection.timeout}")
    private String connectionTimeOut;

    @Test
    public void counterTest()
    {
        System.out.println("-------------------"+connectionTimeOut);
        String businessType="55";
        Integer workID=ZookeeperUtils.getCounterNumberWithListener();
        ExecutorService executorService= Executors.newCachedThreadPool();
        for (int i=0;i<100;i++)
        {
            Future<String> futureTask = executorService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    String orderNo= SerialNumberGenerator.generatorSerialNumber(businessType,workID,new Date());
                    return  orderNo;
                }
            });

            try {
                System.out.println(String.format("生成的序列号为：%s 长度： %s",futureTask.get(),futureTask.get().length()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
    }
}
