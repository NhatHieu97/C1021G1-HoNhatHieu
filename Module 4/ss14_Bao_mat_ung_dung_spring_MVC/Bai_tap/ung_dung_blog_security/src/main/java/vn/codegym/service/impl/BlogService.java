package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Blog;
import vn.codegym.repository.IBlogRepository;
import vn.codegym.service.IBlogService;

public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public void add(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public Blog findById(Long id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Long id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public void edit(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Page<Blog> search(String name, Pageable pageable) {
        return iBlogRepository.findByTitleContaining(name, pageable);
    }
}