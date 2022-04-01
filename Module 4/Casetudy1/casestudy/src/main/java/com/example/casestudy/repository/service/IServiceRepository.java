package com.example.casestudy.repository.service;

import com.example.casestudy.model.person.customer.Customer;
import com.example.casestudy.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceRepository extends JpaRepository<Service,Long> {
    Page<Service> findByNameContaining(String name, Pageable pageable);
}
