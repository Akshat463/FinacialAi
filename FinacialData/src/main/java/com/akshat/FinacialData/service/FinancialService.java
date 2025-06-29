package com.akshat.FinacialData.service;


import com.akshat.FinacialData.model.BalanceSheet;
import com.akshat.FinacialData.model.CashFlowStatement;
import com.akshat.FinacialData.model.IncomeStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FinancialService {

    private final BalanaceSheetService balanaceSheetService;
    private final CashFlowService cashFlowService;
    private final IncomeStatementService incomeStatementService;

    @Autowired
    public FinancialService(BalanaceSheetService balanaceSheetService, CashFlowService cashFlowService, IncomeStatementService incomeStatementService)
    {
        this.balanaceSheetService=balanaceSheetService;
        this.cashFlowService=cashFlowService;
        this.incomeStatementService = incomeStatementService;
    }

    public Mono<Map<String,Object>> getFinancialData(String symbol){
        Mono<List<BalanceSheet>> balanceMono=balanaceSheetService.getBalanceSheet(symbol);
        Mono<List<CashFlowStatement>> cashFlowMono=cashFlowService.getCashFlow(symbol);
        Mono<List<IncomeStatement>> incomeMono=incomeStatementService.getIncomeStatement(symbol);

        return Mono.zip(balanceMono,cashFlowMono,incomeMono)
                .map(tuple ->{
                    Map<String, Object> result= new HashMap<>();
                    result.put("balanceSheet",tuple.getT1());
                    result.put("cashFlow",tuple.getT2());
                    result.put("incomeStatement",tuple.getT3());
                    return result;
                });
    }
}
