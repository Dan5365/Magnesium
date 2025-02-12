//package com.example.serving_web_content.service.impl;
//
//import com.example.serving_web_content.dto.OrderDto;
//import com.example.serving_web_content.entity.Order;
//import com.example.serving_web_content.entity.User;
//import com.example.serving_web_content.exception.ResourceNotFoundException;
//import com.example.serving_web_content.mapper.OrderMapper;
//import com.example.serving_web_content.repository.OrderRepository;
//import com.example.serving_web_content.repository.UserRepository;
//import com.example.serving_web_content.service.OrderService;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@AllArgsConstructor
//public class OrderServiceImpl implements OrderService {
//    private final OrderRepository orderRepository;
//    private final UserRepository userRepository;
//
//    @Override
//    public OrderDto createOrder(OrderDto orderDto) {
//        // Проверяем, существует ли пользователь
//        User user = userRepository.findById(orderDto.getUserId())
//                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + orderDto.getUserId()));
//
//        Order order = OrderMapper.mapToOrder(orderDto);
//        order.setUser(user);
//        Order savedOrder = orderRepository.save(order);
//        return OrderMapper.mapToOrderDto(savedOrder);
//    }
//
//    @Override
//    public OrderDto getOrderById(Long orderId) {
//        Order order = orderRepository.findById(orderId)
//                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + orderId));
//        return OrderMapper.mapToOrderDto(order);
//    }
//
//    @Override
//    public List<OrderDto> getAllOrders() {
//        List<Order> orders = orderRepository.findAll();
//        return orders.stream()
//                .map(OrderMapper::mapToOrderDto)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public OrderDto updateOrder(Long orderId, OrderDto updatedOrderDto) {
//        Order order = orderRepository.findById(orderId)
//                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + orderId));
//
//        order.setStatus(updatedOrderDto.getStatus());
//
//        Order updatedOrder = orderRepository.save(order);
//        return OrderMapper.mapToOrderDto(updatedOrder);
//    }
//
//    @Override
//    public void deleteOrder(Long orderId) {
//        Order order = orderRepository.findById(orderId)
//                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + orderId));
//        orderRepository.deleteById(orderId);
//    }
//}
