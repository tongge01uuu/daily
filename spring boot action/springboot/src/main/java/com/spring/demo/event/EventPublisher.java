package com.spring.demo.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by yukai on 2017/6/22.
 */
@Component
public class EventPublisher {
    @Autowired
    private ApplicationContext applicationContext;

    public void publish(String msg)
    {
        applicationContext.publishEvent(new EventEntity(this,msg));
    }
}
