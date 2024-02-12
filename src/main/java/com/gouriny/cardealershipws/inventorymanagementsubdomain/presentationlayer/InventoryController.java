package com.gouriny.cardealershipws.inventorymanagementsubdomain.presentationlayer;

import com.gouriny.cardealershipws.inventorymanagementsubdomain.businesslayer.VehicleInventoryService;
import com.gouriny.cardealershipws.inventorymanagementsubdomain.utils.exceptions.InvalidInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/inventories")
public class InventoryController {

    @Autowired
    private VehicleInventoryService vehicleInventoryService;

    @GetMapping()
    List<InventoryResponseModel> getInventories() {
        return vehicleInventoryService.getInventories();
    }

    @GetMapping("/{inventoryId}")
    VehicleInventoryResponseModel getInventoryDetailsById(@PathVariable String inventoryId) {
        return vehicleInventoryService.getInventoryById(inventoryId);
    }

    @GetMapping("/{inventoryId}/vehicles")
    List<VehicleResponseModel> getVehiclesInInventory(@PathVariable String inventoryId,
                                                      @RequestParam(required = false) Map<String, String> queryParams) {
        return vehicleInventoryService.getVehiclesInInventoryByField(inventoryId, queryParams);
    }

    @PostMapping()
    InventoryResponseModel addInventory(@RequestBody InventoryRequestModel inventoryRequestModel) {
        return vehicleInventoryService.addInventory(inventoryRequestModel);
    }

    @PostMapping("/{inventoryId}/vehicles")
    VehicleResponseModel addVehicleToInventory(@RequestBody VehicleRequestModel vehicleRequestModel, @PathVariable String inventoryId) {

        if (vehicleRequestModel.getVin().length() < 17) {
            throw new InvalidInputException("Invalid vin provided:" + vehicleRequestModel.getVin());
        }

        return vehicleInventoryService.addVehicleToInventory(vehicleRequestModel, inventoryId);
    }

    @PutMapping("/{inventoryId}")
    InventoryResponseModel updateInventory(@RequestBody InventoryRequestModel inventoryRequestModel, @PathVariable String inventoryId) {

        return vehicleInventoryService.updateInventory(inventoryRequestModel, inventoryId);
    }

    @PutMapping("/{inventoryId}/vehicles/{vehicleId}")
    VehicleResponseModel updateVehicleInInventory(@RequestBody VehicleRequestModel vehicleRequestModel, @PathVariable String inventoryId, @PathVariable String vehicleId) {
        return vehicleInventoryService.updateVehicleInInventoryByVehicleId(vehicleRequestModel, inventoryId, vehicleId);
    }

    @DeleteMapping("/{inventoryId}")
    void deleteInventory(@PathVariable String inventoryId) {
        vehicleInventoryService.deleteInventory(inventoryId);
    }

    @DeleteMapping("/{inventoryId}/vehicles/{vehicleId}")
    void removeVehicleFromInventory(@PathVariable String inventoryId, @PathVariable String vehicleId) {
        vehicleInventoryService.removeVehicleFromInventory(inventoryId, vehicleId);
    }

    @GetMapping("/{inventoryId}/vehicles/{vehicleId}")
    VehicleResponseModel getVehicleInInventoryByVehicleId(@PathVariable String inventoryId, @PathVariable String vehicleId) {
        return vehicleInventoryService.getVehicleInInventoryByVehicleId(inventoryId, vehicleId);
    }


}
