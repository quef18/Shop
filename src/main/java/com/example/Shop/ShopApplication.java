package com.example.Shop;


import com.example.Shop.entity.User;
import com.example.Shop.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
@AllArgsConstructor
public class ShopApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
		System.out.println("App started!");
	}

}
