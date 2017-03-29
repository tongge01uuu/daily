package daily.jave.se.thread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		for (int i = 0; i < 10; i++) {
			Thread.currentThread().sleep(200);
			System.out.println(Thread.currentThread().getName()+"----"+i);
		}
		return 9;
	}

}
