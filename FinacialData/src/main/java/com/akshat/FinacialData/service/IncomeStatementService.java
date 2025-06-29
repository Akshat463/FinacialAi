package com.akshat.FinacialData.service;

import com.akshat.FinacialData.model.CashFlowStatement;
import com.akshat.FinacialData.model.IncomeStatement;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class IncomeStatementService {

    private final WebClient webClient;
    private static final String API_KEY="PpdFOKvoYGduBRrx5mK76mWj3ekjMSYC";
    private static final String BASE_URL = "https://financialmodelingprep.com/api/v3";

    public IncomeStatementService(WebClient webClient) {
        this.webClient = webClient.mutate().baseUrl(BASE_URL).build();
    }

    public Mono<List<IncomeStatement>> getIncomeStatement(String symbol){
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/income-statement/" + symbol)
                        .queryParam("period","annual")
                        .queryParam("apikey", API_KEY) // 👈 Add this line
                        .build())
                .retrieve()
                .onStatus(HttpStatusCode::isError, clientResponse ->
                        clientResponse.bodyToMono(String.class)
                                .map(errorBody -> new RuntimeException("API Error: " + errorBody))
                )
                .bodyToFlux(IncomeStatement.class)
                .collectList();
    }
}
