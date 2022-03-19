package com.example.casestudy.model.person.employee;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class EmployeeDivision {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idDivision;
    private String nameDivision;
    @OneToMany(mappedBy = "employeeDivision", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Employee> employee;

    public EmployeeDivision() {
    }

    public EmployeeDivision(int idDivision, String nameDivision, Set<Employee> employee) {
        this.idDivision = idDivision;
        this.nameDivision = nameDivision;
        this.employee = employee;
    }

    public int getIdDivision() {
        return idDivision;
    }

    public void setIdDivision(int idDivision) {
        this.idDivision = idDivision;
    }

    public String getNameDivision() {
        return nameDivision;
    }

    public void setNameDivision(String nameDivision) {
        this.nameDivision = nameDivision;
    }

    public Set<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Set<Employee> employee) {
        this.employee = employee;
    }
}
