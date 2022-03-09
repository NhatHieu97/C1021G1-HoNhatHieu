package com.example.quan_ly_khach_hang_quan_ly_tinh.service.provice.impl;

import com.example.quan_ly_khach_hang_quan_ly_tinh.model.Province;
import com.example.quan_ly_khach_hang_quan_ly_tinh.repository.IProviceRepository;
import com.example.quan_ly_khach_hang_quan_ly_tinh.service.provice.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements IProvinceService {
    @Autowired
    private IProviceRepository proviceRepository;

    @Override
    public List<Province> findAll() {
        return proviceRepository.findAll();
    }

    @Override
    public Page<Province> findAll(Pageable pageable) {
        return proviceRepository.findAll(pageable);
    }

    @Override
    public Province findById(Long id) {
        return proviceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Province province) {
        proviceRepository.save(province);
    }

    @Override
    public void deleteById(Long id) {
        proviceRepository.deleteById(id);
    }
}
