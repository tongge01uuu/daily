package test.fzservice;
import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider1 {

	/**
	 * @package 
	 * @description TODO
	 * @param args
	 * @returnType void
	 * @author Goliath
	 * @throws IOException 
	 * @createTime 2012-8-14 下午02:00:14
	 * @modifyTime
	 */
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "service-provider.xml" });
		context.start();
		System.out.println("dubbo started");
		System.in.read(); // 按任意键退出
	}

}
