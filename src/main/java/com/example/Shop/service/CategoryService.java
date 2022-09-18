package com.example.Shop.service;

import com.example.Shop.entity.Category;

import java.util.List;

public interface CategoryService {
    Integer findById(Integer id);

    Category findByName(String categoryName);

    List<Category> findAll();

    Category save(Category category);
}
