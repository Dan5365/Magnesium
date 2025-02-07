package com.example.serving_web_content.mapper;

import com.example.serving_web_content.dto.OrderDto;
import com.example.serving_web_content.entity.Order;

import java.util.Collections;
import java.util.stream.Collectors;

public class OrderMapper {
    public static OrderDto mapToOrderDto(Order order) {
        if (order == null) {
            return null;
        }
        return new OrderDto(
                order.getId(),
                order.getUser().getId(),
                order.getStatus(),
                order.getOrderItems() != null
                        ? order.getOrderItems().stream()
                        .map(OrderItemMapper::mapToOrderItemDto)
                        .collect(Collectors.toList())
                        : Collections.emptyList()
        );
    }

    public static Order mapToOrder(OrderDto orderDto) {
        if (orderDto == null) {
            return null;
        }
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setStatus(orderDto.getStatus());
        return order;
    }
}
