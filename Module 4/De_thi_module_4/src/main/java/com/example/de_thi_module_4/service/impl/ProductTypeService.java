package com.example.de_thi_module_4.service.impl;

import com.example.de_thi_module_4.model.ProductType;
import com.example.de_thi_module_4.repository.IProductTypeRepository;
import com.example.de_thi_module_4.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService implements IProductTypeService {
    @Autowired
    private IProductTypeRepository productTypeRepository;
    @Override
    public List<ProductType> findAll() {
        return productTypeRepository.findAll();
    }
}
