package daily.jave.se.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExec {
	public static void main(String[] args) {
		Thread thread1=new MyThread();
//		Thread thread2=new MyThread();
		Thread thread3=new Thread(new MyRunnable());
		ExecutorService service=Executors.newFixedThreadPool(2);
		service.submit(new MyCallable());
		thread1.start();
//		thread2.start();
		ThreadExec.deamonRun();
		thread3.start();
		service.shutdown();
		
	}
	
	public static void deamonRun()
	{
		Thread t=new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName()+"---deamon---"+i);
					try {
						Thread.currentThread().sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		//设置该线程为守护线程
		t.setDaemon(true);
		t.start();
	}

}
