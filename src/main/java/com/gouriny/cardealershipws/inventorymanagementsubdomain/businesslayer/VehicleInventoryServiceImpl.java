package com.gouriny.cardealershipws.inventorymanagementsubdomain.businesslayer;

import com.gouriny.cardealershipws.common.VehicleIdentifier;
import com.gouriny.cardealershipws.inventorymanagementsubdomain.datalayer.*;
import com.gouriny.cardealershipws.inventorymanagementsubdomain.datamapperlayer.*;
import com.gouriny.cardealershipws.inventorymanagementsubdomain.presentationlayer.*;
import com.gouriny.cardealershipws.inventorymanagementsubdomain.utils.exceptions.DuplicateVinException;
import com.gouriny.cardealershipws.inventorymanagementsubdomain.utils.exceptions.InvalidInputException;
import com.gouriny.cardealershipws.inventorymanagementsubdomain.utils.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class VehicleInventoryServiceImpl implements VehicleInventoryService {

    private InventoryRepository inventoryRepository;
    private InventoryResponseMapper inventoryResponseMapper;

    private VehicleRepository vehicleRepository;

    private VehicleResponseMapper vehicleResponseMapper;


    private VehicleInventoryResponseMapper vehicleInventoryResponseMapper;

    private InventoryRequestMapper inventoryRequestMapper;

    private VehicleRequestMapper vehicleRequestMapper;


    public VehicleInventoryServiceImpl(InventoryRepository inventoryRepository, InventoryResponseMapper inventoryResponseMapper, VehicleRepository vehicleRepository, VehicleResponseMapper vehicleResponseMapper, VehicleInventoryResponseMapper vehicleInventoryResponseMapper, InventoryRequestMapper inventoryRequestMapper, VehicleRequestMapper vehicleRequestMapper) {
        this.inventoryRepository = inventoryRepository;
        this.inventoryResponseMapper = inventoryResponseMapper;
        this.vehicleRepository = vehicleRepository;
        this.vehicleResponseMapper = vehicleResponseMapper;
        this.vehicleInventoryResponseMapper = vehicleInventoryResponseMapper;
        this.inventoryRequestMapper = inventoryRequestMapper;
        this.vehicleRequestMapper = vehicleRequestMapper;
    }

    @Override
    public List<InventoryResponseModel> getInventories() {
        log.debug("Getting all inventories from the database.");
        return inventoryResponseMapper.entityListToResponseModelList(inventoryRepository.findAll());
    }

    @Override
    public VehicleInventoryResponseModel getInventoryById(String inventoryId) {

        Inventory inventory = inventoryRepository.findByInventoryIdentifier_InventoryId(inventoryId);

        if (inventory == null) {
            return null;
        }

        List<Vehicle> vehicles = vehicleRepository.findAllByInventoryIdentifier_InventoryIdAndStatusEquals(inventoryId, Status.AVAILABLE);


        List<VehicleResponseModel> vehicleResponseModels = vehicleResponseMapper.entityListToResponseModelList(vehicles);
        log.debug("First Link is: " + vehicleResponseModels.get(0).getLinks());

        return vehicleInventoryResponseMapper.entitiesToResponseModel(inventory, vehicleResponseModels);


    }

//    public VehicleResponseModel getVehicleInInventoryByVin(String inventoryId, String vin) {
//
//        if (!inventoryRepository.existsByInventoryIdentifier_InventoryId(inventoryId)) {
//            return null; // throw an exception
//        }
//
//        Vehicle foundVehicle = vehicleRepository.findByInventoryIdentifier_InventoryIdAndVehicleIdentifier_Vin(inventoryId, vin);
//        return vehicleResponseMapper.entityToResponseModel(foundVehicle);
//
//    }

    @Override
    public List<VehicleResponseModel> getVehiclesInInventoryByField(String inventoryId, Map<String, String> queryParams) {

        if (!inventoryRepository.existsByInventoryIdentifier_InventoryId(inventoryId)) {
            throw new InvalidInputException("Invalid inventoryId provided: " + inventoryId);
        }

        //extract the query params
        String status = queryParams.get("status");
        String usageType = queryParams.get("usage");

        Map<String, Status> statusMap = new HashMap<String, Status>();
        statusMap.put("available", Status.AVAILABLE);
        statusMap.put("sale_pending", Status.SALE_PENDING);
        statusMap.put("sold", Status.SOLD);

        //convert to enums
        Map<String, UsageType> usageTypeMap = new HashMap<String, UsageType>();
        usageTypeMap.put("new", UsageType.NEW);
        usageTypeMap.put("used", UsageType.USED);


        if (status != null && usageType != null) {
            return vehicleResponseMapper.entityListToResponseModelList(vehicleRepository.findAllByInventoryIdentifier_InventoryIdAndStatusEqualsAndUsageTypeEquals(inventoryId,
                    statusMap.get(status.toLowerCase()), usageTypeMap.get(usageType.toLowerCase())));


        }

        if (status != null) {
            return vehicleResponseMapper.entityListToResponseModelList(vehicleRepository.findAllByInventoryIdentifier_InventoryIdAndStatusEquals(inventoryId,
                    statusMap.get(status.toLowerCase())));
        }

        if (usageType != null) {
            return vehicleResponseMapper.entityListToResponseModelList(vehicleRepository.findAllByInventoryIdentifier_InventoryIdAndUsageTypeEquals(inventoryId, usageTypeMap.get(usageType.toLowerCase())));
        }

        return null;


    }

    @Override
    public VehicleResponseModel addVehicleToInventory(VehicleRequestModel vehicleRequestModel, String inventoryId) {

        Inventory inventory = inventoryRepository.findByInventoryIdentifier_InventoryId(inventoryId);

        if (inventory == null) {
            throw new NotFoundException("Unknown inventoryId provided: " + inventoryId);
        }


        VehicleIdentifier vehicleIdentifier = new VehicleIdentifier(vehicleRequestModel.getVin());

        //calculate options cost
        double totalOptionsCost = vehicleRequestModel.getOptions().stream().mapToDouble(Option::getCost).sum();

        Price price = new Price(vehicleRequestModel.getMsrp(), vehicleRequestModel.getCost(), totalOptionsCost);


        try {
            return vehicleResponseMapper.entityToResponseModel(vehicleRepository.save(vehicleRequestMapper.requestModelToEntity(vehicleRequestModel, vehicleIdentifier, inventory.getInventoryIdentifier(), price)));
        } catch (DataAccessException ex) {

            if (ex.getMessage().contains("constraint[vin]")) {
                throw new DuplicateVinException("The inventory already contains a vehicle with vin:" + vehicleRequestModel.getVin());
            } else throw new InvalidInputException("Could not save the vehicle");
        }


    }

    @Override
    public InventoryResponseModel addInventory(InventoryRequestModel inventoryRequestModel) {

        return inventoryResponseMapper.entityToResponseModel(inventoryRepository.save(inventoryRequestMapper.requestModelToEntity(inventoryRequestModel)));
    }

    @Override
    public InventoryResponseModel updateInventory(InventoryRequestModel inventoryRequestModel, String inventoryId) {
        Inventory inventory = inventoryRepository.findByInventoryIdentifier_InventoryId(inventoryId);

        if (inventory == null) {
            return null;
        }

        Inventory newInventory = inventoryRequestMapper.requestModelToEntity(inventoryRequestModel);
        newInventory.setId(inventory.getId());
        newInventory.setInventoryIdentifier(inventory.getInventoryIdentifier());

        return inventoryResponseMapper.entityToResponseModel(inventoryRepository.save(newInventory));
    }

    @Override
    public VehicleResponseModel updateVehicleInInventoryByVehicleId(VehicleRequestModel vehicleRequestModel, String inventoryId, String vehicleId) {

        if (!inventoryRepository.existsByInventoryIdentifier_InventoryId(inventoryId)) {
            return null; // throw an excepiton
        }

        Inventory inventory = inventoryRepository.findByInventoryIdentifier_InventoryId(inventoryId);

        if (inventory == null) {
            return null;
        }
        double totalOptionsCost = vehicleRequestModel.getOptions().stream().mapToDouble(Option::getCost).sum();

        Price price = new Price(vehicleRequestModel.getMsrp(), vehicleRequestModel.getCost(), totalOptionsCost);

        VehicleIdentifier vehicleIdentifier = new VehicleIdentifier(vehicleRequestModel.getVin());

        Vehicle oldVehicle = vehicleRepository.findByVehicleIdentifier_Vin(vehicleId);
        if (oldVehicle == null) {
            return null;
        }

        Vehicle toBeUpdated = vehicleRequestMapper.requestModelToEntity(vehicleRequestModel, oldVehicle.getVehicleIdentifier(), oldVehicle.getInventoryIdentifier(), price);

        return vehicleResponseMapper.entityToResponseModel(vehicleRepository.save(toBeUpdated));

    }

    @Override
    public void deleteInventory(String inventoryId) {
        Inventory inventory = inventoryRepository.findByInventoryIdentifier_InventoryId(inventoryId);

        if (inventory == null) {
            return;
        }

        List<Vehicle> vehicles = vehicleRepository.findAllByInventoryIdentifier_InventoryId(inventoryId);

        //vehicles.forEach(vehicle -> vehicleRepository.delete(vehicle));
        vehicleRepository.deleteAll(vehicles);

//        if(!vehicles.isEmpty()){
//            return;
//        }

        inventoryRepository.delete(inventory);
    }

    @Override
    public void removeVehicleFromInventory(String inventoryId, String vehicleId) {

        Inventory inventory = inventoryRepository.findByInventoryIdentifier_InventoryId(inventoryId);

        if (inventory == null) {
            return;
        }

        Vehicle vehicle = vehicleRepository.findByVehicleIdentifier_Vin(vehicleId);
        vehicleRepository.delete(vehicle);


    }

    @Override
    public VehicleResponseModel getVehicleInInventoryByVehicleId(String inventoryId, String vehicleId) {

        if (!inventoryRepository.existsByInventoryIdentifier_InventoryId(inventoryId)) {
            return null; // throw an excepiton
        }

        Vehicle foundVehicle = vehicleRepository.findByInventoryIdentifier_InventoryIdAndVehicleIdentifier_Vin(inventoryId, vehicleId);
        return vehicleResponseMapper.entityToResponseModel(foundVehicle);

    }


}
