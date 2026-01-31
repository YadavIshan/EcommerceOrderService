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
        String url = "http://ECOMMERCEBACKEND/api/admin/products/" + productId;
        System.out.println("DEBUG: Calling URL: " + url);
        try {
            ResponseEntity<ProductDTO> response = restTemplate.getForEntity(url, ProductDTO.class);
            System.out.println("DEBUG: Response Status: " + response.getStatusCode());
            System.out.println("DEBUG: Response Body: " + response.getBody());
            if (response.getBody() == null) {
                return null;
            }
            return response.getBody();
        } catch (Exception e) {
            System.out.println("DEBUG: Error calling Product Service: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

}