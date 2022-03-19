package com.example.casestudy.model.person.employee;

import com.example.casestudy.model.person.UserName;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Employee  {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idEmployee;
    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "idPosition")
    @JsonBackReference
    private EmployeePosition employeePosition;
    @ManyToOne
    @JoinColumn(name="division_id", referencedColumnName = "idDivision")
    @JsonBackReference
    private EmployeeDivision employeeDivision;
    @ManyToOne
    @JoinColumn(name="education_degree_id", referencedColumnName = "idEducationDegree")
    @JsonBackReference
    private EmployeeEducationDegree employeeEducationDegree;
    @OneToOne
    @JoinColumn(name="user_name", referencedColumnName = "userName")
    @JsonBackReference
    private UserName userName;


    private Long salary;
    private String name;
    private String birthday;
    private String idCard;
    private String phone;
    private String email;
    private String address;
    private String code;

    public Employee() {
    }

    public Employee(Long idEmployee, EmployeePosition employeePosition, EmployeeDivision employeeDivision,
                    EmployeeEducationDegree employeeEducationDegree,
                    UserName userName, Long salary, String name, String birthday, String idCard,
                    String phone, String email, String address, String code) {
        this.idEmployee = idEmployee;
        this.employeePosition = employeePosition;
        this.employeeDivision = employeeDivision;
        this.employeeEducationDegree = employeeEducationDegree;
        this.userName = userName;
        this.salary = salary;
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.code = code;
    }

    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public EmployeePosition getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(EmployeePosition employeePosition) {
        this.employeePosition = employeePosition;
    }

    public EmployeeDivision getEmployeeDivision() {
        return employeeDivision;
    }

    public void setEmployeeDivision(EmployeeDivision employeeDivision) {
        this.employeeDivision = employeeDivision;
    }

    public EmployeeEducationDegree getEmployeeEducationDegree() {
        return employeeEducationDegree;
    }

    public void setEmployeeEducationDegree(EmployeeEducationDegree employeeEducationDegree) {
        this.employeeEducationDegree = employeeEducationDegree;
    }

    public UserName getUserName() {
        return userName;
    }

    public void setUserName(UserName userName) {
        this.userName = userName;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
