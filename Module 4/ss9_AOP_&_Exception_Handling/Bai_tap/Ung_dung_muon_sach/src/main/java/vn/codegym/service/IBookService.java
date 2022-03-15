package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Book;

public interface IBookService {
    Page<Book> findAll(Pageable pageable);
    void save(Book book);
    void delete(Book book);
    Book findById(Long id);
}
