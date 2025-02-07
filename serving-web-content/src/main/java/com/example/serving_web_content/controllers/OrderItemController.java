package com.example.serving_web_content.controllers;

import com.example.serving_web_content.dto.OrderItemDto;
import com.example.serving_web_content.service.OrderItemService;
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
@RequestMapping("/api/order-items")
@Validated
public class OrderItemController {
    private final OrderItemService orderItemService;

    // Create Order Item
    @PostMapping
    public ResponseEntity<OrderItemDto> createOrderItem(@RequestBody @Valid OrderItemDto orderItemDto) {
        OrderItemDto savedOrderItem = orderItemService.createOrderItem(orderItemDto);
        return new ResponseEntity<>(savedOrderItem, HttpStatus.CREATED);
    }

    // Get Order Item by ID
    @GetMapping("{id}")
    public ResponseEntity<OrderItemDto> getOrderItemById(@PathVariable("id") @NotNull Long orderItemId) {
        OrderItemDto orderItemDto = orderItemService.getOrderItemById(orderItemId);
        return ResponseEntity.ok(orderItemDto);
    }

    // Get All Order Items
    @GetMapping
    public ResponseEntity<List<OrderItemDto>> getAllOrderItems() {
        List<OrderItemDto> orderItems = orderItemService.getAllOrderItems();
        return ResponseEntity.ok(orderItems);
    }

    // Update Order Item
    @PutMapping("{id}")
    public ResponseEntity<OrderItemDto> updateOrderItem(@PathVariable("id") @NotNull Long orderItemId,
                                                        @RequestBody @Valid OrderItemDto updatedOrderItem) {
        OrderItemDto orderItemDto = orderItemService.updateOrderItem(orderItemId, updatedOrderItem);
        return ResponseEntity.ok(orderItemDto);
    }

    // Delete Order Item
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOrderItem(@PathVariable("id") @NotNull Long orderItemId) {
        orderItemService.deleteOrderItem(orderItemId);
        return ResponseEntity.ok("Order item deleted successfully");
    }

    // Exception handler for validation errors
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleValidationExceptions(ConstraintViolationException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
