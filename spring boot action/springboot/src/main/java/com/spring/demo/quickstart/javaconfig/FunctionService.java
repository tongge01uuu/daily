package com.spring.demo.quickstart.javaconfig;

import org.springframework.stereotype.Service;

/**
 * Created by yukai on 2017/6/19.
 */
public class FunctionService {
    public void doSomething(String someBody){
        System.out.println(someBody+"--do something");
    }
    public void functionServiceInit()
    {
        System.out.println("functionService init");
    }

    public void functionServiceDestory()
    {
        System.out.println("functionService destoryed");
    }
}
