package com.ecommerce.cart_service.service.client;

import java.math.BigDecimal;

import com.ecommerce.cart_service.dto.EcomProductVariantsDto;

public class ProductFeignFallback implements ProductFeignClient{

	@Override
	public EcomProductVariantsDto getProductVariantById(Long variantId) {
		// TODO Auto-generated method stub 
		return null;
	}

}
