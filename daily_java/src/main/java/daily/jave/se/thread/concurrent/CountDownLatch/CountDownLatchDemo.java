package daily.jave.se.thread.concurrent.CountDownLatch;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by phantom on 2017/3/4.
 */

/**
 * CountDownLatch这个类能够使一个/多个线程等待其他一个/多个线程完成各自的工作后再执行
 * 用于某个线程A等待若干个其他线程执行完任务之后，它才执行；
 *
 */
public class CountDownLatchDemo {
    static final int size = 5;

    public static void main(String[] args) {
        //CountDownLatch是通过一个计数器来实现的，计数器的初始值为线程的数量
        CountDownLatch countDownLatch = new CountDownLatch(size);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new WaitingWork(countDownLatch));
        }


        for (int i = 0; i < size; i++) {
            executorService.execute(new TaskWork(countDownLatch));
        }

        System.out.println("launched all tasks");
        executorService.shutdown();

    }
}

class TaskWork implements Runnable {

    private final CountDownLatch countDownLatch;
    private static int count = 0;
    private final int id = count++;
    private static int i=0;
    private static Random random = new Random(47);
    static final Lock lock=new ReentrantLock();
    public TaskWork(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
//        Lock lock=new ReentrantLock(); 定义在这里，再看下并发效果，注意观察countDownLatch.getCount()的计数
        try {
            lock.lock();
            doWork();
            //类似notify，只不过需要等count计数为0时，wait的线程才能启动
            countDownLatch.countDown();
        } catch (Exception e) {
            System.out.println(this + "task interrupted");
        }finally {
            lock.unlock();

        }

    }

    public void doWork() throws Exception {
        /**
         * 并发问题复现
            i++;
            Thread.yield();
            i++;
            if (i%2!=0)
            {
                System.out.println("------------------"+i);
            }
         */

        System.out.println(this + " task completed " + countDownLatch.getCount());
    }

    @Override
    public String toString() {
        return String.format(" do task-%d-  ", id);
    }
}

class WaitingWork implements Runnable {

    private final CountDownLatch countDownLatch;
    private static int count = 0;
    private final int id = count++;

    public WaitingWork(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
            System.out.println(this + " 计数器结束 " + countDownLatch.getCount());
        } catch (Exception e) {
            System.out.println(this + " waiting task interrupted");
        }

    }

    @Override
    public String toString() {
        return String.format(" waiting task-%d-  ", id);
    }
}

