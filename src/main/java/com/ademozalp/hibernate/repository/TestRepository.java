package com.ademozalp.hibernate.repository;

import com.ademozalp.hibernate.model.Test;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

import java.util.List;

import static org.hibernate.jpa.HibernateHints.HINT_CACHEABLE;


public interface TestRepository extends JpaRepository<Test, Integer> {


    @QueryHints(value = {@QueryHint(name = HINT_CACHEABLE, value = "true")})
    List<Test> findAll();

}
