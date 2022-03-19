package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.Blog;
import vn.codegym.model.Category;
import vn.codegym.service.IBlogService;
import vn.codegym.service.ICategoryService;
import vn.codegym.service.impl.BlogService;
import vn.codegym.service.impl.CategoryService;

import java.util.Date;
@Controller
public class BlogController {
    @Autowired
    private BlogService iBlogService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping
    public ModelAndView display(@RequestParam(defaultValue = "") String search, @PageableDefault(value = 3) Pageable pageable,Model model){

        Page<Blog> blogPage;
        if(search != null){
            blogPage = iBlogService.search(search,pageable);
        }else{
            blogPage = iBlogService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("list", "blog", blogPage);
//        model.addAttribute("category",categoryService.findAll(pageable));
        return modelAndView;
    }
    @GetMapping("/show-create-form")
    public String showCreateForm( Model model,@PageableDefault(size = 10)Pageable pageable){
        Page<Category> categories = categoryService.findAll(pageable);
        model.addAttribute("categories",categories);
        model.addAttribute("blog",new Blog());
        return "/createFrom";
    }

    @PostMapping("/create")
    public String create(Blog blog){
        blog.setTime(new Date().getTime());
        iBlogService.add(blog);
        return ("redirect:/");
    }

    @GetMapping("/cancel/{id}")
    public String cancel(@PathVariable Long id){
        iBlogService.remove(id);
        return ("redirect:/");
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id,Model model){
        Blog blog = iBlogService.findById(id);
        model.addAttribute("blog",blog);
        return ("/view");
    }
    @GetMapping("/edit/{id}")
    public  String showFormEdit(@PageableDefault Pageable pageable,@PathVariable Long id,Model model){
        Blog blog = iBlogService.findById(id);
        model.addAttribute("blog",blog);
        Page<Category> categories = categoryService.findAll(pageable);
        model.addAttribute("category",categories);
        return "/edit";
    }

    @PostMapping("/edit")
    public String edit(Blog blog){
        iBlogService.edit(blog);
        System.out.println(blog.getId());
        return "redirect: /";
    }

    @GetMapping("/search")
    public String search(@RequestParam String title,@PageableDefault(5) Pageable pageable,Model model){
        Page<Blog> blogList = iBlogService.search(title,pageable);
        model.addAttribute("listBlog",blogList);
        //  System.out.println(blogList.size());
        return "search";
    }
}
