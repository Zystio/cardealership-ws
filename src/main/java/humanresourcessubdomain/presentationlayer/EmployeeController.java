package humanresourcessubdomain.presentationlayer;

import humanresourcessubdomain.businesslayer.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

    private EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public ResponseEntity<List<EmployeeResponseModel>> getEmployees() {
        return ResponseEntity.ok().body(employeeService.getEmployees());
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeResponseModel> getEmployeeById(@PathVariable UUID employeeId) {
        return ResponseEntity.ok().body(employeeService.getEmployeeById(employeeId));
    }

    @PostMapping()
    public ResponseEntity<EmployeeResponseModel> addEmployee(@RequestBody EmployeeRequestModel employeeRequestModel) {
        EmployeeResponseModel employeeResponseModel = employeeService.addEmployee(employeeRequestModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeResponseModel);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeResponseModel> updateEmployee(@RequestBody EmployeeRequestModel employeeRequestModel, @PathVariable UUID employeeId) {
        EmployeeResponseModel employeeResponseModel = employeeService.updateEmployee(employeeRequestModel, employeeId);
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponseModel);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable UUID employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.noContent().build();
    }
}
