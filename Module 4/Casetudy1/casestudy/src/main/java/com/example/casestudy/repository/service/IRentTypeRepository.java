package com.example.casestudy.repository.service;

import com.example.casestudy.model.service.RentType;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentTypeRepository extends JpaRepository<RentType,Long> {
}
