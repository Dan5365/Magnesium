//package com.example.serving_web_content.service.impl;
//
//import com.example.serving_web_content.dto.OrderItemDto;
//import com.example.serving_web_content.entity.Order;
//import com.example.serving_web_content.entity.OrderItem;
//import com.example.serving_web_content.exception.ResourceNotFoundException;
//import com.example.serving_web_content.mapper.OrderItemMapper;
//import com.example.serving_web_content.repository.OrderItemRepository;
//import com.example.serving_web_content.repository.OrderRepository;
//import com.example.serving_web_content.service.OrderItemService;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@AllArgsConstructor
//public class OrderItemServiceImpl implements OrderItemService {
//    private final OrderItemRepository orderItemRepository;
//    private final OrderRepository orderRepository;
//
//    @Override
//    public OrderItemDto createOrderItem(OrderItemDto orderItemDto) {
//        Order order = orderRepository.findById(orderItemDto.getOrderId())
//                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + orderItemDto.getOrderId()));
//
//        OrderItem orderItem = OrderItemMapper.mapToOrderItem(orderItemDto);
//        orderItem.setOrder(order);
//
//        OrderItem savedOrderItem = orderItemRepository.save(orderItem);
//        return OrderItemMapper.mapToOrderItemDto(savedOrderItem);
//    }
//
//    @Override
//    public OrderItemDto getOrderItemById(Long orderItemId) {
//        OrderItem orderItem = orderItemRepository.findById(orderItemId)
//                .orElseThrow(() -> new ResourceNotFoundException("OrderItem not found with id: " + orderItemId));
//        return OrderItemMapper.mapToOrderItemDto(orderItem);
//    }
//
//    @Override
//    public List<OrderItemDto> getAllOrderItems() {
//        List<OrderItem> orderItems = orderItemRepository.findAll();
//        return orderItems.stream()
//                .map(OrderItemMapper::mapToOrderItemDto)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public OrderItemDto updateOrderItem(Long orderItemId, OrderItemDto updatedOrderItemDto) {
//        OrderItem orderItem = orderItemRepository.findById(orderItemId)
//                .orElseThrow(() -> new ResourceNotFoundException("OrderItem not found with id: " + orderItemId));
//
//        orderItem.setQuantity(updatedOrderItemDto.getQuantity());
//
//        OrderItem updatedOrderItem = orderItemRepository.save(orderItem);
//        return OrderItemMapper.mapToOrderItemDto(updatedOrderItem);
//    }
//
//    @Override
//    public void deleteOrderItem(Long orderItemId) {
//        OrderItem orderItem = orderItemRepository.findById(orderItemId)
//                .orElseThrow(() -> new ResourceNotFoundException("OrderItem not found with id: " + orderItemId));
//        orderItemRepository.deleteById(orderItemId);
//    }
//
//
//}
