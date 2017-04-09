package local.java.thread;

public class ThreadTest2 extends Thread{
	public static void main(String[] args) {
//		Thread t1=new ThreadTest2();
//		Thread t2=new ThreadTest2();
		Runnable t=new MyThread();
		Thread t1=new Thread(t);
		Thread t2=new Thread(t);
		
		t1.start();
		t2.start();
	}

	int i=0;
	public void run() {
		while(true)
		{
			System.out.println(Thread.currentThread().getName()+" --- "+i++);
			try {
				//sleep 0-1 seconds
				Thread.sleep((long)(Math.random()*1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(i==50)
			{
				break;
			}
		}
	}
}

class MyThread implements Runnable
{

	int i=0;
	public void run() {
		while(true)
		{
			System.out.println(Thread.currentThread().getName()+" --- "+i++);
			try {
				//sleep 0-1 seconds
				Thread.sleep((long)(Math.random()*1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(i==50)
			{
				break;
			}
		}
	}
	
}

