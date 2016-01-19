package com.jd.activemq.sample;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jd.activemq.consumer.TextMessageListener;

public class MessageHandler extends TextMessageListener {
	private static final Log logger = LogFactory.getLog(MessageHandler.class);
	@Override
	protected void onMessage(String textMessage) throws Exception {
		System.out.println("---------MessageHandler---------onMessage");
		logger.info("received message: " +textMessage);
	}
}
