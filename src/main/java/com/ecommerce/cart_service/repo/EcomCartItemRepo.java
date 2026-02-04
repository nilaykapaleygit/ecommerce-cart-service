package com.ecommerce.cart_service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.cart_service.entity.EcomCartItem;


public interface EcomCartItemRepo extends JpaRepository<EcomCartItem, Long> {

	List<EcomCartItem> deleteByCartCartId(Long cartId);
}
