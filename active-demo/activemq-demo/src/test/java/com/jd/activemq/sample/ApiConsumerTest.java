package com.jd.activemq.sample;

import javax.annotation.Resource;
import javax.jms.MessageListener;

import org.apache.activemq.ActiveMQPrefetchPolicy;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jd.activemq.connection.ClusterConnectionFactory;
import com.jd.activemq.consumer.ClusterMessageListenerContainer;
import com.jd.activemq.consumer.ConsumerSetting;
import com.jd.activemq.retry.RetryListenerContainer;

/**
 * 使用API文件方式消费消息
 * @author tianya
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/spring-consumer.xml" })
public class ApiConsumerTest {
	private static final Logger logger = Logger
			.getLogger(ApiConsumerTest.class);
	


	@Resource(name = "retryContainer")
	private RetryListenerContainer retryContainer;

	@Resource(name = "messageListener")
	private MessageListener messageListener;

	@Test
	public void test() {

		ActiveMQPrefetchPolicy prefetchPolicy = new ActiveMQPrefetchPolicy();
		prefetchPolicy.setQueuePrefetch(100);

		ClusterConnectionFactory connectionFactory = new ClusterConnectionFactory();
		connectionFactory.setUser("mq");
		connectionFactory.setPassword("mq");
		connectionFactory.setSystemId("BBB");
		//线上环境不需要setAddress
		connectionFactory.setAddress("zookeeper://192.168.225.26:2181,192.168.225.26:2182,192.168.225.26:2183");
		//使用固定地址
//		connectionFactory.setAddress("fix://192.168.225.26:61618,192.168.225.25:61619");
		
		connectionFactory.setMaxReconnectAttempts(2);
		connectionFactory.setPrefetchPolicy(prefetchPolicy);

		ConsumerSetting setting1 = new ConsumerSetting(
				"Consumer.BBB.VirtualTopic.XXX", messageListener);
		ConsumerSetting setting2 = new ConsumerSetting(
				"Consumer.BBB.VirtualTopic.YYY", messageListener);

		ClusterMessageListenerContainer listener = new ClusterMessageListenerContainer();
		listener.setConnectionFactory(connectionFactory);
		listener.setMessageListener(messageListener);
		listener.setSessionTransacted(true);
		listener.setExceptionListener(retryContainer);
		listener.setConcurrency("1-5");
		listener.addConsumer(setting1);
		listener.addConsumer(setting2);

		try {
			connectionFactory.open();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		try {
			listener.open();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("Start listening...");
		while (true) {

		}

	}
}
