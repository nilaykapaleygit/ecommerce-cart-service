package com.ecommerce.cart_service.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ecommerce.cart_service.dto.EcomOrderDto;

// name = "order-service" → Eureka service name
// URL path must exactly match Order Service controller
// No hardcoded host/port
@FeignClient(name = "order-service")
public interface OrderFeignClient {

    @PostMapping("/api/orders/checkout/{cartsId}")
    EcomOrderDto checkout(@RequestBody EcomOrderDto requestDto, @PathVariable Long cartsId);
}
