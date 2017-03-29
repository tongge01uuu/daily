package daily.jave.se.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by yukai on 2017/2/24.
 */
public class ThreadStateTest {

    public static void main(String[] args) {
        new Thread(new Waiting(),"wait").start();
        new Thread(new TimeWaiting(),"wait-time").start();
        new Thread(new Runnalbe(),"run-1").start();
        new Thread(new Runnalbe(),"run-2").start();
    }

    static class Waiting implements Runnable{
        @Override
        public void run() {
            synchronized (Waiting.class){
                try {
                    Waiting.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    static class TimeWaiting implements Runnable{
        @Override
        public void run() {
            synchronized (TimeWaiting.class){
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Runnalbe implements Runnable{
        @Override
        public void run() {
            synchronized (Runnalbe.class){

                while (true)
                {
                }
            }
        }
    }

}
