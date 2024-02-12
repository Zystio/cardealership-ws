package com.gouriny.cardealershipws.inventorymanagementsubdomain.presentationlayer;

import com.gouriny.cardealershipws.inventorymanagementsubdomain.businesslayer.VehicleInventoryService;
import com.gouriny.cardealershipws.inventorymanagementsubdomain.utils.exceptions.InvalidInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/inventories")
public class InventoryController {

    @Autowired
    private VehicleInventoryService vehicleInventoryService;

    @GetMapping()
    public ResponseEntity<List<InventoryResponseModel>> getInventories() {
        return ResponseEntity.ok().body(vehicleInventoryService.getInventories());
    }

    @GetMapping("/{inventoryId}")
    public ResponseEntity<VehicleInventoryResponseModel> getInventoryDetailsById(@PathVariable String inventoryId) {
        return ResponseEntity.ok().body(vehicleInventoryService.getInventoryById(inventoryId));
    }

    @GetMapping("/{inventoryId}/vehicles")
    public ResponseEntity<List<VehicleResponseModel>> getVehiclesInInventory(@PathVariable String inventoryId,
                                                                             @RequestParam(required = false) Map<String, String> queryParams) {
        return ResponseEntity.ok().body(vehicleInventoryService.getVehiclesInInventoryByField(inventoryId, queryParams));
    }

//    @GetMapping("/{vin}")
//    public ResponseEntity<VehicleResponseModel> getVehicleInInventoryByVin(@PathVariable String inventoryId, @PathVariable String vin) {
//        return ResponseEntity.ok().body(vehicleInventoryService.getVehicleInInventoryByVin(inventoryId, vin));
//    }
    @PostMapping()
    public ResponseEntity<InventoryResponseModel> addInventory(@RequestBody InventoryRequestModel inventoryRequestModel) {
        return ResponseEntity.ok().body(vehicleInventoryService.addInventory(inventoryRequestModel));
    }

    @PostMapping("/{inventoryId}/vehicles")
    public ResponseEntity<VehicleResponseModel> addVehicleToInventory(@RequestBody VehicleRequestModel vehicleRequestModel, @PathVariable String inventoryId) {

        if (vehicleRequestModel.getVin().length() < 17) {
            throw new InvalidInputException("Invalid vin provided:" + vehicleRequestModel.getVin());
        }

        return ResponseEntity.ok().body(vehicleInventoryService.addVehicleToInventory(vehicleRequestModel, inventoryId));
    }

    @PutMapping("/{inventoryId}")
    public ResponseEntity<InventoryResponseModel> updateInventory(@RequestBody InventoryRequestModel inventoryRequestModel, @PathVariable String inventoryId) {

        return ResponseEntity.ok().body(vehicleInventoryService.updateInventory(inventoryRequestModel, inventoryId));
    }

    @PutMapping("/{inventoryId}/vehicles/{vehicleId}")
    public ResponseEntity<VehicleResponseModel> updateVehicleInInventory(@RequestBody VehicleRequestModel vehicleRequestModel, @PathVariable String inventoryId, @PathVariable String vehicleId) {
        return ResponseEntity.ok().body(vehicleInventoryService.updateVehicleInInventoryByVehicleId(vehicleRequestModel, inventoryId, vehicleId));
    }

    @DeleteMapping("/{inventoryId}")
    ResponseEntity<Void> deleteInventory(@PathVariable String inventoryId) {
        vehicleInventoryService.deleteInventory(inventoryId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{inventoryId}/vehicles/{vehicleId}")
    public ResponseEntity<Void> removeVehicleFromInventory(@PathVariable String inventoryId, @PathVariable String vehicleId) {
        vehicleInventoryService.removeVehicleFromInventory(inventoryId, vehicleId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{inventoryId}/vehicles/{vehicleId}")
    public ResponseEntity<VehicleResponseModel> getVehicleInInventoryByVehicleId(@PathVariable String inventoryId, @PathVariable String vehicleId) {
        return ResponseEntity.ok().body(vehicleInventoryService.getVehicleInInventoryByVehicleId(inventoryId, vehicleId));
    }


}
