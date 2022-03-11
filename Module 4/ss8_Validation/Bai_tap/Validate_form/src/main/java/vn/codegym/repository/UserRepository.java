package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.model.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Page<User> findAllByFirstNameContaining(String search, Pageable pageable);
}
