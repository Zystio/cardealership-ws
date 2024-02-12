package com.gouriny.cardealershipws.inventorymanagementsubdomain.presentationlayer;

import com.gouriny.cardealershipws.inventorymanagementsubdomain.datalayer.Option;
import com.gouriny.cardealershipws.inventorymanagementsubdomain.datalayer.Price;
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
public class VehicleResponseModel {

    private final String vehicleId;
    private final String inventoryId;
    private final Status status;
    private final UsageType usageType;
    private final Integer year;
    private final String manufacturer;
    private final String make;
    private final String model;
    private final String bodyClass;
    private final List<Option> options;
    private final Price price;

}
