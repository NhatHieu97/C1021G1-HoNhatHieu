package com.example.de_thi_module_4.service;

import com.example.de_thi_module_4.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Page<Product> findAll(Pageable pageable);

    Product findById(Long id);


    void save(Product product);

    void remove(Long id);

    Page<Product> findByNameContaining(String name, Pageable pageable);
}
