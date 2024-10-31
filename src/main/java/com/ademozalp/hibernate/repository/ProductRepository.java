package com.ademozalp.hibernate.repository;

import com.ademozalp.hibernate.dto.CountByName;
import com.ademozalp.hibernate.model.Product;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, String> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Product> findByDetailName(String name);

    //    @QueryHints(value = {@QueryHint(name = HINT_CACHEABLE, value = "true")})
    List<Product> findAll();

//    @Lock(LockModeType.PESSIMISTIC_WRITE)
//    Product save(Product product);

    @Query("select new com.ademozalp.hibernate.dto.CountByName(p.detail.name as name, count(p) as count) from Product p group by p.detail.name")
    List<CountByName> getCountGroupedByName();
}
