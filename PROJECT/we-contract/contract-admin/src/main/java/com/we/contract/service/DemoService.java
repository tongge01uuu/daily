package com.we.contract.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by yukai on 2017-8-28.
 */
@Service
public class DemoService {
    private static final Logger logger= LoggerFactory.getLogger(DemoService.class);
   public void doService()
   {
       logger.info("---------------execute DemoService----------------hot11");
   }
}
