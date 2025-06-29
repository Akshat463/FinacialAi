package com.akshat.FinacialData.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CashFlowStatement {
    private String date;
    private String symbol;
    private String reportedCurrency;
    private String cik;
    private String fillingDate;
    private String acceptedDate;
    private String calendarYear;
    private String period;

    private Long netIncome;
    private Long depreciationAndAmortization;
    private Long deferredIncomeTax;
    private Long stockBasedCompensation;
    private Long changeInWorkingCapital;
    private Long accountsReceivables;
    private Long inventory;
    private Long accountsPayables;
    private Long otherWorkingCapital;
    private Long otherNonCashItems;
    private Long netCashProvidedByOperatingActivities;

    private Long investmentsInPropertyPlantAndEquipment;
    private Long acquisitionsNet;
    private Long purchasesOfInvestments;
    private Long salesMaturitiesOfInvestments;

}
