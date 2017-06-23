package com.spring.demo.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by yukai on 2017/6/22.
 */
public class ProfileExecutor {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("produc4");
        context.register(ProfileConfig.class);
        context.refresh();

        ProfileDemoBean profileDemoBean=context.getBean(ProfileDemoBean.class);
        System.out.println(profileDemoBean.getContent());
        context.close();
    }
}
