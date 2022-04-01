package com.example.casestudy.service.username;

import com.example.casestudy.model.person.UserName;
import com.example.casestudy.model.person.employee.EmployeeDivision;

import java.util.List;

public interface IUserNameService {
    List<UserName> findAll();
}
