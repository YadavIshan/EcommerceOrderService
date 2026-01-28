package com.ishan.ecommerce.OrderService.controller;

import com.ishan.ecommerce.OrderService.dto.CreateOrderResponseDTO;
import com.ishan.ecommerce.OrderService.dto.OrderRequestDTO;
import com.ishan.ecommerce.OrderService.service.IOrderService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final IOrderService orderService;

    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<CreateOrderResponseDTO> createOrder(@Valid @RequestBody OrderRequestDTO orderRequestDTO) {
        CreateOrderResponseDTO response = orderService.createOrder(orderRequestDTO);
        return ResponseEntity.ok(response);
    }
}
