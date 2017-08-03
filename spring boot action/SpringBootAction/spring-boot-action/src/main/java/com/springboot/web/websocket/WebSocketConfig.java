package com.springboot.web.websocket;

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
        stompEndpointRegistry.addEndpoint("/stomp/endpoint/broadcast").withSockJS();
        //stomp协议节点 - P2P
        stompEndpointRegistry.addEndpoint("/stomp/endpoint/p2p").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //消息代理 - 广播
        // 此配置决定 @SendTo("/stomp/topic/broadcast/greeting/obj")的前缀路径
        registry.enableSimpleBroker("/stomp/topic/broadcast","/stomp/queue/p2p");


        //注意： 多个消息代理，用逗号隔开，
        // 不要调用多次 enableSimpleBroker方法，最后一次会把之前的覆盖
        //消息代理 - 点对点
//        registry.enableSimpleBroker("/stomp/queue/p2p");
    }
}
