package com.gouriny.cardealershipws.salesandmarketingsubdomain.dataaccesslayer;

import com.gouriny.cardealershipws.common.CustomerIdentifier;
import com.gouriny.cardealershipws.common.EmployeeIdentifier;
import com.gouriny.cardealershipws.common.InventoryIdentifier;
import com.gouriny.cardealershipws.common.VehicleIdentifier;
import com.gouriny.cardealershipws.customerrelationssubdomain.datalayer.Customer;
import com.gouriny.cardealershipws.inventorymanagementsubdomain.datalayer.Inventory;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Table(name = "sales")
public class Sale {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    SaleIdentifier saleIdentifier;

    @Embedded
    InventoryIdentifier inventoryIdentifier;

    @Embedded
    VehicleIdentifier vehicleIdentifier;

    @Embedded
    CustomerIdentifier customerIdentifier;

    @Embedded
    EmployeeIdentifier employeeIdentifier;

    @Embedded
    Price salePrices;

    @Enumerated(EnumType.STRING)
    private SaleStatus saleStatus;

    @Embedded
    FinancingAgreementDetails financingAgreementDetails;

    private LocalDate saleOfferDate;

    @Embedded
    Warranty warranty;

    public Sale(@NotNull InventoryIdentifier inventoryIdentifier,@NotNull VehicleIdentifier vehicleIdentifier, @NotNull CustomerIdentifier customerIdentifier,
                @NotNull EmployeeIdentifier employeeIdentifier, @NotNull Price salePrices, @NotNull SaleStatus saleStatus,
                @NotNull FinancingAgreementDetails financingAgreementDetails, @NotNull LocalDate saleOfferDate, @NotNull Warranty warranty) {
        this.saleIdentifier = new SaleIdentifier();
        this.inventoryIdentifier = inventoryIdentifier;
        this.vehicleIdentifier = vehicleIdentifier;
        this.customerIdentifier = customerIdentifier;
        this.employeeIdentifier = employeeIdentifier;
        this.salePrices = salePrices;
        this.saleStatus = saleStatus;
        this.financingAgreementDetails = financingAgreementDetails;
        this.saleOfferDate = saleOfferDate;
        this.warranty = warranty;
    }

    public Sale() {
        
    }
}
