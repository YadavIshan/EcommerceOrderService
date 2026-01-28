package com.ishan.ecommerce.OrderService.client;

import com.ishan.ecommerce.OrderService.dto.ProductDTO;
import com.ishan.ecommerce.OrderService.exception.ProductNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductServiceClient {

    private final RestTemplate restTemplate;

    public ProductServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ProductDTO getProductById(Long productId) {
        String url = "https://fakestoreapi.com/products/" + productId;
        ResponseEntity<ProductDTO> response = restTemplate.getForEntity(url, ProductDTO.class);
        
        if (response.getBody() == null) {
            throw new ProductNotFoundException("Product not found with ID: " + productId);
        }
        
        return response.getBody();
    }

}