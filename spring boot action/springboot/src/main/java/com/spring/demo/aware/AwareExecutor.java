package com.spring.demo.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by yukai on 2017/6/22.
 */
public class AwareExecutor {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AwareConfig.class);
        AwareService awareService_=context.getBean(AwareService.class);
        awareService_.printBeanName();
        awareService_.printResource("classpath:test/EL/ELTest.properties");
        context.close();
    }
}
