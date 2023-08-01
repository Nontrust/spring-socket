package com.socket.spring.springsocket.presentation.socket;

import com.socket.spring.springsocket.domain.chat.dto.ChatRequest;
import com.socket.spring.springsocket.domain.chat.dto.ChatResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class StompController {
    @MessageMapping("/send")
    @SendTo("/topic/message")
    public ChatResponse sendMessage(ChatRequest request){
        log.warn("request {}", request);
        return ChatResponse.fromRequest(request);
    }
}
