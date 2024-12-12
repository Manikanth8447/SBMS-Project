package com.mani.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mani.entity.Role;
import com.mani.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public String createRole(Role role) {
        roleRepository.save(role);
        return "Role created successfully!";
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
