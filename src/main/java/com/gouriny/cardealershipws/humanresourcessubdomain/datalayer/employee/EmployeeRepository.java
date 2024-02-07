package com.gouriny.cardealershipws.humanresourcessubdomain.datalayer.employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findEmployeeByEmployeeIdentifier_EmployeeId(String employeeId);
}
