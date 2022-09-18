package com.example.Shop.controller;

import com.example.Shop.entity.Category;
import com.example.Shop.entity.Product;
import com.example.Shop.repository.CategoryRepo;
import com.example.Shop.repository.ProductRepo;
import com.example.Shop.service.CategoryService;
import com.example.Shop.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@AllArgsConstructor
public class ProductController {
    private final CategoryService categoryService;
    private final ProductService productService;
    private final CategoryRepo categoryRepo;
    private final ProductRepo productRepo;

    @GetMapping("/category/{id}/products") // như này id là của product nhá
    public String showProduct(@PathVariable Integer id, @RequestParam("page") Optional<Integer> pageNo, Model model) {
        List<Product> productList = new ArrayList<>();
//        productList = productService.findAllByCategory_Id(id);
        Pageable paging = PageRequest.of(pageNo.orElse(0), 9);
        Page<Product> products = productRepo.findAllByCategory_Id(id, paging);
//        productList = list.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("idCat", id);
        model.addAttribute("product", products);
        model.addAttribute("category", categoryService.findAll());
        return "product";
    }

    @GetMapping("/category/{id1}/product/{id2}")
    public String showProductDetail(@PathVariable Integer id1, @PathVariable Integer id2, Model model) {
        Product product;
        product = productService.findById(id2);
        String size[] = product.getSize().split("\\s+");
        model.addAttribute("product", product);
        model.addAttribute("size", size);
        model.addAttribute("category", categoryService.findAll());
        return "product_detail";
    }

    @GetMapping("/search")
    public String searchView(Model model, @RequestParam("name") String name, @RequestParam("page") Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0), 4);
        model.addAttribute("name", name);
        model.addAttribute("category", categoryService.findAll());
        model.addAttribute("product", productService.search(name, pageable));
        return "product";
    }
}
