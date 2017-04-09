package com.daily.launcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScheduleCenterServiceRunner {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleCenterServiceRunner.class);

    /**
     * timer程序启动方法
     * 
     * @param args
     */
    public static void main(String[] args) {
        try {
            ScheduleCenterServiceLocator.getApplicationContext();
            logger.info("SchedulecenterServiceRunner start");
            while (System.in.available() == 0) {
                Thread.sleep(5000);
            }
        } catch (Exception e) {
            logger.error("SchedulecenterServiceRunner error" + e.getMessage());
            System.exit(100);
        }
    }
}
