package com.spring.demo.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by yukai on 2017/6/22.
 */
public class EventEntity extends ApplicationEvent{
    private String msg;
    public EventEntity(Object source,String msg) {
        super(source);
        this.msg=msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
