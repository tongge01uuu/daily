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
 * 用于一组线程互相等待至某个状态，然后这一组线程再同时执行；
 *
 * 第一个版本比较常用，用来挂起当前线程，直至所有线程都到达barrier状态再同时执行后续任务；
 *
 * 第二个版本是让这些线程等待至一定的时间，如果还有线程没有到达barrier状态就直接让到达barrier的线程执行后续任务。
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        int count=5;
        final List result = new ArrayList();
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
    static Random random = new Random(40); //定义成静态的，每次random.nextInt(10000）返回的值会不一样
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
        System.out.println(String.format(" %d 高呼：比赛结束，可以休息咯", id));
    }
}


