package com.spring.demo.schedule;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by yukai on 2017/6/22.
 */
public class ScheduleExecutor {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SchedulerConfig.class);

    }
}
