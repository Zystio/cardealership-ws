package com.gouriny.cardealershipws.salesandmarketingsubdomain.dataaccesslayer;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Embeddable
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class Warranty {

    private LocalDate warrantyEndDate;
    private String warrantyTerms;
}
