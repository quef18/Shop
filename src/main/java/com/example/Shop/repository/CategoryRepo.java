package com.example.Shop.repository;

import com.example.Shop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
    Category findByName(String categoryName);

    List<Category> findAll();
    //    Optional<Category> findById(UUID id);
}
