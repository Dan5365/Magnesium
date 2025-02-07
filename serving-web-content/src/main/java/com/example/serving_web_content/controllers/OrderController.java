package com.example.serving_web_content.controllers;

import com.example.serving_web_content.dto.OrderDto;
import com.example.serving_web_content.service.OrderService;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/orders")
@Validated
public class OrderController {
    private final OrderService orderService;

    // Create Order
    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody @Valid OrderDto orderDto) {
        OrderDto savedOrder = orderService.createOrder(orderDto);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

    // Get Order by ID
    @GetMapping("{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable("id") @NotNull Long orderId) {
        OrderDto orderDto = orderService.getOrderById(orderId);
        return ResponseEntity.ok(orderDto);
    }

    // Get All Orders
    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    // Update Order
    @PutMapping("{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable("id") @NotNull Long orderId,
                                                @RequestBody @Valid OrderDto updatedOrder) {
        OrderDto orderDto = orderService.updateOrder(orderId, updatedOrder);
        return ResponseEntity.ok(orderDto);
    }

    // Delete Order
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") @NotNull Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok("Order deleted successfully");
    }

    // Exception handler for validation errors
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleValidationExceptions(ConstraintViolationException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
