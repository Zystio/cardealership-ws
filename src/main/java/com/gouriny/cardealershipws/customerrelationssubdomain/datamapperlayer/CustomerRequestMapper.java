package com.gouriny.cardealershipws.customerrelationssubdomain.datamapperlayer;


import com.gouriny.cardealershipws.customerrelationssubdomain.datalayer.Address;
import com.gouriny.cardealershipws.customerrelationssubdomain.datalayer.Customer;
import com.gouriny.cardealershipws.common.CustomerIdentifier;
import com.gouriny.cardealershipws.customerrelationssubdomain.presentationlayer.CustomerRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CustomerRequestMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
    })
    Customer requestModelToEntity(CustomerRequestModel customerRequestModel, CustomerIdentifier customerIdentifier,
                                  Address address);
}
