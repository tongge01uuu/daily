package com.ribbon.web.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(@RequestParam Integer a,@RequestParam Integer b) {
        return restTemplate.getForEntity("http://compute.service/add?a="+a+"&b="+b, String.class).getBody();
    }

    @HystrixCommand(fallbackMethod = "addCallBack")
    @RequestMapping(value = "/add_", method = RequestMethod.GET)
    public String addWithHystrix(@RequestParam Integer a,@RequestParam Integer b) {
        return restTemplate.getForEntity("http://compute.service/add?a="+a+"&b="+b, String.class).getBody();
    }

    public String addCallBack(Integer a,Integer b)
    {
        return a+b+"error";
    }
}