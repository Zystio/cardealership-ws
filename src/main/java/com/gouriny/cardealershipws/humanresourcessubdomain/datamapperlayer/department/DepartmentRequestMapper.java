package com.gouriny.cardealershipws.humanresourcessubdomain.datamapperlayer.department;

import com.gouriny.cardealershipws.humanresourcessubdomain.datalayer.department.Department;
import com.gouriny.cardealershipws.humanresourcessubdomain.datalayer.department.DepartmentIdentifier;
import com.gouriny.cardealershipws.humanresourcessubdomain.presentationlayer.DepartmentRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DepartmentRequestMapper {

    @Mapping(target = "id", ignore = true)
    Department requestModelToEntity(DepartmentRequestModel departmentRequestModel,
                                    DepartmentIdentifier departmentIdentifier);
}
