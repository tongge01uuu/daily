package com.spring.demo.quickstart.ioc;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by yukai on 2017/6/19.
 */
@Service
public class FunctionService {
    public void doSomething(String someBody){
        System.out.println(someBody+"--do something");
    }
    @PostConstruct
    public void functionServiceInit()
    {
        System.out.println("functionService init");
    }
    @PreDestroy
    public void functionServiceDestory()
    {
        System.out.println("functionService destoryed");
    }
}
