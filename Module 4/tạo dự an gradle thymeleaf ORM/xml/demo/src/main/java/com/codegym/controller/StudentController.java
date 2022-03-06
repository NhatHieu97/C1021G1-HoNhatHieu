package com.codegym.controller;

import com.codegym.model.Student;
import com.codegym.reponsitory.StudentRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentController {
    @RequestMapping
    public String get(){
        List<Student> studentList= new StudentRepo().findAll();
        return "dsd";
    }
}
