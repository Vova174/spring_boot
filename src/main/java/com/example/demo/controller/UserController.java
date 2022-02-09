package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping
    public String show(Model model) {
        List<User> users = userServiceImpl.findAll();
        model.addAttribute("users", users);
        return "user";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("User") User user) {
        userServiceImpl.save(user);
        return "redirect:/user";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userServiceImpl.getId(id));
        return "edit";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("user") User user) {
        userServiceImpl.save(user);
        return "redirect:/user";
    }

    @PostMapping("delete/{id}")
    public String delete(@ModelAttribute("user") User user) {
        userServiceImpl.delete(user);
        return "redirect:/user";
    }
}

