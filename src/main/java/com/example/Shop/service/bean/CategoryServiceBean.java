package com.example.Shop.service.bean;

import com.example.Shop.entity.Category;
import com.example.Shop.repository.CategoryRepo;
import com.example.Shop.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceBean implements CategoryService {
    private final CategoryRepo categoryRepo;

    @Override
    public Integer findById(Integer id) {
        return categoryRepo.findById(id).map(Category::getId).orElse(null);
    }

    @Override
    public Category findByName(String categoryName) {
        return categoryRepo.findByName(categoryName);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Category save(Category category) {
        return categoryRepo.save(category);
    }
}
