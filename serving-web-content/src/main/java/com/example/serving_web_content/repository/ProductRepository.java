package com.example.serving_web_content.repository;

import com.example.serving_web_content.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByProductCategoryIgnoreCase(String productCategory);

}
