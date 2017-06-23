package com.spring.demo.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by yukai on 2017/6/22.
 */
@Component
public class EventListener implements ApplicationListener<EventEntity> {
    public void onApplicationEvent(EventEntity event) {
        System.out.println("\n event triggered------listener-----begin");

        System.out.println("listener accept msg:"+event.getMsg());

        System.out.println("event triggered------listener-----end");
    }
}
