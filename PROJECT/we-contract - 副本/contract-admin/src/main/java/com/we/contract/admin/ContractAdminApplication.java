package com.we.contract.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class ContractAdminApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//            打war包的时候用这个
		return application.sources(ContractAdminApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ContractAdminApplication.class, args);
	}
}
