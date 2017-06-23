package com.spring.demo.combination_annotation;

import org.springframework.stereotype.Service;

/**
 * Created by yukai on 2017/6/23.
 */
@Service
public class DemoService {
    public void print(){
        System.out.println("---execute ok-----");
    }
}
