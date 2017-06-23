package com.spring.demo.quickstart.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yukai on 2017/6/19.
 */
@Service
public class UserService {
    @Autowired
    private FunctionService functionService;

    public void userFunction(String name)
    {
        functionService.doSomething(name);
    }
}
