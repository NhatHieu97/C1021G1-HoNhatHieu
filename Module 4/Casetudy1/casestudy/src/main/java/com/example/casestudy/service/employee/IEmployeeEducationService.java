package com.example.casestudy.service.employee;

import com.example.casestudy.model.person.employee.Employee;
import com.example.casestudy.model.person.employee.EmployeeEducationDegree;

import java.util.List;

public interface IEmployeeEducationService {
    List<EmployeeEducationDegree> findAll();
}
