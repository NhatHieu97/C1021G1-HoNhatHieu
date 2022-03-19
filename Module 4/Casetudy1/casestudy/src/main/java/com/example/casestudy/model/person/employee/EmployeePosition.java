package com.example.casestudy.model.person.employee;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class EmployeePosition {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idPosition;
    private String namePosition;
    @OneToMany(mappedBy = "employeePosition", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Employee> employee;

    public EmployeePosition() {
    }

    public EmployeePosition(Long idPosition, String namePosition, Set<Employee> employee) {
        this.idPosition = idPosition;
        this.namePosition = namePosition;
        this.employee = employee;
    }

    public Long getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(Long idPosition) {
        this.idPosition = idPosition;
    }

    public String getNamePosition() {
        return namePosition;
    }

    public void setNamePosition(String namePosition) {
        this.namePosition = namePosition;
    }

    public Set<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Set<Employee> employee) {
        this.employee = employee;
    }
}
