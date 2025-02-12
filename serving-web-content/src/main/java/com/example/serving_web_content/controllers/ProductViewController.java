package com.example.serving_web_content.controllers;

import com.example.serving_web_content.dto.ProductDto;
import com.example.serving_web_content.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;


@Controller
public class ProductViewController {

    private final ProductService productService;

//Англ ключ и Рус значение
    private static final Map<String, String> categoryMap = Map.of(
            "drinks", "Напитки",
            "bread", "Хлеб",
            "dairy", "Молочные продукты"
    );

    public ProductViewController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/drinks")
    public String drinksPage(Model model) {
        return loadCategoryPage("drinks", model, "products/drinks");
    }

    @GetMapping("/bread")
    public String breadPage(Model model) {
        return loadCategoryPage("bread", model, "products/bread");
    }

    @GetMapping("/dairy")
    public String dairyPage(Model model) {
        return loadCategoryPage("dairy", model, "products/dairy");
    }

    // Universal method for installing categories
    private String loadCategoryPage(String englishCategory, Model model, String template) {
        String category = categoryMap.getOrDefault(englishCategory, englishCategory);
        List<ProductDto> products = productService.getProductsByCategory(category);
        model.addAttribute("products", products);
        return template;
    }
}
