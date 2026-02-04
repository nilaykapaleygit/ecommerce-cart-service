package com.ecommerce.cart_service.service;

import com.ecommerce.cart_service.dto.EcomCartCheckoutRequest;
import com.ecommerce.cart_service.dto.EcomCartCheckoutResponse;
import com.ecommerce.cart_service.dto.EcomCartDto;
import com.ecommerce.cart_service.dto.EcomCartItemDto;
import com.ecommerce.cart_service.dto.EcomOrderDto;

public interface EcomCartService {
	EcomCartItemDto addItemToCart(EcomCartItemDto cartItemDto, Long userId);
	EcomCartDto updateCartItem(EcomCartItemDto cartItemDto); 
	EcomCartDto removeCartItem(Long cartItemId);
	EcomCartDto getCartByUserId(Long userId);
	EcomCartCheckoutResponse checkout( EcomCartCheckoutRequest request); 
	EcomCartDto checkout(EcomOrderDto requestDto, Long cartId);
}
