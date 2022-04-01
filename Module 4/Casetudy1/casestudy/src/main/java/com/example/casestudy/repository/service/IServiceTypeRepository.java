package com.example.casestudy.repository.service;

import com.example.casestudy.model.service.Service;
import com.example.casestudy.model.service.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceTypeRepository extends JpaRepository<ServiceType,Long> {
}
