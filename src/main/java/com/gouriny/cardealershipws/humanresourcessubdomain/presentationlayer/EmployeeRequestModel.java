package com.gouriny.cardealershipws.humanresourcessubdomain.presentationlayer;

import com.gouriny.cardealershipws.humanresourcessubdomain.datalayer.employee.Address;
import com.gouriny.cardealershipws.humanresourcessubdomain.datalayer.employee.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeRequestModel {
    private String firstName;
    private String lastName;
    private String email;
    private Double salary;
    private Double commissionRate;
    private Address address;
    private List<PhoneNumber> phoneNumbers;

}
