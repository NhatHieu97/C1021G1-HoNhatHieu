package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Smartphone;
import vn.codegym.repository.SmartphoneRepository;
import vn.codegym.service.SmartphoneService;

import java.util.List;
@Service
public class SmartphoneImpl implements SmartphoneService {
    @Autowired
    SmartphoneRepository smartphoneRepository;

    @Override
    public List<Smartphone> findAll() {
        return this.smartphoneRepository.findAll();
    }

    @Override
    public Smartphone findById(Long id) {
        return this.smartphoneRepository.findById(id).orElse(null);
    }

    public Smartphone save(Smartphone phone) {
        return this.smartphoneRepository.save(phone);
    }

    @Override
    public Smartphone remove(Long id) {
        Smartphone smartphone = findById(id);
        smartphoneRepository.delete(findById(id));
        return smartphone;
    }
}
