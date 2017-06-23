package com.spring.demo.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by yukai on 2017/6/22.
 */
@Configuration
public class ProfileConfig {

    @Bean
    @Profile("dev")
    public ProfileDemoBean getDev()
    {
        return new ProfileDemoBean("dev");
    }
    @Bean
    @Profile("produc")
    public ProfileDemoBean getPro()
    {
        return new ProfileDemoBean("produc");
    }
    @Bean
    @Profile("produc4")
    public ProfileDemoBean getPro4()
    {
        return new ProfileDemoBean("produc4--");
    }
}
