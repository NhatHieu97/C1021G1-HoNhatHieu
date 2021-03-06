package com.example.quan_ly_khach_hang_quan_ly_tinh.controller;

import com.example.quan_ly_khach_hang_quan_ly_tinh.model.Customer;
import com.example.quan_ly_khach_hang_quan_ly_tinh.model.Province;
import com.example.quan_ly_khach_hang_quan_ly_tinh.service.customer.ICustomerService;
import com.example.quan_ly_khach_hang_quan_ly_tinh.service.provice.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProvinceController {
    @Autowired
    private IProvinceService iProvinceService;

    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("/provinces")
    public ModelAndView listProvince(){
        List<Province> provinceList = iProvinceService.findAll();
        ModelAndView modelAndView = new ModelAndView("/province/list","provinces",provinceList);
        return modelAndView;
    }

    @GetMapping("/create-province")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/province/create");
        modelAndView.addObject("province", new Province());
        return modelAndView;
    }

    @PostMapping("/create-province")
    public ModelAndView saveProvince(@ModelAttribute("province") Province province) {
        iProvinceService.save(province);

        ModelAndView modelAndView = new ModelAndView("/province/create");
        modelAndView.addObject("province", new Province());
        modelAndView.addObject("message", "New province created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-province/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Province province = iProvinceService.findById(id);
        if (province != null) {
            ModelAndView modelAndView = new ModelAndView("/province/edit");
            modelAndView.addObject("province", province);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-province")
    public ModelAndView updateProvince(@ModelAttribute("province") Province province) {
        iProvinceService.save(province);
        ModelAndView modelAndView = new ModelAndView("/province/edit");
        modelAndView.addObject("province", province);
        modelAndView.addObject("message", "Province updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-province/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Province province = iProvinceService.findById(id);
        if (province!=null) {
            ModelAndView modelAndView = new ModelAndView("/province/delete");
            modelAndView.addObject("province", province);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-province")
    public String deleteProvince(@ModelAttribute Province province) {
        iProvinceService.deleteById(province.getId());
        return "redirect:/provinces";
    }

//
//    @GetMapping("/view-province/{id}")
//    public ModelAndView viewProvince(@PathVariable("id") Long id){
//        Province provinceOptional = iProvinceService.findById(id);
//        if(provinceOptional==null){
//            return new ModelAndView("/error.404");
//        }
//
//        Iterable<Customer> customers = iCustomerService.findAllByProvince(provinceOptional);
//
//        ModelAndView modelAndView = new ModelAndView("/province/view");
//        modelAndView.addObject("province", provinceOptional);
//        modelAndView.addObject("customers", customers);
//        return modelAndView;
//    }
}
