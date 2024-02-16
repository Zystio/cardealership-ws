package humanresourcessubdomain.datamapperlayer.employee;

import humanresourcessubdomain.datalayer.employee.Address;
import humanresourcessubdomain.datalayer.employee.Employee;
import com.gouriny.cardealershipws.common.EmployeeIdentifier;
import humanresourcessubdomain.presentationlayer.EmployeeRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeRequestMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "employeeIdentifier")
    @Mapping(target = "address")
    Employee requestModelToEntity(EmployeeRequestModel employeeRequestModel, EmployeeIdentifier employeeIdentifier, Address address);
}
