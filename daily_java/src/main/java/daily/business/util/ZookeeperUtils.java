package daily.business.util;

import com.alibaba.druid.support.json.JSONParser;
import com.alibaba.druid.support.json.JSONUtils;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.atomic.AtomicValue;
import org.apache.curator.framework.recipes.atomic.DistributedAtomicInteger;
import org.apache.curator.framework.recipes.atomic.DistributedAtomicLong;
import org.apache.curator.framework.recipes.shared.SharedCount;
import org.apache.curator.framework.recipes.shared.SharedCountListener;
import org.apache.curator.framework.recipes.shared.SharedCountReader;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.retry.RetryOneTime;
import org.apache.zookeeper.*;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;


/**
 * Created by phantom on 2017/4/30.
 */
public class ZookeeperUtils {
    private static final int CONNECTION_TIMEOUT=10000;
    private static final int CLIENT_PORT=2181;
    private static final int POOL_SIZE=10;
    private static final String IP="localhost";
    private static final String COUNTR_NODE="/counter";


    public static void zookeeperTest()throws Exception{
        // 创建一个与服务器的连接
        ZooKeeper zk;
        zk = new ZooKeeper(IP+":" + CLIENT_PORT,
                CONNECTION_TIMEOUT, new Watcher() {
            // 监控所有被触发的事件
            public void process(WatchedEvent event) {
                System.out.println("已经触发了" + event.getType() + "事件！");
            }
        });
        String node1=zk.create("/1","1".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT_SEQUENTIAL);
        System.out.println(String.format("节点 : %s 存储数据 : %s",node1,new String(zk.getData(node1,false,null))));
        String node2=zk.create("/1","1".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT_SEQUENTIAL);
        System.out.println(String.format("节点 : %s 存储数据 : %s",node2,new String(zk.getData(node2,false,null))));


        // 创建一个目录节点
        zk.create("/testRootPath", "testRootData".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT);
        // 创建一个子目录节点
        zk.create("/testRootPath/testChildPathOne", "testChildDataOne".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
        System.out.println(new String(zk.getData("/testRootPath",false,null)));
        // 取出子目录节点列表
        System.out.println(zk.getChildren("/testRootPath",true));
        // 修改子目录节点数据
        zk.setData("/testRootPath/testChildPathOne","modifyChildDataOne".getBytes(),-1);
        System.out.println("目录节点状态：["+zk.exists("/testRootPath",true)+"]");
        // 创建另外一个子目录节点
        zk.create("/testRootPath/testChildPathTwo", "testChildDataTwo".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
        System.out.println(new String(zk.getData("/testRootPath/testChildPathTwo",true,null)));
        // 删除子目录节点
        zk.delete("/testRootPath/testChildPathTwo",-1);
        zk.delete("/testRootPath/testChildPathOne",-1);
        // 删除父目录节点
        zk.delete("/testRootPath",-1);
        // 关闭连接
        zk.close();
    }

    private static void curatorTest()
    {
        CuratorFramework client=CuratorFrameworkFactory.newClient(IP+":" + CLIENT_PORT,CONNECTION_TIMEOUT,CONNECTION_TIMEOUT, new RetryOneTime(5));
        client.start();
        try {
//            client.delete().forPath(COUNTR_NODE);
            AtomicBoolean isExist=new AtomicBoolean();
            isExist.set(true);
            if(client.checkExists().forPath(COUNTR_NODE)==null)
            {
                isExist.compareAndSet(true,false);
                //不存在该zk节点
                client.create().forPath(COUNTR_NODE,COUNTR_NODE.getBytes());
            }
            final DistributedAtomicLong distributedAtomicLong=new DistributedAtomicLong(client,COUNTR_NODE,new RetryOneTime(5));
            if (!isExist.get())
            {
                System.out.println(String.format("节点：%s 不存在 初始化计数。。。。",COUNTR_NODE));
                distributedAtomicLong.trySet(1l);
            }
            ExecutorService executorService= Executors.newCachedThreadPool();
            final CountDownLatch countDownLatch=new CountDownLatch(POOL_SIZE);

            for (int i=0;i<POOL_SIZE;i++)
            {
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            AtomicValue<Long> value=distributedAtomicLong.increment();
                            while (!value.succeeded())
                            {
                                System.out.println(String.format("-------------线程：%s  请求失败 ：%s retry ",Thread.currentThread().getName(),value.succeeded()));
                                value=distributedAtomicLong.increment();
                            }
                            if (value.succeeded())
                            {
                                System.out.println(String.format("-------------线程：%s 前值：%s 后值：%s",Thread.currentThread().getName(),value.preValue(),value.postValue()));
                            }


                        } catch (Exception e) {
                            e.printStackTrace();
                        }finally {
                            countDownLatch.countDown();
                            System.out.println("-------------"+countDownLatch.getCount());
                        }
                    }
                });

            }

