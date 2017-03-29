package daily.jave.se.thread.concurrent.ThreadLocal;

/**
 * Created by phantom on 2017/3/26.
 */

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 当很多线程需要多次使用同一个对象，并且需要该对象具有相同初始化值的时候最适合使用ThreadLocal。
 *
 * 原理：
 * 1、每个线程会有一个ThreadLocal.ThreadLocalMap threadLocals变量.
*    每个Thread对象内部都维护了一个ThreadLocalMap这样一个ThreadLocal的Map，可以存放若干个ThreadLocal
 * 2、里面存储着,以threadLocal为key,放入threadLocal的数据为值的（Map）ThreadLocalMap
 * 3、线程的ThreadLocalMap里保存了一个threadLocal携带的数据的副本，每个线程都是独立拥有该数据副本
 * 4、线程ThreadLocalMap可以保持多个以threadLocal为key的键值对
 * 5、线程的threadLocals初始化在threadlocal的方法中进行，如下：
 *      thread.threadLocals = new ThreadLocalMap(threadLocal, firstValue);
 */
public class ThreadLocalDemo {
    static ThreadLocal<Integer> threadLocal1 =new MyThreadLocal<>();
    static ThreadLocal<String> threadLocal2=new MyThreadLocal<>();

    public static void main(String[] args) {
        System.out.println(String.format("threadLocal1:%s threadLocal2:%s",threadLocal1.get(),threadLocal2.get()));
        threadLocal1.set(10);
        threadLocal2.set("initial");
        ExecutorService executorService= Executors.newCachedThreadPool();
        for (int i=0;i<2;i++)
        {
            executorService.execute(new Worker(threadLocal1));
            executorService.execute(new Worker(threadLocal2));
        }
        executorService.shutdown();
    }

}

class Worker implements Runnable
{
    static Random random=new Random(10);
    private ThreadLocal<Integer> threadLocal;
    public Worker(ThreadLocal threadLocal)
    {
        this.threadLocal=threadLocal;
    }

    @Override
    public void run() {
        System.out.println(String.format("线程 %s 在threadLocal %s 的初始值： %s ",
                Thread.currentThread().getName(),threadLocal,threadLocal.get()));
        threadLocal.set(random.nextInt(1000));
        System.out.println(String.format("线程 %s 在threadLocal %s 处理后的值：%s",
                Thread.currentThread().getName(),threadLocal,threadLocal.get()));
    }
}

class MyThreadLocal<T> extends ThreadLocal<T>
{
    @Override
    protected T initialValue() {
        System.out.println(Thread.currentThread().getName()+"-----initial----");
        return super.initialValue();
    }

    public MyThreadLocal() {
        super();
    }

    @Override
    public T get() {
        return super.get();
    }

    @Override
    public void set(T value) {
        super.set(value);
    }

    @Override
    public void remove() {
        super.remove();
    }
}