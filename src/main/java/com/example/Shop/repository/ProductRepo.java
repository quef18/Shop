package com.example.Shop.repository;

import com.example.Shop.entity.Category;
import com.example.Shop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
    List<Product> findAllByCategory(Category category);
//    @Query("select pro from product pro where pro.category.name = :name")
//    List<Product> ListProductByCategory(@Param("name") String name);
    List<Product> findAll();
    Optional<Product> findById(Integer id);
    Page<Product> findAllByCategory_Id(Integer id, Pageable pageable);

    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%")
    Page<Product> search(String name, Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT * FROM shop.product ORDER BY id DESC limit 8")
    List<Product> findLastestProducts();

    @Query(nativeQuery = true, value = "SELECT * FROM shop.product ORDER BY product_price DESC limit 8")
    List<Product> findBestProducts();
}
