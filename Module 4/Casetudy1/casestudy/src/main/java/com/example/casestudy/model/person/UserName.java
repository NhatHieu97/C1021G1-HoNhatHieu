package com.example.casestudy.model.person;

import com.example.casestudy.model.person.employee.Employee;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class UserName {
    @Id
    private String userName;
    private String password;

    @OneToOne(mappedBy = "userName", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Employee employee;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_Name"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;


    public UserName() {
    }

    public UserName(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public UserName(String userName, String password, Employee employee, List<Role> roles) {
        this.userName = userName;
        this.password = password;
        this.employee = employee;
        this.roles = roles;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
