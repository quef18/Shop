package com.example.Shop.service;

import com.example.Shop.entity.User;
import com.example.Shop.entity.dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {
    User save(User user);

    User addNewUser(User user);

    User findByUsername(String username);

    List<User> getUsers();

    User findById(Integer id);

    User toUser(UserDto userDto);
}
