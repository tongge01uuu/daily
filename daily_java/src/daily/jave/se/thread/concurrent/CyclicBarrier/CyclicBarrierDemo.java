package daily.jave.se.thread.concurrent.CyclicBarrier;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by phantom on 2017/3/5.
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        int count=5;
        List result = new ArrayList();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(count, new Runnable() {
            @Override
            public void run() {
                System.out.println("比赛结束，结果" + result);
            }
        });

        ExecutorService executorService = Executors.newCachedThreadPool();
        try {
            for (int i = 0; i < count; i++) {
                executorService.execute(new Runner(cyclicBarrier, result));
//                new Thread(new Runner(cyclicBarrier, result)).start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {

//            executorService.shutdownNow();  //用立刻关闭会处理终端异常
            executorService.shutdown();
        }

    }


}

class Runner implements Runnable {
    static AtomicInteger count = new AtomicInteger(0);
    int id = count.get() + 1;
    Random random = new Random(40);
    private CyclicBarrier cyclicBarrier;
    private List result;

    public Runner(CyclicBarrier cyclicBarrier, List result) {
        count.getAndSet(count.get() + 1);
        this.cyclicBarrier = cyclicBarrier;
        this.result = result;
    }

    @Override
    public void run() {
        try {
            long sleep=random.nextInt(10000+id);
            System.out.println(String.format("跑道%s的运动员%d大约需要时间%d",Thread.currentThread(),id,sleep));
            TimeUnit.MILLISECONDS.sleep(sleep);
//            Thread.sleep(sleep);
            System.out.println(String.format("runner %d get", id));
            result.add(id);
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

    }
}


