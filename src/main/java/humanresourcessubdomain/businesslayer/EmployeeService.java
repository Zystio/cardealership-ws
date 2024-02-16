package humanresourcessubdomain.businesslayer;

import humanresourcessubdomain.presentationlayer.EmployeeRequestModel;
import humanresourcessubdomain.presentationlayer.EmployeeResponseModel;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    List<EmployeeResponseModel> getEmployees();

    EmployeeResponseModel getEmployeeById(UUID employeeId);

    EmployeeResponseModel addEmployee(EmployeeRequestModel employeeRequestModel);

    EmployeeResponseModel updateEmployee(EmployeeRequestModel employeeRequestModel, UUID employeeId);

    void deleteEmployee(UUID employeeId);

}
