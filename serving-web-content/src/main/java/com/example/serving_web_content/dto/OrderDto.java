package com.example.serving_web_content.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Long id;

    @NotNull(message = "User ID cannot be null")
    private Long userId;

    @NotBlank(message = "Order status cannot be blank")
    private String status;

    private List<OrderItemDto> orderItems;
}
