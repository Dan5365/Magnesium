package com.example.serving_web_content.controllers;

import com.example.serving_web_content.dto.UserDto;
import com.example.serving_web_content.observer.UserDeletionNotifier;
import com.example.serving_web_content.observer.UserDeletionSubject;
import com.example.serving_web_content.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/users")
public class AdminController {

    private final UserService userService;
    private final UserDeletionSubject userDeletionSubject;

    public AdminController(UserService userService) {
        this.userService = userService;
        this.userDeletionSubject = new UserDeletionSubject();

        //Adding observer which sends notification
        this.userDeletionSubject.addObserver(new UserDeletionNotifier());
    }

    // Display all users
    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "admin/users";
    }

    //Form for creating a new user
    @GetMapping("/new")
    public String createUserForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "admin/create_user";
    }

    //Creating a new user
    @PostMapping
    public String createUser(@ModelAttribute("user") UserDto userDto) {
        userService.createUser(userDto);
        return "redirect:/admin/users";
    }

    //Form for Editing a user
    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "admin/edit_user";
    }

    //Updating a user
    @PostMapping("/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute("user") UserDto userDto) {
        userService.updateUser(id, userDto);
        return "redirect:/admin/users";
    }

    // Delete a user and notify observers
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id, Model model) {
        userService.deleteUser(id);
        //Notify everyone
        userDeletionSubject.notifyObservers(id);

        return "redirect:/admin/users";
    }
}
