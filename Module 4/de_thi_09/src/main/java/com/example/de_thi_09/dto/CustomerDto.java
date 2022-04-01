package com.example.de_thi_09.dto;

import com.example.de_thi_09.model.Transaction;

import java.util.Set;

public class CustomerDto {
    private String maKhachHang;
    private String tenKhachHang;
    private String email;
    private Set<Transaction> transactions;

    public CustomerDto() {
    }

    public CustomerDto(String maKhachHang, String tenKhachHang, String email, Set<Transaction> transactions) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.email = email;
        this.transactions = transactions;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }
}
