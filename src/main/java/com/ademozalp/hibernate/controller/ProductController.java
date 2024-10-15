package com.ademozalp.hibernate.controller;

import com.ademozalp.hibernate.model.Detail;
import com.ademozalp.hibernate.model.Product;
import com.ademozalp.hibernate.repository.ProductRepository;
import com.ademozalp.hibernate.service.ProductService;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public void save(Product product) {
        service.save(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/increment-stock")
    public void incrementStock() {
        service.incrementStock();
    }
}
