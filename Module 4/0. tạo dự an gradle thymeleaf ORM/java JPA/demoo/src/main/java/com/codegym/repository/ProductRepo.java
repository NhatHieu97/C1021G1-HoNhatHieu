package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
@Repository
public class ProductRepo implements IProductRepo{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product as p",Product.class);
        return query.getResultList();
    }

    @Override
    public void save(Product product) {
        if(product.getId() !=null) {
            entityManager.merge(product);
        } else {
            entityManager.persist(product);
        }
        //entityManager.persist(product);
    }
}
