package com.example.serving_web_content.controllers;

import com.example.serving_web_content.dto.CreateOrderDto;
import com.example.serving_web_content.dto.FullOrderDescriptionDto;
import com.example.serving_web_content.dto.OrderDto;
import com.example.serving_web_content.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{orderId}/full-description")
    public FullOrderDescriptionDto getFullOrderDescription(@PathVariable Long orderId) {
        return orderService.getFullOrderDescription(orderId);
    }

    @PostMapping
    public OrderDto createOrder(@RequestBody CreateOrderDto createOrderDto) {
        return orderService.createOrder(createOrderDto);
    }
}