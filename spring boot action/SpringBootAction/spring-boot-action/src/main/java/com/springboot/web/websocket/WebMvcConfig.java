package com.springboot.web.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by yukai on 2017/7/19.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        /**
         * Thymeleaf视图解析器
         * 默认前缀classpath:/templates/
         * 默认后缀.html
         * 可在属性文件里配置 spring.thymeleaf.*** 来覆盖默认配置
         * 详情可参考源文件：
         * ThymeleafProperties
         */
        registry.addViewController("/greeting").setViewName("/websocket/broadcast/websocket_greeting");
        registry.addViewController("/chat").setViewName("/websocket/p2p/chat");
        registry.addViewController("/login").setViewName("/login");
    }
}
