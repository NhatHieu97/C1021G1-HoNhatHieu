package com.example.de_thi_09.dto;

import com.example.de_thi_09.model.Customer;
import com.example.de_thi_09.model.TransactionType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import javax.validation.constraints.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionDto implements Validator {
    @Pattern(regexp = "^(MGD)(-)[0-9]{4}$" ,message = "Hãy Nhập Đúng Định Dạng VD:MGD_3456")
    private String maGiaoDich;
    private String maKhachHang;
//    @Pattern( regexp = "([0-9]{2})\\\\\\\\([0-9]{2})\\\\\\\\([0-9]{4})",message = "Hãy Nhập Đúng Định Dạng VD:23/12/2022")
    private String ngayGiaoDich;
    @Min(500)
    @NotNull
    private Double donGia;
    @Min(0)
    @NotNull
    private Double dienTich;
    private Customer customer;
    private TransactionType transactionType;

    public TransactionDto() {
    }

    public TransactionDto(String maGiaoDich, String maKhachHang, String ngayGiaoDich, Double donGia, Double dienTich, Customer customer, TransactionType transactionType) {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }


    @Override
    public void validate(Object target, Errors errors) {
        TransactionDto transactionDto = (TransactionDto) target;
        String date = transactionDto.ngayGiaoDich;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date transactionDate = simpleDateFormat.parse(date);
            Date currentDate = new Date(System.currentTimeMillis());
            long dateSecond = transactionDate.getTime() - currentDate.getTime();
            if (dateSecond < (-24*60*60*1000)){
                errors.rejectValue("ngayGiaoDich","","Ngày Phải Lớn Hơn Ngày Hiện Tại");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        TransactionDto transactionDto = (TransactionDto) target;
//        String date = transactionDto.ngayGiaoDich;
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            Date transactionDate = simpleDateFormat.parse(date);
//            Date currentDate = new Date(System.currentTimeMillis());
//            if(transactionDate.before(currentDate)){
//                errors.rejectValue("ngayGiaoDich","", "Ngày phải lớn hơn ngày hiện tại");
//            }
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
    }
}
