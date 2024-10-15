package com.ademozalp.hibernate.repository;

import com.ademozalp.hibernate.model.Product;
import jakarta.persistence.LockModeType;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, String> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Product> findByDetailName(String name);


//    @Lock(LockModeType.PESSIMISTIC_WRITE)
//    Product save(Product product);
}
