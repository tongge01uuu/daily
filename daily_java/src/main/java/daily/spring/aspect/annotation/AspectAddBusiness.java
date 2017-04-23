package daily.spring.aspect.annotation;

import daily.spring.aspect.annotation.PlusBusiness;
import daily.spring.aspect.annotation.PlusBusinessImpl;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by phantom on 2017/4/6.
 */
@Component
@Aspect
public class AspectAddBusiness {
    private static final Logger logger= LoggerFactory.getLogger(AspectAddBusiness.class);

//    @Pointcut("execution(** daily.spring.aspect.annotation.NormalBusiness.*(..))")
//    public void business(){};

    @DeclareParents(value = "daily.spring.aspect.annotation.NormalBusiness+",
                    defaultImpl =PlusBusinessImpl.class )
    private PlusBusiness plusBusiness;
}
