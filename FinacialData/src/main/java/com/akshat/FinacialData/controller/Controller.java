package com.akshat.FinacialData.controller;

import com.akshat.FinacialData.service.FinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/api/financial")
public class Controller {

    @Autowired
    private FinancialService financialService;

    private final WebClient.Builder webClientBuilder;

    public Controller(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @GetMapping("statements/{symbol}")
    public ResponseEntity<Mono<Map<String, Object>>> getStatement(@PathVariable String symbol){
        return new ResponseEntity<Mono<Map<String, Object>>>(financialService.getFinancialData(symbol), HttpStatus.OK);
    }

    @PostMapping("/analyze")
    public Mono<ResponseEntity<String>> analyze(@RequestBody Map<String, Object> body) {
        return webClientBuilder.build()
                .post()
                .uri("http://ai-service/api/ai/analyze")
                .bodyValue(body)
                .retrieve()
                .bodyToMono(String.class)
                .map(ResponseEntity::ok);
    }
}
