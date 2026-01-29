package com.ecommerce.cart_service.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.ecommerce.cart_service.entity.EcomCartItem;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class EcomCartDto {
    private Long cartId;
    private Long userId;
    private String status; // ACTIVE, CHECKED_OUT
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<EcomCartItem> cartItems;
}
