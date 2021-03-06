package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
