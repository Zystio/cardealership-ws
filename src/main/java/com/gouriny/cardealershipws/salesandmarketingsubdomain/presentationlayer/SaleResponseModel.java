package com.gouriny.cardealershipws.salesandmarketingsubdomain.presentationlayer;

import com.gouriny.cardealershipws.common.CurrencyType;
import com.gouriny.cardealershipws.salesandmarketingsubdomain.dataaccesslayer.FinancingAgreementDetails;
import com.gouriny.cardealershipws.salesandmarketingsubdomain.dataaccesslayer.SaleStatus;
import com.gouriny.cardealershipws.salesandmarketingsubdomain.dataaccesslayer.Warranty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleResponseModel {

    private String saleId;
    private String inventoryId;
    private String vin;
    private String vehicleMake;
    private String vehicleModel;
    private String customerId;
    private String customerFirstName;
    private String customerLastName;
    private String employeeId;
    private String employeeFirstName;
    private String employeeLastName;
    private BigDecimal salePrice;
    private CurrencyType currency;
    private SaleStatus saleStatus;
    private LocalDate saleOfferDate;
    private FinancingAgreementDetails financingAgreementDetails;
    private Warranty warranty;

}
