package com.demo.spring_ai_deepseek.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ChatAIService {

    private final ChatClient chatClient;

    public ChatAIService(ChatClient.Builder chatClientBuilder)
    {
        chatClient=chatClientBuilder.build();
    }

    public String generation(String userInput) {
        return this.chatClient.prompt()
                .user(userInput)
                .call()
                .content();
    }

    public Flux<String> generationWithStream(String userInput) {
        return this.chatClient.prompt()
                .user(userInput)
                .stream()
                .content();
    }



}
