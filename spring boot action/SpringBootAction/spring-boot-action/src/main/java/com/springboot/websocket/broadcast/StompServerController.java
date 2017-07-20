package com.springboot.websocket.broadcast;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Date;

/**
 * Created by yukai on 2017/7/19.
 */
@Controller
@MessageMapping("/stomp/server")
public class StompServerController {

    @MessageMapping("/greeting")
    @SendTo("/stomp/topic/greeting")
    public Greeting welcome(GreetingMessage greeting)
    {
        return new Greeting(new Date().toString(),greeting.getMessage(),new Date().toString());
    }

    @MessageMapping("/greeting/obj")
    @SendTo("/stomp/topic/greeting/obj") // 对应WebSocketConfig.configureMessageBroker 中的消息代理地址前缀
    public Greeting welcome(Greeting greeting)
    {
        return greeting;
    }

}
