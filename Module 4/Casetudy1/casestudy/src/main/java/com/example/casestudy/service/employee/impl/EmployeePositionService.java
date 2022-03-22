package com.example.casestudy.service.employee.impl;

import com.example.casestudy.model.person.employee.EmployeePosition;
import com.example.casestudy.repository.employee.IEmployeePositionRepository;
import com.example.casestudy.service.employee.IEmployeePositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeePositionService implements IEmployeePositionService {
    @Autowired
    private IEmployeePositionRepository employeePositionRepository;
    @Override
    public List<EmployeePosition> findAll() {
        return employeePositionRepository.findAll();
    }
}
