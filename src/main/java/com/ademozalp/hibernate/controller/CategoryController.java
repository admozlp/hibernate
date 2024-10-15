package com.ademozalp.hibernate.controller;

import com.ademozalp.hibernate.model.Category;
import com.ademozalp.hibernate.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping
    public void save(@RequestBody Category category) {
        service.save(category);
    }

    @GetMapping
    public List<Category> getAll() {
        return service.getAll();
    }
}
