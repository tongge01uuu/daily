package com.spring.demo.quickstart.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by yukai on 2017/6/19.
 */
public class Executor {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(Config.class);
//        UserService userService=(UserService) context.getBean("userService");
        UserService userService= context.getBean(UserService.class);
        userService.userFunction("JAY ZHOU");
        context.close();
    }
}
