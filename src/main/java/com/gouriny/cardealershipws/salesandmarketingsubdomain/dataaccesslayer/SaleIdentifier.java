package com.gouriny.cardealershipws.salesandmarketingsubdomain.dataaccesslayer;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Embeddable
@Getter
public class SaleIdentifier {

    private String saleId;

    public SaleIdentifier() {
        this.saleId = UUID.randomUUID().toString();
    }
}
