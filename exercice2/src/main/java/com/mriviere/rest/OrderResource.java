package com.mriviere.rest;


import com.mriviere.dto.OrderDto;
import com.mriviere.dto.ProductOrderDto;
import com.mriviere.jpa.repository.ClientRepository;
import com.mriviere.jpa.repository.OrderRepository;
import com.mriviere.jpa.repository.ProductDetailRepository;
import com.mriviere.jpa.repository.ProductRepository;
import com.mriviere.model.Order;
import com.mriviere.model.ProductDetail;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

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
        checkNotNull(orderDto, "Order must be not null");
        checkNotNull(orderDto.getClientId(), "Client id must be not null");
        checkNotNull(orderDto.getProductsOrdered(), "Products ordered must be not null");
        checkArgument(clientRepository.getOne(orderDto.getClientId()) != null, "Client is not available");
        orderDto.getProductsOrdered()
                .forEach(product ->
                        checkArgument(productDetailRepository.findByProductId(product.getProductId()) != null,
                                "Product " + product.getProductId() + " is not available"));

        List<ProductOrderDto> productsOrdered = orderDto.getProductsOrdered();
        checkCommandConsistency(productsOrdered);
        computeNewStock(productsOrdered);

        Order order = new Order();
        order.setClient(clientRepository.getOne(orderDto.getClientId()));
        for (ProductOrderDto productOrderDto : productsOrdered) {
            order.addProduct(productRepository.findOne(productOrderDto.getProductId()));
        }
    }

    private void computeNewStock(List<ProductOrderDto> productsOrdered) {
        for (ProductOrderDto productOrderDto : productsOrdered) {
            ProductDetail productDetail = productDetailRepository.findByProductId(productOrderDto.getProductId());
            productDetail.setQuantity(productDetail.getQuantity() - productOrderDto.getQuantity());
            productDetailRepository.save(productDetail);
        }
    }

    private void checkCommandConsistency(List<ProductOrderDto> productsOrdered) throws Exception {
        for (ProductOrderDto productOrderDto : productsOrdered) {
            ProductDetail productDetail = productDetailRepository.findByProductId(productOrderDto.getProductId());
            if (productDetail.getQuantity() < productOrderDto.getQuantity()) {
                throw new Exception("There is not enough quantity of: " + productDetail);
            }
        }
    }

}
