package com.springboot.websocket.broadcast;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * Created by yukai on 2017/7/19.
 */
@Configuration
@EnableWebSocketMessageBroker
/**
 * 广播式
 */
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        //stomp协议节点 - 广播
        stompEndpointRegistry.addEndpoint("/stomp/endpoint").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //消息代理 - 广播
        // 此配置决定 @SendTo("/stomp/topic/greeting/obj")的前缀路径
        registry.enableSimpleBroker("/stomp/topic");
    }
}
