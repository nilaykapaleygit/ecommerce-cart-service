package com.ecommerce.cart_service.mapper;

import com.ecommerce.cart_service.dto.EcomCartItemDto;
import com.ecommerce.cart_service.entity.EcomCartItem;

public class EcomCartItemMapper {

    public static EcomCartItemDto mapToEcomCartItemDto(EcomCartItem item) {
        if (item == null) return null;
 
        EcomCartItemDto dto = new EcomCartItemDto();
        dto.setCartItemId(item.getCartItemId());
        dto.setProductId(item.getProductId());
        dto.setProductVariantId(item.getProductVariantId());
        dto.setQuantity(item.getQuantity());
        dto.setPriceAtAddTime(item.getPriceAtAddTime());
        dto.setCreatedAt(item.getCreatedAt());
        dto.setCart(item.getCart()); // reference only

        return dto;
    }

    public static EcomCartItem mapToEcomCartItem(EcomCartItemDto dto) {
        if (dto == null) return null;

        EcomCartItem item = new EcomCartItem();
        item.setCartItemId(dto.getCartItemId());
        item.setProductId(dto.getProductId());
        item.setProductVariantId(dto.getProductVariantId());
        item.setQuantity(dto.getQuantity());
        item.setPriceAtAddTime(dto.getPriceAtAddTime());
        item.setCreatedAt(dto.getCreatedAt());
        item.setCart(dto.getCart()); // reference only

        return item;
    }
}
