package daily.jave.se.thread;

public class MyRunnable implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println(Thread.currentThread().getName()+"---"+i);
		}
	}

}
