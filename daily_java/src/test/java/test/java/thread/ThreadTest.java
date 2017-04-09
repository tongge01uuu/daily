package test.java.thread;

import daily.jave.se.thread.MyCallable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by yukai on 2017/2/20.
 */
public class ThreadTest {

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
