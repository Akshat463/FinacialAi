package com.akshat.FinacialData.model;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BalanceSheet {
    private String date;
    private String symbol;
    private String reportedCurrency;
    private String calendarYear;
    private String period;
    private Long totalAssets;
    private Long totalCurrentAssets;
    private Long totalNonCurrentAssets;
    private Long totalLiabilities;
    private Long totalCurrentLiabilities;
    private Long totalNonCurrentLiabilities;
    private Long totalEquity;
    private Long totalStockholdersEquity;
    private Long totalLiabilitiesAndStockholdersEquity;
}

