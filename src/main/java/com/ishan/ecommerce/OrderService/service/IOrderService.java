package com.ishan.ecommerce.OrderService.service;

import com.ishan.ecommerce.OrderService.dto.CreateOrderResponseDTO;
import com.ishan.ecommerce.OrderService.dto.OrderRequestDTO;

public interface IOrderService {
    CreateOrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO);
}
