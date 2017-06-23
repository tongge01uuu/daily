package com.spring.demo.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yukai on 2017/6/23.
 */
@Configuration
public class ConditionConfig {
    @Bean
    @Conditional(ConditionOfLinux.class)
    public ExecutorService getLinux()
    {
        return new ExecutorServiceLinux();
    }

    @Bean
    @Conditional(ConditionOfWindows.class)
    public ExecutorService getWindows()
    {
        return new ExecutorServiceWindows();
    }
}
