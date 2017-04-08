package com.mriviere.dto;

import java.util.List;
import java.util.Map;

/**
 * Created by rivie on 08/04/2017.
 */
public class OrderDto {
    private List<ProductOrderDto> productsOrdered;

    private Long clientId;

    public List<ProductOrderDto> getProductsOrdered() {
        return productsOrdered;
    }

    public void setProductsOrdered(List<ProductOrderDto> productsOrdered) {
        this.productsOrdered = productsOrdered;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public OrderDto() {
    }

    public OrderDto(List<ProductOrderDto> productsOrdered, Long clientId) {
        this.productsOrdered = productsOrdered;
        this.clientId = clientId;
    }

}
