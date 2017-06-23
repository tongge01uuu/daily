package com.spring.demo.EL;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by yukai on 2017/6/21.
 */
public class ELExecutor {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext(ELConfig.class);
        ELConfig elConfig=annotationConfigApplicationContext.getBean(ELConfig.class);
        elConfig.outPutResource();
        annotationConfigApplicationContext.close();
    }
}
