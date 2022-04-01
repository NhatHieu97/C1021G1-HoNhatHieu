package com.example.de_thi_09.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Transaction {
    @Id
    private String maGiaoDich;
    private String maKhachHang;
    private String ngayGiaoDich;
    private Double donGia;
    private Double dienTich;

    @ManyToOne
    @JoinColumn(name = "id_khach_hang",referencedColumnName = "maKhachHang")
    @JsonBackReference
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "transactionType_id",referencedColumnName = "id")
    private TransactionType transactionType;

    public Transaction() {
    }

    public Transaction(String maGiaoDich, String maKhachHang, String ngayGiaoDich, Double donGia, Double dienTich, Customer customer, TransactionType transactionType) {
        this.maGiaoDich = maGiaoDich;
        this.maKhachHang = maKhachHang;
        this.ngayGiaoDich = ngayGiaoDich;
        this.donGia = donGia;
        this.dienTich = dienTich;
        this.customer = customer;
        this.transactionType = transactionType;
    }

    public String getMaGiaoDich() {
        return maGiaoDich;
    }

    public void setMaGiaoDich(String maGiaoDich) {
        this.maGiaoDich = maGiaoDich;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getNgayGiaoDich() {
        return ngayGiaoDich;
    }

    public void setNgayGiaoDich(String ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    public Double getDienTich() {
        return dienTich;
    }

    public void setDienTich(Double dienTich) {
        this.dienTich = dienTich;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}
