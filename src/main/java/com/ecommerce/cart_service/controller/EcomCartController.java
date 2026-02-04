package com.ecommerce.cart_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.cart_service.contants.CartsConstants;
import com.ecommerce.cart_service.dto.EcomCartCheckoutRequest;
import com.ecommerce.cart_service.dto.EcomCartCheckoutResponse;
import com.ecommerce.cart_service.dto.EcomCartDto;
import com.ecommerce.cart_service.dto.EcomCartItemDto;
import com.ecommerce.cart_service.dto.ResponseDto;
import com.ecommerce.cart_service.service.EcomCartService;

@RestController
@RequestMapping("/cart")
public class EcomCartController {
	  private final EcomCartService cartService;

	    public EcomCartController(EcomCartService cartService) {
	        this.cartService = cartService;
	    }

	    // ---------------- ADD ITEM ----------------
	    @PostMapping("/addToCart/{userId}")
	    public ResponseEntity<ResponseDto> addItemToCart(
	            @RequestBody EcomCartItemDto cartItemDto, @PathVariable Long userId) {
	         cartService.addItemToCart(cartItemDto,userId);
	         return ResponseEntity
	                 .status(HttpStatus.CREATED)
	                 .body(new ResponseDto(CartsConstants.STATUS_201, CartsConstants.MESSAGE_201));
	    }

	    // ---------------- UPDATE ITEM ----------------
	    @PutMapping("/updateCart/{userId}")
	    public ResponseEntity<ResponseDto> updateCartItem(
	            @RequestBody EcomCartItemDto cartItemDto, @PathVariable Long userId) {
	         cartService.updateCartItem(cartItemDto);
	         return ResponseEntity
	                 .status(HttpStatus.CREATED)
	                 .body(new ResponseDto(CartsConstants.STATUS_201, CartsConstants.MESSAGE_201));
	    }

	    // ---------------- REMOVE ITEM ----------------
	    @DeleteMapping("/remove/{cartItemId}")
	    public EcomCartDto removeCartItem(
	            @PathVariable Long cartItemId) {
	        return cartService.removeCartItem(cartItemId);
	    }

	    // ---------------- GET CART ----------------
	    @GetMapping("/getCartByUser/{userId}")
	    public EcomCartDto getCartByUser(@PathVariable Long userId) {
	        return cartService.getCartByUserId(userId);
	    }


}
