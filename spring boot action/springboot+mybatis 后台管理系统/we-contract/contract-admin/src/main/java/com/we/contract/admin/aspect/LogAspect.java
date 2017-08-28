package com.we.contract.admin.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by yukai on 2017/8/2.
 */
@Aspect
@Component
//@Configuration
public class LogAspect {
    private static final Logger logger= LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* com.we.contract.admin.service.business.*.*(..))")
    public void aspectMethodService(){}

    @Before("aspectMethodService()")
    public void doBefore(JoinPoint joinPoint){
        System.out.println("------------------------------------before----------------------------------------");
    }
    @Around("aspectMethodService()")
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
