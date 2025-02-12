package com.example.serving_web_content.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDto {
    private String productName;
    private int quantity;
    private double price;
}