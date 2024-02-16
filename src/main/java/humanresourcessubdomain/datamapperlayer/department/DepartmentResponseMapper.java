package humanresourcessubdomain.datamapperlayer.department;

import humanresourcessubdomain.datalayer.department.Department;
import humanresourcessubdomain.presentationlayer.DepartmentResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentResponseMapper {

    // departmentId is the value inside of departmentResponseModel
    @Mapping(expression = "java(department.getDepartmentIdentifier().getDepartmentId())", target = "departmentId")
    DepartmentResponseModel entityToResponseModel(Department department);

    //for every entity in the list, it's going to run the entityToResponseModel method
    List<DepartmentResponseModel> entityListToResponseModelList(List<Department> departmentList);

}
