package vn.codegym.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.dto.CartDto;
import vn.codegym.dto.ProductDto;
import vn.codegym.model.Product;
import vn.codegym.service.impl.ProductService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;


@SessionAttributes("cart")
@Controller
public class ProductController {
    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }
    @Autowired
    ProductService productService;

    @GetMapping
    public ModelAndView showListPage(Model model, @CookieValue(value = "idProduct",defaultValue = "-1") Long idProduct){
        if (idProduct != 1){
            model.addAttribute("historyProduct");
        }
        return new ModelAndView("product/list","productlist",productService.findAll());
    }

    @GetMapping("/add/{id}")
    public ModelAndView showDetail(@PathVariable Long id, HttpServletResponse response){
        Cookie cookie = new Cookie("idProduct", id + "");
        cookie.setMaxAge(60*60*24*1);
        cookie.setPath("/");
        return new ModelAndView("product/detail","product", productService.findById(id));
    }
//    @GetMapping("add/{id}")
//    public String addToCart(@PathVariable Long id, @SessionAttribute ("cart") CartDto cart){
//        Product productOptional = productService.findById(id);
//        if(productOptional != null){
//            ProductDto productDto = new ProductDto();
//            BeanUtils.copyProperties(productOptional,productDto);
//            cart.addProduct(productDto);
//        }
//        return "redirect:/cart";
//    }
}
