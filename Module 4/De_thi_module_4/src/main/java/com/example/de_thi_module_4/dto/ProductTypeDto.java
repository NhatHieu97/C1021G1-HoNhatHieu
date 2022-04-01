package com.example.de_thi_module_4.dto;

import com.example.de_thi_module_4.model.Product;

import java.util.Set;

public class ProductTypeDto {
    private Long id;
    private String name;
    private Set<Product> productSet;

    public ProductTypeDto() {
    }

    public ProductTypeDto(Long id, String name, Set<Product> productSet) {
        this.id = id;
        this.name = name;
        this.productSet = productSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }
}
