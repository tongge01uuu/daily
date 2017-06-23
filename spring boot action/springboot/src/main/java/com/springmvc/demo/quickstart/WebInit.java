package com.springmvc.demo.quickstart;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by yukai on 2017/6/21.
 */
public class WebInit implements WebApplicationInitializer {
    public void onStartup(ServletContext servletContext) throws ServletException {
        try {
            servletContext.setInitParameter("spring.profiles.default","dev");

            AnnotationConfigWebApplicationContext context=new AnnotationConfigWebApplicationContext();
            context.register(MvcConfig.class);
            context.setServletContext(servletContext);
            ServletRegistration.Dynamic servletRegistration=servletContext.addServlet("dispatcher",new DispatcherServlet(context));
            servletRegistration.addMapping("/");
            servletRegistration.setLoadOnStartup(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
