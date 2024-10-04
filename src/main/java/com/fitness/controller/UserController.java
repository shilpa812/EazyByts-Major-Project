package com.fitness.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fitness.entity.User;
import com.fitness.service.UserService;

import jakarta.validation.GroupSequence;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @PostMapping("/users")
    public String saveUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }
    @DeleteMapping("/delete")
    public String deleteUser(@PathVariable Long id) {
    	userService.deleteUser( id);
    	return "users";
    	
    }
    
    
    
    
}

