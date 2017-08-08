package com.springboot.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by yukai on 2017/8/2.
 */
@Aspect
@Component
//@Configuration
public class MonitorAspect {
    private static final Logger logger= LoggerFactory.getLogger(MonitorAspect.class);

    @Pointcut("execution(* com.springboot.data.jpa.dao.*.*(..))")
    public void aspectMethodJpa(){}
    @Pointcut("execution(* com.springboot.web.*.*(..))")
    public void aspectMethodWeb(){}

    @Before("aspectMethodJpa()")
    public void doBefore(JoinPoint joinPoint){
        System.out.println("------------------------------------before----------------------------------------");
    }
    @Around("aspectMethodJpa()")
    public Object aroundAspect(ProceedingJoinPoint proceedingJoinPoint)
    {
        Object obj=null;
        try {
            obj=proceedingJoinPoint.proceed();
            logger.info("\n执行方法：{} \n入参{} \n返回值{}",
                    proceedingJoinPoint.getSignature().toString(),
                    JSON.toJSON(proceedingJoinPoint.getArgs()),
                    JSON.toJSON(obj));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return obj;
    }
}
