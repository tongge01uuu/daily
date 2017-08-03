package com.springboot.web.websocket.p2p;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * Created by yukai on 2017/7/21.
 */
@Controller
@MessageMapping("/stomp/server")
public class ChatController {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg) {
        if (principal.getName().equals("user_1")) {
            messagingTemplate.convertAndSendToUser("user_2",
                    "/stomp/queue/p2p", principal.getName() + "-send:"
                            + msg);
        } else {
            messagingTemplate.convertAndSendToUser("user_1",
                    "/stomp/queue/p2p", principal.getName() + "-send:"
                            + msg);
        }
    }
}
