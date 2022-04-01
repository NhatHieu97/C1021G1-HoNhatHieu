package com.example.test_module4.dto;

import com.example.test_module4.model.Customer;
import com.example.test_module4.model.TransactionType;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.Column;
import javax.validation.constraints.*;
import java.util.Date;


public class TransactionDto {

    private int id;

//    @NotBlank(message = "Không để khoảng trắng")
//    @Pattern(regexp = "^MDG-([0-9]{4})$")
    private String code;

    private Customer customer;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(columnDefinition = "DATE")
    private Date date;

    private TransactionType transactionType;

//    @Min(value = 500000, message = "Nhập giá lớn hơn 500000")
//    @Max(value = 5000000, message = "Nhập giá lớn hơn 60000000")
    private double price;

//    @Min(value = 20, message = "Nhập giá lớn hơn 20")
    private double area;

    public TransactionDto(int id, String code, Customer customer, Date date, TransactionType transactionType, double price, double area) {
        this.id = id;
        this.code = code;
        this.customer = customer;
        this.date = date;
        this.transactionType = transactionType;
        this.price = price;
        this.area = area;
    }

    public TransactionDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
