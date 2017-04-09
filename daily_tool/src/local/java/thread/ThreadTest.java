package local.java.thread;

public class ThreadTest{
	public static void main(String[] args) {
		Thread t1=new ThreadMine(); 
//		一个线程只能启动一次(调用start方法)，运行完之后不能重启，只能重新定义新线程启动
		t1.start();
		System.out.println(t1.getName()+"--"+Thread.currentThread().getName());
		
		Thread t2=new Thread(new Runnable() {
			public void run() {
				new ThreadTest().runMine();
			}
		});
		
		Thread t3=new Thread(new ThreadMine2());
		t3.start();
		t2.start();
	}
	
	public void runMine()
	{
		for (int i = 0; i <100; i++) {
			System.out.println(Thread.currentThread().getName()+"----"+i);
		}
	}

}

/**
 * 线程实现方式一
 * @author phantom
 *
 */
class ThreadMine extends Thread
{
	public void run() {
		System.out.println("继承Thread 重写run方法");
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName()+"--1--"+i);
		}
	}
}

/**
 * 线程实现方式二
 * @author phantom
 *
 */
class ThreadMine2 implements Runnable
{

	public void run() {
		System.out.println("实现Runnable 重写run方法");
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName()+"--2--"+i);
		}
	}
	
}

