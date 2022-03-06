package com.codegym.reponsitory;

import com.codegym.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student>   findAll();
}
