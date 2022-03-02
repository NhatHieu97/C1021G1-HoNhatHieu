package service.service;

import model.Product;
import reponssitory.Impl.Productreponssitory;
import service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    Productreponssitory productreponssitory = new Productreponssitory();
    @Override
    public List<Product> finAll() {
        return productreponssitory.selectAll();
    }

    @Override
    public void create(Product product) {
        productreponssitory.create(product);
    }

    @Override
    public void remove(int id) {
        productreponssitory.remove(id);
    }

    @Override
    public Product finById(int id) {
        return productreponssitory.selectID(id);
    }

    @Override
    public void update(Product product) {
        productreponssitory.update(product);
    }

    @Override
    public List<Product> searchName(String name) {
        List<Product> productList = productreponssitory.searchName(name);
        return productList;
    }


}
