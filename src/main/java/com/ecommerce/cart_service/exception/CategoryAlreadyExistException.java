package com.ecommerce.cart_service.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CategoryAlreadyExistException extends RuntimeException {
    
	public CategoryAlreadyExistException(String message) {
        super(message);
    }
	
}
