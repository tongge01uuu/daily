package com.spring.demo.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by yukai on 2017/6/22.
 */
public class EventExecutor {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(EventConfig.class);
        EventPublisher eventPublisher=context.getBean(EventPublisher.class);
        EventPublisherByAware eventPublisherByAware=context.getBean(EventPublisherByAware.class);
        eventPublisher.publish("hello world!!!");
        eventPublisherByAware.publish("hello world!!! by aware");
        context.close();
    }
}
