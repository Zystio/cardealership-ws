package com.gouriny.cardealershipws.humanresourcessubdomain.datalayer.department;

import com.gouriny.cardealershipws.humanresourcessubdomain.presentationlayer.DepartmentResponseModel;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface DepartmentResponseMapper {

    DepartmentResponseModel entityToResponseDTO(Department department);

    List<DepartmentResponseModel> listEntityToResponseDTO(List<Department> departments);
}
