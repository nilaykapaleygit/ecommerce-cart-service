package com.ecommerce.cart_service.dto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EcomProductVariantsDto {
	private Long ecomProductVariantsId;
	private String variantSku;
	private Double price;
	private Boolean active;
	private Integer stock;	
}
