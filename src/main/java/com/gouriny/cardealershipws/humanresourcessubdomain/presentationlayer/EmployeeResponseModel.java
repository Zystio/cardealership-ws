package com.gouriny.cardealershipws.humanresourcessubdomain.presentationlayer;

import com.gouriny.cardealershipws.humanresourcessubdomain.datalayer.employee.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseModel {

    String employeeId;
    String departmentId;
    String firstName;
    String lastName;
    String email;
    List<PhoneNumber> phoneNumbers;

    String streetAddress;
    String city;
    String province;
    String country;
    String postalCode;

    String departmentName;
    String title;
    Integer headCount;

    Double salary;
    Double commissionRate;


}
