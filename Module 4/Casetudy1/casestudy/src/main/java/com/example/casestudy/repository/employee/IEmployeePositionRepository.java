package com.example.casestudy.repository.employee;

import com.example.casestudy.model.person.employee.Employee;
import com.example.casestudy.model.person.employee.EmployeeDivision;
import com.example.casestudy.model.person.employee.EmployeePosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeePositionRepository extends JpaRepository<EmployeePosition,Long> {
}
