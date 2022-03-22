package com.example.casestudy.repository.employee;

import com.example.casestudy.model.person.customer.Customer;
import com.example.casestudy.model.person.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
    Page<Employee> findByNameContaining(String name, Pageable pageable);
}
