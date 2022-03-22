package com.example.casestudy.service.employee.impl;

import com.example.casestudy.model.person.employee.EmployeeDivision;
import com.example.casestudy.repository.employee.IEmployeeDivisionRepository;
import com.example.casestudy.service.employee.IEmployeeDividionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeDivisionService implements IEmployeeDividionService {
    @Autowired
    private IEmployeeDivisionRepository iEmployeeDivisionRepository;
    @Override
    public List<EmployeeDivision> findAll() {
        return iEmployeeDivisionRepository.findAll();
    }
}
