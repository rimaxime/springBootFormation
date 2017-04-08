package com.mriviere.jpa.repository;

import com.mriviere.model.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {
    ProductDetail findByProductId(Long productId);

}