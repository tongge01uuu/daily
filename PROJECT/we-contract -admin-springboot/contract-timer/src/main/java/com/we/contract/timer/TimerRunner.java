package com.we.contract.timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

;

/**
 * Created by qibaichao on 2015/3/11.
 */
public class TimerRunner {

    private static final Logger logger = LoggerFactory.getLogger(TimerRunner.class);

    /**
     * timer程序启动方法
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            TimerServiceLocator.getApplicationContext();
            logger.info("TimerRunner start");
            while (System.in.available() == 0) {
                Thread.sleep(5000);
            }
        } catch (Exception e) {
            logger.error("TimerRunner error" + e.getMessage());
            System.exit(100);
        }
    }
}
