package test.fzweb;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fzweb.action.DubboAction;

public class Consumer3 {
	private static ClassPathXmlApplicationContext context;

	public static void main(String[] args) throws Exception {
		context = new ClassPathXmlApplicationContext(new String[] { "service-consumer.xml" });
		context.start();
		ExecutorService service = Executors.newCachedThreadPool();
		Thread thread = new Thread() {
			public void run() {

				while (true) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					try {
						DubboAction dubboAction = (DubboAction) context.getBean("dubboAction");
						Map<String,String> paramMap = new HashMap<String,String>();
						paramMap.put("param", "Goliath");
						System.out.println(dubboAction.sayHello(paramMap));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		};
		service.submit(thread);
	}
}