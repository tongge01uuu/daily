package com.spring.demo.quickstart.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yukai on 2017/6/19.
 */
@Configuration
public class JavaConfig {
    public JavaConfig(){
        System.out.println("加载spring配置");
    }

    //初始化与销毁方法   配置在bean内部方法
    @Bean(initMethod = "functionServiceInit",destroyMethod = "functionServiceDestory")
    public FunctionService functionService()
    {
        return new FunctionService();
    }

    @Bean
    public UserService userService()
    {
        UserService userService=new UserService();
        userService.setFunctionService(functionService());
        return userService;
    }

}
