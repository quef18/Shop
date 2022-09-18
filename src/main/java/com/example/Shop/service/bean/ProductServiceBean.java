package com.example.Shop.service.bean;

import com.example.Shop.entity.Product;
import com.example.Shop.repository.ProductRepo;
import com.example.Shop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceBean implements ProductService {
    private final ProductRepo productRepo;

//    @Override
//    public List<Product> findAllByCategory_Id(Integer id) {
//        return productRepo.findAllByCategory_Id(id);
//    }

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public Product save(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Page<Product> search(String name, Pageable pageable) {
        return productRepo.search(name, pageable);
    }

}
