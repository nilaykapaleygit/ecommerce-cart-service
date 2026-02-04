package com.ecommerce.cart_service.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.ecommerce.cart_service.entity.EcomCart;
import com.ecommerce.cart_service.entity.EcomCartItem;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class EcomCartItemDto {
    private Long cartItemId;
    //private EcomCartDto cart;
    private Long productId;
    private Long productVariantId;
    private Integer quantity;
    private Double priceAtAddTime;
    private LocalDateTime createdAt;
}
