package com.jd.activemq.sample;

import java.util.concurrent.CountDownLatch;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jd.activemq.consumer.JMSListener;

/**
 * 使用spring配置文件方式消费消息
 * @author tianya
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/spring-consumer.xml" })
public class ConsumerTest {
	private static final Logger logger = Logger.getLogger(ConsumerTest.class);
	@Resource(name = "consumer")
	private JMSListener consumer;

	/**
	 * @param args
	 */
	@Test
	public void test() {
		try {
			/* 默认配置autoStart="true"，会自动启动消费线程
			 * 如果需要手动启动消费线程可以配置autoStart="false"，然后使用consumer.open()方法手动开启
			 */
			logger.info("Start listening...");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		try {
			new CountDownLatch(1).await();
		} catch (InterruptedException e) {
			logger.error(e.getMessage(), e);
		}
	}

}
