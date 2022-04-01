package com.example.casestudy.service.services.impl;

import com.example.casestudy.model.person.customer.Customer;
import com.example.casestudy.model.service.Service;
import com.example.casestudy.repository.service.IServiceRepository;
import com.example.casestudy.service.services.IServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



import java.util.List;

@org.springframework.stereotype.Service
public class ServicesService implements IServicesService {
    @Autowired
    private IServiceRepository iServiceRepository;
    @Override
    public List<Service> findAll() {
        return iServiceRepository.findAll();
    }

    @Override
    public Page<Service> findAll(Pageable pageable) {
        return iServiceRepository.findAll(pageable);
    }

    @Override
    public Service findById(Long id) {
        return iServiceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Service service) {
        iServiceRepository.save(service);
    }

    @Override
    public void deleteById(Long id) {
        iServiceRepository.deleteById(id);
    }

    @Override
    public void remove(Service service) {
        iServiceRepository.delete(service);
    }

    @Override
    public Page<Service> findByNameContaining(String name, Pageable pageable) {
        return iServiceRepository.findByNameContaining(name,pageable);
    }
}
