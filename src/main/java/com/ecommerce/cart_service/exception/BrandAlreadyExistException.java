package com.ecommerce.cart_service.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BrandAlreadyExistException extends RuntimeException {
    
	public BrandAlreadyExistException(String message) {
        super(message);
    }
	
}
