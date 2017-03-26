package daily.jave.se.thread.concurrent.ThreadLocal;

/**
 * Created by phantom on 2017/3/26.
 */

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 当很多线程需要多次使用同一个对象，并且需要该对象具有相同初始化值的时候最适合使用ThreadLocal。
 */
public class ThreadLocalDemo {
    static ThreadLocal<Integer> threadLocal=new MyThreadLocal<>();

    public static void main(String[] args) {
        System.out.println(threadLocal.get());
        threadLocal.set(10);
        ExecutorService executorService= Executors.newCachedThreadPool();
        for (int i=0;i<5;i++)
        {
            executorService.execute(new Worker(threadLocal));
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
        System.out.println(String.format("线程 %s 的初始值： %s ",Thread.currentThread().getName(),threadLocal.get()));
        threadLocal.set(random.nextInt(1000));
        System.out.println(String.format("线程 %s 处理后的值：%s",Thread.currentThread().getName(),threadLocal.get()));
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