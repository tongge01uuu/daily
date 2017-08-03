package com.springboot;

import com.springboot.starter.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class SpringBootActionApplicationTests {

	@Autowired
	private HelloService helloService;
	@Test
	public void autoConfig() {
		System.out.println(helloService.sayHello());
	}

}
