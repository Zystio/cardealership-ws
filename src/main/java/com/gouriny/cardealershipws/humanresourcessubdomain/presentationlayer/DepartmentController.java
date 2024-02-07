package com.gouriny.cardealershipws.humanresourcessubdomain.presentationlayer;

import com.gouriny.cardealershipws.humanresourcessubdomain.businesslayer.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping()
    public ResponseEntity<List<DepartmentResponseModel>> getAllDepartments() {
        return ResponseEntity.ok().body(departmentService.getAllDepartments());
    }

    @GetMapping("{departmentId}")
    public ResponseEntity<DepartmentResponseModel> getDepartmentById(@PathVariable String departmentId) {
        return ResponseEntity.ok().body(departmentService.getDepartmentById(departmentId));
    }

    @PostMapping()
    public ResponseEntity<DepartmentResponseModel> addDepartment(@RequestBody DepartmentRequestModel departmentRequestModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.addDepartment(departmentRequestModel));
    }
}
