package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {
    @Qualifier("productRepo")
    @Autowired
    private IProductRepo iProductRepo;
    @RequestMapping
    public String DisplayHome(){
        //List<Product> productList=iProductRepo.findAll();

        iProductRepo.save(new Product(1,"b"));
        iProductRepo.save(new Product(5,"c"));
        return "";
    }
}
