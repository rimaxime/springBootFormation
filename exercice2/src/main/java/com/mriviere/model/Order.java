package com.mriviere.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by rivie on 06/04/2017.
 */
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Client client;

    @ManyToMany
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private List<Product> products;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }
}
