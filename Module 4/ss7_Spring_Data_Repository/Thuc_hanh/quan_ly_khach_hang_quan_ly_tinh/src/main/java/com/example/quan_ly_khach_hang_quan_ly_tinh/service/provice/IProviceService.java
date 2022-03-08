package com.example.quan_ly_khach_hang_quan_ly_tinh.service.provice;

import com.example.quan_ly_khach_hang_quan_ly_tinh.model.Customer;
import com.example.quan_ly_khach_hang_quan_ly_tinh.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProviceService {
    Page<Province> findAll(Pageable pageable);

    Province findById(int id);

    void save(Province province);

    void deleteById(Integer id);
}
