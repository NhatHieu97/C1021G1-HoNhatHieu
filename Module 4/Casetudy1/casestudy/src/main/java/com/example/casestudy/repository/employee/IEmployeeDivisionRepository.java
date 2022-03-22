package com.example.casestudy.repository.employee;

import com.example.casestudy.model.person.employee.Employee;
import com.example.casestudy.model.person.employee.EmployeeDivision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeDivisionRepository extends JpaRepository<EmployeeDivision,Long> {
}
