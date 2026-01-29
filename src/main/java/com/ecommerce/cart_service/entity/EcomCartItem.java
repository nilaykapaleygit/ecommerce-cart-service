package com.ecommerce.cart_service.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "ecom_cart_items")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EcomCartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private Long cartItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", nullable = false)
    private EcomCart cart;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "product_variant_id", nullable = false)
    private Long productVariantId;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "price_at_add_time", nullable = false)
    private Double priceAtAddTime;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
