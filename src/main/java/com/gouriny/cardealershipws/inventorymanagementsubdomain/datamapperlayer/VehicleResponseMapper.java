package com.gouriny.cardealershipws.inventorymanagementsubdomain.datamapperlayer;

import com.gouriny.cardealershipws.inventorymanagementsubdomain.datalayer.Vehicle;
import com.gouriny.cardealershipws.inventorymanagementsubdomain.presentationlayer.VehicleResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VehicleResponseMapper {

    @Mapping(expression = "java(vehicle.getVehicleIdentifier().getVin())", target = "vehicleId")
    @Mapping(expression = "java(vehicle.getInventoryIdentifier().getInventoryId())", target = "inventoryId")
    VehicleResponseModel entityToResponseModel(Vehicle vehicle);

    List<VehicleResponseModel> entityListToResponseModelList(List<Vehicle> vehicle);
}
