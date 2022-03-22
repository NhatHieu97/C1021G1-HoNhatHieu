package com.example.casestudy.service.employee;

import com.example.casestudy.model.person.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    Page<Employee> findAll(Pageable pageable);

    Employee findById(Long id);

    void save(Employee employee);

    void deleteById(Long id);

    void remove(Employee employee);

    Page<Employee> findByNameContaining(String name, Pageable pageable);
}
