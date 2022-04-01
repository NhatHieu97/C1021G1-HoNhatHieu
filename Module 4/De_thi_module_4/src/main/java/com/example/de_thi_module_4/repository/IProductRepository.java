package com.example.de_thi_module_4.repository;

import com.example.de_thi_module_4.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Long> {
//    Page<Product> findAllByProduct_NameContaining(String name, Pageable pageable);
    Page<Product> findByNameProductContaining(String name, Pageable pageable);
//    Page<Product> findAllByCustomer_NameContainingAndTransactionType_Name(String nameCustomer,String transactionType, Pageable pageable);
}
