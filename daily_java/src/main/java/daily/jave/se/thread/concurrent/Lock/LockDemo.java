package daily.jave.se.thread.concurrent.Lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by phantom on 2017/3/5.
 *
 * 操作ReentrantLock的加锁（lock）和解锁（unlock）必须是针对同一个ReentrantLock对象，
 * 要是new 两个ReetrantLock来分别完成对同一资源的加锁和解锁是没有意义的。
 */

public class LockDemo {

    public static void main(String[] args) {
        Lock lock=new ReentrantLock();
        Condition condition=lock.newCondition();
        ExecutorService executorService= Executors.newCachedThreadPool();
        CountDownLatch countDownLatch=new CountDownLatch(2);
        try {
            for (int i=0;i<10;i++)
            {
            }
            executorService.execute(new FirstStep(lock,condition));
            executorService.execute(new SecondStep(lock,condition));
//            for (int i=0;i<10;i++)
//            {
//                executorService.execute(new SecondStep(lock,condition));
//
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        executorService.shutdown();

    }

}

class FirstStep implements Runnable{
    private static volatile int count=0;
    private final int id=count++;
    private final Lock lock;
    private final Condition condition;
    public FirstStep(Lock lock,Condition condition) {
        this.lock=lock;
        this.condition=condition;
    }
    @Override
    public void run() {
        try {
            lock.lock();
            System.out.println(this+"-lock-");
            TimeUnit.SECONDS.sleep(1);
            System.out.println(this+"-await-");
            condition.await();
            System.out.println(this+"-------end await-");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(this+"-unlock-");
            lock.unlock();
        }
    }

    public String toString()
    {
        return "1-setp-"+id;
    }
}



class SecondStep implements Runnable{
    private static volatile int count=0;
    private final int id=count++;
    private final Lock lock;
    private final Condition condition;
    public SecondStep(Lock lock,Condition condition) {
        this.lock=lock;
        this.condition=condition;
    }
    @Override
    public void run() {
        boolean flag=false;
        try {
            flag=lock.tryLock(22, TimeUnit.SECONDS);

            if (flag)
            {
                System.out.println(this+"-lock-");
                System.out.println(this+"-single-");
                condition.signal();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (flag)
            {
                lock.unlock();
                System.out.println(this+"-unlock-");
            }
        }
    }
    public String toString()
    {
        return "2-setp-"+id;
    }
}

