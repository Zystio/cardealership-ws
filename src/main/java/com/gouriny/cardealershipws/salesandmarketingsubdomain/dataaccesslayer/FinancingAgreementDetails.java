package com.gouriny.cardealershipws.salesandmarketingsubdomain.dataaccesslayer;

import com.gouriny.cardealershipws.common.CurrencyType;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Embeddable
@NoArgsConstructor
@Getter
public class FinancingAgreementDetails {
    private Integer numberOfMonthlyPayments;
    private BigDecimal monthlyPaymentAmount;
    private BigDecimal downPaymentAmount;
    private CurrencyType paymentCurrency;
}
