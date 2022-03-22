package com.example.casestudy.service.employee.impl;

import com.example.casestudy.model.person.employee.Employee;
import com.example.casestudy.repository.employee.IEmployeeRepository;
import com.example.casestudy.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;
    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return iEmployeeRepository.findAll(pageable);
    }

    @Override
    public Employee findById(Long id) {
        return iEmployeeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        iEmployeeRepository.deleteById(id);
    }

    @Override
    public void remove(Employee employee) {
        iEmployeeRepository.delete(employee);
    }

    @Override
    public Page<Employee> findByNameContaining(String name, Pageable pageable) {
        return iEmployeeRepository.findByNameContaining(name,pageable);
    }
}
