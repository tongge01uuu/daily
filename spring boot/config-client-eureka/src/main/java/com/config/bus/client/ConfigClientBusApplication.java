package com.config.bus.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by phantom on 16/9/11.
 */
@SpringBootApplication
public class ConfigClientBusApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigClientApplication.class).web(true).run(args);
    }
}
