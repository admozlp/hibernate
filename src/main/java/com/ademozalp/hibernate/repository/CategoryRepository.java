package com.ademozalp.hibernate.repository;

import com.ademozalp.hibernate.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
