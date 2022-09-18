package com.example.Shop.controller;

import com.example.Shop.entity.Order;
import com.example.Shop.entity.OrderItems;
import com.example.Shop.entity.Product;
import com.example.Shop.repository.OrderItemsRepo;
import com.example.Shop.repository.OrderRepo;
import com.example.Shop.service.CategoryService;
import com.example.Shop.service.OrderItemsService;
import com.example.Shop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class CartController {
    private final CategoryService categoryService;
    private final OrderItemsService orderItemsService;
    private final ProductService productService;
    private final OrderRepo orderRepo;
    private final OrderItemsRepo orderItemsRepo;
    @GetMapping("/cart/view")
    public String viewCart(Model model) {
        model.addAttribute("category", categoryService.findAll());
        model.addAttribute("count", orderItemsService.getCount());
        model.addAttribute("cartItem", orderItemsService.getCartItem());
        model.addAttribute("totalPrice", orderItemsService.getAmount());
        return "cart";
    }

    @GetMapping("/cart/add/{productId}")
    public String add(@PathVariable Integer productId, Model model) {
        Product product = productService.findById(productId);

        if(product != null) {
            OrderItems item = new OrderItems();
            item.setProduct(product);
            item.setQuantity(1);
            orderItemsService.add(item);
        }
        return "redirect:/cart/view";
    }

    @GetMapping("/cart/remove/{productId}")
    public String remove(@PathVariable Integer productId) {
        orderItemsService.remove(productId);
        return "redirect:/cart/view";
    }

    @PostMapping("/cart/update")
    public String update(@RequestParam Integer productId, @RequestParam Integer quantity) {
        orderItemsService.update(productId, quantity);
        return "redirect:/cart/view";
    }

    @GetMapping("/checkout")
    public String checkout(Model model) {
        if (orderItemsService.getCartItem().size() == 0) {
            return "redirect:/cart/view";
        }
        model.addAttribute("productOrder", new Order());
        model.addAttribute("cartItem", orderItemsService.getCartItem());
        model.addAttribute("totalPrice", orderItemsService.getAmount());
        return "checkout";
    }

    @PostMapping("/checkout")
    public String makeBill(@ModelAttribute("productOrder") Order order) {
        for (OrderItems i : orderItemsService.getCartItem()) {
            OrderItems orderItems = new OrderItems();
            orderItems.setOrder(order);
            orderItems.setProduct(i.getProduct());
            orderItems.setQuantity(i.getQuantity());
            orderItemsRepo.save(orderItems);
        }
        orderRepo.save(order);
        return "redirect:/cart/view";
    }
}
