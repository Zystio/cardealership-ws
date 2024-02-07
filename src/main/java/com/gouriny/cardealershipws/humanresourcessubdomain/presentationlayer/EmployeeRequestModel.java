package com.gouriny.cardealershipws.humanresourcessubdomain.presentationlayer;

import com.gouriny.cardealershipws.humanresourcessubdomain.datalayer.department.DepartmentIdentifier;
import com.gouriny.cardealershipws.humanresourcessubdomain.datalayer.employee.EmployeeIdentifier;
import com.gouriny.cardealershipws.humanresourcessubdomain.datalayer.employee.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeRequestModel {

    private EmployeeIdentifier employeeIdentifier;

    private DepartmentIdentifier departmentIdentifier;

    private String streetAddress;
    private String city;
    private String province;
    private String country;
    private String postalCode;

    private List<PhoneNumber> phoneNumbers;

    private String firstName;
    private String lastName;
    private String email;
    private Double salary;
    private Double commissionRate;

    private String positionTitle;
}
