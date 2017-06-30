package com.spring.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by yukai on 2017/6/27.
 */

@Aspect
@Component
public class AspectService {
    private final static Logger logger= LoggerFactory.getLogger(AspectService.class);
    private void log(String param)
    {
        //调用方法的方法名
        String methodName=new Exception().getStackTrace()[1].getMethodName();
        String className=this.getClass().getName();
        String classInfo=this.toString();
        logger.info(String.format("执行对象：%s（%s）的方法:%s   拦截方法 %s",className,classInfo,methodName,param));
    }

    @Pointcut("execution(** com.springmvc.demo.quickstart.*.*(..))")
    public void pointCut(){}

    @Before("pointCut() && args(methodParam)")
    public void beforeBusinessWithParam(int methodParam)
    {
        log("before "+methodParam);
    }

}
