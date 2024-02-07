package com.gouriny.cardealershipws.humanresourcessubdomain.datalayer.employee;

import com.gouriny.cardealershipws.humanresourcessubdomain.presentationlayer.EmployeeResponseModel;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface EmployeeResponseMapper {

    EmployeeResponseModel entityToResponseDTO(Employee employee);

    List<EmployeeResponseModel> listEntityToResponseDTO(List<Employee> employees);
}
