package com.codegym.controller;

import com.codegym.model.EmailObj;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmailController {

    @RequestMapping("")
    public String home(Model model){
        model.addAttribute("emailObj",new EmailObj());
        return "home";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute EmailObj emailObj, Model model){
        model.addAttribute("language", emailObj.getLanguages());
        model.addAttribute("pageSize", emailObj.getPageSize());
        model.addAttribute("spamsFilter", emailObj.isSpamsFilter());
        model.addAttribute("signature", emailObj.getSignature());
        return "result";
    }
}
