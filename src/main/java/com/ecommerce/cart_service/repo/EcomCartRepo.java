package com.ecommerce.cart_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommerce.cart_service.entity.EcomCart;

public interface EcomCartRepo extends JpaRepository<EcomCart, Long> {

	EcomCart findByUserId(Long userId);
}
