package daily.jave.se.thread.concurrent.CountDownLatch;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by phantom on 2017/3/4.
 */

/**
 * CountDownLatch这个类能够使一个线程等待其他线程完成各自的工作后再执行
 *
 */
public class CountDownLatchDemo {
    static final int size = 100;

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
    private static Random random = new Random(47);

    public TaskWork(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            doWork();
            //类似notify，只不过需要等count计数为0时，wait的线程才能启动
            countDownLatch.countDown();
        } catch (Exception e) {
            System.out.println(this + "task interrupted");
        }

    }

    public void doWork() throws Exception {
        TimeUnit.MILLISECONDS.sleep(random.nextInt(2000));
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
            System.out.println(this + " latch barrier passed " + countDownLatch.getCount());
        } catch (Exception e) {
            System.out.println(this + " waiting task interrupted");
        }

    }

    @Override
    public String toString() {
        return String.format(" waiting task-%d-  ", id);
    }
}

