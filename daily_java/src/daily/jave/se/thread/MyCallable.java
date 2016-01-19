package daily.jave.se.thread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Object>{

	@Override
	public Object call() throws Exception {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+"----"+i);
		}
		return null;
	}

}
