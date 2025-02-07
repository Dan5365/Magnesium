package com.example.serving_web_content.mapper;

import com.example.serving_web_content.dto.OrderItemDto;
import com.example.serving_web_content.entity.OrderItem;

public class OrderItemMapper {
    public static OrderItemDto mapToOrderItemDto(OrderItem orderItem) {
        if (orderItem == null) {
            return null;
        }
        return new OrderItemDto(
                orderItem.getId(),
                orderItem.getOrder().getId(),
                orderItem.getProduct().getId(),
                orderItem.getQuantity(),
                orderItem.getPrice(),  // Общая стоимость
                orderItem.getPrice() / orderItem.getQuantity() // Цена за единицу товара
        );
    }

    public static OrderItem mapToOrderItem(OrderItemDto orderItemDto) {
        if (orderItemDto == null) {
            return null;
        }
        OrderItem orderItem = new OrderItem();
        orderItem.setId(orderItemDto.getId());
        orderItem.setQuantity(orderItemDto.getQuantity());
        orderItem.setPrice(orderItemDto.getTotalPrice()); // Общая стоимость
        return orderItem;
    }
}
