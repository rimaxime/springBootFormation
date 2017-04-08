package com.mriviere.rest;


import com.mriviere.jpa.repository.ProductDetailRepository;
import com.mriviere.jpa.repository.ProductRepository;
import com.mriviere.model.Product;
import com.mriviere.model.ProductDetail;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductsRessource {

    private ProductRepository productRepository;

    private ProductDetailRepository productDetailRepository;

    public ProductsRessource(ProductRepository productRepository, ProductDetailRepository productDetailRepository) {
        this.productRepository = productRepository;
        this.productDetailRepository = productDetailRepository;
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long id) {
        return productRepository.getOne(id);
    }

    @PutMapping
    public void putProduct(@RequestBody Product product) {
        if (product.getId() == null) {
            productDetailRepository.save(new ProductDetail(product, 0));
        } else {
            productRepository.save(product);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        ProductDetail productDetail = productDetailRepository.findByProductId(id);
        productRepository.delete(productDetail.getId());
    }

    @PostMapping("/{id}/quantity/{quantity}")
    public void postProductQuantity(@PathVariable("id") Long id, @PathVariable("quantity") int quantity) {
        ProductDetail productDetail = productDetailRepository.findByProductId(id);
        productDetail.setQuantity(quantity);
        productDetailRepository.save(productDetail);
    }

    @GetMapping("/details")
    public List<ProductDetail> getProductsDetails() {
        return productDetailRepository.findAll();
    }

    @GetMapping("/{id}/details")
    public ProductDetail getProductDetails(@PathVariable("id") Long id) {
        return productDetailRepository.findByProductId(id);
    }
}
