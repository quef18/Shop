package com.example.Shop.role;

import com.example.Shop.entity.Role;
import com.example.Shop.entity.RoleNameEnum;
import com.example.Shop.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InsertRole {
    @Autowired
    RoleService roleService;

    @Test
    public void addRole() {
        Role role = new Role();
        role.setRoleName(RoleNameEnum.USER.getName());
        role.setDescription("User role");

        roleService.save(role);
    }
}
