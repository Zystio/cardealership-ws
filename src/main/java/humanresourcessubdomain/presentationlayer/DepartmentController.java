package humanresourcessubdomain.presentationlayer;

import humanresourcessubdomain.businesslayer.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentResponseModel> getDepartmentById(@PathVariable String departmentId) {
        return ResponseEntity.ok().body(departmentService.getDepartmentById(departmentId));
    }

    @PostMapping()
    public ResponseEntity<DepartmentResponseModel> addDepartment(@RequestBody DepartmentRequestModel departmentRequestModel) {
        DepartmentResponseModel departmentResponseModel = departmentService.addDepartment(departmentRequestModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentResponseModel);
    }

    @PutMapping("/{departmentId}")
    public ResponseEntity<DepartmentResponseModel> updateDepartment(@RequestBody DepartmentRequestModel departmentRequestModel, @PathVariable UUID departmentId) {
        DepartmentResponseModel departmentResponseModel = departmentService.updateDepartment(departmentRequestModel, departmentId);
        return ResponseEntity.status(HttpStatus.OK).body(departmentResponseModel);
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable UUID departmentId) {
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.noContent().build();
    }

}
