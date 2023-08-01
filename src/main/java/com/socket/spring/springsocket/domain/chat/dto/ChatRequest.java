package com.socket.spring.springsocket.domain.chat.dto;

import lombok.Builder;

public record ChatRequest(String id, String message) {
    @Builder
    public ChatRequest {
    }
}
