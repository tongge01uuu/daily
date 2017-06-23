package com.spring.demo.EL;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * Created by yukai on 2017/6/20.
 */
@Configuration
@ComponentScan("com.spring.demo.EL")
@PropertySource("classpath:test/EL/ELTest.properties")
//@PropertySource("classpath:com/spring/demo/EL/EL_test.properties")
public class ELConfig {

    @Value("hello EL")
    private String normal;
    @Value("#{systemProperties['os.name']}")
    private String osName;
    @Value("#{T(java.lang.Math).random()*1000}")
    private String calResult;
    @Value("#{dataEntity.otherProperty}")
    private String anotherObjProperty;
    @Value("test/EL/ELTest.properties")
    private Resource fileContent;
    @Value("http://www.baidu.com")
    private Resource webContent;
    @Value("${dubbo.url}")
    private String dubboUrl;
    private Environment environment;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer()
    {
        return new PropertySourcesPlaceholderConfigurer();
    }
    public void outPutResource()
    {
        try {
            System.out.println(normal);
            System.out.println(osName);
            System.out.println(calResult);
            System.out.println(anotherObjProperty);
            System.out.println(IOUtils.toString(fileContent.getInputStream()));
            System.out.println(IOUtils.toString(webContent.getInputStream()));
            System.out.println(dubboUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
