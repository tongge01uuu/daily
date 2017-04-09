package test.spring.aspect.annotation;

import daily.spring.aspect.annotation.AnnotationConfig;
import daily.spring.aspect.annotation.NormalBusiness;
import daily.spring.aspect.annotation.PlusBusiness;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by phantom on 2017/4/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AnnotationConfig.class)
public class AspectTest {
    private static final Logger logger= LoggerFactory.getLogger(AspectTest.class);
    @Autowired
    private NormalBusiness normalBusiness;
    @Test
    public void aspectText()
    {
        normalBusiness.doBusiness();
        normalBusiness.doBusiness(10);

        logger.info("AOP-@DeclareParents 动态引入新 接口/对象 功能");
        PlusBusiness plusBusiness=(PlusBusiness)normalBusiness;
        plusBusiness.doBusinessPlus();
    }
}
