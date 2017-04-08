package com.mriviere.dto;

import com.mriviere.model.Client;

/**
 * Created by rivie on 08/04/2017.
 */
public class PriceResponseDto {
    private Double price;

    private Client client;

    public PriceResponseDto(Double price, Client client) {
        this.price = price;
        this.client = client;
    }

    public PriceResponseDto() {}

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
