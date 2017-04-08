package com.mriviere.rest;


import com.mriviere.dto.OrderDto;
import com.mriviere.jpa.repository.ClientRepository;
import com.mriviere.jpa.repository.OrderRepository;
import com.mriviere.jpa.repository.ProductDetailRepository;
import com.mriviere.jpa.repository.ProductRepository;
import com.mriviere.model.Order;
import com.mriviere.model.ProductDetail;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderResource {

    private OrderRepository orderRepository;

    private ClientRepository clientRepository;

    private ProductDetailRepository productDetailRepository;

    private ProductRepository productRepository;

    public OrderResource(OrderRepository orderRepository, ClientRepository clientRepository, ProductDetailRepository productDetailRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
        this.productDetailRepository = productDetailRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/all")
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable("id") Long id) {
        return orderRepository.getOne(id);
    }

    @PostMapping
    public void postOrder(@RequestBody OrderDto orderDto) throws Exception {
        Map<Long, Integer> productsOrdered = orderDto.getProductsOrdered();
        checkCommandConsistency(productsOrdered);
        computeNewStock(productsOrdered);

        Order order = new Order();
        order.setClient(clientRepository.getOne(orderDto.getClientId()));
        for (Long productId : productsOrdered.keySet()) {
            order.addProduct(productRepository.findOne(productId));
        }
    }

    private void computeNewStock(Map<Long, Integer> productsOrdered) {
        for (Long productId : productsOrdered.keySet()) {
            ProductDetail productDetail = productDetailRepository.findByProductId(productId);
            productDetail.setQuantity(productDetail.getQuantity() - productsOrdered.get(productId));
            productDetailRepository.save(productDetail);
        }
    }

    private void checkCommandConsistency(Map<Long, Integer> productsOrdered) throws Exception {
        for (Long productId : productsOrdered.keySet()) {
            ProductDetail productDetail = productDetailRepository.findByProductId(productId);
            if (productDetail.getQuantity() < productsOrdered.get(productId)) {
                throw new Exception("There is not enough quantity of: " + productDetail);
            }
        }
    }

}
