package com.ecommerce.cart_service.mapper;

import com.ecommerce.cart_service.dto.EcomCartDto;
import com.ecommerce.cart_service.dto.EcomCartItemDto;
import com.ecommerce.cart_service.entity.EcomCart;
import com.ecommerce.cart_service.entity.EcomCartItem;

import java.util.ArrayList;
import java.util.List;

public class EcomCartMapper {
    public static EcomCartDto mapToEcomCartDto(EcomCart cart) {
        if (cart == null) return null;

        EcomCartDto dto = new EcomCartDto();
        dto.setCartId(cart.getCartId());
        dto.setUserId(cart.getUserId());
        dto.setStatus(cart.getStatus());
        dto.setCreatedAt(cart.getCreatedAt());
        dto.setUpdatedAt(cart.getUpdatedAt());
        List<EcomCartItem> ecomCartItems = cart.getCartItems();
        List<EcomCartItemDto> ecomCartItemsDto = new ArrayList<>();
        for(EcomCartItem obj : ecomCartItems) {
        	ecomCartItemsDto.add(EcomCartItemMapper.mapToEcomCartItemDto(obj));
        }
        dto.setCartItems(ecomCartItemsDto);
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

        List<EcomCartItemDto> ecomCartItemsDto = dto.getCartItems();
        List<EcomCartItem> ecomCartItems = new ArrayList<>();
        
        for(EcomCartItemDto obj : ecomCartItemsDto) {
        	ecomCartItems.add(EcomCartItemMapper.mapToEcomCartItem(obj));
        }
        cart.setCartItems(ecomCartItems);
        return cart;
    }
}
