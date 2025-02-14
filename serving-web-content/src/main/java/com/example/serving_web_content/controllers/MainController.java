package com.example.serving_web_content.controllers;

import com.example.serving_web_content.entity.Product;
import com.example.serving_web_content.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    private final ProductRepository productRepository; //Future perspectives

    public MainController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("title", "Главная Страница");
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "О нас");
        return "about";
    }




}
