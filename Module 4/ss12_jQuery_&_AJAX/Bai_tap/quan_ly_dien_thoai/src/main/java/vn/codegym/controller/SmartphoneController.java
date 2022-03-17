package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.Smartphone;
import vn.codegym.service.SmartphoneService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/smartphones")
public class SmartphoneController {
    @Autowired
    private SmartphoneService smartphoneService;

    @PostMapping
    public ResponseEntity<List<Smartphone>> createSmartphone(@RequestBody Smartphone smartphone) {
        smartphoneService.save(smartphone);
        return new ResponseEntity<>(smartphoneService.findAll(), HttpStatus.CREATED);
    }
    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage() {
        ModelAndView modelAndView = new ModelAndView("/phones/list");
        modelAndView.addObject("smartphones", smartphoneService.findAll());
        return modelAndView;
    }
    @GetMapping
    public ResponseEntity<Iterable<Smartphone>> allPhones() {
        return new ResponseEntity<>(smartphoneService.findAll(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Smartphone>> deleteSmartphone(@PathVariable Long id) {
        Smartphone smartphone= smartphoneService.findById(id);
        if (smartphone == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(id);
        return new ResponseEntity<>(smartphoneService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Smartphone> updateSmartphone(@PathVariable Long id, @PathVariable Smartphone smartphone){
        Smartphone smartphones = smartphoneService.findById(id);
        if(smartphones == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphones.setModel(smartphone.getModel());
        smartphones.setPrice(smartphone.getPrice());
        smartphones.setProducer(smartphone.getProducer());
        return new ResponseEntity<>(smartphones,HttpStatus.OK);
    }

}
