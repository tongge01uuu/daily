package com.springboot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
@PropertySource({"properties/db.properties","properties/hello.properties"})
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
