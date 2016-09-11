package com.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by phantom on 16/9/11.
 */
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
}
