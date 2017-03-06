package test.thread;

import daily.jave.se.thread.MyCallable;
import daily.jave.se.thread.MyRunnable;

import java.util.concurrent.*;

/**
 * Created by yukai on 2017/2/20.
 */
public class ThreadTest{

    public static void main(String[] args) throws Exception {
        ThreadTest.callableTest();
        for (int i=0;i<2;i++)
        {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        ThreadTest.runnableTest();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public static void callableTest()throws Exception
    {
        ExecutorService executor= Executors.newSingleThreadExecutor();
        FutureTask<Integer> futureTask=new FutureTask<Integer>(new MyCallable());
        executor.submit(futureTask);
        System.out.println(futureTask.get());
    }
    public static void runnableTest()throws Exception
    {

    }
}
