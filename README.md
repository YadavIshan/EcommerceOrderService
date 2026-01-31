# Ecommerce Order Service

A Spring Boot microservice responsible for creating and complying customer orders. It communicates with the **Product Service (Backend)** to validate product details before processing an order.

## 🚀 Getting Started

### Prerequisites
- **EcommerceBackendSpring** MUST be running on **Port 3000**.
- Java 17+
- Gradle (wrapper included)

### Configuration
- **Port**: `8081` (Configured to avoid conflict with Backend)
- **Database**: H2 In-Memory
- **Eureka**: Consumes `ECOMMERCEBACKEND` service.

### Running the Application
```bash
./gradlew bootRun
```
*Wait for "Started OrderServiceApplication in X seconds"*

---

## 📡 API Reference

### Create Order
**POST** `/api/orders`

Creates a new order. The service calls the **Backend Admin API** (`/api/admin/products/{id}`) to fetch the current price of each product.

#### Request Body
```json
{
  "userId": 1,
  "orderItems": [
    {
      "productId": 1,
      "quantity": 2
    }
  ]
}
```

#### Response (Success 200 OK)
```json
{
  "orderId": 1,
  "orderAmount": 1000.0,
  "status": "CREATED"
}
```

---

## ⚠️ Troubleshooting

### "Product not found"
If you get a 500 error or "Product not found", it means the **Backend Database is empty**.
- **Reason**: The Backend uses an In-Memory DB (H2), so data is lost when it restarts.
- **Fix**: You must Create a Product in the Backend first using its Admin API.

### "Connection Refused"
- Check if `EcommerceBackendSpring` is running on port **3000**.
- Check if `EcommerceOrderService` is running on port **8081**.