            countDownLatch.await();
            System.out.println("-------------主线程等待结束");
            executorService.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            client.close();
        }
    }

    public static Integer getCounterNumber()
    {
        Integer result=null;
        CuratorFramework client=CuratorFrameworkFactory.newClient(IP+":" + CLIENT_PORT,CONNECTION_TIMEOUT,CONNECTION_TIMEOUT, new RetryOneTime(5));
        client.start();
        try {
            AtomicBoolean isExist=new AtomicBoolean();
            isExist.set(true);
            if(client.checkExists().forPath(COUNTR_NODE)==null)
            {
                isExist.compareAndSet(true,false);
                //不存在该zk节点 则手动创建
                client.create().forPath(COUNTR_NODE,COUNTR_NODE.getBytes());
            }
            DistributedAtomicInteger distributedAtomicInteger=new DistributedAtomicInteger(client,COUNTR_NODE,new RetryOneTime(5));
            if (!isExist.get())
            {
                System.out.println(String.format("节点：%s 不存在 初始化计数。。。。",COUNTR_NODE));
                distributedAtomicInteger.trySet(1);
            }

            AtomicValue<Integer> value=distributedAtomicInteger.increment();
            while (!value.succeeded())
            {
                System.out.println(String.format("-------------线程：%s  请求失败 ：%s retry ",Thread.currentThread().getName(),value.succeeded()));
                value=distributedAtomicInteger.increment();
            }
            if (value.succeeded())
            {
                result=value.postValue();
                System.out.println(String.format("-------------线程：%s 前值：%s 后值：%s",Thread.currentThread().getName(),value.preValue(),result));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            client.close();
        }

        return result;
    }

    public static Integer getCounterNumberWithListener()
    {
        Integer result=null;
        CuratorFramework client=CuratorFrameworkFactory.newClient(IP+":" + CLIENT_PORT,CONNECTION_TIMEOUT,CONNECTION_TIMEOUT, new RetryOneTime(5));
        client.start();

        SharedCount baseCount=new SharedCount(client,COUNTR_NODE,1);
        baseCount.addListener(new SharedCounterListener());
        try {
            if(client.checkExists().forPath(COUNTR_NODE)==null)
            {
                //不存在该zk节点 则手动创建
                System.out.println("---创建节点"+COUNTR_NODE);
                client.create().forPath(COUNTR_NODE,COUNTR_NODE.getBytes());
            }
            baseCount.start();

            int count=baseCount.getCount();
            boolean isSuccess=baseCount.trySetCount(baseCount.getVersionedValue(),count+1);
            while (!isSuccess)
            {
                //并发导致版本不一致，设置失败重试，直到成功
                isSuccess=baseCount.trySetCount(baseCount.getVersionedValue(),count+1);
            }
            result=baseCount.getCount();
            System.out.println(String.format("listener-------------线程：%s 前值：%s 后值：%s",Thread.currentThread().getName(),count,result));

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            client.close();
        }

        return result;
    }


    public static void main(String[] args) {
        try {
//            test();
//            curatorTest();
            ExecutorService executorService=Executors.newCachedThreadPool();
            for (int i=0;i<POOL_SIZE;i++)
            {
                Future<Integer> future=executorService.submit(new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        getCounterNumberWithListener();
                        return getCounterNumber();
                    }
                });
                System.out.println(future.get());
            }

            executorService.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class SharedCounterListener implements SharedCountListener {


    @Override
    public void countHasChanged(SharedCountReader sharedCountReader, int i) throws Exception {
        System.out.println(String.format("计数数值变为：%s",i));
    }

    @Override
    public void stateChanged(CuratorFramework curatorFramework, ConnectionState connectionState) {
        System.out.println(String.format("状态改变：%s",connectionState));
    }
}