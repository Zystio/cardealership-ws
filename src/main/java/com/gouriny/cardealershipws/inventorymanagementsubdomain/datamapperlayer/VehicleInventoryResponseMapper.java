package com.gouriny.cardealershipws.inventorymanagementsubdomain.datamapperlayer;

import com.gouriny.cardealershipws.inventorymanagementsubdomain.datalayer.Inventory;
import com.gouriny.cardealershipws.inventorymanagementsubdomain.presentationlayer.VehicleInventoryResponseModel;
import com.gouriny.cardealershipws.inventorymanagementsubdomain.presentationlayer.VehicleResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VehicleInventoryResponseMapper {

    @Mapping(expression = "java(inventory.getInventoryIdentifier().getInventoryId())", target = "inventoryId")
    @Mapping(expression = "java(vehicles)", target = "availableVehicles")
    VehicleInventoryResponseModel entitiesToResponseModel(Inventory inventory, List<VehicleResponseModel> vehicles);

}
