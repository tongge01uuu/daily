package com.we.contract.admin.service;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
