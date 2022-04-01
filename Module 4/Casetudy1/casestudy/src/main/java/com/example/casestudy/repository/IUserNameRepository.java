package com.example.casestudy.repository;

import com.example.casestudy.model.person.UserName;
import com.example.casestudy.model.person.employee.EmployeeDivision;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface IUserNameRepository extends JpaRepository<UserName,String> {
}
