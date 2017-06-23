package com.spring.demo.aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by yukai on 2017/6/22.
 */
@Component
public class AwareService implements BeanNameAware,ResourceLoaderAware{
//    @Autowired
    private String beanName;
//    @Autowired
    private ResourceLoader resourceLoader;
    public void setBeanName(String beanName) {
        this.beanName=beanName;
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader=resourceLoader;
    }


    public void printBeanName()
    {
        System.out.println(" 调用的beanName："+beanName);
    }
    public void printResource(String path)
    {
        try {
            System.out.println("\n读到的资源文件\n路径："+path+"\n内容："+IOUtils.toString(resourceLoader.getResource(path).getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






}
