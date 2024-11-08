package com.ademozalp.hibernate.service;


import com.ademozalp.hibernate.model.Category;
import com.ademozalp.hibernate.model.Detail;
import com.ademozalp.hibernate.repository.CategoryRepository;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    public static final Logger logger = LoggerFactory.getLogger(CategoryService.class);
    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void initialize(){
        Category category = new Category("https://youtube.com", new Detail("Yemekler","bol bol yiyiniz"), List.of());
        save(category);
    }
    public void save(Category category) {
        repository.save(category);
    }


    public List<Category> getAll() {
        return repository.findAll();
    }
}
