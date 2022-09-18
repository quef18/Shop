package com.example.Shop;

import com.example.Shop.entity.Category;
import com.example.Shop.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InsertCategory {
    @Autowired
    CategoryService categoryService;

    @Test
    public void addCategory() {
        Category category = new Category();
        category.setName("áo khoác");

        categoryService.save(category);
    }
}
