package com.ishan.ecommerce.OrderService.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
public class OrderRequestDTO {
    @NotNull(message = "User ID is required")
    private Long userId;
    
    @NotEmpty(message = "Order must have at least one item")
    @Valid
    private List<OrderItemRequestDTO> orderItems;
}
