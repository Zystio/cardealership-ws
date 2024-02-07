package com.gouriny.cardealershipws.humanresourcessubdomain.businesslayer;

import com.gouriny.cardealershipws.humanresourcessubdomain.datalayer.department.Department;
import com.gouriny.cardealershipws.humanresourcessubdomain.datalayer.department.DepartmentIdentifier;
import com.gouriny.cardealershipws.humanresourcessubdomain.datalayer.department.DepartmentRepository;
import com.gouriny.cardealershipws.humanresourcessubdomain.datalayer.employee.Address;
import com.gouriny.cardealershipws.humanresourcessubdomain.datalayer.employee.Employee;
import com.gouriny.cardealershipws.humanresourcessubdomain.datalayer.employee.EmployeeIdentifier;
import com.gouriny.cardealershipws.humanresourcessubdomain.datalayer.employee.EmployeeRepository;
import com.gouriny.cardealershipws.humanresourcessubdomain.presentationlayer.EmployeeRequestModel;
import com.gouriny.cardealershipws.humanresourcessubdomain.presentationlayer.EmployeeResponseModel;
import com.gouriny.cardealershipws.humanresourcessubdomain.utils.exceptions.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepository employeeRepository;

    private DepartmentRepository departmentRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }


    @Override
    public List<EmployeeResponseModel> getAllEmployees() {

        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeResponseModel> responseList = new ArrayList<>();

        employeeList.forEach(employee -> {

            EmployeeResponseModel dto = new EmployeeResponseModel();
            Department department = departmentRepository.findDepartmentByDepartmentIdentifier_DepartmentId(employee.getDepartmentIdentifier().getDepartmentId());

            BeanUtils.copyProperties(employee, dto);
            BeanUtils.copyProperties(department, dto);

            dto.setEmployeeId(employee.getEmployeeIdentifier().getEmployeeId());
            dto.setStreetAddress(employee.getAddress().getStreetAddress());
            dto.setCity(employee.getAddress().getCity());
            dto.setProvince(employee.getAddress().getProvince());
            dto.setCountry(employee.getAddress().getCountry());
            dto.setPostalCode(employee.getAddress().getPostalCode());

            dto.setDepartmentId(department.getDepartmentIdentifier().getDepartmentId());
            dto.setDepartmentName(department.getName());
            dto.setHeadCount(department.getHeadCount());

            dto.setTitle(employee.getPositionTitle());


            responseList.add(dto);
        });

        return responseList;
    }

    @Override
    public EmployeeResponseModel getEmployeeById(String employeeId) {
        Employee foundEmployee = employeeRepository.findEmployeeByEmployeeIdentifier_EmployeeId(employeeId);
        if (foundEmployee == null) {
            throw new NotFoundException("Unknown employee" + employeeId);
        }

        EmployeeResponseModel employeeResponseModel = new EmployeeResponseModel();
        BeanUtils.copyProperties(foundEmployee, employeeResponseModel);
        BeanUtils.copyProperties(departmentRepository.findDepartmentByDepartmentIdentifier_DepartmentId(foundEmployee.getDepartmentIdentifier().getDepartmentId()), employeeResponseModel);

        employeeResponseModel.setEmployeeId(foundEmployee.getEmployeeIdentifier().getEmployeeId());
        employeeResponseModel.setDepartmentId(foundEmployee.getDepartmentIdentifier().getDepartmentId());

        employeeResponseModel.setStreetAddress(foundEmployee.getAddress().getStreetAddress());
        employeeResponseModel.setCity(foundEmployee.getAddress().getCity());
        employeeResponseModel.setProvince(foundEmployee.getAddress().getProvince());
        employeeResponseModel.setCountry(foundEmployee.getAddress().getCountry());
        employeeResponseModel.setPostalCode(foundEmployee.getAddress().getPostalCode());

        employeeResponseModel.setTitle(foundEmployee.getPositionTitle());

        employeeResponseModel.setDepartmentName(departmentRepository.findDepartmentByDepartmentIdentifier_DepartmentId(foundEmployee.getDepartmentIdentifier().getDepartmentId()).getName());

        return employeeResponseModel;
    }

    @Override
    public EmployeeResponseModel addEmployee(EmployeeRequestModel employeeRequestModel) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeRequestModel, employee);
        employee.setEmployeeIdentifier(new EmployeeIdentifier());
        employee.setDepartmentIdentifier(new DepartmentIdentifier());

        Address address = new Address(employeeRequestModel.getStreetAddress(), employeeRequestModel.getCity(), employeeRequestModel.getProvince(), employeeRequestModel.getCountry(), employeeRequestModel.getPostalCode());
        employee.setAddress(address);


        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeResponseModel employeeResponseModel = new EmployeeResponseModel();
        BeanUtils.copyProperties(savedEmployee, employeeResponseModel);
        employeeResponseModel.setEmployeeId(savedEmployee.getEmployeeIdentifier().getEmployeeId());

        return employeeResponseModel;
    }


}
