package com.spring.demo.quickstart.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by yukai on 2017/6/19.
 */
public class Executor {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
        UserService userService= context.getBean(UserService.class);
        userService.userFunction("JAVA JAY ZHOU");
        context.close();
    }
}
