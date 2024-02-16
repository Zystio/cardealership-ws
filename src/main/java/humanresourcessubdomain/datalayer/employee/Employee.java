package humanresourcessubdomain.datalayer.employee;

import com.gouriny.cardealershipws.common.EmployeeIdentifier;
import humanresourcessubdomain.datalayer.department.DepartmentIdentifier;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
@Table(name = "employees")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private EmployeeIdentifier employeeIdentifier;

    @Embedded
    private DepartmentIdentifier departmentIdentifier;

    @Embedded
    private Address address;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "employee_phonenumbers", joinColumns = @JoinColumn(name = "employee_id"))
    private List<PhoneNumber> phoneNumbers;

    private String firstName;
    private String lastName;
    private String email;
    private Double salary;
    private Double commissionRate;

    private String positionTitle;


    public Employee() {

    }

    public Employee(@NotNull Address address, @NotNull List<PhoneNumber> phoneNumbers, @NotNull String firstName, @NotNull String lastName, @NotNull String email, @NotNull Double salary, @NotNull Double commissionRate, @NotNull String positionTitle) {
        this.employeeIdentifier = new EmployeeIdentifier();
        this.departmentIdentifier = new DepartmentIdentifier();
        this.address = address;
        this.phoneNumbers = phoneNumbers;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.salary = salary;
        this.commissionRate = commissionRate;
        this.positionTitle = positionTitle;
    }


}
