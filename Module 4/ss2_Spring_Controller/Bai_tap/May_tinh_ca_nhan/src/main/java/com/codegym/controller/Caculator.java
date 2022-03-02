package com.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.codegym.service.iml.CaculatorServiceImpl;

@Controller
public class Caculator {
    @Autowired
    private CaculatorServiceImpl calculateService;
    @GetMapping("")
    public String home(){
        return "index";
    }

    @GetMapping("/caculator")
    public String caculate(@RequestParam double num1, @RequestParam double num2, @RequestParam String caculate , Model model){
        double result = calculateService.caculator(num1,num2,caculate);
        model.addAttribute("result",result);
       return "index";
    }

}
