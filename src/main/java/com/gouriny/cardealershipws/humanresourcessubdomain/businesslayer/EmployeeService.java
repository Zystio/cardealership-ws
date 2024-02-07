package com.gouriny.cardealershipws.humanresourcessubdomain.businesslayer;

import com.gouriny.cardealershipws.humanresourcessubdomain.presentationlayer.EmployeeRequestModel;
import com.gouriny.cardealershipws.humanresourcessubdomain.presentationlayer.EmployeeResponseModel;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponseModel> getAllEmployees();

    EmployeeResponseModel getEmployeeById(String employeeId);

    EmployeeResponseModel addEmployee(EmployeeRequestModel employeeRequestModel);

}
