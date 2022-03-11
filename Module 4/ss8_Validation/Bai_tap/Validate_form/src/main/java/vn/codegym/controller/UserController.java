package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.User;
import vn.codegym.service.UserService;

import javax.validation.Valid;
import java.util.Optional;
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping({"","/user"})
    public ModelAndView home(Model model,
                       @PageableDefault(size = 3) Pageable pageable,
                       @RequestParam(defaultValue = "") String search) {
        Page<User> userPage;
        if (search != null) {
            userPage = userService.searchUserByFirstName(search, pageable);
        } else {
            userPage = userService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("list", "user", userPage);
        return modelAndView;
    }

    @GetMapping("/create-user")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/create-user")
    public String createStudent(Model model, @Valid @ModelAttribute User user,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("users", this.userService.findAll());
            return "create";
        }

        this.userService.save(user);
        redirectAttributes.addFlashAttribute("message", "Register successfully!");

        return "redirect:/user";
    }

    @GetMapping("/edit-user/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id){
        User user = userService.findById(id);
        if(user != null) {
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("user", user);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-user")
    public ModelAndView updateBlog(@ModelAttribute("user") User user){
        userService.save(user);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("user", user);
        modelAndView.addObject("message", "User updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-user/{id}")
    public ModelAndView showDeleteForm(@PathVariable Integer id){
        User user = userService.findById(id);
        if(user != null) {
            ModelAndView modelAndView = new ModelAndView("delete");
            modelAndView.addObject("user", user);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-user")
    public String deleteUser(@ModelAttribute("user") User user){
        userService.delete(user.getId());
        return "redirect: ";
    }
}
