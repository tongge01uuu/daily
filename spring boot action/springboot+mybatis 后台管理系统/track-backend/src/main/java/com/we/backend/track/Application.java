package com.we.backend.track;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Spring boot 主类入口测试
 *
 * @author YK
 * @date 2017/7/27
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer{
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//            打war包的时候用这个
        return application.sources(Application.class);
    }


	
    public static void main(String[] args) throws Exception {
    	SpringApplication.run(Application.class, args);  
    }
}

