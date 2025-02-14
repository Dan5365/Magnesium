package com.example.serving_web_content.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FullOrderDescriptionDto {
    private Long orderId;
    @NotNull(message = "User ID cannot be null")
    @Size(min = 1, max = 10)
    private String orderDate;
    @Positive(message = "totalAmount must be positive!")
    private double totalAmount;
    private UserDto user;
    @NotNull
    private List<OrderItemDto> orderItems;
}