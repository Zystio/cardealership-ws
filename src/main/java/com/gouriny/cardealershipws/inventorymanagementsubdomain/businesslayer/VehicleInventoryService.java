package com.gouriny.cardealershipws.inventorymanagementsubdomain.businesslayer;

import com.gouriny.cardealershipws.inventorymanagementsubdomain.presentationlayer.*;

import java.util.List;
import java.util.Map;

public interface VehicleInventoryService {

    List<InventoryResponseModel> getInventories();

    VehicleInventoryResponseModel getInventoryById(String inventoryId);

//    VehicleResponseModel getVehicleInInventoryByVin(String inventoryId, String vin);

    List<VehicleResponseModel> getVehiclesInInventoryByField(String inventoryId,
                                                             Map<String, String> queryParams);

    VehicleResponseModel addVehicleToInventory(VehicleRequestModel vehicleRequestModel, String inventoryId);

    InventoryResponseModel addInventory(InventoryRequestModel inventoryRequestModel);

    InventoryResponseModel updateInventory(InventoryRequestModel inventoryRequestModel, String inventoryId);

    VehicleResponseModel updateVehicleInInventoryByVehicleId(VehicleRequestModel vehicleRequestModel, String inventoryId, String vehicleId);

    void deleteInventory(String inventoryId);

    void removeVehicleFromInventory(String inventoryId, String vehicleId);

    VehicleResponseModel getVehicleInInventoryByVehicleId(String inventoryId, String vehicleId);
}

