package service.service;

import model.Category;
import reponssitory.Impl.CategoryReponsitory;
import service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    CategoryReponsitory categoryReponsitory = new CategoryReponsitory();
    @Override
    public List<Category> selectAll() {
        return categoryReponsitory.selectAll();
    }
}
