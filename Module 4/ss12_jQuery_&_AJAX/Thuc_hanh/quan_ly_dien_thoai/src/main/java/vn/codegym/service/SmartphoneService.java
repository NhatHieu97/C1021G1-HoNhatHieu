package vn.codegym.service;

import vn.codegym.model.Smartphone;

import java.util.List;

public interface SmartphoneService {
    List<Smartphone> findAll();
    Smartphone findById(Long id);
    Smartphone save(Smartphone phone);
    Smartphone remove(Long id);
}
