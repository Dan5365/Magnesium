package com.example.serving_web_content.repository;

import com.example.serving_web_content.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;



public interface OrderRepository extends JpaRepository<Order, Long> {
}
