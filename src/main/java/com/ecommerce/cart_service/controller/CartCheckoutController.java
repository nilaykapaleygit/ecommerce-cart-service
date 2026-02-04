package com.ecommerce.cart_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.cart_service.contants.CartsConstants;
import com.ecommerce.cart_service.dto.EcomCartDto;
import com.ecommerce.cart_service.dto.EcomOrderDto;
import com.ecommerce.cart_service.dto.ResponseDto;
import com.ecommerce.cart_service.service.EcomCartService;
import com.ecommerce.cart_service.service.client.OrderFeignClient;

@RestController
@RequestMapping("/checkoutCart")
public class CartCheckoutController {

    private final EcomCartService ecomCartService;

    public CartCheckoutController(EcomCartService ecomCartService) {
        this.ecomCartService = ecomCartService;
    }
    
    @PostMapping("/checkout/{cartId}")
    public ResponseEntity<ResponseDto> checkout(@RequestBody EcomOrderDto requestDto,@PathVariable Long cartId){

    	EcomCartDto ecomCartDto = ecomCartService.checkout(requestDto, cartId);
    	
    	if(ecomCartDto!=null && ecomCartDto.getCartItems()!=null && ecomCartDto.getCartItems().size()>0) {   	       
            return ResponseEntity.ok(new ResponseDto("200", "Order Created Successfully"));
    	}
    
    	   return ResponseEntity
	                 .status(HttpStatus.NOT_ACCEPTABLE)
	                 .body(new ResponseDto(CartsConstants.MESSAGE_417_UPDATE, CartsConstants.MESSAGE_417_UPDATE));

    }

}
