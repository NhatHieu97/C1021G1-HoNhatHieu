package com.codegym.service;

import com.codegym.model.Product;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private static final Map<Integer, Product> products;

    static {

        products = new HashMap<>();
        products.put(1, new Product(1, "iphone 11", 799.0, 12,"Black, Yellow, Green"));
        products.put(2, new Product(2, "iphone Pro", 1100.0, 12,"Black, Yellow, Green"));
        products.put(3, new Product(3, "iphone X", 749.0, 12,"Black, Yellow, Green"));
        products.put(4, new Product(4, "Smart Tivi inch", 799.0, 12,"Black, Yellow, Green"));
        products.put(5, new Product(5, "Tủ lạnh 2 cánh Tosiba", 799.0, 12,"Black, Yellow, Green"));
        products.put(6, new Product(6, "Máy giăc cửa ngang Samsung", 799.0, 12,"Black, Yellow, Green"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getIdProduct(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
