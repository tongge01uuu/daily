package com.springboot;

import com.springboot.data.jpa.dao.PersonRepository;
import com.springboot.data.jpa.support.CustomRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

@Controller
@SpringBootApplication //包含了@Configuration的注解
//@EnableAspectJAutoProxy //spring-boot-starter-aop引入后，aop默认是开启状态
@PropertySource({"classpath:properties/db.properties","classpath:properties/hello.properties"})
@EnableJpaRepositories(repositoryFactoryBeanClass = CustomRepositoryFactoryBean.class)
//@ComponentScan("com.springboot")
public class SpringBootActionApplication {
	@RequestMapping("/")
	@ResponseBody
	public String index()
	{
		return "Hello World ! Spring Boot";
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootActionApplication.class, args);

//		SpringApplication builder=new SpringApplicationBuilder(SpringBootActionApplication.class).build();
//		builder.setBannerMode(Banner.Mode.LOG);
//		builder.run(args);

//		new SpringApplicationBuilder(SpringBootActionApplication.class)
//				.bannerMode(Banner.Mode.CONSOLE)
//				.run(args);
	}

}
