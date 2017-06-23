package com.spring.demo.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * Created by yukai on 2017/6/22.
 */
@Component
public class EventPublisherByAware implements ApplicationEventPublisherAware {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher=applicationEventPublisher;
    }
    public void publish(String msg)
    {
        applicationEventPublisher.publishEvent(new EventEntity(this,msg));
    }
}
