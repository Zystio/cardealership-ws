package humanresourcessubdomain.businesslayer;

import humanresourcessubdomain.presentationlayer.DepartmentRequestModel;
import humanresourcessubdomain.presentationlayer.DepartmentResponseModel;

import java.util.List;
import java.util.UUID;

public interface DepartmentService {

    List<DepartmentResponseModel> getAllDepartments();

    DepartmentResponseModel getDepartmentById(String departmentId);

    DepartmentResponseModel addDepartment(DepartmentRequestModel departmentRequestModel);

    DepartmentResponseModel updateDepartment(DepartmentRequestModel departmentRequestModel, UUID departmentId);

    void deleteDepartment(UUID departmentId);
}
