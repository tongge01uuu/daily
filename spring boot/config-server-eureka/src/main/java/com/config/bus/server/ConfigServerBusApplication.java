package com.config.bus.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigServerBusApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ConfigServerApplication.class).web(true).run(args);
//		Banner banner=new Banner() {
//			@Override
//			public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
//				out.print("CONFIG SERVER");
//			}
//		};
//		SpringApplication springApplication=new SpringApplication(ConfigServerApplication.class);
//		springApplication.setBanner(banner);
//		springApplication.run(args);
	}

}
