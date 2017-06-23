package com.spring.demo.combination_annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by yukai on 2017/6/23.
 */
public class AnnotationExecutor {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(MyAnnotation.class);
        DemoService demoService=context.getBean(DemoService.class);
        demoService.print();
        context.close();
    }
}
