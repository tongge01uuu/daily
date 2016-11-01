package client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by phantom on 16/9/11.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigClientBusKafkaApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigClientBusKafkaApplication.class).web(true).run(args);
    }
}
