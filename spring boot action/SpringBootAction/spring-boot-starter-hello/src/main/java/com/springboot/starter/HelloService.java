package com.springboot.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by yukai on 2017/6/29.
 */



public class HelloService {
    private String message;

    public HelloService(String message) {
        this.message = message;
    }

    public String sayHello()
    {
        return "Hello "+message;
    }
}
