package daily.spring.aspect.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by phantom on 2017/4/6.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class AnnotationConfig {

    @Bean
    public NormalBusiness NormalBusiness()
    {
        return new NormalBusiness();
    }
    @Bean
    public Aspect Aspect()
    {
        return new Aspect();
    }
    @Bean
    public AspectAddBusiness AspectAddBusiness()
    {
        return new AspectAddBusiness();
    }

}
