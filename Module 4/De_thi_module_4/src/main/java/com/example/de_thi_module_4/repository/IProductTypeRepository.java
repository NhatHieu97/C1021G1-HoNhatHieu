package com.example.de_thi_module_4.repository;

import com.example.de_thi_module_4.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductTypeRepository extends JpaRepository<ProductType, Long> {
}
