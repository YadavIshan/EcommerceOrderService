package com.ishan.ecommerce.OrderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ishan.ecommerce.OrderService.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
