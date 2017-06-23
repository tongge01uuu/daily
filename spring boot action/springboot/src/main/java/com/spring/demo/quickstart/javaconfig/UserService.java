package com.spring.demo.quickstart.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yukai on 2017/6/19.
 */
public class UserService {
    private FunctionService functionService;

    public FunctionService getFunctionService() {
        return functionService;
    }

    public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }

    public void userFunction(String name)
    {
        functionService.doSomething(name);
    }
}
