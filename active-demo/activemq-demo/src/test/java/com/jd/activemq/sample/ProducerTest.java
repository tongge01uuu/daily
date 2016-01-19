package com.jd.activemq.sample;

import javax.annotation.Resource;
import javax.jms.JMSException;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jd.activemq.producer.JMSProducer;

/**
 * 使用spring配置文件方式发送消息
 * @author tianya
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/spring-producer.xml" })
public class ProducerTest {
	private static final Logger logger = Logger.getLogger(ProducerTest.class);
	@Resource(name = "producer")
	private JMSProducer producer;

	@Test
	public void test() {
		while (true) {
			try {
				/********************** 在配置文件中已经配置destination **********************/
				producer.send("消息内容", "消息归档时的标识，比如订单的ID");

				
				
				
				
				/********************** 在配置文件中没有配置destination **********************/
				// 如果XXX消息是Topic类型
				producer.send("VirtualTopic.XXX", "消息内容", "消息归档时的标识，比如订单的ID");
				// 如果XXX消息是Queu类型
				producer.send("XXX", "消息内容", "消息归档时的标识，比如订单的ID");

				
				
				
				
				
				/********************** 需要发送多个消息时，配置文件中无需配置destination, 例如要发送消息XXX和YYY **********************/
				// 如果XXX消息是Topic类型
				producer.send("VirtualTopic.XXX", "消息内容", "消息归档时的标识，比如订单的ID");
				// 如果XXX消息是Queu类型
				producer.send("XXX", "消息内容", "消息归档时的标识，比如订单的ID");

				// 如果YYY消息是Topic类型
				producer.send("VirtualTopic.YYY", "消息内容", "消息归档时的标识，比如订单的ID");
				// 如果YYY消息是Queu类型
				producer.send("YYY", "消息内容", "消息归档时的标识，比如订单的ID");
				
				
			} catch (JMSException e) {
				e.printStackTrace();
			}
			logger.info("Send 消息内容  message success");
		}
	}
}
