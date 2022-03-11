package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(int id);

    void save(User user);

    void delete(int id);

    Page<User> findAll(Pageable pageable);

    Page<User> searchUserByFirstName(String keyword,Pageable pageable);
}
