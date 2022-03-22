package com.example.casestudy.service.employee.impl;

import com.example.casestudy.model.person.employee.EmployeeEducationDegree;
import com.example.casestudy.repository.employee.IEmployeeEducationRepository;
import com.example.casestudy.service.employee.IEmployeeEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeEducationService implements IEmployeeEducationService {
    @Autowired
    private IEmployeeEducationRepository iEmployeeEducationRepository;
    @Override
    public List<EmployeeEducationDegree> findAll() {
        return iEmployeeEducationRepository.findAll();
    }
}
