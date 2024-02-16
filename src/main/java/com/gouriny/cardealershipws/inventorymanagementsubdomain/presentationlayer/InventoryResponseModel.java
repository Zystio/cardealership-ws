package com.gouriny.cardealershipws.inventorymanagementsubdomain.presentationlayer;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;


@Data
//@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class InventoryResponseModel extends RepresentationModel<InventoryResponseModel> {

    String inventoryId; //public id
    String type;
}
