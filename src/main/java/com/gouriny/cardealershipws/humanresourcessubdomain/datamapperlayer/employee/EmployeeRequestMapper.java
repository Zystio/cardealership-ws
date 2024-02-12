package com.gouriny.cardealershipws.humanresourcessubdomain.datamapperlayer.employee;

import com.gouriny.cardealershipws.humanresourcessubdomain.datalayer.employee.Address;
import com.gouriny.cardealershipws.humanresourcessubdomain.datalayer.employee.Employee;
import com.gouriny.cardealershipws.humanresourcessubdomain.datalayer.employee.EmployeeIdentifier;
import com.gouriny.cardealershipws.humanresourcessubdomain.presentationlayer.EmployeeRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeRequestMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "employeeIdentifier")
    @Mapping(target = "address")
    Employee requestModelToEntity(EmployeeRequestModel employeeRequestModel, EmployeeIdentifier employeeIdentifier, Address address);
}
