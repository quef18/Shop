package com.example.Shop.service.bean;

import com.example.Shop.entity.Role;
import com.example.Shop.repository.RoleRepo;
import com.example.Shop.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceBean implements RoleService {
    private final RoleRepo roleRepo;

    @Override
    public Role findByRoleName(String roleName) {
        return roleRepo.findByRoleName(roleName).orElse(null);
    }

    @Override
    public Role save(Role role) {
        return roleRepo.save(role);
    }
}
