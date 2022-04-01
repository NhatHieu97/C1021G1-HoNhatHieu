package com.example.casestudy.service.services.impl;

import com.example.casestudy.model.service.ServiceType;
import com.example.casestudy.repository.service.IServiceTypeRepository;
import com.example.casestudy.service.services.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceTypeService implements IServiceTypeService {
    @Autowired
    private IServiceTypeRepository iServiceTypeRepository;
    @Override
    public List<ServiceType> findAll() {
        return iServiceTypeRepository.findAll();
    }
}
