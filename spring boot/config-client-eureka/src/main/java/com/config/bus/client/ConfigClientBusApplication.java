package com.config.bus.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by phantom on 16/9/11.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigClientBusApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigClientBusApplication.class).web(true).run(args);
    }
}
