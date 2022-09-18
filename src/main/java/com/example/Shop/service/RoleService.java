package com.example.Shop.service;

import com.example.Shop.entity.Role;

public interface RoleService {
    Role findByRoleName(String roleName);

    Role save(Role role);
}
