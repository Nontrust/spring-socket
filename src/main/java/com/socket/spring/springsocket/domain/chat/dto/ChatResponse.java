package com.socket.spring.springsocket.domain.chat.dto;

import lombok.Builder;

public record ChatResponse(String id, String message) {
    @Builder
    public ChatResponse {
    }

    public static ChatResponse fromRequest(ChatRequest request){
        return ChatResponse.builder()
                .id(request.id())
                .message(request.message())
                .build();
    }
}
