package com.springboot.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by yukai on 2017/6/29.
 */
@ConfigurationProperties("say.hello")
public class HelloSetting {

    private static final String DEFAULT="World!!!";

    private String message=DEFAULT;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
