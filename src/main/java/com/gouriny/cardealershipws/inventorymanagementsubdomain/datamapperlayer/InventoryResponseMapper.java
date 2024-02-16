package com.gouriny.cardealershipws.inventorymanagementsubdomain.datamapperlayer;

import com.gouriny.cardealershipws.inventorymanagementsubdomain.datalayer.Inventory;
import com.gouriny.cardealershipws.inventorymanagementsubdomain.presentationlayer.InventoryController;
import com.gouriny.cardealershipws.inventorymanagementsubdomain.presentationlayer.InventoryResponseModel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.Link;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Mapper(componentModel = "spring")
public interface InventoryResponseMapper {

    @Mapping(expression = "java(inventory.getInventoryIdentifier().getInventoryId())", target = "inventoryId")
    InventoryResponseModel entityToResponseModel(Inventory inventory);

    List<InventoryResponseModel> entityListToResponseModelList(List<Inventory> inventories);

    @AfterMapping
    default void addLinks(@MappingTarget InventoryResponseModel model, Inventory inventory) {
        //self link
        Link selfLink = linkTo(methodOn(InventoryController.class)
            .getInventoryDetailsById(model.getInventoryId()))
            .withSelfRel();
        model.add(selfLink);

        //all inventories
        Link inventoriesLink =
            linkTo(methodOn(InventoryController.class).getInventories())
                .withRel("inventories");
        model.add(inventoriesLink);
    }


}



