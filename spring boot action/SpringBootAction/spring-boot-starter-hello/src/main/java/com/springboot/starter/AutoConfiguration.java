package com.springboot.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yukai on 2017/6/29.
 */
@Configuration
@EnableConfigurationProperties(HelloSetting.class)
@ConditionalOnClass(HelloService.class)
@ConditionalOnProperty(prefix = "say.hello",value = "enabled",matchIfMissing = true)
public class AutoConfiguration {
    @Autowired
    private HelloSetting helloSetting;

    @Bean
    @ConditionalOnMissingBean(HelloService.class)
    public HelloService getHelloService()
    {
        HelloService helloService=new HelloService(helloSetting.getMessage());
        return helloService;
    }
}
