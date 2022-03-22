package com.example.casestudy.service.employee;

import com.example.casestudy.model.person.employee.Employee;
import com.example.casestudy.model.person.employee.EmployeePosition;

import java.util.List;

public interface IEmployeePositionService {
    List<EmployeePosition> findAll();
}
