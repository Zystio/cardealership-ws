package com.gouriny.cardealershipws.humanresourcessubdomain.businesslayer;

import com.gouriny.cardealershipws.humanresourcessubdomain.presentationlayer.DepartmentRequestModel;
import com.gouriny.cardealershipws.humanresourcessubdomain.presentationlayer.DepartmentResponseModel;

import java.util.List;

public interface DepartmentService {

    List<DepartmentResponseModel> getAllDepartments();

    DepartmentResponseModel getDepartmentById(String departmentId);

    DepartmentResponseModel addDepartment(DepartmentRequestModel departmentRequestModel);

    DepartmentResponseModel updateDepartment(String departmentId, DepartmentRequestModel departmentRequestModel);
}
