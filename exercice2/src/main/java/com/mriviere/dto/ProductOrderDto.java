package com.mriviere.dto;

/**
 * Created by rivie on 08/04/2017.
 */
public class ProductOrderDto {
    private Long productId;

    private Integer quantity;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
