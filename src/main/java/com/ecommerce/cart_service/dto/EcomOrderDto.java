package com.ecommerce.cart_service.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class EcomOrderDto {
    private Long orderId;
    private Long userId;
    private String orderStatus;
    private Double totalAmount;
    private String currency;
    private LocalDateTime createdAt;
    private List<EcomOrderItemDto> items;
}
