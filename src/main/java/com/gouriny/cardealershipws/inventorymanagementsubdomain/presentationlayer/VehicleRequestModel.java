package com.gouriny.cardealershipws.inventorymanagementsubdomain.presentationlayer;

import com.gouriny.cardealershipws.inventorymanagementsubdomain.datalayer.Option;
import com.gouriny.cardealershipws.inventorymanagementsubdomain.datalayer.Status;
import com.gouriny.cardealershipws.inventorymanagementsubdomain.datalayer.UsageType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class VehicleRequestModel {
    //probably good not to include the total options cost.
    //we should calculate that ourselves
    //probably only in the response and not store it at all
    //since it's a calculated value.

    private String vin;
    private String inventoryId;
    private Status status;
    private UsageType usageType;
    private Integer year;
    private String manufacturer;
    private String make;
    private String model;
    private String bodyClass;
    private List<Option> options;
    private Double msrp;
    private Double cost;

}
