package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.model.Customer;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product customer);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);
}
