package com.example.Shop;

import com.example.Shop.entity.Category;
import com.example.Shop.entity.Product;
import com.example.Shop.service.CategoryService;
import com.example.Shop.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InsertProduct {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Test
    public void addProduct() {
        Product product = new Product();
        product.setImg("/img/ao-khoac-ni-co-non");
        product.setName("Áo khoác nỉ có nón");
        product.setPrice(280.);
        product.setSize("");
        product.setCategory(categoryService.findByName("áo khoác"));

        productService.save(product);
    }
}
