package com.we.contract.timer;

import com.site.spring.DefaultServiceLocator;
import com.we.contract.timer.runner.DemoJobRunner;
import org.springframework.context.ApplicationContext;

/**
 * @Author qibaichao
 * @ClassName TimerServiceLocator
 * @Date 2015年03月11日
 * @Description:
 */
public class TimerServiceLocator extends DefaultServiceLocator {
    /**
     * The context.
     */
    private static ApplicationContext context;

    static {
        try {
            context = getApplicationContext(TimerServiceLocator.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the application context.
     *
     * @return the application context
     */
    public static ApplicationContext getApplicationContext() {
        if (context == null) {
            throw new RuntimeException("Spring loading error!");
        }
        return context;
    }

    public static DemoJobRunner getUserQuitJobRunner() {
        return (DemoJobRunner) getApplicationContext().getBean("userQuitJobRunner");
    }

}