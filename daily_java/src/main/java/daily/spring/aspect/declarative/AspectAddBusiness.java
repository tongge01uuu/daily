package daily.spring.aspect.declarative;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by phantom on 2017/4/6.
 */
public class AspectAddBusiness {
    private static final Logger logger= LoggerFactory.getLogger(AspectAddBusiness.class);
    private PlusBusiness plusBusiness;
}