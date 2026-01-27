package com.ishan.ecommerce.OrderService.mapper;

import com.ishan.ecommerce.OrderService.dto.OrderRequestDTO;
import com.ishan.ecommerce.OrderService.entity.Order;
import com.ishan.ecommerce.OrderService.entity.OrderItem;
import com.ishan.ecommerce.OrderService.enums.OrderStatus;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.List;

public class OrderMapper {
    public static Order mapToOrder(OrderRequestDTO orderRequestDTO) {
        Order order = Order.builder()
                .userId(orderRequestDTO.getUserId())
                .orderNumber(UUID.randomUUID().toString())
                .orderStatus(OrderStatus.PENDING)
                .build();

        if (orderRequestDTO.getOrderItems() != null) {
            List<OrderItem> items = orderRequestDTO.getOrderItems().stream()
                    .map(itemDto -> OrderItem.builder()
                            .productId(itemDto.getProductId())
                            .quantity(itemDto.getQuantity())
                            .order(order)
                            .build())
                    .collect(Collectors.toList());
            order.setOrderItems(items);
        }

        return order;
    }
}
