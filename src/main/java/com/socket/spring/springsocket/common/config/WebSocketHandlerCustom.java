package com.socket.spring.springsocket.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class WebSocketHandlerCustom extends TextWebSocketHandler {
    // Todo: Redis 이용 예정
    private static final Map<String, WebSocketSession> inMemorySessionStorage = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        inMemorySessionStorage.put(session.getId(), session);
        log.debug("afterConnectionEstablished {} ", inMemorySessionStorage.get(session.getId()));
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        inMemorySessionStorage.remove(session.getId(), session);
    }
}
