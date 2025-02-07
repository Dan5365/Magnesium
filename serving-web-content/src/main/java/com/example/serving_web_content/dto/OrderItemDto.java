package com.example.serving_web_content.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto {

    private Long id;

    @NotNull(message = "Order ID cannot be null")
    private Long orderId;

    @NotNull(message = "Product ID cannot be null")
    private Long productId;

    @NotNull(message = "Quantity cannot be null")
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;

    @NotNull(message = "Total price cannot be null")
    @Min(value = 0, message = "Total price must be at least 0")
    private Double totalPrice;

    @NotNull(message = "Price per item cannot be null")
    @Min(value = 0, message = "Price per item must be at least 0")
    private Double pricePerItem;
}
