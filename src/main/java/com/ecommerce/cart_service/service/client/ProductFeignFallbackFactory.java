package com.ecommerce.cart_service.service.client;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import com.ecommerce.cart_service.dto.EcomProductVariantsDto;

@Component
public class ProductFeignFallbackFactory implements FallbackFactory<ProductFeignClient> {
    private static final Logger logger = LoggerFactory.getLogger(ProductFeignFallbackFactory.class);

    
	 @Override
	    public ProductFeignClient create(Throwable cause) {

	        return id -> {
	        	logger.error("Product service failed", cause);
	            return new EcomProductVariantsDto(
	                    id,
	                    "Service unavailable",
	                    null,
	                    false,
	                    null
	            );
	        };
	    }
}
