package com.example.serving_web_content.service;

import com.example.serving_web_content.dto.FullOrderDescriptionDto;
import com.example.serving_web_content.dto.OrderItemDto;
import com.example.serving_web_content.dto.UserDto;
import com.example.serving_web_content.entity.Order;
import com.example.serving_web_content.entity.OrderItem;
import com.example.serving_web_content.entity.User;
import com.example.serving_web_content.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public FullOrderDescriptionDto getFullOrderDescription(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        User user = order.getUser();
        List<OrderItem> orderItems = order.getOrderItems();

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstname());
        userDto.setLastName(user.getLastname());
        userDto.setEmail(user.getEmail());
        userDto.setBalance(user.getBalance());

        List<OrderItemDto> orderItemDtos = orderItems.stream()
                .map(item -> {
                    OrderItemDto dto = new OrderItemDto();
                    dto.setProductName(item.getProductName());
                    dto.setQuantity(item.getQuantity());
                    dto.setPrice(item.getPrice());
                    return dto;
                })
                .collect(Collectors.toList());

        FullOrderDescriptionDto fullOrderDescriptionDto = new FullOrderDescriptionDto();
        fullOrderDescriptionDto.setOrderId(order.getId());
        fullOrderDescriptionDto.setOrderDate(order.getOrderDate());
        fullOrderDescriptionDto.setTotalAmount(order.getTotalAmount());
        fullOrderDescriptionDto.setUser(userDto);
        fullOrderDescriptionDto.setOrderItems(orderItemDtos);

        return fullOrderDescriptionDto;
    }
}