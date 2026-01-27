package com.ishan.ecommerce.OrderService.client;

import com.ishan.ecommerce.OrderService.dto.ProductDTO;
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
        String url = "https://fakestoreapi.com/products/" + productId; // Using FakeStoreAPI as placeholder , will replace this with my backnd service
        ResponseEntity<ProductDTO> response = restTemplate.getForEntity(url, ProductDTO.class);
        return response.getBody();
    }

}