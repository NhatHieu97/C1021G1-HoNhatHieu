package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

//@Transactional
//@Repository
public interface IProductRepo {
    List<Product> findAll();
    void save(Product product);
}
