package com.gouriny.cardealershipws.salesandmarketingsubdomain.dataaccesslayer;

import com.gouriny.cardealershipws.common.CurrencyType;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Price {

    private BigDecimal amount;
    private CurrencyType currency;

}
