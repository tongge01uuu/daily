package com.we.contract;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by 
 */
public class P2pServiceRunner {

    private static final Logger logger = LoggerFactory.getLogger(P2pServiceRunner.class);

    /**
     * timer程序启动方法
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            System.setProperty("druid.logType", "slf4j");
            System.setProperty("dubbo.application.logger", "slf4j");
            P2pServiceLocator.getApplicationContext();
            logger.info("DemoServiceRunner start");
            while (System.in.available() == 0) {
                Thread.sleep(5000);
            }
        } catch (Exception e) {
            logger.error("DemoServiceRunner error" + e.getMessage());
            System.exit(100);
        }
    }
}
