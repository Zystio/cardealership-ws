package com.gouriny.cardealershipws.inventorymanagementsubdomain.datalayer;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Table(name = "vehicles")
@Data
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private VehicleIdentifier vehicleIdentifier;

    @Embedded
    private InventoryIdentifier inventoryIdentifier;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private UsageType usageType;

    private Integer year;

    private String manufacturer;

    private String make;

    private String model;

    private String bodyClass;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "vehicle_options", joinColumns = @JoinColumn(name = "vehicle_id"))
    private List<Option> options;

    @Embedded
    private Price price; //price invariant - depends on total options cost

    public Vehicle() {

    }

    public Vehicle(VehicleIdentifier vehicleIdentifier, Status status, UsageType usageType, List<Option> options, Price price) {
        this.vehicleIdentifier = vehicleIdentifier;
        this.status = status;
        this.usageType = usageType;
        this.options = options;
        this.price = price;
    }
}
