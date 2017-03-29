package daily.jave.se.thread.join;

/**
 * Created by phantom on 2017/2/26.
 */
public class JoinTest {
    public static void main(String[] args) {
        Thread t=new Thread(new RunnableImpl());
        t.start();
        try {
            t.join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finish");

    }

    static  class RunnableImpl implements Runnable
    {
        @Override
        public void run() {

            System.out.println("begin sleep---");
            try {
                Thread.currentThread().sleep(5000);
                System.out.println("end sleep---");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
