package com.mriviere.dto;

import java.util.Map;

/**
 * Created by rivie on 08/04/2017.
 */
public class OrderDto {
    private Map<Long, Integer> productsOrdered;

    private Long clientId;

    public Map<Long, Integer> getProductsOrdered() {
        return productsOrdered;
    }

    public void setProductsOrdered(Map<Long, Integer> productsOrdered) {
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

    public OrderDto(Map<Long, Integer> productsOrdered, Long clientId) {
        this.productsOrdered = productsOrdered;
        this.clientId = clientId;
    }

}
