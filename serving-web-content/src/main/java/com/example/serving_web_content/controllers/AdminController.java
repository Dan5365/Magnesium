package com.example.serving_web_content.controllers;

import com.example.serving_web_content.dto.UserDto;
import com.example.serving_web_content.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/users")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    // Display all users
    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "admin/users";
    }

    // Show form for creating a new user
    @GetMapping("/new")
    public String createUserForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "admin/create_user";
    }

    // Handle form submission for creating a new user
    @PostMapping
    public String createUser(@ModelAttribute("user") UserDto userDto) {
        userService.createUser(userDto);
        return "redirect:/admin/users";
    }

    // Show form for editing a user
    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "admin/edit_user";
    }

    // Handle form submission for updating a user
    @PostMapping("/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute("user") UserDto userDto) {
        userService.updateUser(id, userDto);
        return "redirect:/admin/users";
    }

    // Delete a user
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }
}