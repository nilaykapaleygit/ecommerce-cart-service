package com.ecommerce.cart_service.mapper;

import java.util.stream.Collectors;

import com.ecommerce.cart_service.dto.EcomCartDto;
import com.ecommerce.cart_service.entity.EcomCart;

public class EcomCartMapper {
    public static EcomCartDto mapToEcomCartDto(EcomCart cart) {
        if (cart == null) return null;

        EcomCartDto dto = new EcomCartDto();
        dto.setCartId(cart.getCartId());
        dto.setUserId(cart.getUserId());
        dto.setStatus(cart.getStatus());
        dto.setCreatedAt(cart.getCreatedAt());
        dto.setUpdatedAt(cart.getUpdatedAt());
        return dto;
    }

    public static EcomCart mapToEcomCart(EcomCartDto dto) {
        if (dto == null) return null;

        EcomCart cart = new EcomCart();
        cart.setCartId(dto.getCartId());
        cart.setUserId(dto.getUserId());
        cart.setStatus(dto.getStatus());
        cart.setCreatedAt(dto.getCreatedAt());
        cart.setUpdatedAt(dto.getUpdatedAt());
        return cart;
    }
}
