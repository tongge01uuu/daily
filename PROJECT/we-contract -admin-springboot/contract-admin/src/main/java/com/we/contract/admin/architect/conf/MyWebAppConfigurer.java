package com.we.contract.admin.architect.conf;

import com.we.contract.admin.architect.interceptor.CommonInterceptor;
import com.we.contract.admin.architect.interceptor.ErrorInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.ErrorPageFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * WebMvc适配器<br>
 * 添加 listener、filter、interceptor
 * @author YK
 * @date 2017/7/26.
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
    private Logger log = LoggerFactory.getLogger(MyWebAppConfigurer.class);

    @Bean
    public ErrorPageFilter errorPageFilter() {
        return new ErrorPageFilter();
    }


    /**
     * 只过滤*.do的错误信息
     * @param filter
     * @return
     */
    @Bean
    public FilterRegistrationBean disableSpringBootErrorFilter(ErrorPageFilter filter) {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(filter);
        filterRegistrationBean.addUrlPatterns("*.do");
        return filterRegistrationBean;
    }

    /**
     * 拦截器添加
     * addPathPatterns 用于添加拦截规则
     * excludePathPatterns 用户排除拦截
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info(">>>>拦截器注册>>>");

        // 多个拦截器组成一个拦截器链依次加载


        //通用错误页面拦截器
        registry.addInterceptor(new ErrorInterceptor()).addPathPatterns("/*");
        //通用错误页面拦截器
        registry.addInterceptor(new CommonInterceptor()).addPathPatterns("/*");
        super.addInterceptors(registry);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);
        registry.addViewController("/business/dic_list").setViewName("/business/dic_list");
    }
}
