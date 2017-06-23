package com.springmvc.demo.quickstart;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by yukai on 2017/6/23.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.springmvc.demo.quickstart")
public class MvcConfig {
    @Bean
    public InternalResourceViewResolver myViewResolver(){
        InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
        viewResolver.setPrefix("WEB-INF/classes/mvc/views");
        viewResolver.setSuffix(".html");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }
}
