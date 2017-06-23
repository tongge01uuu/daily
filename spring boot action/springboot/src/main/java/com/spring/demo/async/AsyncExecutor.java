package com.spring.demo.async;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by yukai on 2017/6/22.
 */
public class AsyncExecutor {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AsyncConfig.class);
        AsyncTaskService asyncTaskService=context.getBean(AsyncTaskService.class);
        for (int i=0;i<10;i++)
        {
            asyncTaskService.executeTask_1(i);
            asyncTaskService.executeTask_2(i);
        }
        context.close();
    }
}
