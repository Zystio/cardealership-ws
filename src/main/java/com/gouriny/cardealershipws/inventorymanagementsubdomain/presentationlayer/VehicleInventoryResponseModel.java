package com.gouriny.cardealershipws.inventorymanagementsubdomain.presentationlayer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;


@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class VehicleInventoryResponseModel {
    //inventory details response (get inventory by id)

    private String inventoryId;
    private String type;
    private List<VehicleResponseModel> availableVehicles;
}
