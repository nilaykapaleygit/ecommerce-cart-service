package com.ecommerce.cart_service.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.cart_service.dto.EcomCartCheckoutRequest;
import com.ecommerce.cart_service.dto.EcomCartCheckoutResponse;
import com.ecommerce.cart_service.dto.EcomCartDto;
import com.ecommerce.cart_service.dto.EcomCartItemDto;
import com.ecommerce.cart_service.dto.EcomOrderDto;
import com.ecommerce.cart_service.dto.EcomProductVariantsDto;
import com.ecommerce.cart_service.entity.EcomCart;
import com.ecommerce.cart_service.entity.EcomCartItem;
import com.ecommerce.cart_service.mapper.EcomCartItemMapper;
import com.ecommerce.cart_service.mapper.EcomCartMapper;
import com.ecommerce.cart_service.repo.EcomCartItemRepo;
import com.ecommerce.cart_service.repo.EcomCartRepo;
import com.ecommerce.cart_service.service.EcomCartService;
import com.ecommerce.cart_service.service.client.OrderFeignClient;
import com.ecommerce.cart_service.service.client.ProductFeignClient;

@Service
public class EcomCartServiceImpl implements EcomCartService{

	@Autowired 
	EcomCartRepo ecomCartRepo;

	@Autowired 
	EcomCartItemRepo ecomCartItemRepo;
	
	@Autowired
    ProductFeignClient productFeignClient;
	
	@Autowired
	OrderFeignClient orderFeignClient;
	
	@Override
	public EcomCartItemDto addItemToCart(EcomCartItemDto cartItemDto, Long UserId) {
		// TODO Auto-generated method stub
		EcomCart ecomCart = ecomCartRepo.findByUserId(UserId);
		
		if(ecomCart==null) {
			EcomCartDto ecomCartDto = new EcomCartDto();
			ecomCartDto.setCreatedAt(LocalDateTime.now());
			ecomCartDto.setUpdatedAt(LocalDateTime.now());
			ecomCartDto.setStatus("ACTIVE");
			ecomCartDto.setUserId(UserId);
			ecomCart = EcomCartMapper.mapToEcomCart(ecomCartDto);
			ecomCart= ecomCartRepo.save(ecomCart);
		}
		
		   // 🔹 Call Product Service to get price
        EcomProductVariantsDto variant = productFeignClient.getProductVariantById(cartItemDto.getProductVariantId());
        
        if (!Boolean.TRUE.equals(variant.getActive())) {
            throw new RuntimeException("Product variant is inactive");
        }
        
        Double price = variant.getPrice(); // ✅ authoritative price
        
		EcomCartItem ecomCartItem = EcomCartItemMapper.mapToEcomCartItem(cartItemDto);
		ecomCartItem.setPriceAtAddTime(price);
		ecomCartItem.setCart(ecomCart);
		ecomCartItem =  ecomCartItemRepo.save(ecomCartItem);
		return EcomCartItemMapper.mapToEcomCartItemDto(ecomCartItem);
	}

	@Override
	public EcomCartDto updateCartItem(EcomCartItemDto cartItemDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EcomCartDto removeCartItem(Long cartItemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EcomCartDto getCartByUserId(Long userId) {
		// TODO Auto-generated method stub
		EcomCart ecomCart = ecomCartRepo.findByUserId(userId);
		if(ecomCart!=null) {
			return EcomCartMapper.mapToEcomCartDto(ecomCart);
		}
		return null;
	}

	@Override
	public EcomCartCheckoutResponse checkout(EcomCartCheckoutRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EcomCartDto checkout(EcomOrderDto requestDto, Long cartId) {
		// TODO Auto-generated method stub	   	
        EcomOrderDto orderDto =
                orderFeignClient.checkout(requestDto,cartId);
        // 5️⃣ Mark cart as CHECKED_OUT
        Optional<EcomCart> ecomCart = ecomCartRepo.findById(cartId);
        EcomCart saveObj = ecomCart.isPresent() ?  ecomCart.get() : null;
        if(saveObj!=null) {
        	saveObj.setStatus("CHECKED_OUT");
        	saveObj.setUpdatedAt(LocalDateTime.now());
        	saveObj = ecomCartRepo.save(saveObj);
        }
        else {
            throw new RuntimeException("Cart is not avialble");
        }
        
        // 6️⃣ Clear cart items
        List<EcomCartItem> ecomCartItems = ecomCartItemRepo.deleteByCartCartId(cartId);
        saveObj.setCartItems(ecomCartItems);
        EcomCartDto ecomCartDto = EcomCartMapper.mapToEcomCartDto(saveObj);
		return ecomCartDto;
	}

}
