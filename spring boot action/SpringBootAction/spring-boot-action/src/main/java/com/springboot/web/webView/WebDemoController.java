package com.springboot.web.webView;

import org.springframework.boot.SpringApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebDemoController {
	
	@RequestMapping(value="/search",produces={MediaType.APPLICATION_JSON_VALUE})
	public PersonVo search(String personName){
		
		return new PersonVo(personName, 32, "hefei");
		
	}

    public static void main(String[] args) {
        SpringApplication.run(WebDemoController.class, args);
    }
}
