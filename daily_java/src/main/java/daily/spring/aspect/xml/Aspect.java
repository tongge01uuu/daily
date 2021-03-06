package daily.spring.aspect.xml;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by phantom on 2017/4/6.
 */
@Component //xml声明式配置aspect的时候 需要添加@Component 这样在scan的时候会将该aspect处理 不然不会加载该切面
@org.aspectj.lang.annotation.Aspect
public class Aspect {
    private static final Logger logger= LoggerFactory.getLogger(Aspect.class);

    @Pointcut("execution(** daily.spring.aspect.xml.NormalBusiness.*(..))")
    public void business(){};

    /**
     * 拦截带参数的方法 并获取传入目标方法的入参
     * @param methodParam
     */
    @Before("business() && args(methodParam)")
    public void beforeBusinessWithParam(int methodParam)
    {
        log("before "+methodParam);
    }
    @Before("business()")
    public void beforeBusiness()
    {
        log("before");
    }
    @After("business()")
    public void afterBusiness()
    {
        log("after");
    }
    @AfterReturning("business()")
    public void returnBusiness()
    {
        log("return");
    }
    @AfterThrowing("business()")
    public void throwBusiness()
    {
        log("throw exception");
    }

    /**
     * 环绕通知，开始先于beore 结束先于after
     * @param proceedingJoinPoint
     */
    @Around("business()")
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
