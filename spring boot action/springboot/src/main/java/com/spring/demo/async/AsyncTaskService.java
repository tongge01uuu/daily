package com.spring.demo.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by yukai on 2017/6/22.
 */
@Component
@Async
public class AsyncTaskService {

    public void executeTask_1(int i)
    {
        System.out.println("executeTask_1----"+i);
    }
    public void executeTask_2(int i)
    {
        System.out.println("executeTask_2----"+(i+1));
    }

}
