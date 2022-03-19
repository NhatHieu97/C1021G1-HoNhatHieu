package com.example.casestudy.model.person.employee;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class EmployeeEducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEducationDegree;
    private String nameEducationDegree;
    @OneToMany(mappedBy = "employeeEducationDegree", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Employee> employee;

    public EmployeeEducationDegree() {
    }

    public EmployeeEducationDegree(Long idEducationDegree, String nameEducationDegree, Set<Employee> employee) {
        this.idEducationDegree = idEducationDegree;
        this.nameEducationDegree = nameEducationDegree;
        this.employee = employee;
    }

    public Long getIdEducationDegree() {
        return idEducationDegree;
    }

    public void setIdEducationDegree(Long idEducationDegree) {
        this.idEducationDegree = idEducationDegree;
    }

    public String getNameEducationDegree() {
        return nameEducationDegree;
    }

    public void setNameEducationDegree(String nameEducationDegree) {
        this.nameEducationDegree = nameEducationDegree;
    }

    public Set<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Set<Employee> employee) {
        this.employee = employee;
    }
}
