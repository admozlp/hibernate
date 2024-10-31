package com.ademozalp.hibernate.controller;

import com.ademozalp.hibernate.model.Product;
import com.ademozalp.hibernate.model.Test;
import com.ademozalp.hibernate.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/get-tests")
    public List<Test> getAllTests() {
        return service.getAllTests();
    }

}
