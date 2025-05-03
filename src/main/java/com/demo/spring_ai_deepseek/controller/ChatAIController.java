package com.demo.spring_ai_deepseek.controller;

import com.demo.spring_ai_deepseek.service.ChatAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ChatAIController {

    @Autowired
    private ChatAIService chatAIService;

    @GetMapping("/askDeepSeek")
    public String askDeepSeek(@RequestParam(value="prompt") String prompt)
    {

        return chatAIService.generation(prompt);
    }

    @GetMapping("/askDeepSeek/v1")
    public Flux<String> askDeepSeekV1(@RequestParam(value="prompt") String prompt)
    {

        return chatAIService.generationWithStream(prompt);
    }
}
