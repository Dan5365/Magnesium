package com.example.serving_web_content.repository;

import com.example.serving_web_content.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
