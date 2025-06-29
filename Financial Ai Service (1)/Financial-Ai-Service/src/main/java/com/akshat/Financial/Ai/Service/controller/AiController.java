package com.akshat.Financial.Ai.Service.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/ai")
public class AiController {

    private final ChatClient chatClient;
    private final ObjectMapper objectMapper;


    public AiController(ChatClient chatClient, ObjectMapper objectMapper) {
        this.chatClient = chatClient;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/analyze")
    public ResponseEntity<String> analyze(@RequestBody Map<String,Object> payload) throws JsonProcessingException{
        String userQuestion = (String) payload.get("question");
        String response = chatClient.prompt()
                .user(userQuestion)
                .call()
                .content();
        return ResponseEntity.ok(response);
    }
}
