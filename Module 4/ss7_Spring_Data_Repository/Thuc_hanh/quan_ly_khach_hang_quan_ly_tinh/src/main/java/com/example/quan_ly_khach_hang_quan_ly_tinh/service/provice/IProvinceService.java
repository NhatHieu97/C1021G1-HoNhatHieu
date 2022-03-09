package com.example.quan_ly_khach_hang_quan_ly_tinh.service.provice;

import com.example.quan_ly_khach_hang_quan_ly_tinh.model.Customer;
import com.example.quan_ly_khach_hang_quan_ly_tinh.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProvinceService {
    List<Province> findAll();

    Page<Province> findAll(Pageable pageable);

    Province findById(Long id);

    void save(Province province);

    void deleteById(Long id);
}
