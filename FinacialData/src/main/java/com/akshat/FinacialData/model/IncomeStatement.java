package com.akshat.FinacialData.model;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IncomeStatement {

    private String date;
    private String symbol;
    private String reportedCurrency;
    private String cik;
    private String filingDate;
    private String acceptedDate;
    private String fiscalYear;
    private String period;

    private Long revenue;
    private Long costOfRevenue;
    private Long grossProfit;

    private Long researchAndDevelopmentExpenses;
    private Long generalAndAdministrativeExpenses;
    private Long sellingAndMarketingExpenses;
    private Long sellingGeneralAndAdministrativeExpenses;
    private Long otherExpenses;
    private Long operatingExpenses;
    private Long costAndExpenses;

    private Long netInterestIncome;
    private Long interestIncome;
    private Long interestExpense;
    private Long depreciationAndAmortization;

    private Long ebitda;
    private Long ebit;
    private Long nonOperatingIncomeExcludingInterest;
    private Long operatingIncome;

    private Long totalOtherIncomeExpensesNet;
    private Long incomeBeforeTax;
    private Long incomeTaxExpense;
    private Long netIncomeFromContinuingOperations;
    private Long netIncomeFromDiscontinuedOperations;
    private Long otherAdjustmentsToNetIncome;
    private Long netIncome;
    private Long netIncomeDeductions;
    private Long bottomLineNetIncome;
}
