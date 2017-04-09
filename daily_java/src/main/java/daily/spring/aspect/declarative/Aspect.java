package daily.spring.aspect.declarative;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by phantom on 2017/4/6.
 */
public class Aspect {
    private static final Logger logger= LoggerFactory.getLogger(Aspect.class);

    public void business(){};

    /**
     * 拦截带参数的方法 并获取传入目标方法的入参
     * @param methodParam
     */
    public void beforeBusinessWithParam(int methodParam)
    {
        log("before "+methodParam);
    }
    public void beforeBusiness()
    {
        log("before");
    }
    public void afterBusiness()
    {
        log("after");
    }
    public void returnBusiness()
    {
        log("return");
    }
    public void throwBusiness()
    {
        log("throw exception");
    }

    /**
     * 环绕通知，开始先于beore 结束先于after
     * @param proceedingJoinPoint
     */
    public void aroundBusiness(ProceedingJoinPoint proceedingJoinPoint)
    {
        try {
            log("around begin");
            proceedingJoinPoint.proceed();
            log("around end");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    private void log(String execution)
    {
        //调用方法的方法名
        String methodName=new Exception().getStackTrace()[1].getMethodName();
        String className=this.getClass().getSimpleName();
        String classInfo=this.toString();
        logger.info(String.format("AOP-%s-执行对象：%s的方法:%s（%s）",
                execution,className,methodName,classInfo));
    }

}
