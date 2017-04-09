package daily.spring.aspect.declarative;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by phantom on 2017/4/6.
 */
@Component
public class NormalBusiness {
    private static final Logger logger= LoggerFactory.getLogger(NormalBusiness.class);

    public void doBusiness()
    {
        logger.info("------ doBusiness execution ------");
    }

    public void doBusiness(int param)
    {
        logger.info(param+" ------ doBusiness with param execution ------");
    }
}
