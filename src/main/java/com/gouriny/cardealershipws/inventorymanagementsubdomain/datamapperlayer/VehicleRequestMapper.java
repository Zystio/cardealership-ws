package com.gouriny.cardealershipws.inventorymanagementsubdomain.datamapperlayer;

import com.gouriny.cardealershipws.common.InventoryIdentifier;
import com.gouriny.cardealershipws.inventorymanagementsubdomain.datalayer.Price;
import com.gouriny.cardealershipws.inventorymanagementsubdomain.datalayer.Vehicle;
import com.gouriny.cardealershipws.common.VehicleIdentifier;
import com.gouriny.cardealershipws.inventorymanagementsubdomain.presentationlayer.VehicleRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface VehicleRequestMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(expression = "java(vehicleIdentifier)", target = "vehicleIdentifier"),
            @Mapping(expression = "java(inventoryIdentifier)", target = "inventoryIdentifier"),
            @Mapping(expression = "java(price)", target = "price"),
    })
    Vehicle requestModelToEntity(VehicleRequestModel vehicleRequestModel, VehicleIdentifier vehicleIdentifier, InventoryIdentifier inventoryIdentifier, Price price);
}
