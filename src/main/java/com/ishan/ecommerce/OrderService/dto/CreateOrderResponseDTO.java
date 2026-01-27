package com.ishan.ecommerce.OrderService.dto;

import com.ishan.ecommerce.OrderService.enums.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateOrderResponseDTO {
    private Long orderId;
    private String orderNumber;
    private OrderStatus orderStatus;
    private double orderAmount;    
}
