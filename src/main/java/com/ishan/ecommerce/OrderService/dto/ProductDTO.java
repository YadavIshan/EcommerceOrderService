package com.ishan.ecommerce.OrderService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private Long categoryId;
    private String image;
}
