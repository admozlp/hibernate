package com.ademozalp.hibernate.service;


import com.ademozalp.hibernate.model.Detail;
import com.ademozalp.hibernate.model.Product;
import com.ademozalp.hibernate.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Slf4j
public class ProductService {
    private final ProductRepository repository;


    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    @Transactional
    public void initialize() {
        Product product = Product.builder()
                .price(BigDecimal.TEN)
                .stock(500)
                .detail(new Detail("Laptop", "Macbook Pro"))
                .build();

        repository.save(product);
    }


    public void save(Product product) {
        repository.save(product);
    }

    @Transactional
    public List<Product> getAllProducts() {
        try {
            Thread.sleep(5000L);
            return repository.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional
    @Retryable(retryFor = RuntimeException.class, maxAttempts = 2, backoff = @Backoff(delay = 1000))
    public Product incrementStock() {
        Product product = repository.findByDetailName("Laptop")
                .orElseThrow(() -> new EntityNotFoundException("Product not found: Laptop"));

        product.setStock(product.getStock() + 1);
        return repository.save(product);

//        return retryTemplate.execute(context -> hataVerecekMethod());
    }

    @Recover
    public Product recover(RuntimeException e, Product product) throws Throwable {
        log.info("2 denemeden sonra buraya dustu: {}", e.getMessage());

        return product;
    }

//    public Product hataVerecekMethod() {
//        Product product = repository.findByDetailName("Laptop")
//                .orElseThrow(() -> new EntityNotFoundException("Product not found: Laptop"));
//
//        product.setStock(product.getStock() + 1);
//        return repository.save(product);
//    }
}
