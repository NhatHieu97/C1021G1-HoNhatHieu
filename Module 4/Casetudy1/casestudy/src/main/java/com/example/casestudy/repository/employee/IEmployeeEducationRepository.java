package com.example.casestudy.repository.employee;

import com.example.casestudy.model.person.employee.EmployeeDivision;
import com.example.casestudy.model.person.employee.EmployeeEducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeEducationRepository extends JpaRepository<EmployeeEducationDegree,Long> {
}
