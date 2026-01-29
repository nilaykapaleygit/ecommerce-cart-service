package com.ecommerce.cart_service.dto;


import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class EcomProductVariantsDto {
	private Long ecomProductVariantsId;
	private String variantSku;
	private Double price;
	private Boolean active;
	private Integer stock;	
}
