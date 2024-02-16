package humanresourcessubdomain.datamapperlayer.department;

import humanresourcessubdomain.datalayer.department.Department;
import humanresourcessubdomain.datalayer.department.DepartmentIdentifier;
import humanresourcessubdomain.presentationlayer.DepartmentRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DepartmentRequestMapper {

    @Mapping(target = "id", ignore = true)
    Department requestModelToEntity(DepartmentRequestModel departmentRequestModel,
                                    DepartmentIdentifier departmentIdentifier);
}
