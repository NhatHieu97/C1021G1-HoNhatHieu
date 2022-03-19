package com.example.casestudy.repository;

import com.example.casestudy.model.person.UserName;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<UserName, Long> {
    UserName findByUserName(String name);
}
