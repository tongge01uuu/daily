package com.jd.activemq.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jd.activemq.connection.ClusterConnectionFactory;
import com.jd.activemq.producer.ClusterJmsTemplate;

/**
 * 使用API文件方式发送消息
 * 
 * @author tianya
 * 
 */
public class ApiProducerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws Exception {
		ClusterConnectionFactory connectionFactory = new ClusterConnectionFactory();
		connectionFactory.setAddress("zookeeper://192.168.224.21:2181,192.168.224.21:2182,192.168.225.26:2181");
		connectionFactory.setAlwaysSyncSend(true);
		connectionFactory.setSystemId("AAA");
		connectionFactory.setUser("mq");
		connectionFactory.setPassword("mq");
		connectionFactory.open();
		ClusterJmsTemplate jmsTemplate = new ClusterJmsTemplate(connectionFactory);
		jmsTemplate.setDestination("VirtualTopic.XXX");
		for (int i = 0; i < 10; i++) {
			jmsTemplate.send("消息内容", "消息归档时的标识，比如订单的ID");
		}
	}

}
