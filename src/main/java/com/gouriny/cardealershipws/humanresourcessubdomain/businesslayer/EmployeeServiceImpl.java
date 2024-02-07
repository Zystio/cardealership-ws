package com.gouriny.cardealershipws.humanresourcessubdomain.businesslayer;

import com.gouriny.cardealershipws.humanresourcessubdomain.datalayer.department.DepartmentRepository;
import com.gouriny.cardealershipws.humanresourcessubdomain.datalayer.employee.Employee;
import com.gouriny.cardealershipws.humanresourcessubdomain.datalayer.employee.EmployeeIdentifier;
import com.gouriny.cardealershipws.humanresourcessubdomain.datalayer.employee.EmployeeRepository;
import com.gouriny.cardealershipws.humanresourcessubdomain.presentationlayer.EmployeeRequestModel;
import com.gouriny.cardealershipws.humanresourcessubdomain.presentationlayer.EmployeeResponseModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepository employeeRepository;

    private DepartmentRepository departmentRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }


    @Override
    public List<EmployeeResponseModel> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeResponseModel> employeeResponseModels = new ArrayList<>();
        for (Employee employee : employees) {
            EmployeeResponseModel EmployeeResponseModel = new EmployeeResponseModel();
            BeanUtils.copyProperties(employee, EmployeeResponseModel);
            EmployeeResponseModel.setEmployeeId(employee.getEmployeeIdentifier().getEmployeeId());
            employeeResponseModels.add(EmployeeResponseModel);
        }
        return employeeResponseModels;

    }

    @Override
    public EmployeeResponseModel getEmployeeById(UUID employeeId) {
        Employee employee = employeeRepository.findEmployeeByEmployeeIdentifier_EmployeeId(employeeId.toString());
        if (employee == null) {
            throw new EntityNotFoundException("No employee found with ID: " + employeeId);
        }
        EmployeeResponseModel employeeResponseModel = new EmployeeResponseModel();
        BeanUtils.copyProperties(employee, employeeResponseModel);
        employeeResponseModel.setEmployeeId(employee.getEmployeeIdentifier().getEmployeeId());
        return employeeResponseModel;
    }

    @Override
    public EmployeeResponseModel addEmployee(EmployeeRequestModel employeeRequestModel) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeRequestModel, employee);
        employee.setEmployeeIdentifier(new EmployeeIdentifier());
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeResponseModel employeeResponseModel = new EmployeeResponseModel();
        BeanUtils.copyProperties(savedEmployee, employeeResponseModel);
        employeeResponseModel.setEmployeeId(savedEmployee.getEmployeeIdentifier().getEmployeeId());
        return employeeResponseModel;
    }

    @Override
    public EmployeeResponseModel updateEmployee(EmployeeRequestModel employeeRequestModel, UUID employeeId) {
        Employee existingEmployee = employeeRepository.findEmployeeByEmployeeIdentifier_EmployeeId(employeeId.toString());
        if (existingEmployee == null) {
            throw new EntityNotFoundException("No employee found with ID: " + employeeId);
        }
        BeanUtils.copyProperties(employeeRequestModel, existingEmployee);
        Employee updatedEmployee = employeeRepository.save(existingEmployee);
        EmployeeResponseModel employeeResponseModel = new EmployeeResponseModel();
        BeanUtils.copyProperties(updatedEmployee, employeeResponseModel);
        employeeResponseModel.setEmployeeId(updatedEmployee.getEmployeeIdentifier().getEmployeeId());
        return employeeResponseModel;
    }


    @Override
    public void deleteEmployee(UUID employeeId) {
        Employee existingEmployee = employeeRepository.findEmployeeByEmployeeIdentifier_EmployeeId(employeeId.toString());
        if (existingEmployee == null)
            throw new EntityNotFoundException("No employee found with ID: " + employeeId);
        employeeRepository.delete(existingEmployee);
    }
//    @Override
//    public void deleteClient(String clientId) {
//        Client existingClient = clientRepository.findClientByClientIdentifier_ClientId(clientId);
//        if(existingClient == null)
//            return ; //later on throw exception
//        clientRepository.delete(existingClient);
//    }


}
