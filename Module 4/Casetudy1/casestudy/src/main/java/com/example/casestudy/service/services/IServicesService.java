package com.example.casestudy.service.services;

import com.example.casestudy.model.person.customer.Customer;
import com.example.casestudy.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServicesService {
    List<Service> findAll();

    Page<Service> findAll(Pageable pageable);

    Service findById(Long id);

    void save(Service service);

    void deleteById(Long id);

    void remove(Service service);

    Page<Service> findByNameContaining(String name, Pageable pageable);
}
