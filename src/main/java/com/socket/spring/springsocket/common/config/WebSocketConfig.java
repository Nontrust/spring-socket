package com.socket.spring.springsocket.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    private final int BUFFER_SIZE = (int) Math.pow(2, 13);

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketHandlerCustom(), "/socket")
                .addInterceptors(new HttpSessionHandshakeInterceptor())
                // Todo: 도메인 및 https 통신 설정 필요
                .setAllowedOriginPatterns("*").withSockJS();
    }

    @Bean
    public ServletServerContainerFactoryBean createWebSocketContainer(){
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        container.setMaxTextMessageBufferSize(BUFFER_SIZE);
        container.setMaxBinaryMessageBufferSize(BUFFER_SIZE);
        return container;
    }

    @Bean
    public WebSocketHandlerCustom webSocketHandlerCustom() {
        return new WebSocketHandlerCustom();
    }
}
