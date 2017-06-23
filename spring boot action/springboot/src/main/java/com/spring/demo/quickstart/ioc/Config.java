package com.spring.demo.quickstart.ioc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yukai on 2017/6/19.
 */
@Configuration
@ComponentScan("com.spring.demo.quickstart.ioc")
public class Config {
    static {
        System.out.println("配置文件初始化");
    }
    {
        System.out.println("配置文件初始化-instance-before");
    }
    public Config(){
        System.out.println("加载spring配置");
    }
    {
        System.out.println("配置文件初始化-instance-after");
    }
}
