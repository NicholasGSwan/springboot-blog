package com.codeup.blog.controllers;

import com.codeup.blog.models.User;
import com.codeup.blog.repositories.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class UsersController {
    private Users users;
    private PasswordEncoder passwordEncoder;
    @Autowired
    public UsersController(Users users, PasswordEncoder passwordEncoder){
        this.users = users;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/users/sign-up")
    public String showSignupForm(Model vModel){
        vModel.addAttribute("user", new User());
        return "users/sign-up";
    }

    @PostMapping("/users/sign-up")
    public String saveUser(@ModelAttribute User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        users.save(user);
        return "redirect:/login";
    }
}
