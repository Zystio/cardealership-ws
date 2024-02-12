package com.gouriny.cardealershipws.humanresourcessubdomain.businesslayer;

import com.gouriny.cardealershipws.humanresourcessubdomain.datalayer.employee.Address;
import com.gouriny.cardealershipws.humanresourcessubdomain.datalayer.employee.Employee;
import com.gouriny.cardealershipws.humanresourcessubdomain.datalayer.employee.EmployeeIdentifier;
import com.gouriny.cardealershipws.humanresourcessubdomain.datalayer.employee.EmployeeRepository;
import com.gouriny.cardealershipws.humanresourcessubdomain.datamapperlayer.employee.EmployeeRequestMapper;
import com.gouriny.cardealershipws.humanresourcessubdomain.datamapperlayer.employee.EmployeeResponseMapper;
import com.gouriny.cardealershipws.humanresourcessubdomain.presentationlayer.EmployeeRequestModel;
import com.gouriny.cardealershipws.humanresourcessubdomain.presentationlayer.EmployeeResponseModel;
import com.gouriny.cardealershipws.humanresourcessubdomain.utils.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeResponseMapper employeeResponseMapper;
    private final EmployeeRequestMapper employeeRequestMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeResponseMapper employeeResponseMapper, EmployeeRequestMapper employeeRequestMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeResponseMapper = employeeResponseMapper;
        this.employeeRequestMapper = employeeRequestMapper;
    }

    @Override
    public List<EmployeeResponseModel> getEmployees() {
        return employeeResponseMapper.entityListToResponseModelList(employeeRepository.findAll());
    }

    @Override
    public EmployeeResponseModel getEmployeeById(UUID employeeId) {
        Employee employee = employeeRepository.findEmployeeByEmployeeIdentifier_EmployeeId(employeeId.toString());
        return employeeResponseMapper.entityToResponseModel(employee);
    }

    @Override
    public EmployeeResponseModel addEmployee(EmployeeRequestModel employeeRequestModel) {
        Address address = new Address(employeeRequestModel.getStreetAddress(), employeeRequestModel.getCity(), employeeRequestModel.getProvince(), employeeRequestModel.getCountry(), employeeRequestModel.getPostalCode());


        Employee employee = employeeRequestMapper.requestModelToEntity(employeeRequestModel, new EmployeeIdentifier(), address);
        return employeeResponseMapper.entityToResponseModel(employeeRepository.save(employee));


    }

    @Override
    public EmployeeResponseModel updateEmployee(EmployeeRequestModel employeeRequestModel, UUID employeeId) {
        Employee existingEmployee = employeeRepository.findEmployeeByEmployeeIdentifier_EmployeeId(employeeId.toString());
        if (existingEmployee == null) {
            throw new NotFoundException("No employee found with ID: " + employeeId);
        }

        Employee employee = employeeRequestMapper.requestModelToEntity(employeeRequestModel, existingEmployee.getEmployeeIdentifier(), existingEmployee.getAddress());
        employee.setId(existingEmployee.getId());
        return employeeResponseMapper.entityToResponseModel(employeeRepository.save(employee));
    }

    @Override
    public void deleteEmployee(UUID employeeId) {

        Employee existingEmployee = employeeRepository.findEmployeeByEmployeeIdentifier_EmployeeId(employeeId.toString());
        if (existingEmployee == null) {
            throw new NotFoundException("No employee found with: " + employeeId);
        }
        employeeRepository.delete(existingEmployee);
    }

}
