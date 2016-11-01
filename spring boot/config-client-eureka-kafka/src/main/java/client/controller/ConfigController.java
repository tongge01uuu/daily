package client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by phantom on 16/9/11.
 */
@RefreshScope //TODO 这个注解是做什么的
@RestController
@RequestMapping("/config")
public class ConfigController {
    @Value("${from}")
    private String from;

    @RequestMapping("/from")
    public String getFrom()
    {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
