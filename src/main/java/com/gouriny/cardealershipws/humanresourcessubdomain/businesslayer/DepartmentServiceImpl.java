package com.gouriny.cardealershipws.humanresourcessubdomain.businesslayer;

import com.gouriny.cardealershipws.humanresourcessubdomain.datalayer.department.Department;
import com.gouriny.cardealershipws.humanresourcessubdomain.datalayer.department.DepartmentIdentifier;
import com.gouriny.cardealershipws.humanresourcessubdomain.datalayer.department.DepartmentRepository;
import com.gouriny.cardealershipws.humanresourcessubdomain.presentationlayer.DepartmentRequestModel;
import com.gouriny.cardealershipws.humanresourcessubdomain.presentationlayer.DepartmentResponseModel;
import com.gouriny.cardealershipws.humanresourcessubdomain.utils.exceptions.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;


    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<DepartmentResponseModel> getAllDepartments() {

        List<Department> departmentList = departmentRepository.findAll();
        List<DepartmentResponseModel> departmentResponseModelList = new ArrayList<>();

        departmentList.forEach(department -> {
            DepartmentResponseModel departmentResponseModel = new DepartmentResponseModel();
            BeanUtils.copyProperties(department, departmentResponseModel);
            departmentResponseModel.setDepartmentId(department.getDepartmentIdentifier().getDepartmentId());
            departmentResponseModelList.add(departmentResponseModel);
        });

        return departmentResponseModelList;
    }

    @Override
    public DepartmentResponseModel getDepartmentById(String departmentId) {

        Department foundDepartment = departmentRepository.findDepartmentByDepartmentIdentifier_DepartmentId(departmentId);
        if (foundDepartment == null) {
            throw new NotFoundException("Unknown department" + departmentId);
        }
        DepartmentResponseModel departmentResponseModel = new DepartmentResponseModel();
        BeanUtils.copyProperties(foundDepartment, departmentResponseModel);
        departmentResponseModel.setDepartmentId(foundDepartment.getDepartmentIdentifier().getDepartmentId());

        return departmentResponseModel;
    }

    @Override
    public DepartmentResponseModel addDepartment(DepartmentRequestModel departmentRequestModel) {
        Department department = new Department();
        BeanUtils.copyProperties(departmentRequestModel, department);
        department.setDepartmentIdentifier(new DepartmentIdentifier());

        Department savedDepartment = departmentRepository.save(department);

        DepartmentResponseModel departmentResponseModel = new DepartmentResponseModel();
        BeanUtils.copyProperties(savedDepartment, departmentResponseModel);
        departmentResponseModel.setDepartmentId(savedDepartment.getDepartmentIdentifier().getDepartmentId());

        return departmentResponseModel;
    }

    @Override
    public DepartmentResponseModel updateDepartment(DepartmentRequestModel departmentRequestModel, UUID departmentId) {

        Department existingDepartment = departmentRepository.findDepartmentByDepartmentIdentifier_DepartmentId(departmentId.toString());
        if (existingDepartment == null) {
            throw new NotFoundException("No department found with ID: " + departmentId);
        }
        BeanUtils.copyProperties(departmentRequestModel, existingDepartment);
        Department updatedDepartment = departmentRepository.save(existingDepartment);
        DepartmentResponseModel departmentResponseModel = new DepartmentResponseModel();
        BeanUtils.copyProperties(updatedDepartment, departmentResponseModel);
        departmentResponseModel.setDepartmentId(updatedDepartment.getDepartmentIdentifier().getDepartmentId());
        return departmentResponseModel;
    }

    @Override
    public void deleteDepartment(UUID departmentId) {
        Department existingDepartment = departmentRepository.findDepartmentByDepartmentIdentifier_DepartmentId(departmentId.toString());
        if (existingDepartment == null) {
            throw new NotFoundException("No department found with ID: " + departmentId);
        }
        departmentRepository.delete(existingDepartment);
    }

}
