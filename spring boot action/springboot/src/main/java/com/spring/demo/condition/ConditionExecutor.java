package com.spring.demo.condition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by yukai on 2017/6/23.
 */
public class ConditionExecutor {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ConditionConfig.class);

        ExecutorService executorService=context.getBean(ExecutorService.class);

        executorService.getListCmd();

        context.close();
    }
}
