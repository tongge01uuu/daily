package com.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerSerice {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "addCallback")
    public String add( Integer a, Integer b) {
        return restTemplate.getForEntity("http://compute.service/add?a="+a+"&b="+b, String.class).getBody();
    }
    public String addCallBack()
    {
        return "error";
    }


}