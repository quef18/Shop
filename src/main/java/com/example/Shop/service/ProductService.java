package com.example.Shop.service;

import com.example.Shop.entity.Category;
import com.example.Shop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
//    List<Product> findAllByCategory_Id(Integer id);

    List<Product> findAll();

    Product findById(Integer id);

    Product save(Product product);

    Page<Product> search(String name, Pageable pageable);
}
