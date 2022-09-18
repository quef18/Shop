package com.example.Shop.controller;

import com.example.Shop.entity.Product;
import com.example.Shop.repository.ProductRepo;
import com.example.Shop.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class HomeController {
    private final CategoryService categoryService;
    private final ProductRepo productRepo;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("category", categoryService.findAll());
        model.addAttribute("lastestProducts", productRepo.findLastestProducts());
        model.addAttribute("bestProducts", productRepo.findBestProducts());
        return "index";
    }
}
