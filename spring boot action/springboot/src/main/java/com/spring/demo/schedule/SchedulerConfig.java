package com.spring.demo.schedule;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by yukai on 2017/6/22.
 */
@Configuration
@EnableScheduling
@ComponentScan("com.spring.demo.schedule")
public class SchedulerConfig {
}
