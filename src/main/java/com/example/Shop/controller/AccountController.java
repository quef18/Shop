package com.example.Shop.controller;

import com.example.Shop.entity.User;
import com.example.Shop.entity.dto.UserDto;
import com.example.Shop.service.CategoryService;
import com.example.Shop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AccountController {
    private final UserService userService;
    private final CategoryService categoryService;
    private final PasswordEncoder passwordEncoder;
    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("category", categoryService.findAll());
        return "login";
    }

    @GetMapping("/user")
    public String showUserDetail(Model model, Authentication authentication) {
        model.addAttribute("userDto", new UserDto());
        model.addAttribute("category", categoryService.findAll());
        model.addAttribute("userDetail", userService.findByUsername(authentication.getName()));
        return "user";
    }

    @PostMapping("/user")
    public String updateUserDetail(@ModelAttribute("userDto") UserDto userDto) {
        User user = userService.findByUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("category", categoryService.findAll());
        model.addAttribute("userDto", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute("userDto") UserDto userDto) {
        User user = userService.toUser(userDto);
        userService.addNewUser(user);
        return "redirect:/login";
    }
}
