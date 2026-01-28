package com.ishan.ecommerce.OrderService.service;

import com.ishan.ecommerce.OrderService.dto.CreateOrderResponseDTO;
import com.ishan.ecommerce.OrderService.dto.OrderRequestDTO;
import com.ishan.ecommerce.OrderService.dto.ProductDTO;
import com.ishan.ecommerce.OrderService.entity.Order;
import com.ishan.ecommerce.OrderService.entity.OrderItem;
import com.ishan.ecommerce.OrderService.mapper.OrderMapper;
import com.ishan.ecommerce.OrderService.repository.OrderRepository;
import com.ishan.ecommerce.OrderService.client.ProductServiceClient;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService implements IOrderService {

    private final OrderRepository orderRepository;
    private final ProductServiceClient productServiceClient;

    public OrderService(OrderRepository orderRepository, ProductServiceClient productServiceClient) {
        this.orderRepository = orderRepository;
        this.productServiceClient = productServiceClient;
    }

    @Override
    @Transactional
    public CreateOrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO) {
        Order order = OrderMapper.mapToOrder(orderRequestDTO);

        // Enrich order items with product pricing information
        order.getOrderItems().forEach(currentItem -> {
            ProductDTO productDTO = productServiceClient.getProductById(currentItem.getProductId());
            currentItem.setPrice(productDTO.getPrice());
            currentItem.setTotalAmount(productDTO.getPrice() * currentItem.getQuantity());
        });
        
        // Calculate total order amount from all items
        double totalOrderAmount = order.getOrderItems().stream()
                .mapToDouble(OrderItem::getTotalAmount)
                .sum();
        order.setOrderAmount(totalOrderAmount);
        
        Order savedOrder = orderRepository.save(order);
        return OrderMapper.mapToCreateOrderResponseDTO(savedOrder);
    }
}
