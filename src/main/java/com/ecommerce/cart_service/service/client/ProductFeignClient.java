package com.ecommerce.cart_service.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecommerce.cart_service.dto.EcomProductVariantsDto;

@FeignClient(name = "product-service")
public interface ProductFeignClient {
	
    @GetMapping("/getProductVariant/{variantId}")
    EcomProductVariantsDto getProductVariantById(@PathVariable("variantId") Long variantId);
}
