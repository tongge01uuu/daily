package daily.jave.se.thread;

public class MyThread extends Thread{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(this.getName()+"-------"+i);
		}
	}
	
	public MyThread(){}
	public MyThread(Runnable runnable){
	}

}
