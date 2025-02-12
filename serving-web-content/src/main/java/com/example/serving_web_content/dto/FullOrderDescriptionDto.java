package com.example.serving_web_content.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FullOrderDescriptionDto {
    private Long orderId;
    private String orderDate;
    private double totalAmount;
    private UserDto user;
    private List<OrderItemDto> orderItems;
}