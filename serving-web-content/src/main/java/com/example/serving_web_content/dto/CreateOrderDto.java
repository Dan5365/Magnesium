package com.example.serving_web_content.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateOrderDto {

    @NotNull(message = "User ID cannot be null")
    private Long userId;

    @NotBlank(message = "Order status cannot be blank")
    private String status;

    private List<OrderItemDto> orderItems;
}