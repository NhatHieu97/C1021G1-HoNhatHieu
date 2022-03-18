package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Blog;

public interface IBlogRepository extends JpaRepository<Blog,Long> {
    Page<Blog> findByTitleContaining(String name, Pageable pageable);
}
