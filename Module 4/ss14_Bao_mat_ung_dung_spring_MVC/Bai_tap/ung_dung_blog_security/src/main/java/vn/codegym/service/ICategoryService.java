package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Category;

public interface ICategoryService {
    void add(Category category);
    Page<Category> findAll(Pageable pageable);

    Category findById(Long id);

    void remove(Long id);

    void edit(Category category);
}
